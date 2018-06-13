/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoecl;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


/**
 *Clase dedicada a definir los métodos para realizar las conexiones con la base
 * de datos.
 * @author J. Rodrigo Ordóñez Pacheco
 */
public class Conexion{

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost/proyectoecl";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    
    public static Connection cnx;
    public static Statement sentencia;
    public static ResultSet res;
    
    //CONSTRUCTOR
    public Conexion(){
        
        
    }
    /**
     * Método que realiza la conexión con la DB para la tecnologia SQL.
     */
    
    public static void conectar(){
        try{
            Class.forName(DB_DRIVER);//DRIVER
            cnx = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);//CONECCION (DATOS: DIRECCION DE LA BASE, USER, PASS)
            
            if(cnx != null){
                sentencia = cnx.createStatement();//CREAR LA CONEXION
                System.out.println("Conexión exitosa");
            }
        }        
        catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex);//ERROR
        }
    }
    /**
     * Método que cierra la conexion con la BD.
     */
    public static void cerrar(){
        if(cnx != null){
            try {
                cnx.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }else{
            System.out.println("No hay conexión para cerrar");
        }
    }
    /**
     * Método que se usa para ejecutar instrucciones sql como Insert, Delete y
     * Update
     * @param sql
     * Consulta sql proporcionada por los metodos de clases DAO que utilizan a 
     * la clase Conexion
     * @return flag
     * Valor boolean que indica si se realizo la instrucción sql
     */
    public static boolean ejecutar(String sql){
        boolean flag;
        try{
            sentencia.execute(sql);
            sentencia.close();
            flag = true;
        }
        catch(SQLException ex){
            System.err.println(ex);
            flag = false;
        }
        return flag;
    }

    /**
     * Método que realiza las instrucciones sql Select y Join.
     * @param sql
     * Consulta sql proporcionada por los metodos de clases DAO que utilizan a 
     * la clase Conexion
     * @return res
     * Set de Resultados con todos los registros que se recuperaron de la DB.
     */
    public static ResultSet consultar(String sql){
        try{
            res = sentencia.executeQuery(sql);
        }
        catch(SQLException ex){
            System.err.println(ex);
            return null;
        }
        catch(NullPointerException ex){
            System.err.println(ex);
        }
        return res;
    }
    
    public void setCnxNull(){
        this.cnx = null;
    }
}

