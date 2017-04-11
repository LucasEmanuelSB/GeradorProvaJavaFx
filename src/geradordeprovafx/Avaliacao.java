/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

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
    private ArrayList<Avaliacao> listaAvaliacoes = new ArrayList();
            
    public Avaliacao(){
        
    }
    public void salvar(){
            
        try{
            Path url = Paths.get("C:/Users/lucas/Documents/Faculdade/4° Semestre/POO 2/M1/GeradorDeProvaFX/src/arquivo.txt");
            String dadosProva = disciplina+","+media+","+nome+","+peso;
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
            
        }catch(Exception erro){
            
        }
    }
    
    public ArrayList obtemAvaliacoes(){
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
