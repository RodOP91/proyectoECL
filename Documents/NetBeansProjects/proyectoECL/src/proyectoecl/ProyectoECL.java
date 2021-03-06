/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoecl;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ferzo
 */
public class ProyectoECL extends Application {
    
    @Override
    public void start(Stage primaryStage)throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("/gui/inicioSesion.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        Image icono = new Image("/imagenes/LogoECL.png");
        primaryStage.getIcons().add(icono);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Educación Continua en Línea");
        primaryStage.show();  
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
