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
public class FXMLTelaAdicionaProvaController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private Button voltarMinhasAvaliacoes, salvarProva;
    
    @FXML
    private AnchorPane eRTelaAddProva;
    
    @FXML
    public void voltarMinhasAvaliacoes(ActionEvent event) throws IOException {
         //carrega o elemento raiz do FXML da tela que será aberta
        AnchorPane eRTelaMinhasAvaliacoes = FXMLLoader.load(getClass().getResource("TelaMinhasAvaliacoes.fxml"));
        
        //cria uma nova cena, passando para o construtor o elemento raiz do FXML que será aberto
        Scene novaCena = new Scene(eRTelaMinhasAvaliacoes);
        
        //obtém a cena a partir do elemenento raiz da tela que está aberta (tela atual)
        Scene cenaAtual = eRTelaAddProva.getScene();
        
        //obtém o palco da aplicação a partir da cena atual (com cast para Stage)
        Stage palcoDaAplicacao = (Stage) cenaAtual.getWindow();
        
        //atribuindo a nova cena, criada no início do método, ao palco da aplicação
        palcoDaAplicacao.setScene(novaCena);
        
    }
    
    @FXML
    public void salvarProva(ActionEvent event) throws IOException {
         //carrega o elemento raiz do FXML da tela que será aberta
        AnchorPane eRTelaMinhasAvaliacoes = FXMLLoader.load(getClass().getResource("TelaMinhasAvaliacoes.fxml"));
        
        //cria uma nova cena, passando para o construtor o elemento raiz do FXML que será aberto
        Scene novaCena = new Scene(eRTelaMinhasAvaliacoes);
        
        //obtém a cena a partir do elemenento raiz da tela que está aberta (tela atual)
        Scene cenaAtual = eRTelaAddProva.getScene();
        
        //obtém o palco da aplicação a partir da cena atual (com cast para Stage)
        Stage palcoDaAplicacao = (Stage) cenaAtual.getWindow();
        
        //atribuindo a nova cena, criada no início do método, ao palco da aplicação
        palcoDaAplicacao.setScene(novaCena);
        
    }
}
