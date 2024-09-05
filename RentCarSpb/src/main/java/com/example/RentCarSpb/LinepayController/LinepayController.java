package com.example.RentCarSpb.LinepayController;

import java.math.BigDecimal;
//import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RentCarSpb.Entity.Paydb;
import com.example.RentCarSpb.Entity.RentFormdb;
import com.example.RentCarSpb.Repo.PayRepo;
import com.example.RentCarSpb.Repo.RentFormRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import linepay.test.linepay.util.PostApiUtil;
import linepay.test.linepay.vo.CheckoutPaymentRequestForm;
import linepay.test.linepay.vo.ConfirmData;
import linepay.test.linepay.vo.ProductForm;
import linepay.test.linepay.vo.ProductPackageForm;
import linepay.test.linepay.vo.RedirectUrls;

@RestController
@RequestMapping("/api/linepay")
public class LinepayController {
    private static final String CHANNEL_SECRET = "8c4dac62a529369ba8fbef6d0c8d6571";
    private static final String CHANNEL_ID = "2006165060";
    private static final String DEVICE_TYPE = "PC";


    @Autowired
    private PayRepo payRepo;

    @Autowired
    private RentFormRepo rentFormRepo;

    public static String encrypt(final String keys, final String data) {
        return toBase64String(HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_256, keys.getBytes()).doFinal(data.getBytes()));
    }

    public static String toBase64String(byte[] bytes) {
        byte[] byteArray = Base64.encodeBase64(bytes);
        return new String(byteArray);
    }

    public static String generateSignature(String secret, String requestUri, String requestBody, String nonce) {
        String data = secret + requestUri + requestBody + nonce;
        return encrypt(secret, data);
    }

    public static JsonNode sendRequest(CheckoutPaymentRequestForm form) throws JsonProcessingException {
        String requestUri = "/v3/payments/request";
        String requestHttpsUri = "https://sandbox-api-pay.line.me" + requestUri;
        String nonce = UUID.randomUUID().toString();
        String requestData = new ObjectMapper().writeValueAsString(form);
        String signature = generateSignature(CHANNEL_SECRET, requestUri, requestData, nonce);
        System.out.println("Signature: " + signature); // Log signature for debugging
        return PostApiUtil.sendPost(CHANNEL_ID, nonce, signature, requestHttpsUri, requestData, DEVICE_TYPE, UUID.randomUUID().toString());
    }

    public static JsonNode confirmPayment(String transactionId, ConfirmData confirmData) throws JsonProcessingException {
        String confirmUri = "/v3/payments/" + transactionId + "/confirm";
        String confirmHttpsUri = "https://sandbox-api-pay.line.me" + confirmUri;
        String confirmNonce = UUID.randomUUID().toString();
        String confirmDataJson = new ObjectMapper().writeValueAsString(confirmData);
        String signature = encrypt(CHANNEL_SECRET, CHANNEL_SECRET + confirmUri + confirmDataJson + confirmNonce);
        return PostApiUtil.sendPost(CHANNEL_ID, confirmNonce, signature, confirmHttpsUri, confirmDataJson, DEVICE_TYPE, UUID.randomUUID().toString());
    }

    @PostMapping("/request")
    public JsonNode addRequest(@RequestParam String formid, @RequestParam String total) {
    System.out.println("formid: " + formid);
    System.out.println("total: " + total);

    JsonNode requestResponseBody = null;

    try {
        // 创建请求数据
        CheckoutPaymentRequestForm form = new CheckoutPaymentRequestForm();
        form.setAmount(new BigDecimal(total));
        form.setCurrency("TWD");
        String orderId = UUID.randomUUID().toString();
        form.setOrderId(formid+orderId);

        ProductPackageForm productPackageForm = new ProductPackageForm();
        productPackageForm.setId("GoRentCarService");
        productPackageForm.setName("GoRent");
        productPackageForm.setAmount(new BigDecimal(total));

        ProductForm productForm = new ProductForm();
        productForm.setId("GoRent"+formid);
        productForm.setName("GoRentCar");
        productForm.setImageUrl("");
        productForm.setQuantity(new BigDecimal("1"));
        productForm.setPrice(new BigDecimal(total));
        productPackageForm.setProducts(Arrays.asList(productForm));

        form.setPackages(Arrays.asList(productPackageForm));
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setConfirmUrl("https://tongbro.ddns.net:443/LinePayResult?transactionId=" + orderId + "&total=" + total + "&formid=" + formid);
        redirectUrls.setCancelUrl("");
        form.setRedirectUrls(redirectUrls);

        // 发送请求并处理响应
        requestResponseBody = sendRequest(form);
        
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    } catch (RuntimeException e) {
        System.err.println(e.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
    }
    return requestResponseBody;
}




    @PostMapping("/confirm")
    public JsonNode tryConfirm(@RequestParam String transactionId, 
                            @RequestParam String total, 
                            @RequestParam String formid) {
        ConfirmData confirmData = new ConfirmData();

        try {
            // Set the amount and currency for confirmation
            confirmData.setAmount(new BigDecimal(total));
            confirmData.setCurrency("TWD");
             // Find the RentFormdb entity based on the provided formid
            RentFormdb rentForm = rentFormRepo.findByFormid(formid)
                                    .orElseThrow(() -> new RuntimeException("RentFormdb record not found for formid: " + formid));
            // Find the Paydb record associated with the provided formid
            Optional<Paydb> paydataOptional = payRepo.findByFormid(rentForm);
            if (paydataOptional.isPresent()) {
                Paydb paydata = paydataOptional.get();
            
                // Convert LocalDate to java.sql.Date
                java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.now());
                
                // Update the fields
                paydata.setPaydate(sqlDate);
                paydata.setPaymethod("LinePay");
                paydata.setPaystatus("已付款");
                
                // Save the updated record to the database
                payRepo.save(paydata);
            } else {
                // Handle the case where no matching Paydb record is found
                System.out.println("No Paydb record found for the provided formid.");
            }
        } catch (Exception e) {
            // Log the exception and return a meaningful response or handle accordingly
            e.printStackTrace();
        }

        // Send request and handle response
        try {
            return confirmPayment(transactionId, confirmData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
