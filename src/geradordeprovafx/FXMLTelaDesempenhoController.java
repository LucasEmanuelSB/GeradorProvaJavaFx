/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ComboBox cBDisciplinas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> DisciplinaList = FXCollections.observableArrayList(
                "ETICA EM INFORMATICA",
                 "MATEMATICA COMPUTACIONAL",
                 "ALGORITMOS E PROGRAMACAO",
                 "ALGEBRA",
                 "INTRODUCAO AO CALCULO",
                 "INICIACAO TECNICO-CIENTIFICA",
                 "INTRODUCAO A ENGENHARIA DE COMPUTACAO",
                 "INTRODUCAO A FISICA",
                 "CALCULO",
                 "ALGORITMOS E PROGRAMACAO",
                 "CIRCUITOS DIGITAIS",
                 "DESENHO TECNICO",
                 "FISICA GERAL",
                 "ALGEBRA",
                 "CALCULO",
                 "ESTRUTURA DE DADOS",
                 "PROGRAMACAO ORIENTADA A OBJETOS",
                 "ARQUITETURA DE COMPUTADORES",
                 "FISICA",
                 "QUIMICA",
                 "ARQUITETURA DE COMPUTADORES",
                 "PROGRAMACAO ORIENTADA A OBJETOS",
                 "CALCULO",
                 "QUIMICA",
                 "OTICA E FISICA PARA SEMICONDUTORES",
                 "RESISTENCIA DOS MATERIAIS",
                 "ANALISE DE CIRCUITOS ELETRICOS",
                 "BANCO DE DADOS",
                 "SISTEMAS OPERACIONAIS",
                 "MATEMATICA APLICADA A ENGENHARIA",
                 "ENGENHARIA DE SOFTWARE",
                 "PROBABILIDADE E ESTATISTICA",
                 "ELETRONICA BASICA",
                 "INTERFACE HUMANO-COMPUTADOR",
                 "ENGENHARIA DE SOFTWARE",
                 "REDES DE COMPUTADORES",
                 "CALCULO NUMERICO",
                 "LINGUAGENS FORMAIS",
                 "ELETRONICA APLICADA",
                 "ANALISE E CONTROLE DE PROCESSOS",
                 "ENGENHARIA ECONOMICA",
                 "REDES DE COMPUTADORES",
                 "GRAFOS",
                 "CONTROLE LOGICO DE SISTEMAS",
                 "MICROCONTROLADORES",
                 "PROJETO DE SISTEMAS DIGITAIS",
                 "INTELIGENCIA ARTIFICIAL",
                 "TRABALHO TECNICO CIENTIFICO DE CONCLUSAO DE CURSO",
                 "PROJETO DE SISTEMAS EMBARCADOS",
                 "SISTEMAS EM TEMPO REAL",
                 "COMUNICACAO DIGITAL",
                 "PROCESSADOR DIGITAL DE SINAIS",
                 "SISTEMAS ROBOTICOS",
                 "SIMULACAO DISCRETA",
                 "GERENCIA DE PROJETOS",
                 "TOPICOS ESPECIAIS EM ENGENHARIA DE COMPUTACAO",
                 "TOPICOS ESPECIAIS EM HARDWARE",
                 "TRABALHO TECNICO CIENTIFICO DE CONCLUSAO DE CURSO",
                 "ADMINISTRACAO DE NEGOCIOS DE BASE TECNOLOGICA",
                 "TOPICOS ESPECIAIS EM INTEGRACAO SOFTWARE HARDWARE",
                 "TRABALHO TECNICO CIENTIFICO DE CONCLUSAO DE CURSO",
                 "SISTEMAS DISTRIBUIDOS"
        );

        cBDisciplinas.setPromptText("Selecione uma disciplina ... ");
        cBDisciplinas.setValue("ÉTICA EM INFORMÁTICA");
        cBDisciplinas.setItems(DisciplinaList);

    }

    @FXML
    public void geradorGrafico(ActionEvent event) throws IOException {
        try {
            System.out.println(Avaliacao.calculaMediaDaDisciplina(cBDisciplinas.getValue().toString(), "M1"));
            XYChart.Series desempenho = new XYChart.Series<>();

            desempenho.setName(cBDisciplinas.getSelectionModel().getSelectedItem().toString());
            grafico.setLegendSide(Side.BOTTOM);

            desempenho.getData().add(new XYChart.Data("M1", Avaliacao.calculaMediaDaDisciplina(cBDisciplinas.getValue().toString(), "M1")));
            desempenho.getData().add(new XYChart.Data("M2", Avaliacao.calculaMediaDaDisciplina(cBDisciplinas.getValue().toString(), "M2")));
            desempenho.getData().add(new XYChart.Data("M3", Avaliacao.calculaMediaDaDisciplina(cBDisciplinas.getValue().toString(), "M3")));

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
