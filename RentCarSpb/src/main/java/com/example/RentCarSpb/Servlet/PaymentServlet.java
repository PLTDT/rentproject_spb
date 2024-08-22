package com.example.RentCarSpb.Servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ecpay.payment.integration.*;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.exception.EcpayException;

//webservlet 宣告路由時，不用分號結尾
@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AllInOne allInOne;

    @Override
    public void init() throws ServletException{
        super.init();
        allInOne = new AllInOne("");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AioCheckOutALL obj = new AioCheckOutALL();
        //代入商家ID， 但payment_conf.xml 已有設定
        //obj.setMerchantID("");
        //String tno = req.getParameter("tno");
        //String total = req.getParameter("total");
        obj.setMerchantTradeNo("212423543646");
        obj.setMerchantTradeDate("2024/07/23 09:54:00");
        obj.setTotalAmount("123");
        obj.setTradeDesc("Test Payment lalala");
        obj.setItemName("Frank's Jsp online course");
        //設定在金流界面，使用者點選返回商家頁面時的連結
        obj.setReturnURL("http://localhost:8080/shop/");//必填設定回商家網址即可
        //交易完成後，回傳交易結果的連結
        obj.setOrderResultURL("http://localhost:8080/shop/paymentResult");

        String form = "";
        try {
            form = allInOne.aioCheckOut(obj, null);
        } catch (EcpayException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write(form);

    }
}
