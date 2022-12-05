
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import lista.Cliente;
import lista.ListaClientes;

public class ControllerInfoCliente {

    @FXML
    private Button btnInfoFullCliente;

    @FXML
    private Button btnInfoResumoCliente;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnMostrarEsconderCampos;

    @FXML
    private Button btnPesquisar;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField textFieldCPF;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldEndereco;

    @FXML
    private TextField textFieldTelefone;

    @FXML
    private TextField textFieldCarteiraMotorista;

    @FXML
    private Label labelCPF;

    @FXML
    private Label labelNome;

    @FXML
    private Label labelEndereco;

    @FXML
    private Label labelTelefone;

    @FXML
    private Label labelCarteiraMotorista;

    @FXML
    private TableView<Cliente> tableViewInfoCompleta;

    @FXML
    private TableColumn<Cliente, String> tableColumnCpfInfoCompleta;

    @FXML
    private TableColumn<Cliente, String> tableColumnNomeInfoCompleta;

    @FXML
    private TableColumn<Cliente, String> tableColumnEnderecoInfoCompleta;

    @FXML
    private TableColumn<Cliente, Long> tableColumnTelefoneInfoCompleta;

    @FXML
    private TableColumn<Cliente, Long> tableColumnCarteiraMotoristaInfoCompleta;

    @FXML
    private TableView<Cliente> tableViewInfoResumo;

    @FXML
    private TableColumn<Cliente, String> tableColumnCpfInfoResumo;

    @FXML
    private TableColumn<Cliente, String> tableColumnNomeInfoResumo;

    private boolean mostrarEsconderInfoCliente = true;

    private boolean mostrarEsconderInfoCompleta = true;

    private boolean mostrarEsconderInfoResumo = true;

    private ListaClientes listaClientes;

    @FXML
    void initialize() {
        tableColumnCpfInfoCompleta.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        tableColumnNomeInfoCompleta.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        tableColumnEnderecoInfoCompleta.setCellValueFactory(new PropertyValueFactory<Cliente, String>("endereco"));
        tableColumnTelefoneInfoCompleta.setCellValueFactory(new PropertyValueFactory<Cliente, Long>("telefone"));
        tableColumnCarteiraMotoristaInfoCompleta.setCellValueFactory(new PropertyValueFactory<Cliente, Long>("numeroCarteiraMotorista"));

        //tableColumnCpfInfoResumo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        //tableColumnNomeInfoResumo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));

        mascaraCPF(textFieldCPF);
        listaClientes = ControllerMenuLocadora.getListaClientes();

    }


