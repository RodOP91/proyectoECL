/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfacesDAO.InicioSesionDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectoecl.Cliente;
import proyectoecl.Conexion;

/**
 *
 * @author J. Rodrigo Ordóñez Pacheco
 */
public class iniciosesionDAO implements InicioSesionDao{
    @Override
    public Cliente validarDatos(Cliente cliente){
        Cliente clientevalidado = null;
        PreparedStatement validarcliente = null;
        java.sql.Date sqldate;
        
        String sql = "SELECT * FROM `cliente` WHERE `nombre` = ? AND `contrasena` = ?";
        
        try{
            Conexion.conectar();
            
            validarcliente = Conexion.cnx.prepareStatement(sql);
            validarcliente.setString(1, cliente.getNombre());
            validarcliente.setString(2, cliente.getContrasenia());
            
            Conexion.res =validarcliente.executeQuery();
            Conexion.res.next();
            sqldate = Conexion.res.getDate(6);
            LocalDate fecha = sqldate.toLocalDate();
            clientevalidado = new Cliente(Conexion.res.getInt(1), Conexion.res.getString(2), Conexion.res.getString(3),
                    Conexion.res.getString(4), Conexion.res.getString(5), fecha, Conexion.res.getString(7), Conexion.res.getString(8),
                    Conexion.res.getString(9), Conexion.res.getString(10), Conexion.res.getString(11), Conexion.res.getInt(12));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
            
        }catch(NullPointerException nu){
            JOptionPane.showMessageDialog(null, "El usuario introducido no existe");
            System.out.println(nu.getMessage());
        }finally{
            if (Conexion.cnx != null){
                Conexion.cerrar();
            }
            if (validarcliente != null){
                try {
                    validarcliente.close();
                } catch (SQLException ex) {
                    Logger.getLogger(iniciosesionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println(clientevalidado.getNombre());
        return clientevalidado;
    }
}
