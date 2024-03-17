/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Account;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dell
 */
public class AccountDAO extends DBContext {

    public Account findAcount(String username, String password) {
        try {
            Connection connection = this.connection;
            String sql = "  SELECT [name],[username] ,[email] ,[address] ,[phone]  ,[avt] ,[status] , [role]\n"
                    + "  FROM [dbo].[Account]\n"
                    + "  WHERE [username] =? AND [password] = ?";
            
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account a = Account.builder()
                        .name(rs.getString("name"))
                        .username(rs.getString("username"))
                        .email(rs.getString("email"))
                        .address(rs.getString("address"))
                        .phone(rs.getString("phone"))
                        .avt(rs.getString("avt"))
                        .status(rs.getString("status"))
                        .role(rs.getString("role"))
                        .build();
                return  a;
//                return new Account(rs.getString(1),rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new AccountDAO().findAcount("user1", "123"));
    }
}
