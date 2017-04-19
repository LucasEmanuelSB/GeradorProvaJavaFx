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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class FXMLTelaInformarNotaController extends InterfaceUsuario {

    public FXMLTelaInformarNotaController() {
        super("TelaInformarNota.fxml");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        
        try {
            atualizaPagina();
        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaInformarNotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    @FXML
    private TextField campoNota;
    
    @FXML 
    private Label nome, disciplina, media;
    
    @FXML
    public void salvarNota(ActionEvent event) throws IOException {
        
        int id = GerenciadorJanela.obterInstancia().getId();
        
        BufferedReader br = new BufferedReader(new FileReader("Avaliacoes.csv")); 
        List<String> linhas = new ArrayList(); 

        String lin; 
        while ((lin = br.readLine()) != null) { 
        linhas.add(lin); 
        } 
        String[] arrayLinha = new String[linhas.size()]; 
        linhas.toArray(arrayLinha); 
        
        
        String linha = 
                
                Avaliacao.obterListaAvaliacoes().get(id).getDisciplina() + ';' +
                Avaliacao.obterListaAvaliacoes().get(id).getMedia() + ';' +
                Avaliacao.obterListaAvaliacoes().get(id).getNome() + ';' +
                Avaliacao.obterListaAvaliacoes().get(id).getPeso() + ';' + campoNota.getText();
        
        linhas.set(id, linha);
        
        File arquivo = new File("Avaliacoes.csv");
        
        FileWriter escritor = new FileWriter(arquivo);
        PrintWriter saida = new PrintWriter(escritor);
        for(int i = 0; i < linhas.size(); i++){
            saida.println(linhas.get(i));
        }
            
        saida.close();
        
        FXMLTelaMinhasAvaliacoesController tela = new FXMLTelaMinhasAvaliacoesController();
         GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    @FXML
    public void voltarMinhasAvaliacoes(ActionEvent event) throws IOException {
        FXMLTelaMinhasAvaliacoesController tela = new FXMLTelaMinhasAvaliacoesController();
         GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    public void atualizaPagina() throws IOException{
        
       int id = GerenciadorJanela.obterInstancia().getId();
       
       nome.setText(nome.getText() + " " + Avaliacao.obterListaAvaliacoes().get(id).getNome());
       disciplina.setText(disciplina.getText() + " " + Avaliacao.obterListaAvaliacoes().get(id).getDisciplina());
       media.setText(media.getText() + " " + Avaliacao.obterListaAvaliacoes().get(id).getMedia());

    }
}
