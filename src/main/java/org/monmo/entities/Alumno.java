/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.monmo.entities;

import java.io.Serializable;

/**
 *
 * @author nv3ob61
 */
public class Alumno implements Serializable{

  private static final long serialVersionUID = -6386732587771828963L;

  private String fname;
  private String lname;
  private String lname2;

  public Alumno() {
  }

  public Alumno(String fname, String lname, String lname2) {
    this.fname = fname;
    this.lname = lname;
    this.lname2 = lname2;
  }

  public String getFname() {
    return fname;
  }

  public String getLname() {
    return lname;
  }

  public String getLname2() {
    return lname2;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public void setLname2(String lname2) {
    this.lname2 = lname2;
  }

}
