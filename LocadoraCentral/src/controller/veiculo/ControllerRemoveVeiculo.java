package controller.veiculo;

import controller.ControllerMenuLocadora;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import lista.ListaVeiculos;

public class ControllerRemoveVeiculo {

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnRemover;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField textFieldPlaca;

    private ListaVeiculos listaVeiculos;

    @FXML
    void initialize() {
        listaVeiculos = ControllerMenuLocadora.getListaVeiculos();
    }


    
    @FXML
    void removerVeiculo(ActionEvent event) {

        String placa = textFieldPlaca.getText();

        // PREENCHIDO CORRETAMENTE O CAMPO
        if(!placa.isEmpty()) {
            if(listaVeiculos.existe(placa)) {
                if(listaVeiculos.remove(placa)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Remover Veículo");
                    alert.setHeaderText(null);
                    alert.setContentText("O veículo foi removido com sucesso!");
                    alert.showAndWait();
                    limparCampos(null);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Remover Veículo");
                    alert.setHeaderText(null);
                    alert.setContentText("O veículo não foi encontrado na lista de veículos!");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Remover Veículo");
                alert.setHeaderText(null);
                alert.setContentText("O veículo não foi encontrado na lista de veículos!");
                alert.showAndWait();
            }
            
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Remover Veículo");
            alert.setHeaderText(null);
            alert.setContentText("O campo de placa está vazio!");
            alert.showAndWait();
        }

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
    void limparCampos(MouseEvent event) {
        textFieldPlaca.setText("");
    }




    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltar.png"));
    }

    @FXML
    void hoverBtnRemover(MouseEvent event) {
        btnRemover.setStyle("-fx-background-color: #682121;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnRemover(MouseEvent event) {
        btnRemover.setStyle("-fx-background-color: #7d2727;-fx-cursor: hand; -fx-background-radius: 50;");
    }

}
