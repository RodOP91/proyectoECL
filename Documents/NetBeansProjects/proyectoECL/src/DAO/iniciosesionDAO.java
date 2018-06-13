/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfacesDAO.InicioSesionDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import proyectoecl.Cliente;
import proyectoecl.Conexion;

/**
 *
 * @author J. Rodrigo Ordóñez Pacheco
 */
public class iniciosesionDAO implements InicioSesionDao{
    @Override
    public boolean validarDatos(Cliente cliente){
        boolean validado = false;
        PreparedStatement validarcliente = null;
       
        String sql = "SELECT * FROM `cliente` WHERE `nombre` = ?";
        java.sql.Date date = java.sql.Date.valueOf(cliente.getFechanac());
        try{
            Conexion.conectar();
            
            validarcliente = Conexion.cnx.prepareStatement(sql);
          
            validarcliente.setString(1, cliente.getContrasenia());
            
              
            validarcliente.executeQuery(sql);
            validado = true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
        }finally{
            if (Conexion.cnx != null){
                Conexion.cerrar();
            }
            if (validarcliente != null){
                validarcliente.close();
            }
        }
        return validado;
    }
}
