package com.example.RentCarSpb.Dto;

import java.sql.Date;
import com.example.RentCarSpb.Entity.RentFormdb;

public class PayDTO {

    private Long payid;
    private RentFormdb formid;
    private String customername;
    private String customeremail;
    private String carbrand;
    private Date rentdate;
    private Date returndate;
    private Integer totaldays;
    private Date paydate;
    private Integer total;  // Changed from int to Integer
    private String paymethod;
    private String paystatus;
    private boolean isdeleted;
    // Constructors
    public PayDTO(Long payid, RentFormdb formid, String customername, String customeremail,String carbrand, Date rentdate, Date returndate, Integer totaldays, Date paydate, Integer total, String paymethod, String paystatus, boolean isdeleted) {
        this.payid = payid;
        this.formid = formid;
        this.customername = customername;
        this.customeremail = customeremail;
        this.carbrand = carbrand;
        this.rentdate = rentdate;
        this.returndate = returndate;
        this.totaldays = totaldays;
        this.paydate = paydate;
        this.total = total;
        this.paymethod = paymethod;
        this.paystatus = paystatus;
        this.isdeleted = isdeleted;
    }

    public PayDTO() {
    }

    // Getters and Setters
    public Long getPayid() {
        return payid;
    }

    public void setPayid(Long payid) {
        this.payid = payid;
    }

    public RentFormdb getFormid() {
        return formid;
    }

    public void setFormid(RentFormdb formid) {
        this.formid = formid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String customeremail) {
        this.customeremail = customeremail;
    }

    public String getCarbrand() {
        return carbrand;
    }

    public void setCarbrand(String carbrand) {
        this.carbrand = carbrand;
    }

    public Date getRentdate() {
        return rentdate;
    }

    public void setRentdate(Date rentdate) {
        this.rentdate = rentdate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public Integer getTotaldays() {
        return totaldays;
    }

    public void setTotaldays(Integer totaldays) {
        this.totaldays = totaldays;
    }

    public void setReturndate(Date returndate){
        this.returndate = returndate;
    }
    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

    public boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Override
    public String toString() {
        return "PayDTO [payid=" + payid + ", formid=" + formid + ", customername=" + customername + ", customeremail=" + customeremail+ 
        ", carbrand=" + carbrand + ", rentdate=" + rentdate + ", returndate=" + returndate + ", paydate=" + paydate + ", total=" + total + 
        ", paymethod=" + paymethod + ", paystatus=" + paystatus +  ", isdeleted=" + isdeleted + "]";
    }

    
}
