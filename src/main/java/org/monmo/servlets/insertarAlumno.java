/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.monmo.servlets;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.monmo.entities.Alumno;
import org.monmo.negocio.AlumnoNegocio;

/**
 *
 * @author nv3ob61
 */
public class insertarAlumno extends HttpServlet {

  private static final long serialVersionUID = -2776574006094085602L;

  private Alumno a;

  private List<Alumno> listaAlumnos;

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
          throws ServletException, IOException, Exception {
    response.setContentType("text/html;charset=UTF-8");

    a = new Alumno();

    a.setFname(request.getParameter("fname"));
    a.setLname(request.getParameter("lname"));
    a.setLname2(request.getParameter("lname2"));

    AlumnoNegocio alumNeg = new AlumnoNegocio();
    //insertamos alumno
    alumNeg.insertarAlumno(a);
    //actualizar lista 
    listaAlumnos = alumNeg.consultarTodos();

    //variable app
    ServletContext app = getServletContext();

    //request y app atributos
    request.getSession().setAttribute("alumno", a);
    app.setAttribute("listaAlumnos", listaAlumnos);

    RequestDispatcher rd
            = getServletContext().getRequestDispatcher("/insertarAlumno.jsp");
    rd.forward(request, response);
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
    } catch (Exception ex) {
      Logger.getLogger(insertarAlumno.class.getName()).log(Level.SEVERE, null, ex);
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
    } catch (Exception ex) {
      Logger.getLogger(insertarAlumno.class.getName()).log(Level.SEVERE, null, ex);
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
