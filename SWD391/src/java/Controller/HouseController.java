/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Dao.HouseDAO;
import Model.Account;
import Model.Property;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author acer
 */
public class HouseController extends HttpServlet {
   
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HouseDAO hdao = new HouseDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Property p = hdao.getPropertyById(id);
        request.setAttribute("p", p);
        request.getRequestDispatcher("update-house.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Part filePart = request.getPart("file");
        String img = convertStreamToString(filePart.getInputStream());
        String address = request.getParameter("address");
        int id = Integer.parseInt(request.getParameter("id"));
        int size = Integer.parseInt(request.getParameter("size"));
        int bed = Integer.parseInt(request.getParameter("bed"));
        int bath = Integer.parseInt(request.getParameter("bath"));
        int gara = Integer.parseInt(request.getParameter("gara"));
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        
        Account a = (Account) request.getSession().getAttribute("acc");
        HouseDAO hdao = new HouseDAO();
        hdao.updateHouse(id, address, size, bed, bath, gara, price,img, description);
        request.getRequestDispatcher("manageHouseController").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

}
