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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author lucas
 */
public class FXMLTelaAdicionaProvaController extends InterfaceUsuario {
    
    public FXMLTelaAdicionaProvaController() {
        super("TelaAdicionaProva.fxml");
    }

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
        selectDisciplina.setValue("PROGRAMACAO ORIENTADA A OBJETOS");
        selectDisciplina.setItems(DisciplinaList);
        
        ObservableList<String> MediaList = FXCollections.observableArrayList("M1","M2","M3");
        
        selectMedia.setValue("M1");
        selectMedia.setItems(MediaList);
    }
    
    @FXML
    private AnchorPane eRTelaAddProva;
    
    @FXML
    private Button voltarMinhasAvaliacoes, salvarProva;
    
    @FXML
    private ComboBox selectDisciplina, selectMedia;
    
    @FXML
    private TextField campoNome, campoPeso;
    
    @FXML
    public void voltarMinhasAvaliacoes(ActionEvent event) throws IOException {
        FXMLTelaMinhasAvaliacoesController tela = new FXMLTelaMinhasAvaliacoesController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    @FXML
    public void salvarProva(ActionEvent event) throws IOException {

            Avaliacao nova = new Avaliacao();
            nova.setNome(campoNome.getText());
            nova.setDisciplina(selectDisciplina.getValue().toString());
            nova.setPeso(Float.parseFloat(campoPeso.getText()));
            nova.setMedia(selectMedia.getValue().toString());
            nova.salvar();

        FXMLTelaMinhasAvaliacoesController tela = new FXMLTelaMinhasAvaliacoesController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
}
