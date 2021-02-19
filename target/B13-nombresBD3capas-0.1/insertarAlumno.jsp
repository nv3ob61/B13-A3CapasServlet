<%-- 
    Document   : index
    Created on : 4 Feb 2021, 23:05:01
    Author     : jonsui10
--%>

<%@page import="org.monmo.entities.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>B10</title>
    <style>

      table, h1, h3, a {
          display: flex;
          text-align: center;
          align-items: center;
          justify-content: center;
      }

      td:nth-child(even){
          align-items: center;
          text-align: center;
          background-color: aliceblue;
      }
      td:nth-child(odd){
          align-items: center;
          text-align: center;
          background-color: beige;
      }

    </style>
        <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

  </head>
  <body>
    <h1>Menu Insertar Alumnos</h1>
    <table class="table table-bordered">
      <tr>
        <td>Nombre</td>
        <td>Apellido</td>
        <td>Apellido2</td>
      </tr>     
      <%

        session = request.getSession();

        Alumno alumno = (Alumno) session.getAttribute("alumno");

      %>
      <tr>
        <td> <%= alumno.getFname()%></td>
        <td> <%= alumno.getLname()%></td>
        <td> <%= alumno.getLname2()%></td>
      </tr>
    </table>           
    <a href="index.html">Add another student</a>
  </body>
</html>
