/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Megaprey
 */
public class SelectServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SelectServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SelectServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

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
//        processRequest(request, response);
        request.setCharacterEncoding("UTF-8");
        String sTable =(String)request.getParameter("sTable");
        String select = (String)request.getParameter("columnname");
        DbManager resultElem = new DbManager();
        if(select != null)
        {
        String a = resultElem.DbSelect(select, sTable);
        
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<!DOCTYPE HTML>");
            response.getWriter().println("<html><body><p>" + a + "</p></body></html>");
        
        }
        String insertColumn = (String)request.getParameter("InColumnname");
        String insertValue = (String)request.getParameter("valueColumn");
        if(insertColumn != null && insertValue != null)
        {
            resultElem.DbInsert(insertColumn, insertValue);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<!DOCTYPE HTML>");
            response.getWriter().println("<html><body><p>" + "Запрос выполнен" + "</p></body></html>");
        }
            String delTable = (String)request.getParameter("delTable");
            String condition = (String)request.getParameter("condition");
        if(delTable != null)
        {
            resultElem.DbDelete(delTable, condition);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<!DOCTYPE HTML>");
            response.getWriter().println("<html><body><p>" + "Запрос выполнен" + "</p></body></html>");
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
//        processRequest(request, response);
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
