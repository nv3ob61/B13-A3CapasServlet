/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.monmo.entities;

import java.util.LinkedList;
import java.util.List;
import org.monmo.negocio.AlumnoNegocio;

/**
 *
 * @author nv3ob61
 */
public class TestMain {

  /**
   * @param args the command line arguments
   * @throws java.lang.Exception
   */
  public static void main(String[] args) throws Exception {
    // TODO code application logic here
    
    List<Alumno> newList = new LinkedList<>();
    
    Alumno a = new Alumno();
    
    a.setFname("Prueba");
    a.setLname("Ape1Test");
    a.setLname2("Ape2Test");
    
    AlumnoNegocio aNeg = new AlumnoNegocio();
    
    aNeg.insertarAlumno(a);
    newList = aNeg.consultarTodos();
    
    for (Alumno alumno : newList) {
      System.out.println(alumno.getFname());
      System.out.println(alumno.getLname());
      System.out.println("---");
    }
  }
  
}
