package controller.locacao;

import controller.ControllerMenuLocadora;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lista.ListaLocacoes;

public class ControllerAlteraLocacao {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnLimpar;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private ChoiceBox<?> choiceSeguro;

    @FXML
    private DatePicker pickerDataFinal;

    @FXML
    private DatePicker pickerDataInicial;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField textFieldCPF;

    @FXML
    private TextField textFieldPlaca;

    private ListaLocacoes listaLocacao;

     void initialize() {
        listaLocacao = ControllerMenuLocadora.getListaLocacoes();
    }
 
 
 @FXML
    void voltarParaPrincipal(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../views/viewIndex.fxml"));
            Pane cmdPane = (Pane) fxmlLoader.load();

            rootPane.getChildren().clear();
            rootPane.getChildren().add(cmdPane);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @FXML
    void adicionarLocacao(ActionEvent event) {

    }

    @FXML
    void hoverBtnAdicionar(MouseEvent event) {

    }

    @FXML
    void hoverBtnLimpar(MouseEvent event) {

    }

    @FXML
    void hoverBtnVoltar(MouseEvent event) {

    }

    @FXML
    void limparCampos(MouseEvent event) {

    }

    @FXML
    void notHoverBtnAdicionar(MouseEvent event) {

    }

    @FXML
    void notHoverBtnLimpar(MouseEvent event) {

    }

    @FXML
    void notHoverBtnVoltar(MouseEvent event) {

    }


}
