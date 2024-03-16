package Dao;

import Model.RentalAgreement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalAgreementDAO extends DBContext {

    public List<RentalAgreement> searchByRentalAmountRange(double minRentalAmount, double maxRentalAmount) {
        List<RentalAgreement> agreements = new ArrayList<>();
        try {
            String sql = "SELECT * FROM RentalAgreement WHERE RentalAmount BETWEEN ? AND ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, minRentalAmount);
            ps.setDouble(2, maxRentalAmount);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RentalAgreement agreement = new RentalAgreement();
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
}
