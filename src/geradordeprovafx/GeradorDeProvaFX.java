package geradordeprovafx;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Lucas Emanuel
 */

public class GeradorDeProvaFX extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage palco) throws Exception {
     
    GerenciadorJanela.obterInstancia().setPalco(palco);
    FXMLTelaPrincipalController tela = new FXMLTelaPrincipalController();
    GerenciadorJanela.obterInstancia().abreJanela(tela);
    palco.show();
}

}