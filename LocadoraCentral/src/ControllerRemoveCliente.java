import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import lista.ListaClientes;

public class ControllerRemoveCliente {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnLimpar;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private TextField textFieldCPF;

    private ListaClientes listaClientes;

    @FXML
    void initialize() {
        mascaraCPF(textFieldCPF);
        listaClientes = ControllerMenuLocadora.getListaClientes();
    }

    @FXML
    void voltarParaPrincipal(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/viewIndex.fxml"));
            Pane cmdPane = (Pane) fxmlLoader.load();

            rootPane.getChildren().clear();
            rootPane.getChildren().add(cmdPane);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void removerCliente(ActionEvent event) {

        /* VERIFICAR SE O CAMPO ESTÁ VAZIO */
        if (textFieldCPF.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText("Preencha todos os campos!");
            alert.showAndWait();

        } else {

            try {
                String cpf = textFieldCPF.getText();
                long cpfLong;

                cpf = cpf.replace(".", "");
                cpf = cpf.replace("-", "");

                cpfLong = Long.parseLong(cpf);

                if (cpf.length() != 11) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERRO");
                    alert.setHeaderText(null);
                    alert.setContentText("CPF inválido!");
                    alert.showAndWait();
                } else {

                    /* VERIFICAR SE O CPF JÁ ESTÁ CADASTRADO */
                    if (!listaClientes.existe(cpfLong)) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERRO");
                        alert.setHeaderText(null);
                        alert.setContentText("CPF não existente!");
                        alert.showAndWait();
                    } else {
                        listaClientes.remove(cpfLong);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Remover Cliente");
                        alert.setHeaderText(null);
                        alert.setContentText("Cliente removido com sucesso!");
                        alert.showAndWait();
                        limparCampos(null);
                    }
                }
            } catch (NullPointerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }

    }

    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnRemover(MouseEvent event) {
        btnRemover.setStyle("-fx-background-color: #682121;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void limparCampos(MouseEvent event) {
        textFieldCPF.clear();
        rootPane.requestFocus();
    }

    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnRemover(MouseEvent event) {
        btnRemover.setStyle("-fx-background-color: #7d2727;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltar.png"));
    }

    public void mascaraCPF(TextField textField) {

        textField.setOnKeyTyped((KeyEvent event) -> {
            if ("0123456789".contains(event.getCharacter()) == false) {
                event.consume();
            }

            if (event.getCharacter().trim().length() == 0) { // apagando

                if (textField.getText().length() == 4) {
                    textField.setText(textField.getText().substring(0, 3));
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 8) {
                    textField.setText(textField.getText().substring(0, 7));
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 12) {
                    textField.setText(textField.getText().substring(0, 11));
                    textField.positionCaret(textField.getText().length());
                }

            } else {

                if (textField.getText().length() == 14)
                    event.consume();

                if (textField.getText().length() == 3) {
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 7) {
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 11) {
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                }

            }
        });

        textField.setOnKeyReleased((KeyEvent evt) -> {

            if (!textField.getText().matches("\\d.-*")) {
                textField.setText(textField.getText().replaceAll("[^\\d.-]", ""));
                textField.positionCaret(textField.getText().length());
            }
        });

    }

}
