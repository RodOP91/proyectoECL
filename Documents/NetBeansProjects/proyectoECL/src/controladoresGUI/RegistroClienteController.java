/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoresGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxgenero
        btnregistrarse.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            cbxgenero.getSelectionModel().getSelectedItem()
            Cliente cliente = new Cliente(txtfnombre.getText(), txtfapellidop.getText(), 
            txtfapellidom.getText(), txtfcurp.getText(), txtfcontrasenia.getText(), txtfemail.getText())
        }
    });
    }    
    
}
