package com.example.RentCarSpb.Entity;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rentform")
public class RentFormdb {
    @Id
    @Column(name = "form_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int formid;

    @Column(name = "rent_place" ,length=255)
    private String rentplace;

    @Column(name = "return_place", length=255)
    private String returnplace;

    @Column(name = "rent_date")
    private Date rentdate;

    @Column(name = "return_date")
    private Date returndate;

    @Column(name = "car_id")
    private int carid;

    @Column(name = "car_brand" ,length=255)
    private String carbrand;

    @Column(name = "passenger")
    private int passenger;

    @Column(name = "coupon_code", length=255)
    private String couponcode;

    public RentFormdb(int formid, String rentplace, String returnplace, Date rentdate, Date returndate, int carid, String carbrand, int passenger, String couponcode) {
        this.formid = formid;
        this.rentplace = rentplace;
        this.returnplace = returnplace;
        this.rentdate = rentdate;
        this.returndate = returndate;
        this.carid = carid;
        this.carbrand = carbrand;
        this.passenger = passenger;
        this.couponcode = couponcode;
    }

    public int getFormid() {
        return formid;
    }

    public void setFormid(int formid) {
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

    public String getCouponcode() {
        return couponcode;
    }

    public void setCouponcode(String couponcode) {
        this.couponcode = couponcode;
    }
    
    @Override
    public String toString() {
        return "RentFormdb [formid=" + formid + ", rentplace=" + rentplace + ", returnplace=" + returnplace
                + ", rentdate=" + rentdate + ", returndate=" + returndate + ", carid=" + carid + ", carbrand="
                + carbrand + ", passenger=" + passenger + ", couponcode=" + couponcode + "]";
    }
}
