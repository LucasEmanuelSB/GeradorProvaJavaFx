/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FXMLTelaInformarNotaController extends InterfaceUsuario {

    public FXMLTelaInformarNotaController() {
        super("TelaInformarNota.fxml");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        
        atualizaPagina();
    }   
    
    @FXML
    private TextField campoNota;
    
    @FXML 
    private Label nome, disciplina, media;
    
    @FXML
    public void salvarNota(){
        
        /*
        try (Scanner scanner = new Scanner(new FileReader("Avaliacoes.csv")).useDelimiter("\r\n")) {
            
            while( scanner.hasNext() ){
                Avaliacao nova = new Avaliacao();
                String linha = scanner.next();
                String[] partes = linha.split(";");
                
                    nova.controleArquivo = i;
                    nova.disciplina = partes[0];
                    nova.nome = partes[1];
                    nova.media = partes[2];
                
                    nova.peso = Double.parseDouble(partes[3]);
                    if( partes.length == 4 ){
                        System.out.print(" [SEM NOTA] ");
                    }else{
                        nova.nota = Double.parseDouble( partes[4] );
                    }
                    i++; 
                    listAvaliacoes.add(nova);
               
            }
        }
        */
    }
    
    @FXML
    public void voltarMinhasAvaliacoes(ActionEvent event) throws IOException {
        FXMLTelaMinhasAvaliacoesController tela = new FXMLTelaMinhasAvaliacoesController();
         GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    @FXML
    public void salvarNota(ActionEvent event) throws IOException {
        
         FXMLTelaMinhasAvaliacoesController tela = new FXMLTelaMinhasAvaliacoesController();
         GerenciadorJanela.obterInstancia().abreJanela(tela);
    }  
    
    public void atualizaPagina(){
        
        nome = nome.getText()+ Avaliacao.obterListaAvaliacoes().get()
    }
}
