/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfacesDAO.MenuClienteDao;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyectoecl.Cliente;
import proyectoecl.Conexion;
import proyectoecl.Curso;

/**
 *
 * @author J. Rodrigo Ordóñez Pacheco
 */
public class menuclienteDAO implements MenuClienteDao{
    ArrayList<Curso> cursosexistentes= null;
    ArrayList<Curso> miscursos = null;
    java.sql.Date fechainicio;
    java.sql.Date fechafin;
    
    @Override
    public ArrayList<Curso> recuperarCursosExistentes() throws IOException{
        PreparedStatement selectcursos = null;
        
        String sql= "SELECT * FROM `curso`";
        try{
            Conexion.conectar();
            selectcursos = Conexion.cnx.prepareStatement(sql);
            Conexion.res = selectcursos.executeQuery();
            while(Conexion.res.next()){
                
                //Manipulación de fechas
                fechainicio = Conexion.res.getDate(6);
                fechafin = Conexion.res.getDate(7);                
                LocalDate fechai = fechainicio.toLocalDate();
                LocalDate fechaf = fechafin.toLocalDate();
                
                //Creación de Objeto Curso
                Curso curso = new Curso(Conexion.res.getInt(1), Conexion.res.getString(2), Conexion.res.getString(3),
                Conexion.res.getString(4), Conexion.res.getFloat(5), fechai, fechaf);
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
        }
        
        return cursosexistentes;
    }
    
    public ArrayList<Curso> recuperarMisCursos(Cliente cliente) throws IOException{
        PreparedStatement selectmiscursos = null;
        String sql = "SELECT `idcurso` FROM `cliente_curso` WHERE `idcliente` = ?";
        
        try{
            
        }
        return miscursos;
    }
}
