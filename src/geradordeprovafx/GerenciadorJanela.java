/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import javafx.stage.Stage;

/**
 *
 * @author lucas
 */
public class GerenciadorJanela {
    
    private static GerenciadorJanela instancia;
    private int id;
    
    private GerenciadorJanela(){
        
    }
    
    public static GerenciadorJanela obterInstancia(){
        if(GerenciadorJanela.instancia == null){
            GerenciadorJanela.instancia = new GerenciadorJanela();
        }
        return GerenciadorJanela.instancia;
    }
    
    private Stage palco;
    
    public void setPalco(Stage p){
        palco = p;
    }
    
    private Stage getPalco(){
        return this.palco;
    }
    
    public void abreJanela(InterfaceUsuario novaJanela) {
        this.getPalco().setScene(novaJanela.obterCena());
    }
    
    public void abreEmPopup(InterfaceUsuario novaJanela){
        Stage popUp = new Stage();
        popUp.setScene(novaJanela.obterCena());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}

