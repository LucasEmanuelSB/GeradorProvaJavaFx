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
public class FXMLTelaAdicionaProvaController extends InterfaceUsuario {

    public FXMLTelaAdicionaProvaController() {
        super("TelaAdicionaProva.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    private Button voltarMinhasAvaliacoes, salvarProva;
    
    @FXML
    private AnchorPane eRTelaAddProva;
    
    @FXML
    public void voltarMinhasAvaliacoes(ActionEvent event) throws IOException {
        FXMLTelaMinhasAvaliacoesController tela = new FXMLTelaMinhasAvaliacoesController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    @FXML
    public void salvarProva(ActionEvent event) throws IOException {
        FXMLTelaMinhasAvaliacoesController tela = new FXMLTelaMinhasAvaliacoesController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
}
