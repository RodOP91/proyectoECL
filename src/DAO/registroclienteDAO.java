/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfacesDAO.RegistroClienteDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

import proyectoecl.Cliente;
import proyectoecl.Conexion;

/**
 *
 * @author ferzo
 */
public class registroclienteDAO implements RegistroClienteDao{
    
    /**
     * public boolean registroCliente(Cliente obj) throws SQLException
     * 
     * Método que crea un nuevo registro de un Cliente dentro de la base de datos.
     *
     * @param cliente tipo Cliente con los datos ingresados dentrio de la GUI.
     * @return flag tipo boolean, es true si la oepración fue exitosa.
     * @throws SQLException ex en caso de haber un error en la conexión con la BD.
     */
    @Override
    public boolean registroCliente(Cliente cliente) throws SQLException{
        PreparedStatement registrarcliente = null;
        boolean flag = false;
        String sql = "INSERT INTO `cliente`(`nombre`, `apellidop`, `apellidom`"
                + ", `curp`, `fechanac`, `contrasena`, `email`, `genero`) VALUES"
                + " (?, ?, ?, ?, ?, ?, ?, ?)";
        java.sql.Date date = java.sql.Date.valueOf(cliente.getFechanac());
        try{
            Conexion.conectar();
            
            registrarcliente = Conexion.cnx.prepareStatement(sql);
       
            registrarcliente.setString(1, cliente.getNombre());
            registrarcliente.setString(2, cliente.getApellidop());
            registrarcliente.setString(3, cliente.getApellidom());
            registrarcliente.setString(4, cliente.getCurp());
            registrarcliente.setDate(5, date);    
            registrarcliente.setString(6, cliente.getContrasenia());
            registrarcliente.setString(7, cliente.getEmail());
            registrarcliente.setInt(8, cliente.getGenero());
              
            registrarcliente.executeUpdate();
            flag = true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
        }finally{
            if (Conexion.cnx != null){
                Conexion.cerrar();
            }
            if (registrarcliente != null){
                registrarcliente.close();
            }
        }
        return flag;
    }
}
