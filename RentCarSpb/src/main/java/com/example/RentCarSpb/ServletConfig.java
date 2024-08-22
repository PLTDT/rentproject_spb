package com.example.RentCarSpb;

import com.example.RentCarSpb.Servlet.PaymentServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<PaymentServlet> paymentServlet() {
        ServletRegistrationBean<PaymentServlet> registrationBean = new ServletRegistrationBean<>(new PaymentServlet(), "/payment");
        registrationBean.setName("PaymentServlet");
        return registrationBean;
    }
}