/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author acer
 */
public class HouseDAO extends DBContext{
    public void updateHouse(int id, String Address, int Size, int bed, int bath, int gara, int price, int providerID, String img, Date CreateDate, String Description){
        String sql = "update Account_Customer set [customer_name] = ?, [customer_email] = ?, [customer_address]=?,[customer_phone]=?,[customer_dob]=? where [customer_id]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, customer_name);
            st.setString(2, customer_email);
            st.setString(3, customer_address);
            st.setString(4, customer_phone);
            st.setString(5, customer_dob);
            st.setString(6, customer_id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
}
