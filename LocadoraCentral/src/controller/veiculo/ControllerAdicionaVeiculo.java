package controller.veiculo;

import controller.ControllerMenuLocadora;
import exceptions.geral.EmptyFieldException;
import exceptions.veiculo.InvalidVeiculoException;
import exceptions.veiculo.PlacaAlreadyAdd;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import lista.ListaVeiculos;
import veiculo.*;

/**
 * A classe ControllerAdicionaLocacao é responsável por controlar a tela de
 * adicionar veiculo
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ControllerAdicionaVeiculo {

    /**
     * btnAdicionar usado para adicionar uma locacao
     */
    @FXML
    private Button btnAdicionar;

    /**
     * btnLimpar usado para limpar os campos
     */
    @FXML
    private Button btnLimpar;

    /**
     * btnVoltar usado para voltar para a tela principal
     */
    @FXML
    private ImageView btnVoltar;

    /**
     * rootPane usado para carregar a tela de adicionar locacao
     */
    @FXML
    private AnchorPane rootPane;

    /**
     * choiceBoxTipoVeiculo usado para selecionar o tipo de veiculo
     */
    @FXML
    private ChoiceBox<String> choiceBoxTipoVeiculo;

    /**
     * choiceBoxArCondicionadoCarro usado para selecionar se o carro tem ar
     * condicionado
     */
    @FXML
    private ChoiceBox<String> choiceBoxArCondicionadoCarro;

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
     * choiceBoxArCondicionadoOnibus usado para selecionar se o onibus tem ar
     * condicionado
     */
    @FXML
    private ChoiceBox<String> choiceBoxArCondicionadoOnibus;

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
     * textFieldNumeroPassageirosCarro usado para receber o numero de passageiros do
     * carro
     */
    @FXML
    private TextField textFieldNumeroPassageirosCarro;

    /**
     * textFieldNumeroPassageirosOnibus usado para receber o numero de passageiros
     * do onibus
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
     * tipoVeiculos usado para selecionar o tipo de veiculo
     */
    private final String[] tipoVeiculos = { "Carro", "Ônibus", "Caminhão" };

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
     * Método usado para inicializar a lista de locacoes, veiculos e clientes a
     * partir do menu principal
     * e também para adicionar as opções de tipo de veiculo, ar condicionado do
     * carro e onibus, wifi do onibus, categoria do onibus no choiceBox
     */
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
            alertInterface("ERRO", "Não foi possível voltar para o menu principal", AlertType.ERROR);
        }
    }

    /**
     * Método usado para selecionar o tipo de veiculo, que pode ser carro, onibus ou
     * caminhao
     * 
     * @param event evento de clicar no botão
     */
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

    /**
     * Método usado para adicionar um veiculo a partir da placa, tipo de veiculo,
     * ano, diaria, marca, modelo, media de km, numero de portas, numero de
     * passageiros do carro, numero de eixos do caminhao, numero de passageiros do
     * onibus, ar condicionado do carro, ar condicionado do onibus, wifi do onibus,
     * categoria do onibus
     * 
     * @param event evento de clicar no botão
     */
    @FXML
    void adicionarVeiculo(ActionEvent event) {

        String placa = textFieldPlaca.getText().toLowerCase();
        String ano = textFieldAno.getText();
        String diaria = textFieldDiaria.getText();

        try {
            String tipoVeiculo = choiceBoxTipoVeiculo.getValue();

            /* POSSIVEL NUMBERFORMATEXCEPTION */
            int anoInt = Integer.parseInt(ano);
            double diariaDouble = Double.parseDouble(diaria);
            
            if (placa.isEmpty() || ano.isEmpty() || diaria.isEmpty()) {
                throw new EmptyFieldException("Preencha todos os campos!");
            }
            // PLACA JÁ CADASTRADA
            if (listaVeiculos.existe(placa)) {
                throw new PlacaAlreadyAdd("Placa já cadastrada!");
            }
            // VEICULO ESCOLHIDO
            if (tipoVeiculo == null) {
                throw new InvalidVeiculoException("Escolha um veículo!");
            }
            switch (tipoVeiculo) {

                case "Carro":
                    String arCondicionado = choiceBoxArCondicionadoCarro.getValue();
                    String numeroPortas = textFieldNumeroPortas.getText();
                    String numeroPassageiros = textFieldNumeroPassageirosCarro.getText();
                    String mediaKm = textFieldMediaKm.getText();

                    if (arCondicionado == null || numeroPortas.isEmpty() || numeroPassageiros.isEmpty() || mediaKm.isEmpty()) {
                        throw new EmptyFieldException("Preencha todos os campos!");
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

                        Veiculo carro = new Carro(placa, anoInt, diariaDouble, numeroPassageirosInt, numeroPortasInt, mediaKmDouble, arCondicionadoBoolean);
                        listaVeiculos.add(carro);

                        alertInterface("SUCESSO", "Carro adicionado com sucesso!", AlertType.INFORMATION);
                        limparTodosCampos(null);
                    }
                    break;

                case "Ônibus":
                    String wifi = choiceBoxWifiOnibus.getValue();
                    String arCondicionadoOnibus = choiceBoxArCondicionadoOnibus.getValue();
                    String numeroPassageirosOnibus = textFieldNumeroPassageirosOnibus.getText();

                    if (wifi == null || arCondicionadoOnibus == null || numeroPassageirosOnibus.isEmpty()) {
                        throw new EmptyFieldException("Preencha todos os campos!");
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

                        Veiculo onibus = new Onibus(placa, anoInt, diariaDouble, numeroPassageirosOnibusInt, categoria, wifiBoolean, arCondicionadoOnibusBoolean);
                        listaVeiculos.add(onibus);

                        alertInterface("SUCESSO", "Ônibus adicionado com sucesso!", AlertType.INFORMATION);

                        limparTodosCampos(null);
                    }
                    break;

                case "Caminhão":
                    String cargaMaxima = textFieldCargaMaxima.getText();
                    String numeroEixos = textFieldNumeroEixos.getText();

                    if (cargaMaxima.isEmpty() || numeroEixos.isEmpty()) {
                        throw new EmptyFieldException("Preencha todos os campos!");
                    } else {
                        double cargaMaximaDouble = Double.parseDouble(cargaMaxima);
                        int numeroEixosInt = Integer.parseInt(numeroEixos);

                        Veiculo caminhao = new Caminhao(placa, anoInt, diariaDouble, numeroEixosInt, cargaMaximaDouble);
                        listaVeiculos.add(caminhao);

                        alertInterface("SUCESSO", "Caminhão adicionado com sucesso!", AlertType.INFORMATION);
                        limparTodosCampos(null);
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            alertInterface("ERRO", "Preencha os campos corretamente!", AlertType.ERROR);
        } catch (EmptyFieldException | PlacaAlreadyAdd | InvalidVeiculoException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }

    }

    /**
     * Método para limpar os campos de texto presentes na tela
     * 
     * @param event evento de limpar os campos de texto presentes na tela
     */
    void limparCampos() {
        textFieldCargaMaxima.setText("");
        textFieldMediaKm.setText("");
        textFieldNumeroEixos.setText("");
        textFieldNumeroPassageirosCarro.setText("");
        textFieldNumeroPassageirosOnibus.setText("");
        textFieldNumeroPortas.setText("");
    }

    /**
     * Método para limpar todos os campos de texto presentes na tela
     * 
     * @param event evento de limpar os campos de texto presentes na tela
     */
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
     * @param event efeito de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de voltar
     * 
     * @param event evento hover ao passar o mouse no botão de voltar
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
     * Efeito de hover ao passar o mouse no botão de adicionar
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnAdicionar(MouseEvent event) {
        btnAdicionar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse do botão de adicionar
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnAdicionar(MouseEvent event) {
        btnAdicionar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
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
