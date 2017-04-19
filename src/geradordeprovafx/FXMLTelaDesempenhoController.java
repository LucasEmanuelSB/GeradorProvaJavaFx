/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author lucas
 */
public class FXMLTelaDesempenhoController extends InterfaceUsuario {

    public FXMLTelaDesempenhoController() {
        super("TelaDesempenho.fxml");
    }
    
    @FXML
    private BarChart<?, ?> grafico;

    @FXML
    private CategoryAxis disciplinas;

    @FXML
    private NumberAxis medias;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series desempenho = new XYChart.Series<>();
        
        desempenho.getData().add(new XYChart.Data<>("dasjdsaiod", 10));
        
        grafico.getData().addAll(desempenho);
    }
    
    @FXML
    public void voltarTelaPrincipal(ActionEvent event) throws IOException {
        FXMLTelaPrincipalController tela = new FXMLTelaPrincipalController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    public Double calculaMediaDaDisciplina(String linha, char media){
         
        double m = 0;
                
         return m;
    }
}
