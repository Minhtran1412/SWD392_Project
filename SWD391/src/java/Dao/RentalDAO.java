package Dao;

import Model.Rental;
import java.math.BigDecimal; // Import thư viện BigDecimal
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Rental> searchByRentalAmountRange(double minRentalAmount, double maxRentalAmount) {
    List<Rental> agreements = new ArrayList<>();
    try {
        String sql = "SELECT ID, AgreementDate, AccountID, PropertyID, RentalAmount, Status FROM RentalAgreement WHERE RentalAmount BETWEEN ? AND ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, minRentalAmount);
        ps.setDouble(2, maxRentalAmount);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Rental agreement = new Rental();
            agreement.setId(rs.getInt("ID"));
            agreement.setAgreementDate(rs.getDate("AgreementDate")); // Retrieve AgreementDate as java.sql.Date
            agreement.setAccountID(rs.getInt("AccountID"));
            agreement.setPropertyID(rs.getInt("PropertyID"));
            agreement.setRentalAmount(BigDecimal.valueOf(rs.getDouble("RentalAmount"))); // Convert double to BigDecimal
            agreement.setStatus(rs.getInt("Status"));
            agreements.add(agreement);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return agreements;
}

    public String getPropertyById(int propertyID) {
    String propertyName = "";
    try {
        // Thực hiện truy vấn để lấy tên của property dựa trên ID
        String sql = "SELECT Name FROM Property WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, propertyID);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            propertyName = rs.getString("Name");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return propertyName;
}

    
    // Phương thức main() để test
    public static void main(String[] args) {
        // Khởi tạo một đối tượng RentalDAO
        RentalDAO rentalDAO = new RentalDAO();

        // Thực hiện tìm kiếm các hợp đồng thuê nhà trong khoảng giá từ 1000 đến 2000
        double minRentalAmount = 1000;
        double maxRentalAmount = 2000;
        List<Rental> agreements = rentalDAO.searchByRentalAmountRange(minRentalAmount, maxRentalAmount);

        // Hiển thị kết quả tìm kiếm
        if (agreements.isEmpty()) {
            System.out.println("Không tìm thấy hợp đồng thuê nhà trong khoảng giá từ " + minRentalAmount + " đến " + maxRentalAmount);
        } else {
            System.out.println("Các hợp đồng thuê nhà trong khoảng giá từ " + minRentalAmount + " đến " + maxRentalAmount + ":");
            for (Rental agreement : agreements) {
                System.out.println("ID: " + agreement.getId() +
                                   ", Agreement Date: " + agreement.getAgreementDate() +
                                   ", Account ID: " + agreement.getAccountID() +
                                   ", Property ID: " + agreement.getPropertyID() +
                                   ", Rental Amount: " + agreement.getRentalAmount() +
                                   ", Status: " + agreement.getStatus());
            }
        }
    }
}
