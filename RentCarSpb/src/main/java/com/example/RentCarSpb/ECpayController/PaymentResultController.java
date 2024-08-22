package com.example.RentCarSpb.ECpayController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class PaymentResultController {

    @GetMapping("/paymentResult")
@ResponseBody
public String handleGetRequest(@RequestParam Map<String, String> params) {
    return buildHtmlResponse(params);
}

@PostMapping("/paymentResult")
@ResponseBody
public String handlePostRequest(@RequestParam Map<String, String> params) {
    return buildHtmlResponse(params);
}

private String buildHtmlResponse(Map<String, String> params) {
    StringBuilder result = new StringBuilder("<html><body>");
    result.append("<h3>交易結果回傳</h3>");
    result.append("<ul>");

    for (Map.Entry<String, String> entry : params.entrySet()) {
        result.append("<li>").append(entry.getKey()).append(": ").append(entry.getValue()).append("</li>");
    }

    result.append("</ul></body></html>");
    return result.toString();
    }
}

