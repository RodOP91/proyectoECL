/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfacesDAO.InicioSesionDao;
import proyectoecl.Cliente;

/**
 *
 * @author ferzo
 */
public class iniciosesionDAO implements InicioSesionDao{
    @Override
    public Cliente consultarCliente(String nomcliente){
        Cliente cliente = new Cliente();
        return cliente;
    }
}
