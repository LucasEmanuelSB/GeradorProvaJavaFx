/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author lucas
 */
public class GeradorDeProvaFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //carrega o elemento raiz a partir de um FXML
        AnchorPane elementoRaiz = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
        
        //cria uma cena, passando para o construtor o elemento raiz do FXML
        Scene scene = new Scene(elementoRaiz);
        
        //associa a cena ao stage
        stage.setScene(scene);
        
        //exibe o stage(palco)
        stage.show();
        
        stage.setTitle("Dashboard");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
