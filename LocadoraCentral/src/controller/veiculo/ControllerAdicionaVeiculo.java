package controller.veiculo;

import controller.ControllerMenuLocadora;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import lista.ListaVeiculos;
import veiculo.*;

public class ControllerAdicionaVeiculo {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnLimpar;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ChoiceBox<String> choiceBoxTipoVeiculo;

    @FXML
    private ChoiceBox<String> choiceBoxArCondicionadoCarro;

    @FXML
    private ChoiceBox<String> choiceBoxCategoria;

    @FXML
    private ChoiceBox<String> choiceBoxWifiOnibus;

    @FXML
    private ChoiceBox<String> choiceBoxArCondicionadoOnibus;

    @FXML
    private Pane paneCaminhao;

    @FXML
    private Pane paneCarro;

    @FXML
    private Pane paneOnibus;

    @FXML
    private TextField textFieldAno;

    @FXML
    private TextField textFieldCargaMaxima;

    @FXML
    private TextField textFieldDiaria;

    @FXML
    private TextField textFieldMediaKm;

    @FXML
    private TextField textFieldNumeroEixos;

    @FXML
    private TextField textFieldNumeroPassageirosCarro;

    @FXML
    private TextField textFieldNumeroPassageirosOnibus;

    @FXML
    private TextField textFieldNumeroPortas;

    @FXML
    private TextField textFieldPlaca;

    private final String[] tipoVeiculos = { "Carro", "Ônibus", "Caminhão" };

    private final String[] escolhaBooleana = { "Sim", "Não" };

    private final String[] tipoCategorias = { "Leito", "Executivo", "Convencional" };

    private ListaVeiculos listaVeiculos;

    @FXML
    void initialize() {
        choiceBoxTipoVeiculo.getItems().addAll(tipoVeiculos);
        choiceBoxTipoVeiculo.setOnAction(this::selecionaTipoVeiculo);

        choiceBoxArCondicionadoCarro.getItems().addAll(escolhaBooleana);
        choiceBoxArCondicionadoOnibus.getItems().addAll(escolhaBooleana);
        choiceBoxCategoria.getItems().addAll(tipoCategorias);
        choiceBoxWifiOnibus.getItems().addAll(escolhaBooleana);

        listaVeiculos = ControllerMenuLocadora.getListaVeiculos();
    }

    public void selecionaTipoVeiculo(ActionEvent event) {
        String tipoVeiculo = choiceBoxTipoVeiculo.getValue();
        if (tipoVeiculo.equals("Caminhão")) {
            paneCaminhao.setVisible(true);
            paneCarro.setVisible(false);
            paneOnibus.setVisible(false);
        }

        if (tipoVeiculo.equals("Carro")) {
            paneCaminhao.setVisible(false);
            paneCarro.setVisible(true);
            paneOnibus.setVisible(false);
        }

        if (tipoVeiculo.equals("Ônibus")) {
            paneCaminhao.setVisible(false);
            paneCarro.setVisible(false);
            paneOnibus.setVisible(true);
        }
        limparCampos();
    }

