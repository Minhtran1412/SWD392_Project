package Controller;

import Dao.RentalDAO;
import Model.Rental;
import java.io.IOException;
import java.math.BigDecimal; // Import thư viện BigDecimal
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "RentalController", urlPatterns = {"/rental-agreement"})
public class RentalController extends HttpServlet {

    private RentalDAO rentalDAO;

    @Override
    public void init() throws ServletException {
        rentalDAO = new RentalDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Lấy giá trị minRentalAmount và maxRentalAmount từ request
            double minRentalAmount = Double.parseDouble(request.getParameter("minRentalAmount"));
            double maxRentalAmount = Double.parseDouble(request.getParameter("maxRentalAmount"));

            // Gọi phương thức tìm kiếm trong DAO để lấy danh sách hợp đồng thuê nhà
            List<Rental> agreements = rentalDAO.searchByRentalAmountRange(minRentalAmount, maxRentalAmount);

            // Đặt danh sách hợp đồng vào thuộc tính của request để hiển thị trên trang JSP
            request.setAttribute("agreements", agreements);
            request.getRequestDispatcher("rental.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Xử lý nếu có lỗi khi chuyển đổi dữ liệu thành số
            request.setAttribute("errorMessage", "Invalid input. Please enter valid numbers.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
