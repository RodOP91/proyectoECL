/*
 *Capa de persistencia de datos. 
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
    Integer idcursos[];
    java.sql.Date fechainicio;
    java.sql.Date fechafin;
    
    /**
     * public ArrayList<Curso> recuperarCursosExistentes throws IOExeption
     * Recupera de la Base de Datos todos los cursos existentes registrados y
     * los añade a la lista cursosexistentes.
     * @return ArrayList<Curso> lista de todos los Cursos existentes en la Base de datos.
     * @throws IOException Error en la conexión con la base de datos.
     */
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
                cursosexistentes.add(curso);
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
        }
        Conexion.cerrar();
        return cursosexistentes;
    }
    
    /**
     * public ArrayList<Curso> recuperarMisCursos throws IOException
     * @param cliente objeto de tipo Cliente que contiene la información
     * del Cliente que está en el sistema.
     * @return miscursos ArrayList<Curso> lista que contiene los Cursos en los que 
     * el Cliente está inscrito.
     * @throws IOException Error en la conexión con la base de datos.
     */
    @Override
    public ArrayList<Curso> recuperarMisCursos(Cliente cliente) throws IOException{
        
        //La primera parte se encargar de traer las ID de los cursos en los que el
        //Cliente está inscrito.
        
        PreparedStatement selectmiscursos = null;
        String sql = "SELECT `idcurso` FROM `cliente_curso` WHERE `idcliente` = ?";
        int x=0;
        try{
            
            Conexion.conectar();
            selectmiscursos = Conexion.cnx.prepareStatement(sql);
            selectmiscursos.setInt(1, cliente.getId());
            Conexion.res = selectmiscursos.executeQuery();
            
            while(Conexion.res.next()){
                idcursos[x]= Conexion.res.getInt(1);
                x++;
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
        }
        Conexion.cerrar();
        
        //La segunda parte se encarga de usar las ID recuperadas para recuperar
        //toda la información de los Cursos en los que el Cliente está inscrito.
        
        selectmiscursos = null;
        sql = "SELECT * FROM `curso` WHERE `idcurso`= ?";
        for(x=0; x<idcursos.length;x++){
            try{
            
            Conexion.conectar();
            selectmiscursos = Conexion.cnx.prepareStatement(sql);
            selectmiscursos.setInt(1, idcursos[x]);
            
            Conexion.res = selectmiscursos.executeQuery();
            while(Conexion.res.next()){
                
                //Manipulación de fechas
                fechainicio = Conexion.res.getDate(6);
                fechafin = Conexion.res.getDate(7);                
                LocalDate fechai = fechainicio.toLocalDate();
                LocalDate fechaf = fechafin.toLocalDate();
                
                //Creacion de objeto Curso
                Curso curso = new Curso(Conexion.res.getInt(1), Conexion.res.getString(2), Conexion.res.getString(3),
                Conexion.res.getString(4), Conexion.res.getFloat(5), fechai, fechaf);
                miscursos.add(curso);
            }
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
            }
            Conexion.cerrar();
        }
        
        return miscursos;
    }
}
