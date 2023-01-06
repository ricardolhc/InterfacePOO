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

/**
 * Classe responsável por controlar a tela de alteração de veiculos
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ControllerAlteraVeiculo {

    /**
     * btnAlterar usado para alterar um cliente na lista de clientes
     */
    @FXML
    private Button btnAlterar;

    /**
     * btnLimpar usado para limpar os campos da tela
     */
    @FXML
    private Button btnLimpar;

    /**
     * btnProcurar usado para pesquisar um veiculo na lista de veiculos
     */
    @FXML
    private Button btnProcurar;

    /**
     * btnVoltar usado para voltar para a tela principal
     */
    @FXML
    private ImageView btnVoltar;

    /**
     * choiceBoxArCondicionadoCarro usado para selecionar se o carro tem ar condicionado
     */
    @FXML
    private ChoiceBox<String> choiceBoxArCondicionadoCarro;

    /**
     * choiceBoxArCondicionadoOnibus usado para selecionar se o onibus tem ar condicionado
     */
    @FXML
    private ChoiceBox<String> choiceBoxArCondicionadoOnibus;

    /**
     * choiceBoxCategoria usado para selecionar a categoria do onibus
     */
    @FXML
    private ChoiceBox<String> choiceBoxCategoria;

    /**
     * choiceBoxWifiOnibus usado para selecionar se o onibus tem wifi
     */
    @FXML
    private ChoiceBox<String> choiceBoxWifiOnibus;

    /**
     * paneCaminhao usado para carregar os campos do caminhao
     */
    @FXML
    private Pane paneCaminhao;

    /**
     * paneCarro usado para carregar os campos do carro
     */
    @FXML
    private Pane paneCarro;

    /**
     * paneOnibus usado para carregar os campos do onibus
     */
    @FXML
    private Pane paneOnibus;

    /**
     * rootPane usado para carregar a tela de adicionar locacao
     */
    @FXML
    private AnchorPane rootPane;

    /**
     * textFieldAno usado para receber o ano do veiculo
     */
    @FXML
    private TextField textFieldAno;

    /**
     * textFieldCargaMaxima usado para receber a carga maxima do caminhao
     */
    @FXML
    private TextField textFieldCargaMaxima;

    /**
     * textFieldDiaria usado para receber o valor da diaria do veiculo
     */
    @FXML
    private TextField textFieldDiaria;

    /**
     * textFieldMarca usado para receber media de km do veiculo
     */
    @FXML
    private TextField textFieldMediaKm;

    /**
     * textFieldModelo usado para receber o numero de eixos do caminhao
     */
    @FXML
    private TextField textFieldNumeroEixos;

    /**
     * textFieldNumeroPassageirosCarro usado para receber o numero de passageiros do carro
     */
    @FXML
    private TextField textFieldNumeroPassageirosCarro;

    /**
     * textFieldNumeroPassageirosOnibus usado para receber o numero de passageiros do onibus
     */
    @FXML
    private TextField textFieldNumeroPassageirosOnibus;

    /**
     * textFieldNumeroPortas usado para receber o numero de portas do carro
     */
    @FXML
    private TextField textFieldNumeroPortas;

    /**
     * textFieldPlaca usado para receber a placa do veiculo
     */
    @FXML
    private TextField textFieldPlaca;

    /**
     * textFieldTipoVeiculo usado para receber o tipo do veiculo
     */
    @FXML
    private TextField textFieldTipoVeiculo;

    /**
     * placaAlterar usado para receber a placa do veiculo que será alterado
     */
    private String placaAlterar;

    /**
     * escolhaBooleana usado como uma flag de verdadeiro ou falso
     */
    private final String[] escolhaBooleana = { "Sim", "Não" };

    /**
     * tipoCategorias usado para selecionar a categoria do onibus
     */
    private final String[] tipoCategorias = { "Leito", "Executivo", "Convencional" };

    /**
     * listaVeiculos usado para receber a lista de veiculos
     */
    private ListaVeiculos listaVeiculos;

    /**
     * Método usado para inicializar a lista de locacoes, veiculos e clientes a partir do menu principal
     * e também para adicionar ar condicionado do carro e onibus, wifi do onibus, categoria do onibus no choiceBox
     */
    @FXML
    void initialize() {
        choiceBoxArCondicionadoCarro.getItems().addAll(escolhaBooleana);
        choiceBoxArCondicionadoOnibus.getItems().addAll(escolhaBooleana);
        choiceBoxCategoria.getItems().addAll(tipoCategorias);
        choiceBoxWifiOnibus.getItems().addAll(escolhaBooleana);

        listaVeiculos = ControllerMenuLocadora.getListaVeiculos();
    }

    /**
     * Método usado para voltar ao menu principal
     * 
     * @param event evento de clicar no botão
     */
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

    /**
     * Método usado para alterar as informações ano, diaria, media de km, numero de eixos, numero de passageiros, numero de portas, placa, tipo do veiculo 
     * 
     * @param event evento de clicar no botão
     */
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
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText("Preencha os campos corretamente!");
            alert.showAndWait();
        }
    }

    /**
      * Método usado para pesquisar um veiculo usando a placa
     * 
     * @param event evento de clicar no botão
     */
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

    /**
     * Método para limpar os campos de texto presentes na tela
     * 
     * @param event evento de limpar os campos de texto presentes na tela
     */
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

    /**
     * Efeito de hover ao passar o mouse no botão de limpar
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse do botão de limpar
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de voltar
     * 
     * @param event evento hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao tirar o mouse do botão de voltar
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltar.png"));
    }

    /**
     * Efeito de hover ao passar o mouse no botão de pesquisar
     * 
     * @param event evento hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnProcurar(MouseEvent event) {
        btnProcurar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse do botão de procurar
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnProcurar(MouseEvent event) {
        btnProcurar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de alterar
     * 
     * @param event evento hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnAlterar(MouseEvent event) {
        btnAlterar.setStyle("-fx-background-color: #676508;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse do botão de alterar
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnAlterar(MouseEvent event) {
        btnAlterar.setStyle("-fx-background-color: #807d0a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

}
