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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        
        try{ // Caminho e dados para gravar em arquivo.
            Avaliacao nova = new Avaliacao();
            nova.setNome(campoNome.toString());
            nova.setDisciplina(selectDisciplina.getValue().toString());
            nova.setPeso(Float.parseFloat(campoPeso.toString()));
            nova.setMedia(selectMedia.getValue().toString());
            nova
            Path url = Paths.get("C:/Users/lucas/Documents/Faculdade/4° Semestre/POO 2/M1/GeradorDeProvaFX/src/Provas/"+selectDisciplina.getValue()+".txt");
            String dadosProva = selectDisciplina.getValue()+","+selectMedia.getValue()+","+campoNome.getText()+","+campoPeso.getText();
            // converte em byte para poder enviar para funcao
            byte[] dadosEmByte = dadosProva.getBytes();
            try{
                Files.write(url,dadosEmByte);//gravao em bytes na url solcitada
            } catch(Exception erro){
                
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro Prova");
            alert.setHeaderText("Salvo com sucesso");
            alert.setContentText("Um novo arquivo foi criado com as informacões da prova");
            alert.show();
            
        } catch(Exception erro){
            
        }
        
        
        
        FXMLTelaMinhasAvaliacoesController tela = new FXMLTelaMinhasAvaliacoesController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
}
