package controller.locacao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import controller.ControllerMenuLocadora;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lista.Cliente;
import lista.ListaLocacoes;

import lista.Locacao;
import veiculo.Veiculo;

public class ControllerInfoLocacao {

    @FXML
    private Button btnInfoFullLocacao;

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
    private TableColumn<DadosTabela, String> tableColumnCPFInfoCompleta;

    @FXML
    private TableColumn<DadosTabela, Calendar> tableColumnDataFinalInfoCompleta;

    @FXML
    private TableColumn<DadosTabela, Calendar> tableColumnDataInicialInfoCompleta;

    @FXML
    private TableColumn<DadosTabela, Integer> tableColumnIDInfoCompleta;

    @FXML
    private TableColumn<DadosTabela, Boolean> tableColumnSeguroInfoCompleta;

    @FXML
    private TableColumn<DadosTabela, String> tableColumnVeiculoInfoCompleta;

    @FXML
    private TableView<DadosTabela> tableViewInfoCompleta;

    private ListaLocacoes listaLocacoes;

    private boolean mostrarEsconderInfoCompleta = true;

    @FXML
    void initialize() {
        
        tableColumnDataFinalInfoCompleta.setCellValueFactory(dadosTabela -> {
            Locacao locacao = dadosTabela.getValue().getLocacao();
            return new SimpleObjectProperty<Calendar>(locacao.getDataFinal());
        });
        tableColumnDataFinalInfoCompleta.setCellFactory(column -> {
            return new TableCell<DadosTabela, Calendar>() {
                private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
                @Override
                protected void updateItem(Calendar item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(sdf.format(item.getTime()));
                    }
                }
            };
        });

        tableColumnDataInicialInfoCompleta.setCellValueFactory(dadosTabela -> {
            Locacao locacao = dadosTabela.getValue().getLocacao();
            return new SimpleObjectProperty<Calendar>(locacao.getDataInicial());
        });
        tableColumnDataInicialInfoCompleta.setCellFactory(column -> {
            return new TableCell<DadosTabela, Calendar>() {
                private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
                @Override
                protected void updateItem(Calendar item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(sdf.format(item.getTime()));
                    }
                }
            };
        });
        tableColumnIDInfoCompleta.setCellValueFactory(dadosTabela -> {
            Locacao locacao = dadosTabela.getValue().getLocacao();
            return new SimpleObjectProperty<Integer>(locacao.getCodigo());
        });
        tableColumnSeguroInfoCompleta.setCellValueFactory(dadosTabela -> {
            Locacao locacao = dadosTabela.getValue().getLocacao();
            return new SimpleObjectProperty<Boolean>(locacao.getSeguro());
        });

        tableColumnVeiculoInfoCompleta.setCellValueFactory(dadosTabela -> {
            Veiculo veiculo = dadosTabela.getValue().getVeiculo();
            return new SimpleObjectProperty<String>(veiculo.getPlaca());
        });
        tableColumnCPFInfoCompleta.setCellValueFactory(dadosTabela -> {
            Cliente cliente = dadosTabela.getValue().getCliente();
            return new SimpleObjectProperty<String>(cliente.getCpf());
        });

        listaLocacoes = ControllerMenuLocadora.getListaLocacoes();
    }

    @FXML
    void hoverBtnInfoFullLocacao(MouseEvent event) {
        btnInfoFullLocacao.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnLimpar(MouseEvent event) {

    }

    @FXML
    void hoverBtnMostrarCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    @FXML
    void hoverBtnPesquisar(MouseEvent event) {

    }

    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void infoFullLocacao(ActionEvent event) {

        if (tableViewInfoCompleta.isVisible()) {

            tableViewInfoCompleta.setVisible(true);
        }

        tableViewInfoCompleta.setVisible(mostrarEsconderInfoCompleta);


        if (tableViewInfoCompleta.isVisible()) {
            try {
                ObservableList<DadosTabela> observableListLocacoes; 

                String[] dadosLocacoes = listaLocacoes.getInfo().split("\n");

                ArrayList<DadosTabela> listaDadosTabela = new ArrayList<>();

                for (String dadosLocacao : dadosLocacoes) {
                    String[] dados = dadosLocacao.split(";");
                    String codigoLocacao = dados[0].split(": ")[1];

                    Locacao locacao = listaLocacoes.get(Integer.parseInt(codigoLocacao));
                    DadosTabela dadosTabela = new DadosTabela(locacao, locacao.getVeiculo(), locacao.getCliente());
                    
                    listaDadosTabela.add(dadosTabela);
                }
                observableListLocacoes = FXCollections.observableArrayList(listaDadosTabela);
                tableViewInfoCompleta.setItems(observableListLocacoes);
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
    void infoLocacao(ActionEvent event) {

    }

    @FXML
    void limparCampos(MouseEvent event) {

    }

    @FXML
    void mostrarEsconderCampos(ActionEvent event) {

    }

    @FXML
    void notHoverBtnInfoFullLocacao(MouseEvent event) {
        btnInfoFullLocacao.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
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

    }

    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltar.png"));
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

}
