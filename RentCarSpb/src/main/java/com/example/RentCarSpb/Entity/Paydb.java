package com.example.RentCarSpb.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "pay")
public class Paydb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payid")
    private Long payid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id", referencedColumnName = "form_id", foreignKey = @jakarta.persistence.ForeignKey(name = "fk_pay_rentform"))
    private RentFormdb formid;

    @Column(name="customerName")
    private String customername;

    @Column(name="customerEmail")
    private String customeremail;

    @Column(name="carBrand")
    private String carbrand;

    @Column(name="rentDate")
    private Date rentdate;

    @Column(name="returnDate")
    private Date returndate;

    @Column(name="totalDays")
    private Integer totaldays;

    @Column(name="payDate")
    private Date paydate;

    @Column(name="total")
    private Integer total;

    @Column(name="paymethod")
    private String paymethod;  

    @Column(name="paystatus")
    private String paystatus; 

    @Column(name="isdeleted")
    private boolean isdeleted;

    public Paydb(Long payid, RentFormdb formid, String customername, String customeremail,String carbrand, Date rentdate, Date returndate, Integer totaldays, Date paydate, Integer total, String paymethod, String paystatus, boolean isdeleted) {
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

    public Paydb() {
    }

    public Paydb(RentFormdb formid){
        this.formid = formid;
    }

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

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public Integer getTotaldays() {
        return totaldays;
    }

    public void setTotaldays(Integer totaldays) {
        this.totaldays = totaldays;
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

    public String getSyncField() {
        return paystatus;
    }

    public void setSyncField(String paystatus) {
        this.paystatus = paystatus;
    }

    @Override
    public String toString() {
        return "Paydb [customeremail=" + customeremail + ", customername=" + customername +", carbrand=" + carbrand + ", rentdate=" + 
        rentdate + ", returndate=" + returndate + ", totaldays=" + totaldays +  ", paydate=" + paydate+", payid=" + payid + ", paymethod=" 
        + paymethod + ", paystatus=" + paystatus + ", formid=" + formid + ", total=" + total + ", isdeleted=" + isdeleted + "]";
    }
}
