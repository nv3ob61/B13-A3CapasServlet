<%-- 
    Document   : listarAlumnos
    Created on : Feb 13, 2021, 6:49:43 PM
    Author     : nv3ob61
--%>

<%@page import="java.util.List"%>
<%@page import="org.monmo.entities.Alumno"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

  <%
    List<Alumno> listaAlumnos = new LinkedList<>();
    listaAlumnos = (List<Alumno>) session.getAttribute("listaAlumnos");
  %>
  <body>
    <div class="container">
      <h1 class="mt-5">Hallo Wer!</h1>
      <h5>Listado de alumnos:</h5>
      <table class="table table-bordered table-hover">
        <tr>
          <th>Nombre</th>
          <th>Apellido</th>
          <th>Edad</th>
        </tr>

        <%
          if (listaAlumnos != null) {
            for (Alumno al : listaAlumnos) {
        %>

        <tr>
          <td> <%= al.getFname()%></td>
          <td> <%= al.getLname()%></td>
          <td> <%= al.getLname2()%></td>
        </tr>
        <% }
        } else { %>
        <tr>
          <td> - </td>
          <td> - </td>
          <td> - </td>
        </tr> <%
          }
        %>
      </table>

      <a href="index.html">Index</a>
    </div>
  </body>
</html>
