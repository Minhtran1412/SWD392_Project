package Dao;

import Model.Rental;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalDAO extends DBContext {

    public List<Rental> searchByRentalAmountRange(double minRentalAmount, double maxRentalAmount) {
        List<Rental> agreements = new ArrayList<>();
        try {
            String sql = "SELECT * FROM RentalAgreement WHERE RentalAmount BETWEEN ? AND ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, minRentalAmount);
            ps.setDouble(2, maxRentalAmount);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rental agreement = new Rental();
                agreement.setId(rs.getInt("ID"));
                agreement.setAgreementDate(rs.getInt("AgreementDate"));
                agreement.setAccountID(rs.getInt("AccountID"));
                agreement.setPropertyID(rs.getInt("PropertyID"));
                agreement.setRentalAmount(rs.getDouble("RentalAmount"));
                agreement.setStatus(rs.getInt("Status"));
                agreements.add(agreement);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return agreements;
    }
   public static void main(String[] args) {
        // Khởi tạo một đối tượng RentalDAO
        RentalDAO rentalAgreementDAO = new RentalDAO();

        // Thực hiện tìm kiếm các hợp đồng thuê nhà trong khoảng giá từ 100 đến 500
        double minRentalAmount = 1000;
        double maxRentalAmount = 2000;
        List<Rental> agreements = rentalAgreementDAO.searchByRentalAmountRange(minRentalAmount, maxRentalAmount);

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
