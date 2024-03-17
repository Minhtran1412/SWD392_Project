package Model;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

public class Rental {
    private int id;
    private Date  agreementDate;
    private int accountID;
    private int propertyID;
    private Date  startDate;
    private Time endDate;
    private BigDecimal rentalAmount; // Sử dụng BigDecimal thay cho Double
    private int status;

    public Rental() {
        // Constructor mặc định
    }

    public Rental(int id, Date agreementDate, int accountID, int propertyID, Date startDate, Time endDate, BigDecimal rentalAmount, int status) {
        this.id = id;
        this.agreementDate = agreementDate;
        this.accountID = accountID;
        this.propertyID = propertyID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentalAmount = rentalAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(Date agreementDate) {
        this.agreementDate = agreementDate;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Time getEndDate() {
        return endDate;
    }

    public void setEndDate(Time endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getRentalAmount() {
        return rentalAmount;
    }

    public void setRentalAmount(BigDecimal rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

}
