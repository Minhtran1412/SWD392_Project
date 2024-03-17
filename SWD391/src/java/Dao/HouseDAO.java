/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Property;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class HouseDAO extends DBContext{
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public void updateHouse(int id, String Address, int Size, int bed, int bath, int gara, double price, String img, String Description){
        String sql = "update Property set [Address] = ?, [Size] = ?, [bed]=?,[bath]=?,[gara]=?, [price]=?, [img]=?, [Description]=? where [id]=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, Address);
            st.setInt(2, Size);
            st.setInt(3, bed);
            st.setInt(4, bath);
            st.setInt(5, gara);
            st.setDouble(6, price);
            st.setString(7, img);
            st.setString(8, Description);
            st.setInt(9, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public List<Property> getAllHouse(){
        List<Property> data = new ArrayList<>();
        try {
            String sql = "select * from Property";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String Address = rs.getString(2);
                int size = rs.getInt(3);
                int bed = rs.getInt(4);
                int bath = rs.getInt(5);
                int gara = rs.getInt(6);
                double price = rs.getDouble(7);
                int providerID = rs.getInt(8);
                String img = rs.getString(9);
                Time createDate = rs.getTime(10);
                String description = rs.getString(11);
                data.add(new Property(id, Address, size, bed, bath, gara, price, providerID, img, createDate, description));
            }
        } catch (Exception e) {
            System.out.println("List property: " + e.getMessage());
        }
        return data;
    }
    
    public Property getPropertyById(int id){
        String sql = "select * from Property where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Property p = new Property();
                p.setId(id);
                p.setAddress(rs.getString(2));
                p.setSize(rs.getInt(3));
                p.setBed(rs.getInt(4));
                p.setBath(rs.getInt(5));
                p.setGara(rs.getInt(6));
                p.setPrice(rs.getDouble(7));
                p.setProviderID(rs.getInt(8));
                p.setImg(rs.getString(9));
                p.setCreateDate(rs.getTime(10));
                p.setDescription(rs.getString(11));
                
                return p;
                            
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        HouseDAO hdao = new HouseDAO();
        List<Property> list = hdao.getAllHouse();
        for (Property pr : list) {
            System.out.println(pr);
        }
    }
}
