/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoresGUI;

import DAO.registroclienteDAO;
import java.net.URL;
import java.time.*;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;
import proyectoecl.Cliente;
import proyectoecl.Conexion;

/**
 * FXML Controller class
 *
 * @author ferzo
 */
public class RegistroClienteController implements Initializable {

    @FXML
    private TextField txtfnombre;
    @FXML
    private TextField txtfapellidop;
    @FXML
    private TextField txtfapellidom;
    @FXML
    private TextField txtfemail;
    @FXML
    private Font x1;
    @FXML
    private TextField txtfcurp;
    @FXML
    private ComboBox<?> cbxdia;
    @FXML
    private ComboBox<?> cbxmes;
    @FXML
    private ComboBox<?> cbxanio;
    @FXML
    private Button btncancelar;
    @FXML
    private Button btnregistrarse;
    @FXML
    private ComboBox cbxgenero;
    @FXML
    private TextField txtfcontrasenia;
    @FXML
    private Pane panefecha;
    @FXML
    private DatePicker dpfecha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> opciones=
                FXCollections.observableArrayList(
                "Mujer", "Hombre");
        cbxgenero.setItems(opciones);
        
        //panefecha = nr
        
        
        
        btnregistrarse.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            int genero= cbxgenero.getSelectionModel().getSelectedIndex();
            
            Cliente cliente = new Cliente(txtfnombre.getText(), txtfapellidop.getText(), 
            txtfapellidom.getText(), txtfcurp.getText(), txtfcontrasenia.getText(), 
                    txtfemail.getText(), genero, dpfecha.getValue());
            System.out.println(dpfecha.getValue());
            Conexion.conectar();
            try{
                registroclienteDAO registro = new registroclienteDAO();
                boolean flag =registro.registroCliente(cliente);
                
                if(flag == true){
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                }else{
                    JOptionPane.showMessageDialog(null, "La operación no se pudo completar");
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
            }
            
            //System.out.println(cbxgenero.getSelectionModel().getSelectedIndex());
}
    });
    }    
    
}
