/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoecl;

import java.time.*;
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
    private LocalDate fechanac;
    private String folio;
    private String refbancaria;
    private String matricula;
    private String contrasenia;
    private String email;
    private int genero; // 0= mujer  1= hombre

    public Cliente(){
        
    }
    public Cliente(String nombre, String apellidop, String apellidom, String curp, 
            LocalDate fechanac, String folio, String refbancaria, String matricula, 
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
        this.genero = genero; 
    }

    public Cliente(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public Cliente(String nombre, String apellidop, String apellidom, String curp, 
            String contrasenia, String email, int genero, LocalDate fecha) {
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.curp = curp;
        this.contrasenia = contrasenia;
        this.email = email;
        this.genero = genero;
        this.fechanac= fecha;
        
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

    public LocalDate getFechanac() {
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

    public void setFechanac(LocalDate fechanac) {
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
