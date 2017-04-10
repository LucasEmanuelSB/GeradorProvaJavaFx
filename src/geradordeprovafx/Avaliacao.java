/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

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
