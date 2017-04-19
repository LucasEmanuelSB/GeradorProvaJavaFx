/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
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
    private CategoryAxis disciplinas;

    @FXML
    private NumberAxis medias;
    
    @FXML
    private ComboBox cBDisciplinas;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        ObservableList<String> DisciplinaList = FXCollections.observableArrayList(
        "ÉTICA EM INFORMÁTICA","MATEMÁTICA COMPUTACIONAL","ALGORITMOS E PROGRAMAÇÃO",
        "ÁLGEBRA","INTRODUÇÃO AO CÁLCULO","INICIAÇÃO TÉCNICO-CIENTÍFICA","INTRODUÇÃO A ENGENHARIA DE COMPUTAÇÃO",
        "INTRODUÇÃO À FÍSICA "
        );
        
        cBDisciplinas.setValue("Programacao Orientada a Objeto 2");
        cBDisciplinas.setItems(DisciplinaList);
        
        System.out.println(Avaliacao.calculaMediaDaDisciplina(cBDisciplinas.getSelectionModel().getSelectedItem().toString() , "M2"));
        
        XYChart.Series desempenho = new XYChart.Series<>();
        
        desempenho.setName(cBDisciplinas.getSelectionModel().getSelectedItem().toString());
        grafico.setLegendSide(Side.BOTTOM);
        desempenho.getData().add(new XYChart.Data("M1", Avaliacao.calculaMediaDaDisciplina(cBDisciplinas.getSelectionModel().getSelectedItem().toString(),"M1")));
        desempenho.getData().add(new XYChart.Data("M2", Avaliacao.calculaMediaDaDisciplina(cBDisciplinas.getSelectionModel().getSelectedItem().toString(),"M2")));
        desempenho.getData().add(new XYChart.Data("M3", Avaliacao.calculaMediaDaDisciplina(cBDisciplinas.getSelectionModel().getSelectedItem().toString(),"M3")));
        grafico.getData().addAll(desempenho);
    }
    
    @FXML
    public void voltarTelaPrincipal(ActionEvent event) throws IOException {
        FXMLTelaPrincipalController tela = new FXMLTelaPrincipalController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }

}
