package Model;


import java.math.BigDecimal;
import java.sql.Time;

public class RentalAgreement {
    private int id;
    private int agreementDate;
    private int accountID;
    private int propertyID;
    private int startDate;
    private Time endDate;
    private Double rentalAmount;
    private int status;

    public RentalAgreement() {
        // Constructor mặc định
    }

    // Constructor với tất cả các trường
    public RentalAgreement(int id, int agreementDate, int accountID, int propertyID, int startDate, Time endDate, Double rentalAmount, int status) {
        this.id = id;
        this.agreementDate = agreementDate;
        this.accountID = accountID;
        this.propertyID = propertyID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentalAmount = rentalAmount;
        this.status = status;
    }

    // Getters và Setters cho các trường
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(int agreementDate) {
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

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public Time getEndDate() {
        return endDate;
    }

    public void setEndDate(Time endDate) {
        this.endDate = endDate;
    }

    public Double getRentalAmount() {
        return rentalAmount;
    }

    public void setRentalAmount(Double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
