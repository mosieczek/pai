/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ihate
 */
@WebServlet(name = "DetailsServlet", urlPatterns = {"/DetailsServlet"})
public class DetailsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String value = request.getParameter("country");
//        out.write(value);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //pobranie sterownika do MySQL
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?serverTimezone=UTC", "root", "");
            Statement st = conn.createStatement(); 
            String query="SELECT * FROM Country WHERE Name = '" + value + "' ";
            out.print(query);
            ResultSet rs = st.executeQuery(query);
            DetailsBean details;
            ArrayList<DetailsBean> list = new ArrayList<>();
            while (rs.next()) {
                //pobierz i wyświetl dane z odpowiedniej kolumny
                details = new DetailsBean();
                details.setName(rs.getString("name"));
                details.setCode(rs.getString("code"));
                details.setPopulation(rs.getLong("population"));
                details.setContinent(rs.getString("continent"));
                details.setRegion(rs.getString("region"));
                details.setSurfacearea(rs.getDouble("surfacearea"));
                details.setIdepyear(rs.getLong("indepyear"));
                details.setLifeexpactancy(rs.getDouble("LifeExpectancy"));
                details.setGnp(rs.getDouble("gnp"));
                details.setGnpoid(rs.getDouble("GNPOld"));
                details.setLocalname(rs.getString("localname"));
                details.setGovernmentform(rs.getString("governmentform"));
                details.setHeadofstate(rs.getString("headofstate"));
                details.setCapital(rs.getLong("capital"));
                details.setCode2(rs.getString("code2"));
                list.add(details);
                out.print(rs.getString("name"));
                out.print(" ");
                out.print(rs.getString("code"));
                out.print(" ");
                out.print(rs.getString("population"));
                out.print(" <br/>");
            }
            HttpSession session = request.getSession();  
            session.setAttribute("list", list);
            response.sendRedirect("details.jsp");


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
