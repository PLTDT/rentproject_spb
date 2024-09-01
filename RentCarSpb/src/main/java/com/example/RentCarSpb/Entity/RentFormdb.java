package com.example.RentCarSpb.Entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

//建立資料庫欄位用於連接JPA
@Entity
@Table(name = "rentform")
public class RentFormdb {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "form_id",length=45,nullable = false)
    private String formid;

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

    @Column(name = "pay_status", length=255)
    private String paystatus;

    @Column(name = "customer_name", length=255)
    private String customername;

    @Column(name = "customer_email", length=255)
    private String customeremail;

    @Column(name = "isdeleted")
    private boolean isdeleted;

    public RentFormdb(String formid, String rentplace, String returnplace, Date rentdate, Date returndate, int carid, String carbrand, int passenger, String paystatus,String customername, String customeremail,boolean isdeleted) {
    
        this.formid = formid;
        this.rentplace = rentplace;
        this.returnplace = returnplace;
        this.rentdate = rentdate;
        this.returndate = returndate;
        this.carid = carid;
        this.carbrand = carbrand;
        this.passenger = passenger;
        this.paystatus = paystatus;
        this.customername=customername;
        this.customeremail=customeremail;
        this.isdeleted=isdeleted;
    }
    public RentFormdb() {

    }

    public RentFormdb(String form_id) {
        this.formid = form_id;
    }

    @PrePersist
    private void generateFormId() {
    if (this.formid == null || this.formid.isEmpty()) {
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.formid = datePart + "-" + java.util.UUID.randomUUID().toString().substring(0,4); 
    }
    /*if (this.formid == null || this.formid.isEmpty()) {
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String lastFormId = findLastFormIdForToday(datePart); // Method to retrieve the last formid from DB
        int nextId = 1;

        if (lastFormId != null && lastFormId.startsWith(datePart)) {
            String lastSequencePart = lastFormId.substring(lastFormId.indexOf('-') + 1);
            nextId = Integer.parseInt(lastSequencePart) + 1;
        }

        this.formid = datePart + "-" + String.format("%04d", nextId);
        }*/
    }

    /*private String findLastFormIdForToday(String datePart) {
        // Implement a method that queries the database to find the last formid with the current datePart
        // Example: SELECT formid FROM your_table WHERE formid LIKE '20230817%' ORDER BY formid DESC LIMIT 1;
        return null; // Replace with actual retrieval logic
    }*/

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

    public void setCustomername(String custumername) {
        this.customername = custumername;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String custumeremail) {
        this.customeremail = custumeremail;
    }

    public boolean isIsdeleted() {
        return isdeleted;
    }
    public void setIsdeleted(boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public void setSyncField(String paystatus) {
        this.paystatus = paystatus;
    }

    @Override
    public String toString() {
        return "RentFormdb [formid=" + formid + ", rentplace=" + rentplace + ", returnplace=" + returnplace
                + ", rentdate=" + rentdate + ", returndate=" + returndate + ", carid=" + carid + ", carbrand="
                + carbrand + ", passenger=" + passenger + ", paystatus=" + paystatus +", customername=" + customername+ ", customeremail=" + customeremail + ", isdeleted=" + isdeleted + "]";
                
    }
    
}
