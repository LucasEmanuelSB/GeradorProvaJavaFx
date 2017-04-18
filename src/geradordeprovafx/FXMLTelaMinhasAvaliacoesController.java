/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;


import java.io.File;
import java.io.IOException;

import java.net.URL;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author lucas
 */
public class FXMLTelaMinhasAvaliacoesController extends InterfaceUsuario {

    public FXMLTelaMinhasAvaliacoesController() {
        super("TelaMinhasAvaliacoes.fxml");
    }
    
    private ObservableList<Avaliacao> observableList;
    
    @FXML
    private TableView<Avaliacao> tabelaMinhasAvaliacoes;
    
    @FXML
    private TableColumn<Avaliacao, String> colunaNome;
    
    @FXML
    private TableColumn<Avaliacao, String> colunaDisciplina;
    
    @FXML
    private TableColumn<Avaliacao, String> colunaMedia;
    
    @FXML
    private TableColumn<Avaliacao, String> colunaPeso;
            
    @FXML
    private TableColumn<Avaliacao, String> colunaNota;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        File arquivo = new File("Avaliacoes.csv");
        
        if(arquivo.exists()){
            carregaTabela();
        } 
        
        //Quando um item é selecionado
        tabelaMinhasAvaliacoes.getSelectionModel().selectedItemProperty().addListener((
                observable, oldValue, newValue) -> selecaoDeUmaLinha(newValue));
    }
        
    public void carregaTabela(){
        
        try {
            colunaNome.setCellValueFactory(
                    new PropertyValueFactory<Avaliacao, String>("nome")
            );
            colunaDisciplina.setCellValueFactory(
                    new PropertyValueFactory<Avaliacao, String>("disciplina")
            );
            colunaMedia.setCellValueFactory(
                    new PropertyValueFactory<Avaliacao, String>("media")
            );
            colunaPeso.setCellValueFactory(
                    new PropertyValueFactory<Avaliacao, String>("peso")
            );
            colunaNota.setCellValueFactory(
                    new PropertyValueFactory<Avaliacao, String>("nota")
            );
            
            observableList =  FXCollections.observableArrayList(Avaliacao.obterListaAvaliacoes());
            
            tabelaMinhasAvaliacoes.setItems(observableList);
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaMinhasAvaliacoesController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    @FXML
    public void addNovaAvaliacao(ActionEvent event) throws IOException {
        FXMLTelaAdicionaProvaController tela = new FXMLTelaAdicionaProvaController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    @FXML
    public void informarNota(ActionEvent event) throws IOException {
        
        //Verifica se um item da lista esta selecionado, se sim, entra na tela de informar nota.
        if(tabelaMinhasAvaliacoes.getSelectionModel().selectedItemProperty().getValue() != null){
            
            int id = tabelaMinhasAvaliacoes.getSelectionModel().selectedItemProperty().getValue().getControleArquivo();
            
            GerenciadorJanela.obterInstancia().setId(id);
            FXMLTelaInformarNotaController tela = new FXMLTelaInformarNotaController();
            GerenciadorJanela.obterInstancia().abreJanela(tela);
        
        } else{
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Nenhuma prova selecionada");
            alert.setContentText("Para realizar essa operação, é necessário selecionar um prova da tabela.");
            alert.show();  
        }
        
    }
    
    @FXML
    public void voltarTelaPrincipal(ActionEvent event) throws IOException {
        FXMLTelaPrincipalController tela = new FXMLTelaPrincipalController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    public Avaliacao selecaoDeUmaLinha(Avaliacao avaliacao){
        return avaliacao;
    }
}
