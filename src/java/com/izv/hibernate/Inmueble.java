package com.izv.hibernate;
// Generated 01-feb-2015 16:35:42 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Inmueble generated by hbm2java
 */
public class Inmueble  implements java.io.Serializable {


     private Integer id;
     private String localidad;
     private String direccion;
     private String tipo;
     private String precio;
     private String usuario;
     private Date fechaalta;

    public Inmueble() {
    }

	
    public Inmueble(String localidad, String direccion, String tipo, String usuario) {
        this.localidad = localidad;
        this.direccion = direccion;
        this.tipo = tipo;
        this.usuario = usuario;
    }
    public Inmueble(String localidad, String direccion, String tipo, String precio, String usuario, Date fechaalta) {
       this.localidad = localidad;
       this.direccion = direccion;
       this.tipo = tipo;
       this.precio = precio;
       this.usuario = usuario;
       this.fechaalta = fechaalta;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLocalidad() {
        return this.localidad;
    }
    
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Date getFechaalta() {
        return this.fechaalta;
    }
    
    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }




}


