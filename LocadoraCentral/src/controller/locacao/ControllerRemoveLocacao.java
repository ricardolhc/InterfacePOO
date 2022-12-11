package controller.locacao;

import controller.ControllerMenuLocadora;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lista.ListaLocacoes;

public class ControllerRemoveLocacao {

    @FXML
    private Button btnLimparLocacao;

    @FXML
    private Button btnRemoverLocacao;

    @FXML
    private ImageView btnVoltarLocacao;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField textFieldLocacao;

    private ListaLocacoes listaLocacao;

    @FXML

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
    void removerLocacao(ActionEvent event) {

        /* VERIFICAR SE O CAMPO ESTÁ VAZIO */

        try {
            String codigoUnico = textFieldLocacao.getText();
        if(!codigoUnico.isEmpty()) {
            if(listaLocacao.existe(codigoUnico)) {
                if(listaLocacao.remove(codigoUnico)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Remover Veículo");
                    alert.setHeaderText(null);
                    alert.setContentText("Lócação removida com sucesso!");
                    alert.showAndWait();
                    limparCampos(null);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Remover Locacao");
                    alert.setHeaderText(null);
                    alert.setContentText("O código não foi encontrado na lista de locações!");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Remover locacao");
                alert.setHeaderText(null);
                alert.setContentText("O código não foi encontrado na lista de locações!");
                alert.showAndWait();
            }
            
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Remover Veículo");
            alert.setHeaderText(null);
            alert.setContentText("Código não pode ser vazio!");
            alert.showAndWait();
        }

            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            } catch(NullPointerException e ) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        

    

    }



    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimparLocacao.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 50;");

    }

    @FXML
    void hoverBtnRemoverLocacao(MouseEvent event) {
         btnRemoverLocacao.setStyle("-fx-background-color: #682121;-fx-cursor: hand; -fx-background-radius: 50;");

       
    }

    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltarLocacao.setImage(new Image("views/cliente/pngVoltarHover.png"));
        btnVoltarLocacao.setStyle("-fx-cursor: hand;");

    }

    @FXML
    void limparCampos(MouseEvent event) {

    }

    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
         btnLimparLocacao.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 50;");

    }

    @FXML
    void notHoverBtnRemover(MouseEvent event) {
        btnRemoverLocacao.setStyle("-fx-background-color: #7d2727;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    

    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltarLocacao.setImage(new Image("views/cliente/pngVoltar.png"));

    }

    

   

}