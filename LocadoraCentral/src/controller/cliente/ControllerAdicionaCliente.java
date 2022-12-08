package controller.cliente;

import controller.ControllerMenuLocadora;

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
import lista.Cliente;

public class ControllerAdicionaCliente {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private TextField textFieldCPF;

    @FXML
    private TextField textFieldCarteiraMotorista;

    @FXML
    private TextField textFieldTelefone;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldEndereco;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnLimpar;

    private ListaClientes listaClientes;

    @FXML
    void initialize() {
        mascaraCPF(textFieldCPF);
        mascaraCNH(textFieldCarteiraMotorista);
        mascaraTelefone(textFieldTelefone);
        
        listaClientes = ControllerMenuLocadora.getListaClientes();
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
    void adicionarCliente(ActionEvent event) {

        /* VERIFICAR SE O CAMPO ESTÁ VAZIO */
        if (textFieldCPF.getText().isEmpty() || textFieldCarteiraMotorista.getText().isEmpty()
                || textFieldTelefone.getText().isEmpty() || textFieldNome.getText().isEmpty()
                || textFieldEndereco.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText("Preencha todos os campos!");
            alert.showAndWait();

        } else {

            try {
                String cpf = textFieldCPF.getText();
                String cnh = textFieldCarteiraMotorista.getText();
                String telefone = textFieldTelefone.getText();
                String nome = textFieldNome.getText();
                String endereco = textFieldEndereco.getText();
                long cpfLong;
                long cnhLong;
                long telefoneLong;

                cpf = cpf.replace(".", "");
                cpf = cpf.replace("-", "");

                telefone = telefone.replace("(", "");
                telefone = telefone.replace(")", "");
                telefone = telefone.replace("-", "");

                cnhLong = Long.parseLong(cnh);
                telefoneLong = Long.parseLong(telefone);
                cpfLong = Long.parseLong(cpf);

                if(cpf.length() != 11){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERRO");
                    alert.setHeaderText(null);
                    alert.setContentText("CPF inválido!");
                    alert.showAndWait();
                } else {
                    if(telefone.length() != 11 && telefone.length() != 10){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERRO");
                        alert.setHeaderText(null);
                        alert.setContentText("Telefone inválido!");
                        alert.showAndWait();
                    } else {
                        /* VERIFICAR SE O CPF JÁ ESTÁ CADASTRADO */
                        if (listaClientes.existe(cpfLong)) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("ERRO");
                            alert.setHeaderText(null);
                            alert.setContentText("CPF já cadastrado!");
                            alert.showAndWait();
                        } else {
                            /* ADICIONAR CLIENTE */
                            limparCampos(null);
                            listaClientes.add(new Cliente(cpf, nome, cnhLong, endereco, telefoneLong));
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("SUCESSO");
                            alert.setHeaderText(null);
                            alert.setContentText("Cliente adicionado com sucesso!");
                            alert.showAndWait();
                        }
                    }
                }
            } catch (NullPointerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText("Preencha os campos corretamente!");
                alert.showAndWait();
            }
        }

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
    void hoverBtnAdicionar(MouseEvent event) {
        btnAdicionar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnAdicionar(MouseEvent event) {
        btnAdicionar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 50;");
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

    public void mascaraCNH(TextField textField) {
        textField.setOnKeyTyped((KeyEvent event) -> {
            if ("0123456789".contains(event.getCharacter()) == false) {
                event.consume();
            }
            if (textField.getText().length() == 9)
                event.consume();

            if (textField.getText().length() == 5) {
                textField.setText(textField.getText());
                textField.positionCaret(textField.getText().length());
            }
        });

        textField.setOnKeyReleased((KeyEvent evt) -> {
            if (!textField.getText().matches("\\d-*")) {
                textField.setText(textField.getText().replaceAll("[^\\d-]", ""));
                textField.positionCaret(textField.getText().length());
            }
        });
    }

    public void mascaraTelefone(TextField textField) {
        textField.setOnKeyTyped((KeyEvent event) -> {
            if ("0123456789".contains(event.getCharacter()) == false) {
                event.consume();
            }

            if (event.getCharacter().trim().length() == 0) { // apagando

                if (textField.getText().length() == 10 && textField.getText().substring(9, 10).equals("-")) {
                    textField.setText(textField.getText().substring(0, 9));
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 9 && textField.getText().substring(8, 9).equals("-")) {
                    textField.setText(textField.getText().substring(0, 8));
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 4) {
                    textField.setText(textField.getText().substring(0, 3));
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 1) {
                    textField.setText("");
                }

            } else { // escrevendo
                if (textField.getText().length() == 14)
                    event.consume();

                if (textField.getText().length() == 0) {
                    textField.setText("(" + event.getCharacter());
                    textField.positionCaret(textField.getText().length());
                    event.consume();
                }
                if (textField.getText().length() == 3) {
                    textField.setText(textField.getText() + ")" + event.getCharacter());
                    textField.positionCaret(textField.getText().length());
                    event.consume();
                }
                if (textField.getText().length() == 8) {
                    textField.setText(textField.getText() + "-" + event.getCharacter());
                    textField.positionCaret(textField.getText().length());
                    event.consume();
                }
                if (textField.getText().length() == 9 && textField.getText().substring(8, 9) != "-") {
                    textField.setText(textField.getText() + "-" + event.getCharacter());
                    textField.positionCaret(textField.getText().length());
                    event.consume();
                }
                if (textField.getText().length() == 13 && textField.getText().substring(8, 9).equals("-")) {
                    textField.setText(textField.getText().substring(0, 8) + textField.getText().substring(9, 10) + "-"
                            + textField.getText().substring(10, 13) + event.getCharacter());
                    textField.positionCaret(textField.getText().length());
                    event.consume();
                }

            }
        });

    }

    @FXML
    void limparCampos(MouseEvent event) {
        textFieldNome.clear();
        textFieldCPF.clear();
        textFieldCarteiraMotorista.clear();
        textFieldTelefone.clear();
        textFieldEndereco.clear();
        rootPane.requestFocus();
    }


}
