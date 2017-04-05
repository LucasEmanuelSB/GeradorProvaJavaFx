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
public class FXMLTelaMinhasAvaliacoesController extends InterfaceUsuario {

    public FXMLTelaMinhasAvaliacoesController() {
        super("TelaMinhasAvaliacoes.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    private Button informatNota, addNovaAvaliacao,voltarMenuPrincipal;
    
    @FXML
    private AnchorPane eRTelaMinhasAvaliacoes;
    
    @FXML
    public void addNovaAvaliacao(ActionEvent event) throws IOException {
        FXMLTelaAdicionaProvaController tela = new FXMLTelaAdicionaProvaController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    @FXML
    public void informarNota(ActionEvent event) throws IOException {
        FXMLTelaInformarNotaController tela = new FXMLTelaInformarNotaController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    @FXML
    public void voltarTelaPrincipal(ActionEvent event) throws IOException {
        FXMLTelaPrincipalController tela = new FXMLTelaPrincipalController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
}
