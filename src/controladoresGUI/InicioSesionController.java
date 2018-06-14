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
import java.util.Arrays;
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
    
    private Cliente clientevalidado= null;
    
     
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
                    System.out.println("aqui");
                    Stage stage = new Stage();                                                
                    Scene scene = new Scene(root);
                
                    stage.setScene(scene);
                    Image icono = new Image("/imagenes/LogoECL.png");
                    stage.getIcons().add(icono);
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
                
                if(validarCamposDeTexto(txtfnomusuario.getText(), pwfcontrasena.getText()) == true){
                    try{
                        Cliente cliente = new Cliente(txtfnomusuario.getText(), pwfcontrasena.getText());
                        clientevalidado =inicio.validarDatos(cliente);
                        
                        if(clientevalidado == null){
                            JOptionPane.showMessageDialog(null, "Error en los datos ingresados");
                        }else{
                            try{
                                MenuClienteController.setCliente(clientevalidado);
                                Parent root = FXMLLoader.load(getClass().getResource("/gui/menuCliente.fxml"));
                                
                                Stage stage = new Stage();                                                
                                Scene scene = new Scene(root);
                
                                stage.setScene(scene);
                                Image icono = new Image("/imagenes/LogoECL.png");
                                stage.getIcons().add(icono);
                                stage.setResizable(false);
                                stage.setTitle("Educación Continua en Línea");
                                stage.show();                
                                Stage nextstage = (Stage) btningresar.getScene().getWindow();
                                nextstage.close();
                                }catch(IOException ex){
                                    JOptionPane.showMessageDialog(null, "Error, archivo FXML no encontraado");
                                    System.out.println(ex.getMessage());
                                    System.out.println(ex.getCause());
                                    System.out.println(Arrays.toString(ex.getSuppressed()));
                                }
                        }
                        } catch (NullPointerException ex){
                            Logger.getLogger(InicioSesionController.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, "Null Pointer Exception");
                        }
                
                } else {
                    JOptionPane.showMessageDialog(null, "Introduzca datos válidos");
                }
                    
                    
           }
                
                
                
            
        });
    }
    private boolean validarCamposDeTexto(String usuario, String password) {
        return !(usuario.equals("") || password.equals(""));
    }    
    public void cerrarVentana(){
        Stage stage = (Stage) this.btnregistro.getScene().getWindow();
        stage.close();
    }
}
