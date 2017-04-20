/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;

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
    private ComboBox <String> cBDisciplinas;
    
    private ObservableList<String> disciplinas;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            
        try {
            Path path = Paths.get("ListaDisciplinas.csv");
            List<String> listaAvaliacao;
            listaAvaliacao = Files.readAllLines(path);
            
            
            disciplinas = FXCollections.observableArrayList(listaAvaliacao);
            cBDisciplinas.setItems(disciplinas);
        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaDesempenhoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void geradorGrafico() throws IOException {
        try {
            XYChart.Series desempenho = new XYChart.Series<>();

            desempenho.setName(cBDisciplinas.getSelectionModel().getSelectedItem());
            

            desempenho.getData().add(new XYChart.Data("M1", Avaliacao.calculaMediaDaDisciplina(cBDisciplinas.getSelectionModel().getSelectedItem() ,"M1")));
            desempenho.getData().add(new XYChart.Data("M2", Avaliacao.calculaMediaDaDisciplina(cBDisciplinas.getSelectionModel().getSelectedItem(), "M2")));
            desempenho.getData().add(new XYChart.Data("M3", Avaliacao.calculaMediaDaDisciplina(cBDisciplinas.getSelectionModel().getSelectedItem(), "M3")));

            grafico.getData().addAll(desempenho);

        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaDesempenhoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void voltarTelaPrincipal(ActionEvent event) throws IOException {
        FXMLTelaPrincipalController tela = new FXMLTelaPrincipalController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }

}
