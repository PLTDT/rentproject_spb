package com.example.RentCarSpb.back;

public class BackpayConstructor {

    private String isdeleted;
    private String pay_date;
    private String rent_date;
    private String return_date;
    private int total;  // 修正：將total的型別改為int
    private String total_days;
    private String payid;
    private String form_id;
    private String car_brand;
    private String customer_email;
    private String customer_name;
    private String paymethod;
    private String paystatus;

    // 修正後的建構子
    public BackpayConstructor(String isdeleted, String pay_date, String rent_date, String return_date, // 修正：total型別改為int
                              int total, String total_days, String payid, String form_id, 
                              String car_brand, String customer_email, String customer_name, 
                              String paymethod, String paystatus) {
        this.isdeleted = isdeleted;
        this.pay_date = pay_date;
        this.rent_date = rent_date;
        this.return_date = return_date;
        this.total = total;  // 修正：型別一致
        this.total_days = total_days;
        this.payid = payid;
        this.form_id = form_id;
        this.car_brand = car_brand;
        this.customer_email = customer_email;
        this.customer_name = customer_name;
        this.paymethod = paymethod;
        this.paystatus = paystatus;
    }

    // 無參數建構子
    public BackpayConstructor(){
        this.isdeleted = "";
        this.pay_date = "";
        this.rent_date = "";
        this.return_date = "";
        this.total = 0;  // 修正：將total的預設值設為0
        this.total_days = "";
        this.payid = "";
        this.form_id = "";
        this.car_brand = "";
        this.customer_email = "";
        this.customer_name = "";
        this.paymethod = "";
        this.paystatus = "";
    }

    // Getters 和 Setters
    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getRent_date() {
        return rent_date;
    }

    public void setRent_date(String rent_date) {
        this.rent_date = rent_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public int getTotal() {  // 修正：total的getter和setter改為int
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTotal_days() {
        return total_days;
    }

    public void setTotal_days(String total_days) {
        this.total_days = total_days;
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus;
    }

    @Override
    public String toString() {
        return "BackpayConstructor [isdeleted=" + isdeleted + ", pay_date=" + pay_date + ", rent_date=" + rent_date
                + ", return_date=" + return_date + ", total=" + total + ", total_days=" + total_days 
                + ", payid=" + payid + ", form_id=" + form_id + ", car_brand=" + car_brand 
                + ", customer_email=" + customer_email + ", customer_name=" + customer_name
                + ", paymethod=" + paymethod + ", paystatus=" + paystatus + "]";
    }
}
