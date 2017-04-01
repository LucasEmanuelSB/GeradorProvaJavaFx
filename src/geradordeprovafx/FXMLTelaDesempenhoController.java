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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lucas
 */
public class FXMLTelaDesempenhoController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private Button voltarTelaPrincipal;
    
    @FXML
    private AnchorPane eRTelaDesempenho;
    
    @FXML
    public void voltarTelaPrincipal(ActionEvent event) throws IOException {
         //carrega o elemento raiz do FXML da tela que será aberta
        AnchorPane eRTelaPrincipal = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
        
        //cria uma nova cena, passando para o construtor o elemento raiz do FXML que será aberto
        Scene novaCena = new Scene(eRTelaPrincipal);
        
        //obtém a cena a partir do elemenento raiz da tela que está aberta (tela atual)
        Scene cenaAtual = eRTelaDesempenho.getScene();
        
        //obtém o palco da aplicação a partir da cena atual (com cast para Stage)
        Stage palcoDaAplicacao = (Stage) cenaAtual.getWindow();
        
        //atribuindo a nova cena, criada no início do método, ao palco da aplicação
        palcoDaAplicacao.setScene(novaCena);
        
    }
}
