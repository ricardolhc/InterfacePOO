package controller.locacao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import controller.ControllerMenuLocadora;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lista.Cliente;
import lista.ListaClientes;
import lista.ListaLocacoes;
import lista.ListaVeiculos;
import lista.Locacao;
import veiculo.Veiculo;

public class ControllerAlteraLocacao {

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnPesquisar;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private ChoiceBox<String> choiceSeguro;

    private final String[] escolhaseguro = { "Sim", "Não"};

    @FXML
    private DatePicker pickerDataFinal;

    @FXML
    private DatePicker pickerDataInicial;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField textFieldCPF;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textFieldPlaca;

    private int IDAlterar;

    private ListaLocacoes listaLocacao;

    private ListaVeiculos listaVeiculo;

    private ListaClientes listaClientes;

    private Locacao locacao;

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
    void pesquisarLocacao(ActionEvent event) {
        IDAlterar = textFieldID.getText().isEmpty() ? 0 : Integer.parseInt(textFieldID.getText());

        if (textFieldID.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText("Preencha todos os campos!");
            alert.showAndWait();
        } else {

            try {
                if (listaLocacao.existe((IDAlterar))) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERRO");
                    alert.setHeaderText(null);
                    alert.setContentText("ID não encontrado!");
                    alert.showAndWait();
                    
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERRO");
                        alert.setHeaderText(null);
                        alert.setContentText("Cliente não encontrado!");
                        alert.showAndWait();
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
    void alterarLocacao(ActionEvent event) {
        if (textFieldPlaca.getText().isEmpty() || textFieldCPF.getText().isEmpty() || choiceSeguro.getValue() == null
                || pickerDataInicial.getValue() == null || pickerDataFinal.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText("Preencha todos os campos!");
            alert.showAndWait();

        } else {

            if (pickerDataInicial.getValue().isAfter(pickerDataFinal.getValue())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText("Data final menor que a inicial!");
                alert.showAndWait();
            } else {
                LocalDate dataInicial = pickerDataInicial.getValue();
                LocalDate dataFinal = pickerDataFinal.getValue();

                Date date = Date.from(dataInicial.atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date date2 = Date.from(dataFinal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
                Calendar dataInicialC = Calendar.getInstance();
                dataInicialC.setTime(date);
                System.out.println("\nConversion of LocalDate to java.util.Calendar is :- \n"
                    + dataInicialC.get(Calendar.DAY_OF_MONTH) + dataInicialC.get(Calendar.MONTH) + dataInicialC.get(Calendar.YEAR));

                Calendar dataFinalC = Calendar.getInstance();
                dataFinalC.setTime(date2);
                System.out.println("\nConversion of LocalDate to java.util.Calendar is :- \n"
                    + dataFinalC.get(Calendar.DAY_OF_MONTH) + dataFinalC.get(Calendar.MONTH) + dataFinalC.get(Calendar.YEAR));

                try {
                    String placa = textFieldPlaca.getText();
                    String cpf = textFieldCPF.getText();
                    String escolhaseguro = choiceSeguro.getValue();
                    Long cpfLong;

                    boolean seguroBoolean = false;
                    int codigoFinal = locacao.getCodigo();
                    cpfLong = Long.parseLong(cpf);                    

                    if (escolhaseguro.equals("Sim")) {
                        seguroBoolean = true;
                        } else {
                        seguroBoolean = false;
                    }
                    if (cpf.length() != 11) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERRO");
                        alert.setHeaderText(null);
                        alert.setContentText("CPF inválido!");
                        alert.showAndWait();
                    } else {
                        if (!listaClientes.existe(cpfLong)) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("ERRO");
                            alert.setHeaderText(null);
                            alert.setContentText("CPF não existente!");
                            alert.showAndWait();
                        } else {
                            /* alterar locacao */
                            
                            Locacao locacao = listaLocacao.get(codigoFinal);
                            Cliente Cliente = listaClientes.get(cpfLong);
                            Veiculo Veiculo = listaVeiculo.get(placa);

                            locacao.setSeguro(seguroBoolean);
                            locacao.setDataInicial(dataInicialC);
                            locacao.setDataFinal(dataFinalC);
                            locacao.setCliente(Cliente); 
                            locacao.setVeiculo(Veiculo);

                            limparCampos(null);

                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("SUCESSO");
                            alert.setHeaderText(null);
                            alert.setContentText("Locação alterada com sucesso!");
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
    }

    @FXML
    void hoverBtnAlterar(MouseEvent event) {
        btnAlterar.setStyle("-fx-background-color: #676508;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/locacao/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void limparCampos(MouseEvent event) {
        textFieldCPF.clear();
        textFieldPlaca.clear();
        rootPane.requestFocus();
    }

    @FXML
    void notHoverBtnAlterar(MouseEvent event) {
        btnAlterar.setStyle("-fx-background-color: #807d0a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/locacao/pngVoltar.png"));
    }

    @FXML
    void hoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

}
