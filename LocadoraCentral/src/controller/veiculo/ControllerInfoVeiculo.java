package controller.veiculo;

import java.util.ArrayList;

import controller.ControllerMenuLocadora;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lista.ListaVeiculos;
import veiculo.Caminhao;
import veiculo.Carro;
import veiculo.Categoria;
import veiculo.Onibus;
import veiculo.Veiculo;

/**
 * Classe responsável por controlar a tela de visualização de informações de
 * veiculos
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ControllerInfoVeiculo {

    /*
     * btnInfoFullVeiculo usado para mostrar informações completas dos veiculos
     */
    @FXML
    private Button btnInfoFullVeiculo;

    /*
     * btnInfoResumoVeiculo usado para mostrar informações resumidas dos veiculos
     */
    @FXML
    private Button btnInfoResumoVeiculo;

    /*
     * btnLimpar usado para limpar os campos de texto
     */
    @FXML
    private Button btnLimpar;

    /*
     * btnMostrarEsconderCampos usado para mostrar/esconder os campos de texto
     */
    @FXML
    private Button btnMostrarEsconderCampos;

    /*
     * btnPesquisar usado para pesquisar um cliente
     */
    @FXML
    private Button btnPesquisar;

    @FXML
    private ChoiceBox<String> choiceBoxArCondicionadoCarro;

    /*
     * btnVoltar usado para voltar para a tela principal
     */
    @FXML
    private ImageView btnVoltar;

    /*
     * labelPlaca usado para mostrar o texto Placa na tela
     */
    @FXML
    private Label labelPlaca;

    /*
     * labelAno usado para mostrar o texto Ano na tela
     */
    @FXML
    private Label labelAno;

    /*
     * labelDiaria usado para mostrar o texto Diaria na tela
     */
    @FXML
    private Label labelDiaria;

    /*
     * labelTipoVeiculo usado para mostrar o texto Tipo de Veiculo na tela
     */
    @FXML
    private Label labelTipoVeiculo;

    /*
     * rootPane usado para mostrar a tela de informações de clientes
     */
    @FXML
    private AnchorPane rootPane;

    /*
     * tableColumnAnoInfoCompleta usado para mostrar o ano do veiculo nas informações completas
     */
    @FXML
    private TableColumn<Veiculo, Integer> tableColumnAnoInfoCompleta;

    /*
     * tableColumnAnoInfoCompleta usado para mostrar o ano do veiculo nas informações resumidas
     */
    @FXML
    private TableColumn<Veiculo, Integer> tableColumnAnoInfoResumo;

    /*
     * tableColumnArCondicionadoInfoCompleta usado para mostrar se o veiculo tem ar condicionado nas informações completas
     */
    @FXML
    private TableColumn<Veiculo, Boolean> tableColumnArCondicionadoInfoCompleta;

    /*
     * tableColumnCargaMaximaInfoCompleta usado para mostrar a carga maxima do caminhao nas informações completas
     */
    @FXML
    private TableColumn<Veiculo, Double> tableColumnCargaMaximaInfoCompleta;

    /*
     * tableColumnCategoriaInfoCompleta usado para mostrar a categoria do onibus nas informações completas
     */
    @FXML
    private TableColumn<Veiculo, Categoria> tableColumnCategoriaInfoCompleta;
    
    /*
     * tableColumnDiariaInfoCompleta usado para mostrar a diaria do veiculo nas informações completas
     */
    @FXML
    private TableColumn<Veiculo, Double> tableColumnDiariaInfoCompleta;

    /*
     * tableColumnDiariaInfoResumo usado para mostrar a diaria do veiculo nas informações resumidas
     */
    @FXML
    private TableColumn<Veiculo, Double> tableColumnDiariaInfoResumo;

    /*
     * tableColumnEixosInfoCompleta usado para mostrar a quantidade de eixos do caminhao nas informações completas
     */
    @FXML
    private TableColumn<Veiculo, Integer> tableColumnEixosInfoCompleta;

    /*
     * tableColumnMediaKmInfoCompleta usado para mostrar a media de km do veiculo nas informações completas
     */
    @FXML
    private TableColumn<Veiculo, Double> tableColumnMediaKmInfoCompleta;

    /*
     * tableColumnPassageirosInfoCompleta usado para mostrar a quantidade de passageiros do onibus nas informações completas
     */
    @FXML
    private TableColumn<Veiculo, Integer> tableColumnPassageirosInfoCompleta;

    /*
     * tableColumnPlacaInfoCompleta usado para mostrar a placa do veiculo nas informações completas
     */
    @FXML
    private TableColumn<Veiculo, String> tableColumnPlacaInfoCompleta;

    /*
     * tableColumnPlacaInfoResumo usado para mostrar a placa do veiculo nas informações resumidas
     */
    @FXML
    private TableColumn<Veiculo, String> tableColumnPlacafInfoResumo;

    /*
     * tableColumnPortasInfoCompleta usado para mostrar a quantidade de portas do veiculo nas informações completas
     */
    @FXML
    private TableColumn<Veiculo, Integer> tableColumnPortasInfoCompleta;

    /*
     * tableColumnWifiInfoCompleta usado para mostrar se o onibus tem wifi nas informações completas
     */
    @FXML
    private TableColumn<Veiculo, Boolean> tableColumnWifiInfoCompleta;

    /*
     * tableViewInfoCompleta usado para mostrar as informações completas do veiculo
     */
    @FXML
    private TableView<Veiculo> tableViewInfoCompleta;

    /*
     * tableViewInfoResumo usado para mostrar as informações resumidas do veiculo
     */
    @FXML
    private TableView<Veiculo> tableViewInfoResumo;

    /*
     * textFieldAno usado para receber a placa do veiculo
     */
    @FXML
    private TextField textFieldPlaca;

    /*
     * textFieldAno usado para receber o ano do veiculo
     */
    @FXML
    private TextField textFieldAno;

    /*
     * textFieldDiaria usado para receber a diaria do veiculo
     */
    @FXML
    private TextField textFieldDiaria;

    /*
     * textFieldTipoVeiculo usado para receber o tipo de veiculo
     */
    @FXML
    private TextField textFieldTipoVeiculo;

    /*
     * textFieldNumeroPassageirosCarro usado para receber a quantidade de passageiros do carro
     */
    @FXML
    private TextField textFieldNumeroPassageirosCarro;

    /*
     * textFieldMediaKm usado para receber a media de km do veiculo
     */
    @FXML
    private TextField textFieldMediaKm;

    /*
     * textFieldNumeroPortas usado para receber a quantidade de portas do veiculo
     */
    @FXML
    private TextField textFieldNumeroPortas;

    /*
     * textFieldCargaMaxima usado para receber a carga maxima do caminhao
     */
    @FXML
    private TextField textFieldCargaMaxima;

    /*
     * textFieldNumeroEixos usado para receber a quantidade de eixos do caminhao
     */
    @FXML
    private TextField textFieldNumeroEixos;

    /*
     * textFieldNumeroPassageirosOnibus usado para receber a quantidade de passageiros do onibus
     */
    @FXML
    private TextField textFieldNumeroPassageirosOnibus;

    /*
     * choiceBoxCategoria usado para receber a categoria do onibus
     */
    @FXML
    private ChoiceBox<String> choiceBoxCategoria;

    /*
     * choiceBoxWifiOnibus usado para receber se o onibus tem wifi
     */
    @FXML
    private ChoiceBox<String> choiceBoxWifiOnibus;

    /*
     * choiceBoxArCondicionadoOnibus usado para receber se o onibus tem ar condicionado
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
     * listaVeiculos usado para receber a lista de veiculos
     */
    private ListaVeiculos listaVeiculos;

    /**
     * escolhaBooleana usado como uma flag de verdadeiro ou falso
     */
    private final String[] escolhaBooleana = { "Sim", "Não" };

    /**
     * tipoCategorias usado para selecionar a categoria do onibus
     */
    private final String[] tipoCategorias = { "Leito", "Executivo", "Convencional" };

    /**
     * mostrarEsconderInfoVeiculo usado para mostrar ou esconder as informações do veiculo
     */
    private boolean mostrarEsconderInfoVeiculo = true;

    /**
     * mostrarEsconderInfoCompleta usado para mostrar ou esconder as informações completas do veiculo
     */
    private boolean mostrarEsconderInfoCompleta = true;

    /**
     * mostrarEsconderInfoResumo usado para mostrar ou esconder as informações resumidas do veiculo
     */
    private boolean mostrarEsconderInfoResumo = true;

    /**
     * Método usado para inicializar as colunas placa, ano, diaria, categoria, mediaKm, cargaMaxima, eixos, passageiros, portas, wifi e arCondicionado da tabela
     * e também para inicializar a lista de locacoes
     */
    @FXML
    void initialize() {
        tableColumnPlacaInfoCompleta.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("placa"));
        tableColumnAnoInfoCompleta.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("ano"));
        tableColumnDiariaInfoCompleta.setCellValueFactory(new PropertyValueFactory<Veiculo, Double>("diaria"));

        tableColumnCategoriaInfoCompleta.setCellValueFactory(new PropertyValueFactory<Veiculo, Categoria>("categoria"));
        tableColumnMediaKmInfoCompleta.setCellValueFactory(new PropertyValueFactory<Veiculo, Double>("mediaKm"));
        tableColumnCargaMaximaInfoCompleta.setCellValueFactory(new PropertyValueFactory<Veiculo, Double>("cargaMaxima"));
        tableColumnEixosInfoCompleta.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("numeroEixos"));
        tableColumnPassageirosInfoCompleta.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("numeroPassageiros"));
        tableColumnPortasInfoCompleta.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("numeroPortas"));
        tableColumnArCondicionadoInfoCompleta.setCellValueFactory(new PropertyValueFactory<Veiculo, Boolean>("arcondicionado"));
        tableColumnWifiInfoCompleta.setCellValueFactory(new PropertyValueFactory<Veiculo, Boolean>("wifi"));

        tableColumnPlacafInfoResumo.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("placa"));
        tableColumnAnoInfoResumo.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("ano"));
        tableColumnDiariaInfoResumo.setCellValueFactory(new PropertyValueFactory<Veiculo, Double>("diaria"));

        choiceBoxArCondicionadoCarro.getItems().addAll(escolhaBooleana);
        choiceBoxArCondicionadoOnibus.getItems().addAll(escolhaBooleana);
        choiceBoxWifiOnibus.getItems().addAll(escolhaBooleana);
        choiceBoxCategoria.getItems().addAll(tipoCategorias);

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
     * Método usado para mostrar as informações do veiculo pela placa
     * 
     * @param event evento de clicar no botão
     */
    @FXML
    void infoVeiculo(ActionEvent event) {

        String placa = textFieldPlaca.getText();

        try {

            if(!placa.isEmpty()) {
                if(listaVeiculos.existe(placa)) {
                    Veiculo veiculo = listaVeiculos.get(placa);

                    if(veiculo instanceof Carro) {
                        Carro carro = (Carro) veiculo;

                        String arCondicionado;

                        if(carro.getArcondicionado() == true) {
                            arCondicionado = "Sim";
                        } else {
                            arCondicionado = "Não";
                        }

                        paneCaminhao.setVisible(false);
                        paneOnibus.setVisible(false);
                        paneCarro.setVisible(true);

                        textFieldAno.setText(String.valueOf(carro.getAno()));
                        textFieldDiaria.setText(String.valueOf(carro.getDiaria()));
                        textFieldNumeroPassageirosCarro.setText(String.valueOf(carro.getNumeroPassageiros()));
                        textFieldNumeroPortas.setText(String.valueOf(carro.getNumeroPortas()));
                        textFieldMediaKm.setText(String.valueOf(carro.getMediaKm()));
                        choiceBoxArCondicionadoCarro.setValue(arCondicionado);
                        textFieldTipoVeiculo.setText("Carro");

                    } else if(veiculo instanceof Caminhao) {
                        Caminhao caminhao = (Caminhao) veiculo;

                        paneCarro.setVisible(false);
                        paneOnibus.setVisible(false);
                        paneCaminhao.setVisible(true);

                        textFieldAno.setText(String.valueOf(caminhao.getAno()));
                        textFieldDiaria.setText(String.valueOf(caminhao.getDiaria()));
                        textFieldNumeroEixos.setText(String.valueOf(caminhao.getNumeroEixos()));
                        textFieldCargaMaxima.setText(String.valueOf(caminhao.getCargaMaxima()));
                        textFieldTipoVeiculo.setText("Caminhão");

                    } else if(veiculo instanceof Onibus) {
                        Onibus onibus = (Onibus) veiculo;

                        String wifi;
                        String arCondicionado;
                        String categoria;

                        if(onibus.getWifi() == true) {
                            wifi = "Sim";
                        } else {
                            wifi = "Não";
                        }

                        if(onibus.getArcondicionado() == true) {
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

                        paneCarro.setVisible(false);
                        paneCaminhao.setVisible(false);
                        paneOnibus.setVisible(true);

                        textFieldAno.setText(String.valueOf(onibus.getAno()));
                        textFieldDiaria.setText(String.valueOf(onibus.getDiaria()));
                        textFieldNumeroPassageirosOnibus.setText(String.valueOf(onibus.getNumeroPassageiros()));
                        textFieldTipoVeiculo.setText("Ônibus");

                        choiceBoxCategoria.setValue(categoria);
                        choiceBoxWifiOnibus.setValue(wifi);
                        choiceBoxArCondicionadoOnibus.setValue(arCondicionado);
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Preencha o campo placa!");
                alert.showAndWait();
            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    /**
     * Método usado para mostrar as informações completas do veiculo pela placa
     * 
     * @param event evento de clicar no botão
     */
    @FXML
    void infoFullVeiculo(ActionEvent event) {
        if(textFieldPlaca.isVisible() || tableViewInfoResumo.isVisible()) {
            textFieldPlaca.setVisible(false);
            textFieldDiaria.setVisible(false);
            textFieldAno.setVisible(false);
            textFieldTipoVeiculo.setVisible(false);

            labelAno.setVisible(false);
            labelPlaca.setVisible(false);
            labelDiaria.setVisible(false);
            labelTipoVeiculo.setVisible(false);

            paneCaminhao.setVisible(false);
            paneCarro.setVisible(false);
            paneOnibus.setVisible(false);

            btnPesquisar.setVisible(false);
            btnLimpar.setVisible(false);

            tableViewInfoResumo.setVisible(false);

            mostrarEsconderInfoResumo = true;
            mostrarEsconderInfoVeiculo = true;
        }

        tableViewInfoCompleta.setVisible(mostrarEsconderInfoCompleta);

        if(tableViewInfoCompleta.isVisible()) {
            try {
                ObservableList<Veiculo> observableListVeiculos;
                ArrayList<Veiculo> listaVeiculosTable = new ArrayList<Veiculo>();
                
                String[] dadosVeiculos = listaVeiculos.getInfo().split("\n");
                for (String dadosVeiculo : dadosVeiculos) {
                    String[] dados = dadosVeiculo.split(";");
                    String placa = dados[0].split(": ")[1];

                    Veiculo veiculo = listaVeiculos.get(placa);
                    listaVeiculosTable.add(veiculo);
                }
                observableListVeiculos = FXCollections.observableArrayList(listaVeiculosTable);
                tableViewInfoCompleta.setItems(observableListVeiculos);
                tableViewInfoResumo.setItems(observableListVeiculos);
    
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

    /**
     * Método usado para mostrar as informações resumidas do veiculo pela placa
     * 
     * @param event evento de clicar no botão
     */
    @FXML
    void infoResumoVeiculo(ActionEvent event) {

        if(textFieldPlaca.isVisible() || tableViewInfoCompleta.isVisible()) {
            textFieldPlaca.setVisible(false);
            textFieldDiaria.setVisible(false);
            textFieldAno.setVisible(false);
            textFieldTipoVeiculo.setVisible(false);

            labelAno.setVisible(false);
            labelPlaca.setVisible(false);
            labelDiaria.setVisible(false);
            labelTipoVeiculo.setVisible(false);

            paneCaminhao.setVisible(false);
            paneCarro.setVisible(false);
            paneOnibus.setVisible(false);

            btnPesquisar.setVisible(false);
            btnLimpar.setVisible(false);

            tableViewInfoCompleta.setVisible(false);

            mostrarEsconderInfoCompleta = true;
            mostrarEsconderInfoVeiculo = true;
        }

        tableViewInfoResumo.setVisible(mostrarEsconderInfoResumo);

        if(tableViewInfoResumo.isVisible()) {
            try {
                ObservableList<Veiculo> observableListVeiculos;
                ArrayList<Veiculo> listaVeiculosTable = new ArrayList<Veiculo>();
                
                String[] dadosVeiculos = listaVeiculos.getResumoInfo().split("\n");
                for (String dadosVeiculo : dadosVeiculos) {
                    
                    String[] dados = dadosVeiculo.split(";");
                    String placa = dados[0].split(": ")[1];

                    Veiculo veiculo = listaVeiculos.get(placa);
                    listaVeiculosTable.add(veiculo);
                }
                observableListVeiculos = FXCollections.observableArrayList(listaVeiculosTable);
                tableViewInfoResumo.setItems(observableListVeiculos);
                tableViewInfoResumo.setItems(observableListVeiculos);
    
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

    /**
     * Método para limpar os campos de texto presentes na tela
     * 
     * @param event evento de limpar os campos de texto presentes na tela
     */
    @FXML
    void limparCampos(MouseEvent event) {
        
        textFieldAno.setText("");
        textFieldPlaca.setText("");
        textFieldDiaria.setText("");
        textFieldTipoVeiculo.setText("");
        textFieldCargaMaxima.setText("");
        textFieldNumeroEixos.setText("");
        textFieldNumeroPassageirosOnibus.setText("");
        textFieldNumeroPortas.setText("");
        textFieldNumeroPassageirosCarro.setText("");
        textFieldMediaKm.setText("");
        
        paneCaminhao.setVisible(false);
        paneCarro.setVisible(false);
        paneOnibus.setVisible(false);
    }

    /**
     * Método para mostrar/esconder os campos de texto presentes na tela
     * 
     * @param event evento de mostrar/esconder os campos de texto
     */
    @FXML
    void mostrarEsconderCampos(ActionEvent event) {

        if(tableViewInfoCompleta.isVisible() || tableViewInfoResumo.isVisible()) {
            tableViewInfoCompleta.setVisible(false);
            tableViewInfoResumo.setVisible(false);

            paneCaminhao.setVisible(false);
            paneCarro.setVisible(false);
            paneOnibus.setVisible(false);

            mostrarEsconderInfoCompleta = true;
            mostrarEsconderInfoResumo = true;
        }

        textFieldPlaca.setVisible(mostrarEsconderInfoVeiculo);
        textFieldDiaria.setVisible(mostrarEsconderInfoVeiculo);
        textFieldAno.setVisible(mostrarEsconderInfoVeiculo);
        textFieldTipoVeiculo.setVisible(mostrarEsconderInfoVeiculo);

        labelAno.setVisible(mostrarEsconderInfoVeiculo);
        labelPlaca.setVisible(mostrarEsconderInfoVeiculo);
        labelDiaria.setVisible(mostrarEsconderInfoVeiculo);
        labelTipoVeiculo.setVisible(mostrarEsconderInfoVeiculo);

        btnPesquisar.setVisible(mostrarEsconderInfoVeiculo);
        btnLimpar.setVisible(mostrarEsconderInfoVeiculo);

        mostrarEsconderInfoVeiculo = !mostrarEsconderInfoVeiculo;
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * completas de todos os veículos
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnInfoFullVeiculo(MouseEvent event) {
        btnInfoFullVeiculo.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de limpar os campos de texto
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar/esconder os campos de
     * pesquisa
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnMostrarCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de pesquisar
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de voltar
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltar.png"));
    }

    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de todos os veículos
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnInfoFullVeiculo(MouseEvent event) {
        btnInfoFullVeiculo.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * resumidas de todos os veículos
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnInfoResumoVeiculo(MouseEvent event) {
        btnInfoResumoVeiculo.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todos os veículos
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnInfoResumoVeiculo(MouseEvent event) {
        btnInfoResumoVeiculo.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de limpar os campos de texto
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de mostrar/esconder os campos de
     * texto
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnMostrarCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de pesquisar
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
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

}
