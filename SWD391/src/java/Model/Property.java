/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Time;

/**
 *
 * @author acer
 */
public class Property {
    private int id;
    private String Address;
    private int Size, bed, bath, gara;
    private double price;
    private int providerID;
    private String img;
    private Time createDate;
    private String Description;

    public Property() {
    }

    public Property(int id, String Address, int Size, int bed, int bath, int gara, double price, int providerID, String img, Time createDate, String Description) {
        this.id = id;
        this.Address = Address;
        this.Size = Size;
        this.bed = bed;
        this.bath = bath;
        this.gara = gara;
        this.price = price;
        this.providerID = providerID;
        this.img = img;
        this.createDate = createDate;
        this.Description = Description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getBath() {
        return bath;
    }

    public void setBath(int bath) {
        this.bath = bath;
    }

    public int getGara() {
        return gara;
    }

    public void setGara(int gara) {
        this.gara = gara;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Time getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Time createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Property{" + "id=" + id + ", Address=" + Address + ", Size=" + Size + ", bed=" + bed + ", bath=" + bath + ", gara=" + gara + ", price=" + price + ", providerID=" + providerID + ", img=" + img + ", createDate=" + createDate + ", Description=" + Description + '}';
    }
    
    
            
}
