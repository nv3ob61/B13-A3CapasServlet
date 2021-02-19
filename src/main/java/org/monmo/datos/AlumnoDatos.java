/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.monmo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.monmo.entities.Alumno;
import org.monmo.negocio.MyException;

/**
 *
 * @author nv3ob61
 */
public class AlumnoDatos {

  public static final String SQL_INSERT = "INSERT INTO alumnos VALUES(?,?,?)";

  public List<Alumno> consultarTodos(Connection connection) throws Exception {
    List<Alumno> listaAlumnos = new ArrayList();
    ResultSet resultSet = null;
    Statement statement = null;
    try {
      String sql = "SELECT * from alumnos";
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);
      while (resultSet.next()) {
        Alumno a = new Alumno();
        a.setFname(resultSet.getString(1));
        a.setLname(resultSet.getString(2));
        a.setLname2(resultSet.getString(3));
        listaAlumnos.add(a);
      }
    } catch (SQLException excepcion) {
      throw new MyException(84);
    } finally {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
    }
    return listaAlumnos;
  }

  public int insertarAlumno(Connection conn, Alumno a) throws MyException, SQLException {
    int res;
    try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT)) {
      ps.setString(1, a.getFname());
      ps.setString(2, a.getLname());
      ps.setString(3, a.getLname2());
      //execute update
      res = ps.executeUpdate();
    } catch (SQLException e) {
      throw new MyException(80);
    }
    return res;
  }

}