    @FXML
    void adicionarVeiculo(ActionEvent event) {

        String placa = textFieldPlaca.getText();

        // PLACA JÁ CADASTRADA
        if (!listaVeiculos.existe(placa)) {
            String tipoVeiculo = choiceBoxTipoVeiculo.getValue();

            // VEICULO ESCOLHIDO
            if (tipoVeiculo != null) {

                String ano = textFieldAno.getText();
                String diaria = textFieldDiaria.getText();

                // INFORMAÇÕES BÁSICAS NÃO PREENCHIDAS
                if (placa.isEmpty() || ano.isEmpty() || diaria.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERRO");
                    alert.setHeaderText(null);
                    alert.setContentText("Preencha todos os campos!");
                    alert.showAndWait();
                } else {

                    try {
                        int anoInt = Integer.parseInt(ano);
                        double diariaDouble = Double.parseDouble(diaria);

                        switch (tipoVeiculo) {

                            case "Carro":
                                String arCondicionado = choiceBoxArCondicionadoCarro.getValue();
                                String numeroPortas = textFieldNumeroPortas.getText();
                                String numeroPassageiros = textFieldNumeroPassageirosCarro.getText();
                                String mediaKm = textFieldMediaKm.getText();

                                if (arCondicionado.isEmpty() || numeroPortas.isEmpty() || numeroPassageiros.isEmpty()
                                        || mediaKm.isEmpty()) {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("ERRO");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Preencha todos os campos!");
                                    alert.showAndWait();
                                } else {

                                    boolean arCondicionadoBoolean = false;
                                    int numeroPortasInt = Integer.parseInt(numeroPortas);
                                    int numeroPassageirosInt = Integer.parseInt(numeroPassageiros);
                                    double mediaKmDouble = Double.parseDouble(mediaKm);

                                    if (arCondicionado.equals("Sim")) {
                                        arCondicionadoBoolean = true;
                                    } else {
                                        arCondicionadoBoolean = false;
                                    }

                                    Veiculo carro = new Carro(placa, anoInt, diariaDouble, numeroPassageirosInt,
                                            numeroPortasInt, mediaKmDouble, arCondicionadoBoolean);
                                    listaVeiculos.add(carro);

                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("SUCESSO");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Carro adicionado com sucesso!");
                                    alert.showAndWait();

                                    limparTodosCampos(null);
                                }

                                break;

                            case "Ônibus":
                                String wifi = choiceBoxWifiOnibus.getValue();
                                String arCondicionadoOnibus = choiceBoxArCondicionadoOnibus.getValue();
                                String numeroPassageirosOnibus = textFieldNumeroPassageirosOnibus.getText();

                                if (wifi.isEmpty() || arCondicionadoOnibus.isEmpty()
                                        || numeroPassageirosOnibus.isEmpty()) {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("ERRO");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Preencha todos os campos!");
                                    alert.showAndWait();
                                } else {

                                    boolean wifiBoolean = false;
                                    boolean arCondicionadoOnibusBoolean = false;
                                    int numeroPassageirosOnibusInt = Integer.parseInt(numeroPassageirosOnibus);
                                    Categoria categoria;

                                    if (wifi.equals("Sim")) {
                                        wifiBoolean = true;
                                    } else {
                                        wifiBoolean = false;
                                    }

                                    if (arCondicionadoOnibus.equals("Sim")) {
                                        arCondicionadoOnibusBoolean = true;
                                    } else {
                                        arCondicionadoOnibusBoolean = false;
                                    }

                                    if (choiceBoxCategoria.getValue().equals("Executivo")) {
                                        categoria = Categoria.EXECUTIVO;
                                    } else if (choiceBoxCategoria.getValue().equals("Leito")) {
                                        categoria = Categoria.LEITO;
                                    } else {
                                        categoria = Categoria.CONVENCIONAL;
                                    }

                                    Veiculo onibus = new Onibus(placa, anoInt, diariaDouble, numeroPassageirosOnibusInt,
                                            categoria, wifiBoolean, arCondicionadoOnibusBoolean);
                                    listaVeiculos.add(onibus);

                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("SUCESSO");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Ônibus adicionado com sucesso!");
                                    alert.showAndWait();

                                    limparTodosCampos(null);
                                }

                                break;

                            case "Caminhão":
                                String cargaMaxima = textFieldCargaMaxima.getText();
                                String numeroEixos = textFieldNumeroEixos.getText();

                                if (cargaMaxima.isEmpty() || numeroEixos.isEmpty()) {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("ERRO");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Preencha todos os campos!");
                                    alert.showAndWait();
                                } else {

                                    double cargaMaximaDouble = Double.parseDouble(cargaMaxima);
                                    int numeroEixosInt = Integer.parseInt(numeroEixos);

                                    Veiculo caminhao = new Caminhao(placa, anoInt, diariaDouble, numeroEixosInt,
                                            cargaMaximaDouble);
                                    listaVeiculos.add(caminhao);

                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("SUCESSO");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Caminhão adicionado com sucesso!");
                                    alert.showAndWait();

                                    limparTodosCampos(null);
                                }

                                break;

                        }
                    } catch (NullPointerException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERRO");
                        alert.setHeaderText(null);
                        alert.setContentText("Escolha um veículo!");
                        alert.showAndWait();
                    } catch (NumberFormatException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERRO");
                        alert.setHeaderText(null);
                        alert.setContentText("Preencha os campos corretamente!");
                        alert.showAndWait();
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText("Escolha um veículo!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText("Placa já existente!");
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

    void limparCampos() {
        textFieldCargaMaxima.setText("");
        textFieldMediaKm.setText("");
        textFieldNumeroEixos.setText("");
        textFieldNumeroPassageirosCarro.setText("");
        textFieldNumeroPassageirosOnibus.setText("");
        textFieldNumeroPortas.setText("");
    }

    @FXML
    void limparTodosCampos(MouseEvent event) {
        textFieldAno.setText("");
        textFieldCargaMaxima.setText("");
        textFieldDiaria.setText("");
        textFieldMediaKm.setText("");
        textFieldNumeroEixos.setText("");
        textFieldNumeroPassageirosCarro.setText("");
        textFieldNumeroPassageirosOnibus.setText("");
        textFieldNumeroPortas.setText("");
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
    void hoverBtnAdicionar(MouseEvent event) {
        btnAdicionar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnAdicionar(MouseEvent event) {
        btnAdicionar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

}
