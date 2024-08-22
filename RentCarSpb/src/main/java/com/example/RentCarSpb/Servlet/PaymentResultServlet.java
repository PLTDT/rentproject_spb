package com.example.RentCarSpb.Servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.Enumeration;

@WebServlet("/paymentResult")
public class PaymentResultServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        StringBuilder result = new StringBuilder("<html><body>");
        result.append("<h3>交易結果回傳</h3>");
        result.append("<ul>");
        //取得回傳值所有欄位名稱給 pn 這個 enumeration 類型
        Enumeration<String> pn = req.getParameterNames();
        while(pn.hasMoreElements()){
            String paraName = pn.nextElement();
            String paraValue = req.getParameter(paraName);
            //鎖鍊式呼叫
            result.append("<li>").append(paraName).append(":").append(paraValue).append("</li>");
            
        }
        result.append("</ul></body></html>");
        //把組出來的字串回應到網頁上
        resp.getWriter().write(result.toString());
    }
}
