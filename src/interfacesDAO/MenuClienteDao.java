/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDAO;

import java.io.IOException;
import java.util.ArrayList;
import proyectoecl.Cliente;
import proyectoecl.Curso;

/**
 *
 * @author J. Rodrigo Ordóñez Pacheco
 */
public interface MenuClienteDao {
    public ArrayList<Curso> recuperarCursosExistentes() throws IOException;
    public ArrayList<Curso> recuperarMisCursos(Cliente cliente) throws IOException;
}
