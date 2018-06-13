/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoecl;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author ferzo
 */
public class Cliente {
    private String nombre;
    private String apellidop;
    private String apellidom;
    private String curp;
    private Date fechanac;
    private String folio;
    private String refbancaria;
    private String matricula;
    private String contrasenia;
    private String email;
    private int genero;

    public Cliente(String nombre, String apellidop, String apellidom, String curp, 
            Date fechanac, String folio, String refbancaria, String matricula, 
            String contrasenia, String email, int genero) {
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.curp = curp;
        this.fechanac = fechanac;
        this.folio = folio;
        this.refbancaria = refbancaria;
        this.matricula = matricula;
        this.contrasenia = contrasenia;
        this.email = email;
        this.genero = genero; // 0= mujer  1= hombre
    }

    public Cliente(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public Cliente(String nombre, String apellidop, String apellidom, String curp, 
            String contrasenia, String email, int genero, int dia, int mes, int anio) {
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.curp = curp;
        this.contrasenia = contrasenia;
        this.email = email;
        this.genero = genero;
        this.fechanac= this.calcularFecha(dia, mes, anio);
        
    }
    
    private Date calcularFecha(int dia, int mes, int anio){
        dia = Calendar.DAY_OF_MONTH;
        mes = Calendar.MONTH;
        anio = Calendar.YEAR;
        Date fecha = Date.valueOf(anio+"-"+mes+"-"+dia);
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public String getCurp() {
        return curp;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public String getFolio() {
        return folio;
    }

    public String getRefbancaria() {
        return refbancaria;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public int getGenero() {
        return genero;
    }

    
    
    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public void setRefbancaria(String refbancaria) {
        this.refbancaria = refbancaria;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
    
    
    
    
}
