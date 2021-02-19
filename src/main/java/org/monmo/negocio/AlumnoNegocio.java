/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.monmo.negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import org.monmo.datos.AlumnoDatos;
import org.monmo.datos.ConexionBaseDatos;
import org.monmo.entities.Alumno;

/**
 *
 * @author nv3ob61
 */
public class AlumnoNegocio implements Serializable{

  private static final long serialVersionUID = -6774786632512550335L;

  private AlumnoDatos alum = new AlumnoDatos();

  public List<Alumno> consultarTodos() throws Exception {
    Connection conn = null;
    ConexionBaseDatos cbd = new ConexionBaseDatos();
    List<Alumno> listaAlumnos = null;

    try {
      conn = cbd.abrirConexion();
      listaAlumnos = alum.consultarTodos(conn);
    } catch (Exception e) {
      throw e;
    } finally {
      cbd.cerrarConexion(conn);
    }

    return listaAlumnos;
  }

  public int insertarAlumno(Alumno a) throws Exception {
    int res;
    Connection conn = null;
    ConexionBaseDatos cbd = new ConexionBaseDatos();
    try {
      conn = cbd.abrirConexion();
      res = alum.insertarAlumno(conn, a);
    } catch (Exception excepcion) {
      throw excepcion;
    } finally {
      cbd.cerrarConexion(conn);
    }
    return res;
  }
}
