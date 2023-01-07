package controller.veiculo;

import controller.ControllerMenuLocadora;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
        try {
            if (placa.isEmpty()) {
                throw new NullPointerException("O campo de placa está vazio!");
            }
            if (!listaVeiculos.existe(placa)) {
                throw new NullPointerException("O veículo não foi encontrado na lista de veículos!");
            } else {
                if (!listaVeiculos.remove(placa)) {
                    throw new NullPointerException("O veículo não foi encontrado na lista de veículos!");            
                } else {
                    alertInterface("SUCESSO", "O veículo foi removido com sucesso!", AlertType.INFORMATION);

                    limparCampos(null);
                }
            }
        } catch (NumberFormatException e) {
            alertInterface("ERRO", "Preencha os campos corretamente!", AlertType.ERROR);
        } catch (NullPointerException | IllegalArgumentException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
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

    /**
     * Método para imprimir um alerta na tela
     * 
     * @param titulo   titulo do alerta
     * @param mensagem mensagem do alerta
     * @param tipo     tipo do alerta
     */
    void alertInterface(String titulo, String mensagem, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

}