    @FXML
    void infoCliente(ActionEvent event) {
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

                long cnh;
                long telefone;
                String nome;
                String endereco;
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
                        Cliente cliente = listaClientes.get(cpfLong);

                        nome = cliente.getNome();
                        endereco = cliente.getEndereco();
                        telefone = cliente.getTelefone();
                        cnh = cliente.getNumeroCarteiraMotorista();

                        textFieldNome.setText(nome);
                        textFieldEndereco.setText(endereco);
                        textFieldTelefone.setText(String.valueOf(telefone));
                        textFieldCarteiraMotorista.setText(String.valueOf(cnh));
                    }

                }
            } catch (NullPointerException e) {
                System.out.println(e.getLocalizedMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }




    @FXML
    void infoFullCliente(ActionEvent event) {
        if (labelCPF.isVisible() || tableViewInfoResumo.isVisible()) {
            labelCPF.setVisible(false);
            labelNome.setVisible(false);
            labelEndereco.setVisible(false);
            labelTelefone.setVisible(false);
            labelCarteiraMotorista.setVisible(false);

            textFieldCPF.setVisible(false);
            textFieldNome.setVisible(false);
            textFieldEndereco.setVisible(false);
            textFieldTelefone.setVisible(false);
            textFieldCarteiraMotorista.setVisible(false);

            btnPesquisar.setVisible(false);
            btnLimpar.setVisible(false);

            tableViewInfoResumo.setVisible(false);

            mostrarEsconderInfoCliente = true;
            mostrarEsconderInfoResumo = true;
        }

        tableViewInfoCompleta.setVisible(mostrarEsconderInfoCompleta);

        if(tableViewInfoCompleta.isVisible()) {
            try {
                ObservableList<Cliente> observableListClientes;
                ArrayList<Cliente> listaClientesTable = new ArrayList<Cliente>();
                
                String[] dadosClientes = listaClientes.getInfo().split("\n");
                for (String dadosCliente : dadosClientes) {
                    
                    String[] dados = dadosCliente.split(";");

                    String cpf = dados[1].split(": ")[1];

                    Cliente cliente = listaClientes.get(Long.parseLong(cpf));
                    listaClientesTable.add(cliente);
                }
                observableListClientes = FXCollections.observableArrayList(listaClientesTable);
                tableViewInfoCompleta.setItems(observableListClientes);
    
            } catch (NullPointerException e) {
                System.out.println(e.getLocalizedMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
        mostrarEsconderInfoCompleta = !mostrarEsconderInfoCompleta;
    }

    @FXML
    void infoResumoCliente(ActionEvent event) {
        if (labelCPF.isVisible() || tableViewInfoCompleta.isVisible()) {
            labelCPF.setVisible(false);
            labelNome.setVisible(false);
            labelEndereco.setVisible(false);
            labelTelefone.setVisible(false);
            labelCarteiraMotorista.setVisible(false);

            textFieldCPF.setVisible(false);
            textFieldNome.setVisible(false);
            textFieldEndereco.setVisible(false);
            textFieldTelefone.setVisible(false);
            textFieldCarteiraMotorista.setVisible(false);

            btnPesquisar.setVisible(false);
            btnLimpar.setVisible(false);

            tableViewInfoCompleta.setVisible(false);

            mostrarEsconderInfoCliente = true;
            mostrarEsconderInfoCompleta = true;
        }

        tableViewInfoResumo.setVisible(mostrarEsconderInfoResumo);

        if(tableViewInfoResumo.isVisible()) {
            try {
                ObservableList<Cliente> observableListClientes;
                ArrayList<Cliente> listaClientesTable = new ArrayList<Cliente>();
                
                String[] dadosClientes = listaClientes.getResumoInfo().split("\n");
                for (String dadosCliente : dadosClientes) {
                    
                    String[] dados = dadosCliente.split(";");

                    String cpf = dados[1].split(": ")[1];

                    Cliente cliente = listaClientes.get(Long.parseLong(cpf));
                    listaClientesTable.add(cliente);
                    System.out.println(cliente);
                }
                
                observableListClientes = FXCollections.observableArrayList(listaClientesTable);
                tableViewInfoResumo.setItems(observableListClientes);
    
            } catch (NullPointerException e) {
                System.out.println(e.getLocalizedMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
        mostrarEsconderInfoResumo = !mostrarEsconderInfoResumo;
    }

    @FXML
    void hoverBtnMostrarEsconderCampo(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void notHoverBtnEsconderMostrarCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void hoverBtnInfoFullCliente(MouseEvent event) {
        btnInfoFullCliente.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void hoverBtnInfoResumoCliente(MouseEvent event) {
        btnInfoResumoCliente.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void hoverBtnMostrarCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void hoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void limparCampos(MouseEvent event) {
        textFieldCPF.clear();
        textFieldNome.clear();
        textFieldEndereco.clear();
        textFieldTelefone.clear();
        textFieldCarteiraMotorista.clear();
        rootPane.requestFocus();
    }

    @FXML
    void mostrarEsconderCampos(ActionEvent event) {
        if (tableViewInfoCompleta.isVisible() || tableViewInfoResumo.isVisible()) {

            tableViewInfoCompleta.setVisible(false);
            tableViewInfoResumo.setVisible(false);

            mostrarEsconderInfoResumo = true;
            mostrarEsconderInfoCompleta = true;
        }

        limparCampos(null);
        labelCPF.setVisible(mostrarEsconderInfoCliente);
        labelNome.setVisible(mostrarEsconderInfoCliente);
        labelEndereco.setVisible(mostrarEsconderInfoCliente);
        labelTelefone.setVisible(mostrarEsconderInfoCliente);
        labelCarteiraMotorista.setVisible(mostrarEsconderInfoCliente);

        textFieldCPF.setVisible(mostrarEsconderInfoCliente);
        textFieldNome.setVisible(mostrarEsconderInfoCliente);
        textFieldEndereco.setVisible(mostrarEsconderInfoCliente);
        textFieldTelefone.setVisible(mostrarEsconderInfoCliente);
        textFieldCarteiraMotorista.setVisible(mostrarEsconderInfoCliente);

        btnPesquisar.setVisible(mostrarEsconderInfoCliente);
        btnLimpar.setVisible(mostrarEsconderInfoCliente);

        mostrarEsconderInfoCliente = !mostrarEsconderInfoCliente;
    }

    @FXML
    void notHoverBtnInfoFullCliente(MouseEvent event) {
        btnInfoFullCliente.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void notHoverBtnInfoResumoCliente(MouseEvent event) {
        btnInfoResumoCliente.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void notHoverBtnMostrarCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void notHoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 10;");
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
