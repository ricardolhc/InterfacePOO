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

import veiculo.Categoria;
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
    private ImageView btnVoltar;

    @FXML
    private Label labelCPF;

    @FXML
    private Label labelCarteiraMotorista;

    @FXML
    private Label labelEndereco;

    @FXML
    private Label labelNome;

    @FXML
    private Label labelTelefone;

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
    private TextField textFieldCPF;

    @FXML
    private TextField textFieldCarteiraMotorista;

    @FXML
    private TextField textFieldEndereco;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldTelefone;

    private ListaVeiculos listaVeiculos;

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

    }

    @FXML
    void infoFullVeiculo(ActionEvent event) {
        
        if(tableViewInfoCompleta.isVisible()) {
            try {
                ObservableList<Veiculo> observableListVeiculos;
                ArrayList<Veiculo> listaVeiculosTable = new ArrayList<Veiculo>();
                
                String[] dadosVeiculos = listaVeiculos.getInfo().split("\n");
                for (String dadosVeiculo : dadosVeiculos) {

                    System.out.println(dadosVeiculo);
                    
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
    }

    @FXML
    void infoResumoVeiculo(ActionEvent event) {

    }

    /*@FXML
    void limparCampos(MouseEvent event) {
        textFieldCPF.clear();
        textFieldNome.clear();
        textFieldEndereco.clear();
        textFieldTelefone.clear();
        textFieldCarteiraMotorista.clear();
        rootPane.requestFocus();
    }*/

    @FXML
    void mostrarEsconderCampos(ActionEvent event) {

    }

    @FXML
    void notHoverBtnInfoFullVeiculo(MouseEvent event) {
        btnInfoFullVeiculo.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    @FXML
    void notHoverBtnLimpar(MouseEvent event) {

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
