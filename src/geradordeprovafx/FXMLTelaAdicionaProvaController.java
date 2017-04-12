/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    
    ObservableList<String> DisciplinaList = FXCollections.observableArrayList(
    "ÉTICA EM INFORMÁTICA","MATEMÁTICA COMPUTACIONAL","ALGORITMOS E PROGRAMAÇÃO",
    "ÁLGEBRA","INTRODUÇÃO AO CÁLCULO","INICIAÇÃO TÉCNICO-CIENTÍFICA","INTRODUÇÃO A ENGENHARIA DE COMPUTAÇÃO",
    "INTRODUÇÃO À FÍSICA "
    );
    
    ObservableList<String> MediaList = FXCollections.observableArrayList("M1","M2","M3");
    
    public FXMLTelaAdicionaProvaController() {
        super("TelaAdicionaProva.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
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
    public void getDisciplinas(){
        selectDisciplina.setValue("Programacao Orientada a Objeto 2");
        selectDisciplina.setItems(DisciplinaList);
    }
    @FXML 
    public void getMedias(){
        selectMedia.setValue("M1");
        selectMedia.setItems(MediaList);
    }
    
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
