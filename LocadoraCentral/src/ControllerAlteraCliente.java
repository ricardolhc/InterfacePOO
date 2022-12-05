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
import lista.Cliente;
import lista.ListaClientes;

public class ControllerAlteraCliente {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button btnProcurar;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnLimpar;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private TextField textFieldCPF;

    @FXML
    private TextField textFieldCarteiraMotorista;

    @FXML
    private TextField textFieldEndereco;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldTelefone;

    private ListaClientes listaClientes;

    private String cpfAlterar;

    @FXML
    void initialize() {
        mascaraCPF(textFieldCPF);
        listaClientes = ControllerMenuLocadora.getListaClientes();
    }

    @FXML
    void procurarCliente(ActionEvent event) {
        cpfAlterar = textFieldCPF.getText();

        cpfAlterar = cpfAlterar.replace(".", "");
        cpfAlterar = cpfAlterar.replace("-", "");

        if (textFieldCPF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText("Preencha todos os campos!");
            alert.showAndWait();
        } else {

            try {

                if (cpfAlterar.length() != 11) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERRO");
                    alert.setHeaderText(null);
                    alert.setContentText("CPF inválido!");
                    alert.showAndWait();
                } else {
                    if (listaClientes.existe(Long.parseLong(cpfAlterar))) {
                        textFieldNome.setText(listaClientes.get(Long.parseLong(cpfAlterar)).getNome());
                        textFieldTelefone
                                .setText(Long.toString(listaClientes.get(Long.parseLong(cpfAlterar)).getTelefone()));
                        textFieldEndereco.setText(listaClientes.get(Long.parseLong(cpfAlterar)).getEndereco());
                        textFieldCarteiraMotorista.setText(Long
                                .toString(listaClientes.get(Long.parseLong(cpfAlterar)).getNumeroCarteiraMotorista()));
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERRO");
                        alert.setHeaderText(null);
                        alert.setContentText("Cliente não encontrado!");
                        alert.showAndWait();
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
    void hoverBtnProcurar(MouseEvent event) {
        btnProcurar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void alterarCliente(ActionEvent event) {
        if (textFieldCPF.getText().isEmpty() || textFieldCarteiraMotorista.getText().isEmpty()
                || textFieldTelefone.getText().isEmpty() || textFieldNome.getText().isEmpty()
                || textFieldEndereco.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText("Preencha todos os campos!");
            alert.showAndWait();

        } else {

            String cpfFinal = textFieldCPF.getText();

            cpfFinal = cpfFinal.replace(".", "");
            cpfFinal = cpfFinal.replace("-", "");

            System.out.println(cpfFinal + " " + cpfAlterar);

            if (!cpfAlterar.equals(cpfFinal)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText("CPF trocado originalmente!");
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

                    if (cpf.length() != 11) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERRO");
                        alert.setHeaderText(null);
                        alert.setContentText("CPF inválido!");
                        alert.showAndWait();
                    } else {
                        if (telefone.length() != 11 && telefone.length() != 10) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("ERRO");
                            alert.setHeaderText(null);
                            alert.setContentText("Telefone inválido!");
                            alert.showAndWait();
                        } else {
                            if (!listaClientes.existe(cpfLong)) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("ERRO");
                                alert.setHeaderText(null);
                                alert.setContentText("CPF não existente!");
                                alert.showAndWait();
                            } else {
                                /* alterar cliente */
                                Cliente cliente = listaClientes.get(cpfLong);

                                cliente.setNome(nome);
                                cliente.setEndereco(endereco);
                                cliente.setTelefone(telefoneLong);
                                cliente.setNumeroCarteira(cnhLong);

                                limparCampos(null);

                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("SUCESSO");
                                alert.setHeaderText(null);
                                alert.setContentText("Cliente alterado com sucesso!");
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
    }

    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void hoverBtnAlterar(MouseEvent event) {
        btnAlterar.setStyle("-fx-background-color: #676508;-fx-cursor: hand; -fx-background-radius: 50;");
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

    @FXML
    void notHoverBtnProcurar(MouseEvent event) {
        btnProcurar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnAlterar(MouseEvent event) {
        btnAlterar.setStyle("-fx-background-color: #807d0a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltar.png"));
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
