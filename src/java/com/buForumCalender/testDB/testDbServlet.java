/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.testDB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author hpavilion-au171TX
 */
@WebServlet(name = "testDbServlet", urlPatterns = {"/testDbServlet"})
public class testDbServlet extends HttpServlet {

    
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
        String user = "root";
        String pass = "";
        
        String jdbcurl = "jdbc:mysql://localhost:3306/artmuseum?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        
        try{
            PrintWriter out = response.getWriter();
            Class.forName(driver);
            Connection myconn = DriverManager.getConnection(jdbcurl, user, pass);
            out.println("Succesful");
            myconn.close();
            
        }catch(Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
        
    }



}
