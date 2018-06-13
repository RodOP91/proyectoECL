/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfacesDAO.RegistroClienteDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import proyectoecl.Cliente;
import proyectoecl.Conexion;

/**
 *
 * @author ferzo
 */
public class registroclienteDAO implements RegistroClienteDao{
    private Conexion conn;
    
    @Override
    public boolean registrarCliente(Cliente cliente) throws SQLException{
       Conexion conn = new Conexion();
       boolean flag = false;
       String sql = "INSERT INTO `cliente`(`nombre`, `apellidop`, "
               + "`apellidom`, `curp`, `fechanac`, "
               + "`contrasena`, `email`, `genero`) "
               + "VALUES ('"+ cliente.getNombre() +"','" + cliente.getApellidop() 
               +"','" + cliente.getApellidom() + "','" + cliente.getCurp() + "'," + cliente.getFechanac() + ",'" 
               + cliente.getContrasenia() + "','"+cliente.getEmail() 
               + "'," + cliente.getGenero() +")";
       flag =conn.ejecutar(sql);
       return flag;
    }
}
