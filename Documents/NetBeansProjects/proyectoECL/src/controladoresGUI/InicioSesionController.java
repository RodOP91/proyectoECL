/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoresGUI;

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
        // TODO
    }    
    
}
