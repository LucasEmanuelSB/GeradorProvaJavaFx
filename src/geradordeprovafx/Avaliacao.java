/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
            
    public Avaliacao(){
        
    }
    public void salvar() throws IOException{
        
        try{
            File arquivo = new File("Avaliacoes.csv");
        
            FileWriter escritor = new FileWriter(arquivo,true);
            PrintWriter saida = new PrintWriter(escritor);
            saida.println(disciplina+";"+nome+";"+media+";"+peso);
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
 
    public static ArrayList obterListaAvaliacoes() throws FileNotFoundException, IOException {
        
        ArrayList<Avaliacao> listAvaliacoes = new ArrayList();
        
        int i = 0;

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
        
        return listAvaliacoes;
    }
    /*
    public static double calculaMediaDaDisciplina(String disciplina, String media){
        
        return 
    }
    */
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
