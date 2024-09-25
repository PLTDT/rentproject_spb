package linepay.test.linepay.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostApiUtil {

    public static JsonNode sendPost(String channelId, String nonce, String signature, 
                                    String httpsUrl, String mapperData, 
                                    String deviceType, String tradeNo) {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-LINE-ChannelId", channelId);
        headers.add("X-LINE-Authorization-Nonce", nonce);
        headers.add("X-LINE-Authorization", signature);
        headers.add("X-LINE-MerchantDeviceType", deviceType);
        headers.add("X-LINE-MerchantTradeNo", tradeNo);

        HttpEntity<String> request = new HttpEntity<>(mapperData, headers);
        
        System.out.println("Request URL: " + httpsUrl);
        System.out.println("Request Body: " + mapperData);
        System.out.println("Request Headers: " + headers);

        try {
            String responseBody = restTemplate.postForObject(httpsUrl, request, String.class);
            System.out.println("Response Body: " + responseBody);
            
            return mapper.readTree(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResponseEntity<JsonNode> sendGet(String channelId, String nonce, 
                                                    String signature, String httpsUrl) {

        RestTemplate restTemplate = new RestTemplate();                                            

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-LINE-ChannelId", channelId);
        headers.add("X-LINE-Authorization-Nonce", nonce);
        headers.add("X-LINE-Authorization", signature);

        HttpEntity<String> request = new HttpEntity<>(headers);

        System.out.println("GET Request URL: " + httpsUrl);
        System.out.println("GET Request Headers: " + headers);

        return restTemplate.exchange(httpsUrl, HttpMethod.GET, request, JsonNode.class);
    }
}
