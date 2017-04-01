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
public class FXMLTelaMinhasAvaliacoesController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private Button informatNota, addNovaAvaliacao,voltarMenuPrincipal;
    
    @FXML
    private AnchorPane eRTelaMinhasAvaliacoes;
    @FXML
    public void addNovaAvaliacao(ActionEvent event) throws IOException {
         //carrega o elemento raiz do FXML da tela que será aberta
        AnchorPane eRTelaAddAvaliacoes = FXMLLoader.load(getClass().getResource("TelaAdicionaProva.fxml"));
        
        //cria uma nova cena, passando para o construtor o elemento raiz do FXML que será aberto
        Scene novaCena = new Scene(eRTelaAddAvaliacoes);
        
        //obtém a cena a partir do elemenento raiz da tela que está aberta (tela atual)
        Scene cenaAtual = eRTelaMinhasAvaliacoes.getScene();
        
        //obtém o palco da aplicação a partir da cena atual (com cast para Stage)
        Stage palcoDaAplicacao = (Stage) cenaAtual.getWindow();
        
        //atribuindo a nova cena, criada no início do método, ao palco da aplicação
        palcoDaAplicacao.setScene(novaCena);
        
    }
    
    @FXML
    public void informarNota(ActionEvent event) throws IOException {
         
        AnchorPane eRTelaInformaNota = FXMLLoader.load(getClass().getResource("TelaInformarNota.fxml"));
        
        Scene novaCena = new Scene(eRTelaInformaNota);
               
        Scene cenaAtual = eRTelaMinhasAvaliacoes.getScene();
       
        Stage palcoDaAplicacao = (Stage) cenaAtual.getWindow();

        palcoDaAplicacao.setScene(novaCena);
    }
    
    @FXML
    public void voltarTelaPrincipal(ActionEvent event) throws IOException {
        
        AnchorPane eRTelaPrincipal = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
        
        Scene novaCena = new Scene(eRTelaPrincipal);
        
        Scene cenaAtual = eRTelaMinhasAvaliacoes.getScene();
        
        Stage palcoDaAplicacao = (Stage) cenaAtual.getWindow();
        
        palcoDaAplicacao.setScene(novaCena);

    }
}
