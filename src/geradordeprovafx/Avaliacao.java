/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 *
 * @author lucas
 */
public class Avaliacao {
    private String nome;
    private String disciplina;
    private double peso;
    private String media;
    private double nota;
    private int controleArquivo;
    private static ArrayList<Avaliacao> listaAvaliacoes = new ArrayList();
            
    public Avaliacao(){
        
    }
    public void salvar() throws IOException{
        
        try{
            File arquivo = new File("Avaliacoes.txt");
        
            FileWriter escritor = new FileWriter(arquivo,true);
            PrintWriter saida = new PrintWriter(escritor);
            saida.println(disciplina+","+media+","+nome+","+peso);
            saida.close();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro Prova");
            alert.setHeaderText("Salvo com sucesso");
            alert.setContentText("Um novo arquivo foi criado com as informacões da prova");
            alert.show();  
            
        }catch(Exception erro){
            System.out.println("Erro ao escrever no arquivo.");
        }
        
          
    }    
    public static ArrayList obtemAvaliacoes(){
        return listaAvaliacoes;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public double getNota() {
        return nota;
    }
    
    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getControleArquivo() {
        return controleArquivo;
    }

    public void setControleArquivo(int controleArquivo) {
        this.controleArquivo = controleArquivo;
    }
    
    
}
