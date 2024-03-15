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
    public void updateHouse(int id, String Address, int Size, int bed, int bath, int gara, int price, int providerID, String img, Date createDate, String Description){
        String sql = "update Property set [Address] = ?, [Size] = ?, [bed]=?,[bath]=?,[gara]=?, [price]=?, [providerID]=?, [img]=?, [CreateDate]=?, [Description]=? where [id]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, Address);
            st.setInt(2, Size);
            st.setInt(3, bed);
            st.setInt(4, bath);
            st.setInt(5, gara);
            st.setInt(6, price);
            st.setInt(7, providerID);
            st.setString(8, img);
            st.setDate(9, createDate);
            st.setString(10, Description);
            st.setInt(11, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
}
