package com.example.RentCarSpb;

public class BackorderConstructor {
    private int car_id;
    private String form_id;
    private int passenger;
    private String rent_date;
    private String return_date;
    private String car_brand;
    private String coupon_code;
    private String rent_place;
    private String return_place;
    private String customer_email;
    private String customer_name;
    private int total;
    private String status;

    public BackorderConstructor(int car_id, String form_id, int passenger, String rent_date, String return_date, String car_brand,
            String coupon_code, String rent_place, String return_place, String customer_email, String customer_name,
            int total, String status) {
        this.car_id = car_id;
        this.form_id = form_id;
        this.passenger = passenger;
        this.rent_date = rent_date;
        this.return_date = return_date;
        this.car_brand = car_brand;
        this.coupon_code = coupon_code;
        this.rent_place = rent_place;
        this.return_place = return_place;
        this.customer_email = customer_email;
        this.customer_name = customer_name;
        this.total = total;
        this.status = status;
    }
    public BackorderConstructor(){
        this.car_id = 123 ;
        this.form_id = "";
        this.passenger = 0;
        this.rent_date ="" ;
        this.return_date ="" ;
        this.car_brand = "";
        this.coupon_code = "";
        this.rent_place = "";
        this.return_place = "";
        this.customer_email = "";
        this.customer_name = "";
        this.total = 0;
        this.status = "";
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
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

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCoupon_code() {
        return coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code;
    }

    public String getRent_place() {
        return rent_place;
    }

    public void setRent_place(String rent_place) {
        this.rent_place = rent_place;
    }

    public String getReturn_place() {
        return return_place;
    }

    public void setReturn_place(String return_place) {
        this.return_place = return_place;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BackorderConstructor [car_id=" + car_id + ", form_id=" + form_id + ", passenger=" + passenger + ", rent_date="
                + rent_date + ", return_date=" + return_date + ", car_brand=" + car_brand + ", coupon_code="
                + coupon_code + ", rent_place=" + rent_place + ", return_place=" + return_place + ", customer_email="
                + customer_email + ", customer_name=" + customer_name + ", total=" + total + ", status=" + status + "]";
    }
}
