/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 *
 * @author marcelo
 */
public abstract class InterfaceUsuario implements Initializable{
    
    private Scene minhaCena;
    private String caminhoFxml;
    
    protected InterfaceUsuario(String caminhoFxml) {
        this.caminhoFxml = caminhoFxml;
    }
    
    public Scene obterCena()  {
        try {
            Pane elementoPrincipal = FXMLLoader.load(getClass().getResource(caminhoFxml));
            this.minhaCena = new Scene( elementoPrincipal, 1024, 768);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.minhaCena;
    }
    
}