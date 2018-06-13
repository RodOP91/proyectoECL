/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDAO;

import java.sql.SQLException;
import proyectoecl.Cliente;

/**
 *
 * @author ferzo
 */
public interface RegistroClienteDao {
    public boolean registroCliente(Cliente cliente) throws SQLException;
}
