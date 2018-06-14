/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoresGUI;

import DAO.menuclienteDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;
import proyectoecl.Cliente;
import proyectoecl.Curso;

/**
 * FXML Controller class
 *
 * @author J. Rodrigo Ordóñez Pacheco
 */
public class MenuClienteController implements Initializable {

    @FXML
    private Label lblnombrecliente;
    @FXML
    private Button btnmiperfil;
    @FXML
    private Button btncursos;
    @FXML
    private Font x1;
    @FXML
    private Button btnmiscursos;
    
    private static Cliente cliente = null;
    private static ArrayList<Curso> cursosexistentes =null;
    private static ArrayList<Curso> miscursos =null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblnombrecliente.setText(cliente.getNombre() + " " + cliente.getApellidop() + " " + cliente.getApellidop());
        lblnombrecliente.setVisible(true);
        menuclienteDAO menucliente= new menuclienteDAO();
        
        try{
            cursosexistentes = menucliente.recuperarCursosExistentes();
            miscursos = menucliente.recuperarCursosExistentes();
        }catch(IOException io){
            JOptionPane.showMessageDialog(null, io.getMessage());
        }
        
        
       
    }


    public static void setCliente(Cliente cliente){
        MenuClienteController.cliente = cliente;
    }
    
}
