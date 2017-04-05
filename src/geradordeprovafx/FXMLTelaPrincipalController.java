/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author lucas
 */
public class FXMLTelaPrincipalController extends InterfaceUsuario {

    public FXMLTelaPrincipalController() {
        super("TelaPrincipal.fxml");
    }
       
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }   
    
    @FXML
    private Button minhasAvaliacoes, meuDesempenho;
    
    @FXML
    private AnchorPane telaPrincipal;
    
    @FXML
    private void minhasAvaliacoes(ActionEvent event) throws IOException {
         FXMLTelaMinhasAvaliacoesController tela = new FXMLTelaMinhasAvaliacoesController();
         GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    @FXML
    private void meuDesempenho(ActionEvent event) throws IOException {
       FXMLTelaDesempenhoController tela = new FXMLTelaDesempenhoController();
       GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
}
