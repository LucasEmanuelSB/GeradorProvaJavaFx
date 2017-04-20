/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author lucas
 */

public class FXMLTelaAdicionaProvaController extends InterfaceUsuario {
    
    public FXMLTelaAdicionaProvaController() {
        super("TelaAdicionaProva.fxml");
    }
        
    private ObservableList<String> disciplinas,medias;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
            Path path = Paths.get("ListaDisciplinas.csv");
            List<String> listaAvaliacao;
            listaAvaliacao = Files.readAllLines(path);
            
            
            disciplinas = FXCollections.observableArrayList(listaAvaliacao);
            selectDisciplina.setItems(disciplinas);
            
            medias = FXCollections.observableArrayList("M1","M2","M3");
            
            selectMedia.setValue("M1");
            selectMedia.setItems(medias);
        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaAdicionaProvaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private AnchorPane eRTelaAddProva;
    
    @FXML
    private Button voltarMinhasAvaliacoes, salvarProva;
    
    @FXML
    private ComboBox selectDisciplina, selectMedia;
    
    @FXML
    private TextField campoNome, campoPeso;
    
    @FXML
    public void voltarMinhasAvaliacoes(ActionEvent event) throws IOException {
        FXMLTelaMinhasAvaliacoesController tela = new FXMLTelaMinhasAvaliacoesController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    @FXML
    public void salvarProva(ActionEvent event) throws IOException {

            Avaliacao nova = new Avaliacao();
            nova.setNome(campoNome.getText());
            nova.setDisciplina(selectDisciplina.getValue().toString());
            nova.setPeso(Float.parseFloat(campoPeso.getText()));
            nova.setMedia(selectMedia.getValue().toString());
            nova.salvar();

        FXMLTelaMinhasAvaliacoesController tela = new FXMLTelaMinhasAvaliacoesController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
}
