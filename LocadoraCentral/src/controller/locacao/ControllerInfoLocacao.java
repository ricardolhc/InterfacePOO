package controller.locacao;

import java.text.SimpleDateFormat;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lista.Cliente;
import lista.ListaLocacoes;

import lista.Locacao;
import veiculo.Veiculo;

/**
 * Classe responsável por controlar a tela de visualização de informações de
 * locacoes
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ControllerInfoLocacao {

    /*
     * btnInfoFullLocacao usado para mostrar informações completas das locacoes
     */
    @FXML
    private Button btnInfoFullLocacao;

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

    /*
     * btnVoltar usado para voltar para a tela principal
     */
    @FXML
    private ImageView btnVoltar;

    /*
     * rootPane usado para mostrar a tela de informações de clientes
     */
    @FXML
    private AnchorPane rootPane;

    /*
     * tableColumnCPFInfoCompleta usado para mostrar o CPF do cliente da locacao
     */
    @FXML
    private TableColumn<DadosTabela, String> tableColumnCPFInfoCompleta;

    /*
     * tableColumnDataFinalInfoCompleta usado para mostrar a data final da locacao
     */
    @FXML
    private TableColumn<DadosTabela, Calendar> tableColumnDataFinalInfoCompleta;

    /*
     * tableColumnDataInicialInfoCompleta usado para mostrar a data inicial da locacao
     */
    @FXML
    private TableColumn<DadosTabela, Calendar> tableColumnDataInicialInfoCompleta;

    /*
     * tableColumnIDInfoCompleta usado para mostrar o ID da locacao
     */
    @FXML
    private TableColumn<DadosTabela, Integer> tableColumnIDInfoCompleta;

    /*
     * tableColumnNomeInfoCompleta usado para mostrar o nome do cliente da locacao
     */
    @FXML
    private TableColumn<DadosTabela, Boolean> tableColumnSeguroInfoCompleta;

    /*
     * tableColumnVeiculoInfoCompleta usado para mostrar o veiculo da locacao
     */
    @FXML
    private TableColumn<DadosTabela, String> tableColumnVeiculoInfoCompleta;

    /*
     * tableViewInfoCompleta usado para mostrar as informações completas das locacoes
     */
    @FXML
    private TableView<DadosTabela> tableViewInfoCompleta;

    /*
     * listaClientes usado para armazenar as locacoes
     */
    private ListaLocacoes listaLocacoes;

    /*
     * mostrarEsconderInfoCompleta usado para mostrar/esconder a tabela com as
     * informações completas das locacoes
     */
    private boolean mostrarEsconderInfoCompleta = true;

    /**
     * Método usado para voltar ao menu principal
     * 
     * @param event evento de clicar no botão de voltar
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

    /*
     * Método usado para inicializar as colunas das tabelas de informações 
     * das locacoes e também para inicializar a lista de locacoes
     */
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

    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de todas as locacoes
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnInfoFullLocacao(MouseEvent event) {
        btnInfoFullLocacao.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de limpar os campos de texto
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnLimpar(MouseEvent event) {

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

    }

    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

    //////////////////////////////////////FALTA ESSE////////////////////////////////
    @FXML
    void infoFullLocacao(ActionEvent event) {

        if (tableViewInfoCompleta.isVisible()) {



        
        }

        tableViewInfoCompleta.setVisible(mostrarEsconderInfoCompleta);
        mostrarEsconderInfoCompleta = !mostrarEsconderInfoCompleta;

        if (tableViewInfoCompleta.isVisible()) {
            ObservableList<DadosTabela> observableListLocacoes = FXCollections.observableArrayList();

            try {
                String[] dadosLocacoes = listaLocacoes.getInfo().split("\n");

                for (String dados : dadosLocacoes) {
                    String[] campos = dados.split(";");
                    int codigoLocacao = Integer.parseInt(campos[0].split(": ")[1]);

                    Locacao locacao = listaLocacoes.get(codigoLocacao);
                    DadosTabela dadosTabela = new DadosTabela(locacao, locacao.getVeiculo(), locacao.getCliente());
                    observableListLocacoes.add(dadosTabela);
                }
            } catch (NullPointerException e) {
                System.out.println(e.getLocalizedMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
            tableViewInfoCompleta.setItems(observableListLocacoes);
        }
    }

    //////////////////////////////////////FALTA ESSE////////////////////////////////
    @FXML
    void infoLocacao(ActionEvent event) {

    }

    /**
     * Método para limpar os campos de texto presentes na tela
     * 
     * @param event evento de limpar os campos de texto presentes na tela
     */
    @FXML
    void limparCampos(MouseEvent event) {

    }

    /**
     * Método para mostrar/esconder os campos de pesquisa
     * 
     * @param event evento de mostrar/esconder os campos de pesquisa
     */
    @FXML
    void mostrarEsconderCampos(ActionEvent event) {

    }

    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todas as locacoes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnInfoFullLocacao(MouseEvent event) {
        btnInfoFullLocacao.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de limpar os campos de texto
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnLimpar(MouseEvent event) {

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
     * Método para imprimir um alerta na tela
     * @param titulo titulo do alerta
     * @param mensagem mensagem do alerta
     * @param tipo tipo do alerta
     */
    void alertInterface(String titulo, String mensagem, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

}
