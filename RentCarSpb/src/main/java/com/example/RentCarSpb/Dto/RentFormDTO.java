package com.example.RentCarSpb.Dto;

import java.sql.Date;

public class RentFormDTO {
    
    private String formid;

    private String rentplace;

    private String returnplace;

    private Date rentdate;
    
    private Date returndate;

    private int carid;

    private String carbrand;

    private int passenger;

    private String paystatus;

    private String customername;

    private String customeremail;

    private boolean isdeleted;

    public RentFormDTO(String formid, String rentplace, String returnplace, Date rentdate, Date returndate, int carid, String carbrand, int passenger, String paystatus,String customername, String customeremail,boolean isdeleted) {
        
        this.formid = formid;
        this.rentplace = rentplace;
        this.returnplace = returnplace;
        this.rentdate = rentdate;
        this.returndate = returndate;
        this.carid = carid;
        this.carbrand = carbrand;
        this.passenger = passenger;
        this.paystatus = paystatus;
        this.customername = customername;
        this.customeremail = customeremail;
        this.isdeleted = isdeleted;
    }

    public RentFormDTO() {
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getRentplace() {
        return rentplace;
    }

    public void setRentplace(String rentplace) {
        this.rentplace = rentplace;
    }

    public String getReturnplace() {
        return returnplace;
    }

    public void setReturnplace(String returnplace) {
        this.returnplace = returnplace;
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

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public String getCarbrand() {
        return carbrand;
    }

    public void setCarbrand(String carbrand) {
        this.carbrand = carbrand;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus;
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
    public boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(boolean isdeleted) {
        this.isdeleted = isdeleted;
    }     
    @Override
    public String toString() {
        return "RentFormDTO [formid=" + formid + ", rentplace=" + rentplace + ", returnplace=" + returnplace
                + ", rentdate=" + rentdate + ", returndate=" + returndate + ", carid=" + carid + ", carbrand="
                + carbrand + ", passenger=" + passenger + ", paystatus =" + paystatus +", customername="+ customername + ", customeremail=" + customeremail +", isdeleted=" + isdeleted + "]";
    }

                

}
