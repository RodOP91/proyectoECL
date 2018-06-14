/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoecl;

import java.time.LocalDate;

/**
 *
 * @author J. Rodrigo Ordóñez Pacheco
 */
public class Curso {
    private int idcurso;
    private String nombre;
    private String descripcion;
    private String area;
    private float costo;
    private LocalDate fechainicio;
    private LocalDate fechafin;

    public Curso(int idcurso,String nombre,  String descripcion, String area, float costo, LocalDate fechainicio, LocalDate fechafin) {
        this.idcurso = idcurso;
        this.descripcion = descripcion;
        this.area = area;
        this.costo = costo;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }
    
    
}
