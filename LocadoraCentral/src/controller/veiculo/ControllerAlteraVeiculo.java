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

public class ControllerAlteraVeiculo {

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnProcurar;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private ChoiceBox<String> choiceBoxArCondicionadoCarro;

    @FXML
    private ChoiceBox<String> choiceBoxArCondicionadoOnibus;

    @FXML
    private ChoiceBox<String> choiceBoxCategoria;

    @FXML
    private ChoiceBox<String> choiceBoxWifiOnibus;

    @FXML
    private Pane paneCaminhao;

    @FXML
    private Pane paneCarro;

    @FXML
    private Pane paneOnibus;

    @FXML
    private AnchorPane rootPane;

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

    @FXML
    private TextField textFieldTipoVeiculo;

    private String placaAlterar;

    private final String[] escolhaBooleana = { "Sim", "Não" };

    private final String[] tipoCategorias = { "Leito", "Executivo", "Convencional" };

    private ListaVeiculos listaVeiculos;

    @FXML
    void initialize() {
        choiceBoxArCondicionadoCarro.getItems().addAll(escolhaBooleana);
        choiceBoxArCondicionadoOnibus.getItems().addAll(escolhaBooleana);
        choiceBoxCategoria.getItems().addAll(tipoCategorias);
        choiceBoxWifiOnibus.getItems().addAll(escolhaBooleana);

        listaVeiculos = ControllerMenuLocadora.getListaVeiculos();
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
    void alterarVeiculo(ActionEvent event) {
        String placaFinal = textFieldPlaca.getText().toLowerCase();

        try {
            if(!placaFinal.isEmpty()) {
                if (listaVeiculos.existe(placaFinal)) {
                    if (placaFinal.equals(placaAlterar)) {
                    
                        Veiculo veiculo = listaVeiculos.get(placaFinal);

                        String ano = textFieldAno.getText();
                        String diaria = textFieldDiaria.getText();

                        if (veiculo instanceof Carro) {
                            Carro carro = (Carro) veiculo;

                            String numeroPassageiros = textFieldNumeroPassageirosCarro.getText();
                            String numeroPortas = textFieldNumeroPortas.getText();
                            String mediaKm = textFieldMediaKm.getText();
                            String arCondicionado = choiceBoxArCondicionadoCarro.getValue();

                            if (numeroPassageiros.isEmpty() || numeroPortas.isEmpty() || mediaKm.isEmpty()
                                    || arCondicionado.isEmpty()) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("ERRO");
                                alert.setHeaderText(null);
                                alert.setContentText("Preencha todos os campos!");
                                alert.showAndWait();
                            } else {
                                carro.setNumeroPassageiros(Integer.parseInt(numeroPassageiros));
                                carro.setNumeroPortas(Integer.parseInt(numeroPortas));
                                carro.setmediaKm(Double.parseDouble(mediaKm));
                                carro.setArcondicionado(arCondicionado.equals("Sim") ? true : false);
                                
                                veiculo.setAno(Integer.parseInt(ano));
                                veiculo.setDiaria(Double.parseDouble(diaria));

                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("SUCESSO");
                                alert.setHeaderText(null);
                                alert.setContentText("Veiculo alterado com sucesso!");
                                alert.showAndWait();
                            }

                        } else if (veiculo instanceof Onibus) {
                            Onibus onibus = (Onibus) veiculo;

                            String numeroPassageiros = textFieldNumeroPassageirosOnibus.getText();
                            String wifi = choiceBoxWifiOnibus.getValue();
                            String categoria = choiceBoxCategoria.getValue();

                            if (numeroPassageiros.isEmpty() || wifi.isEmpty() || categoria.isEmpty()) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("ERRO");
                                alert.setHeaderText(null);
                                alert.setContentText("Preencha todos os campos!");
                                alert.showAndWait();
                            } else {
                                onibus.setNumeroPassageiros(Integer.parseInt(numeroPassageiros));
                                onibus.setWifi(wifi.equals("Sim") ? true : false);
                                onibus.setCategoria(Categoria.valueOf(categoria.toUpperCase()));

                                veiculo.setAno(Integer.parseInt(ano));
                                veiculo.setDiaria(Double.parseDouble(diaria));

                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("SUCESSO");
                                alert.setHeaderText(null);
                                alert.setContentText("Veiculo alterado com sucesso!");
                                alert.showAndWait();
                            }
                        } else if (veiculo instanceof Caminhao) {
                            Caminhao caminhao = (Caminhao) veiculo;

                            String cargaMaxima = textFieldCargaMaxima.getText();
                            String numeroEixos = textFieldNumeroEixos.getText();

                            if (cargaMaxima.isEmpty() || numeroEixos.isEmpty()) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("ERRO");
                                alert.setHeaderText(null);
                                alert.setContentText("Preencha todos os campos!");
                                alert.showAndWait();
                            } else {
                                caminhao.setCargaMaxima(Double.parseDouble(cargaMaxima));
                                caminhao.setNumeroEixos(Integer.parseInt(numeroEixos));

                                veiculo.setAno(Integer.parseInt(ano));
                                veiculo.setDiaria(Double.parseDouble(diaria));

                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("SUCESSO");
                                alert.setHeaderText(null);
                                alert.setContentText("Veiculo alterado com sucesso!");
                                alert.showAndWait();
                            }
                        }

                        paneCaminhao.setVisible(false);
                        paneCarro.setVisible(false);
                        paneOnibus.setVisible(false);
                        textFieldTipoVeiculo.setText("");

                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERRO");
                        alert.setHeaderText(null);
                        alert.setContentText("Placa trocada originalmente!");
                        alert.showAndWait();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERRO");
                    alert.setHeaderText(null);
                    alert.setContentText("Veiculo não existente!");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText("Digite a placa do veículo!");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText("Preencha os campos corretamente!");
            alert.showAndWait();
        }
    }

    @FXML
    void procurarVeiculo(ActionEvent event) {

        String placa = textFieldPlaca.getText().toLowerCase();
        placaAlterar = placa;

        if (!placa.isEmpty()) {
            if (listaVeiculos.existe(placa)) {

                Veiculo veiculo = listaVeiculos.get(placa);
    
                String ano = String.valueOf(veiculo.getAno());
                String diaria = String.valueOf(veiculo.getDiaria());
    
                textFieldAno.setText(ano);
                textFieldDiaria.setText(diaria);
    
                if (veiculo instanceof Carro) {
                    Carro carro = (Carro) veiculo;
    
                    String numeroPassageiros = String.valueOf(carro.getNumeroPassageiros());
                    String numeroPortas = String.valueOf(carro.getNumeroPortas());
                    String mediaKm = String.valueOf(carro.getMediaKm());
                    String arCondicionado;
    
                    if (carro.getArcondicionado() == true) {
                        arCondicionado = "Sim";
                    } else {
                        arCondicionado = "Não";
                    }
    
                    textFieldTipoVeiculo.setText("Carro");
                    textFieldNumeroPassageirosCarro.setText(numeroPassageiros);
                    textFieldNumeroPortas.setText(numeroPortas);
                    textFieldMediaKm.setText(mediaKm);
                    choiceBoxArCondicionadoCarro.setValue(arCondicionado);
    
                    paneCarro.setVisible(true);
                    paneOnibus.setVisible(false);
                    paneCaminhao.setVisible(false);
                } else if (veiculo instanceof Onibus) {
                    Onibus onibus = (Onibus) veiculo;
    
                    String numeroPassageiros = String.valueOf(onibus.getNumeroPassageiros());
                    String wifi = onibus.getWifi() ? "Sim" : "Não";
                    String categoria;
                    String arCondicionado;
    
                    if (onibus.getArcondicionado() == true) {
                        arCondicionado = "Sim";
                    } else {
                        arCondicionado = "Não";
                    }
    
                    if (onibus.getCategoria() == Categoria.LEITO) {
                        categoria = "Leito";
                    } else if (onibus.getCategoria() == Categoria.EXECUTIVO) {
                        categoria = "Executivo";
                    } else {
                        categoria = "Convencional";
                    }
    
                    textFieldTipoVeiculo.setText("Ônibus");
                    textFieldNumeroPassageirosOnibus.setText(numeroPassageiros);
                    choiceBoxWifiOnibus.setValue(wifi);
                    choiceBoxArCondicionadoOnibus.setValue(arCondicionado);
                    choiceBoxCategoria.setValue(categoria);
    
                    paneCarro.setVisible(false);
                    paneOnibus.setVisible(true);
                    paneCaminhao.setVisible(false);
                } else if (veiculo instanceof Caminhao) {
                    Caminhao caminhao = (Caminhao) veiculo;
    
                    String cargaMaxima = String.valueOf(caminhao.getCargaMaxima());
                    String numeroEixos = String.valueOf(caminhao.getNumeroEixos());
    
                    textFieldTipoVeiculo.setText("Caminhão");
                    textFieldCargaMaxima.setText(cargaMaxima);
                    textFieldNumeroEixos.setText(numeroEixos);
    
                    paneCarro.setVisible(false);
                    paneOnibus.setVisible(false);
                    paneCaminhao.setVisible(true);
                }
    
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText("Veiculo não existente!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText("Digite a placa do veículo!");
            alert.showAndWait();
        }
       

    }

    @FXML
    void limparCampos() {
        textFieldPlaca.setText("");
        textFieldAno.setText("");
        textFieldDiaria.setText("");
        textFieldCargaMaxima.setText("");
        textFieldMediaKm.setText("");
        textFieldNumeroEixos.setText("");
        textFieldNumeroPassageirosCarro.setText("");
        textFieldNumeroPassageirosOnibus.setText("");
        textFieldNumeroPortas.setText("");
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
    void hoverBtnProcurar(MouseEvent event) {
        btnProcurar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnProcurar(MouseEvent event) {
        btnProcurar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnAlterar(MouseEvent event) {
        btnAlterar.setStyle("-fx-background-color: #676508;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnAlterar(MouseEvent event) {
        btnAlterar.setStyle("-fx-background-color: #807d0a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

}
