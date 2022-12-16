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

public class ControllerInfoVeiculo {

    @FXML
    private Button btnInfoFullVeiculo;

    @FXML
    private Button btnInfoResumoVeiculo;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnMostrarEsconderCampos;

    @FXML
    private Button btnPesquisar;

    @FXML
    private ChoiceBox<String> choiceBoxArCondicionadoCarro;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private Label labelPlaca;

    @FXML
    private Label labelAno;

    @FXML
    private Label labelDiaria;

    @FXML
    private Label labelTipoVeiculo;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableColumn<Veiculo, Integer> tableColumnAnoInfoCompleta;

    @FXML
    private TableColumn<Veiculo, Integer> tableColumnAnoInfoResumo;

    @FXML
    private TableColumn<Veiculo, Boolean> tableColumnArCondicionadoInfoCompleta;

    @FXML
    private TableColumn<Veiculo, Double> tableColumnCargaMaximaInfoCompleta;

    @FXML
    private TableColumn<Veiculo, Categoria> tableColumnCategoriaInfoCompleta;

    @FXML
    private TableColumn<Veiculo, Double> tableColumnDiariaInfoCompleta;

    @FXML
    private TableColumn<Veiculo, Double> tableColumnDiariaInfoResumo;

    @FXML
    private TableColumn<Veiculo, Integer> tableColumnEixosInfoCompleta;

    @FXML
    private TableColumn<Veiculo, Double> tableColumnMediaKmInfoCompleta;

    @FXML
    private TableColumn<Veiculo, Integer> tableColumnPassageirosInfoCompleta;

    @FXML
    private TableColumn<Veiculo, String> tableColumnPlacaInfoCompleta;

    @FXML
    private TableColumn<Veiculo, String> tableColumnPlacafInfoResumo;

    @FXML
    private TableColumn<Veiculo, Integer> tableColumnPortasInfoCompleta;

    @FXML
    private TableColumn<Veiculo, Boolean> tableColumnWifiInfoCompleta;

    @FXML
    private TableView<Veiculo> tableViewInfoCompleta;

    @FXML
    private TableView<Veiculo> tableViewInfoResumo;

    @FXML
    private TextField textFieldPlaca;

    @FXML
    private TextField textFieldAno;

    @FXML
    private TextField textFieldDiaria;

    @FXML
    private TextField textFieldTipoVeiculo;

    @FXML
    private TextField textFieldNumeroPassageirosCarro;

    @FXML
    private TextField textFieldMediaKm;

    @FXML
    private TextField textFieldNumeroPortas;

    @FXML
    private TextField textFieldCargaMaxima;
    
    @FXML
    private TextField textFieldNumeroEixos;

    @FXML
    private TextField textFieldNumeroPassageirosOnibus;

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

    private ListaVeiculos listaVeiculos;

    private final String[] escolhaBooleana = { "Sim", "Não" };

    private final String[] tipoCategorias = { "Leito", "Executivo", "Convencional" };

    private boolean mostrarEsconderInfoVeiculo = true;

    private boolean mostrarEsconderInfoCompleta = true;

    private boolean mostrarEsconderInfoResumo = true;

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
    void hoverBtnInfoFullVeiculo(MouseEvent event) {
        btnInfoFullVeiculo.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnInfoResumoVeiculo(MouseEvent event) {
        btnInfoResumoVeiculo.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnInfoResumoVeiculo(MouseEvent event) {
        btnInfoResumoVeiculo.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnMostrarCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

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

    @FXML
    void notHoverBtnInfoFullVeiculo(MouseEvent event) {
        btnInfoFullVeiculo.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnMostrarCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltar.png"));
    }

    

}
