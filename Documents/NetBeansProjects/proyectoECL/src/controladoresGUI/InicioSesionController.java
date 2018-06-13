/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoresGUI;

import DAO.iniciosesionDAO;
import java.net.URL;
import java.util.ResourceBundle;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


import javafx.stage.Stage;
import javax.swing.JOptionPane;
import proyectoecl.Cliente;


/**
 * FXML Controller class
 *
 * @author ferzo
 */
public class InicioSesionController implements Initializable {

    /* ATRIBUTOS*/
    
    private @FXML Button btningresar;
    private @FXML Button btnregistro;
    private @FXML TextField txtfnomusuario;
    private @FXML PasswordField pwfcontrasena;
    
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnregistro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try{
                    Parent root = FXMLLoader.load(getClass().getResource("/gui/registroCliente.fxml"));                                
                
                    Stage stage = new Stage();                                                
                    Scene scene = new Scene(root);
                
                    stage.setScene(scene);
                    //Image icono = new Image("/imagenes/Logo SIT.png");
                    //stage.getIcons().add(icono);
                    stage.setResizable(false);
                    stage.setTitle("Educación Continua en Línea");
                    stage.show();                
                    Stage nextstage = (Stage) btnregistro.getScene().getWindow();
                    nextstage.close();
                    }catch(IOException ex){
                        JOptionPane.showMessageDialog(null, "Error, archivo FXML no encontraado");
                    }
              
            }
    });
        btningresar.setOnAction(new EventHandler<ActionEvent> (){
            @Override
            public void handle(ActionEvent event){
                iniciosesionDAO inicio = new iniciosesionDAO();
                Cliente cliente = new Cliente(txtfnomusuario.getText(), pwfcontrasena.getText());
                
                inicio.validarDatos(cliente);
            }
        });
    }
    
    public void cerrarVentana(){
        Stage stage = (Stage) this.btnregistro.getScene().getWindow();
        stage.close();
    }
}
