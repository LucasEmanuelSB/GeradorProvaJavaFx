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
public class FXMLTelaPrincipalController implements Initializable {
    
    @FXML
    private Button minhasAvaliacoes, meuDesempenho;
    
    @FXML
    private void minhasAvaliacoes(ActionEvent event) throws IOException {
         //carrega o elemento raiz do FXML da tela que será aberta
        AnchorPane eRTelaAddAvaliacoes = FXMLLoader.load(getClass().getResource("TelaAdicionaProva.fxml"));
        
        //cria uma nova cena, passando para o construtor o elemento raiz do FXML que será aberto
        Scene novaCena = new Scene(eRTelaAddAvaliacoes);
        
        //obtém a cena a partir do elemenento raiz da tela que está aberta (tela atual)
        Scene cenaAtual = eRTelaAddAvaliacoes.getScene();
        
        //obtém o palco da aplicação a partir da cena atual (com cast para Stage)
        Stage palcoDaAplicacao = (Stage) cenaAtual.getWindow();
        
        //atribuindo a nova cena, criada no início do método, ao palco da aplicação
        palcoDaAplicacao.setScene(novaCena);
        
        //para abrir a tela em uma nova janela
//        Stage novoPalco = new Stage();
//        novoPalco.setScene(novaCena);
//        novoPalco.show();
    }
    
    @FXML
    private void meuDesempenho(ActionEvent event) throws IOException {
        
        AnchorPane eRTelaDesemepenho = FXMLLoader.load(getClass().getResource("TelaDesempenho.fxml"));
        
        Scene novaCena = new Scene(eRTelaDesemepenho);
        
        //obtém a cena a partir do elemenento raiz da tela que está aberta (tela atual)
        Scene cenaAtual = eRTelaDesemepenho.getScene();
        
        //obtém o palco da aplicação a partir da cena atual (com cast para Stage)
        Stage palcoDaAplicacao = (Stage) cenaAtual.getWindow();
        
        //atribuindo a nova cena, criada no início do método, ao palco da aplicação
        palcoDaAplicacao.setScene(novaCena);
        
        //para abrir a tela em uma nova janela
//        Stage novoPalco = new Stage();
//        novoPalco.setScene(novaCena);
//        novoPalco.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
