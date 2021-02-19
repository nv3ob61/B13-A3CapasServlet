/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.monmo.negocio;

/**
 *
 * @author nv3ob61
 */
public class MyException extends Exception {

  private static final long serialVersionUID = 1432402745338991168L;

  private int codigoError;

  public MyException(int codigoError) {
    this.codigoError = codigoError;
  }

  public int getCodigoError() {
    return codigoError;
  }

  public String gestionarExcepcion(Exception e) {
    String mensajeError = "";

    if (e instanceof MyException) {
      MyException genericaExcepcion = (MyException) e;
      codigoError = genericaExcepcion.getCodigoError();
      switch (genericaExcepcion.getCodigoError()) {
        case 50:
          mensajeError = "Se ha producido una situación de error como consecuencia de problemas con la conexión a la BD";
          break;
        case 71:
          mensajeError = "No existe un libro con ese identificador";
          break;
        case 80:
          mensajeError = "Se ha producido una situación de error en la BD al intentar insertar libro";
          break;
        case 81:
          mensajeError = "Se ha producido una situación de error en la BD al intentar actualizar premiado";
          break;
        case 82:
          mensajeError = "Se ha producido una situación de error en la BD al intentar eliminar libro";
          break;
        case 83:
          mensajeError = "Se ha producido una situación de error en la BD al intentar consultar por identificador de libro";
          break;
        case 84:
          mensajeError = "Se ha producido una situación de error en la BD al intentar consultar todos los libros";
          break;
        case 85:
          mensajeError = "Se ha producido una situación de error en la BD al intentar consultar el número de libros";
          break;
        case 90:
          mensajeError = "Se ha producido una situación de error en la BD al intentar consultar la relación de géneros";
          break;
      }
    } else {
      if (e instanceof NumberFormatException) {
        mensajeError = "La totalidad de los dígitos deben ser numéricos";
      } else {
        mensajeError = e.getMessage();
      }
    }
    System.out.println("Código de error: " + codigoError + "  -  " + mensajeError);
    return mensajeError;
  }

}
