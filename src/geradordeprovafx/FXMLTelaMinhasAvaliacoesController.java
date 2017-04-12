/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private ObservableList<Avaliacao> observableListAvaliacoes;
    
    @FXML
    private TableView<Avaliacao> tabelaMinhasAvaliacaoes;
    
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
    
    @FXML
    private Button informatNota, addNovaAvaliacao,voltarMenuPrincipal;
    
    @FXML
    private AnchorPane eRTelaMinhasAvaliacoes;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Avaliacao> listaAvaliacaoes = FXCollections.observableArrayList();
        /*
        File arquivo = new File("Avaliacoes.txt");
        try{
            FileReader leitor = new FileReader(arquivo);
            BufferedReader entrada = new BufferedReader(leitor);
            String linhaAtual = null;
            
            while((linhaAtual = entrada.readLine()) != ","){
                colunaNome = linhaAtual;
            }
                
        saida.close(); 
        } catch(Exception erro){
            
        }
        */
        Avaliacao avaliacao = new Avaliacao();
        
        for(int i = 0; i < avaliacao.obterListaAvaliacoes().size(); i++){
            avaliacao = (Avaliacao) Avaliacao.obterListaAvaliacoes().get(i);
            listaAvaliacaoes.add(avaliacao);
        }
        
        tabelaMinhasAvaliacaoes.setItems(listaAvaliacaoes);
          
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
         
    }
    
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
