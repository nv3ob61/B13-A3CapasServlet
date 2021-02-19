package org.monmo.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.monmo.negocio.MyException;

public class ConexionBaseDatos {

  public Connection abrirConexion() throws Exception {
    Connection connection = null;
    try {
      /*  
      //    CONEXION MySQL
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
       */
      //    CONEXION Oracle
      Class.forName("oracle.jdbc.driver.OracleDriver");
      connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.11:1521:ORCL", "crud1", "pass");

    } catch (SQLException excepcion) {
      throw new MyException(50);
    }

    return connection;
  }

  public void cerrarConexion(Connection connection) throws MyException {
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException excepcion) {
      throw new MyException(50);
    }
  }
}
