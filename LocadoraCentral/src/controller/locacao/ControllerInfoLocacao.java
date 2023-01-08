package controller.locacao;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import controller.ControllerMenuLocadora;
import exceptions.cliente.ClienteNotFoundException;
import exceptions.geral.EmptyFieldException;
import exceptions.locacao.DateDifferenceException;
import exceptions.locacao.LocacaoNotFoundException;
import exceptions.veiculo.VeiculoNotFoundException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    *btnPesquisaID variavel privada para mostrar a pesquisa
    */
    @FXML
    private Button btnPesquisaID;

    /*
     * btnPesquisaCPF usado para mostrar a pesquisa por CPF
     */
    @FXML
    private Button btnPesquisaCPF;

    /*
     * btnPesquisaPlaca usado para mostrar a pesquisa por placa
     */
    @FXML
    private Button btnPesquisaPlaca;

    /*
     * btnPesquisaData usado para mostrar a pesquisa por data
     */
    @FXML
    private Button btnPesquisaData;

    /*
     * btnPesquisaPeriodo usado para mostrar a pesquisa por periodo 
     */
    @FXML
    private Button btnPesquisaPeriodo;

    /*
     * btnPesquisarLocacaoID usado para pesquisar uma locacao pelo ID
     */
    @FXML
    private Button btnPesquisarLocacaoID;

    /*
     * btnPesquisarLocacaoCPF usado para pesquisar uma locacao pelo CPF
     */
    @FXML
    private Button btnPesquisarLocacaoCPF;

    /*
     * btnPesquisarLocacaoPlaca usado para pesquisar uma locacao pela placa
     */
    @FXML
    private Button btnPesquisarLocacaoPlaca;

    /*
     * btnPesquisarLocacaoData usado para pesquisar uma locacao pela data
     */
    @FXML
    private Button btnPesquisarLocacaoData;

    /*
     * btnPesquisarLocacaoPeriodo usado para pesquisar uma locacao pelo periodo
     */
    @FXML
    private Button btnPesquisarLocacaoPeriodo;

    /*
     * btnPesquisar usado para pesquisar um cliente pelo CPF
     */
    @FXML
    private Button mostrarPesquisaCPF;

    /*
     * btnMostrarPesquisaPeriodo usado para mostrar/esconder o campo de pesquisa por
     * periodo
     */
    @FXML
    private Button btnMostrarPesquisaPeriodo;

    /*
     * btnMostrarPesquisaData usado para mostrar/esconder o campo de pesquisa por
     * placa
     */
    @FXML
    private Button btnPesquisarPlaca;

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
     * tableColumnDataInicialInfoCompleta usado para mostrar a data inicial da
     * locacao
     */
    @FXML
    private TableColumn<DadosTabela, Calendar> tableColumnDataInicialInfoCompleta;

    /*
     * tableColumnIDInfoCompleta usado para mostrar o ID da locacao
     */
    @FXML
    private TableColumn<DadosTabela, Integer> tableColumnIDInfoCompleta;

    /*
     * variavel privada para mostrar table de pesquisa pelo seguro
     */
    @FXML
    private TableColumn<DadosTabela, Boolean> tableColumnSeguroInfoCompleta;

    /*
     * tableColumnVeiculoInfoCompleta usado para mostrar o veiculo da locacao
     */
    @FXML
    private TableColumn<DadosTabela, String> tableColumnVeiculoInfoCompleta;

    /*
     * tableViewInfoCompleta usado para mostrar as informações completas das
     * locacoes
     */
    @FXML
    private TableView<DadosTabela> tableViewInfoCompleta;

    /*
     * variavel privada para mostrar table de pesquisa pelo cpf
     */
    @FXML
    private TableColumn<DadosTabela, String> tableColumnCPFInfo;

    /*
     * tableColumnDataFinalInfo usado para mostrar a data final da locacao
     */
    @FXML
    private TableColumn<DadosTabela, Calendar> tableColumnDataFinalInfo;

    /*
     * tableColumnDataInicialInfo usado para mostrar a data inicial da locacao
     */
    @FXML
    private TableColumn<DadosTabela, Calendar> tableColumnDataInicialInfo;

    /*
     * tableColumnIDInfo usado para mostrar as locações atraves do id
     */
    @FXML
    private TableColumn<DadosTabela, Integer> tableColumnIDInfo;

    /*
     * variavel privada para mostrar table de pesquisa pelo seguro
     */
    @FXML
    private TableColumn<DadosTabela, Boolean> tableColumnSeguroInfo;

    /*
     * tableColumnVeiculoInfo usado para mostrar o veiculo da locacao
     */
    @FXML
    private TableColumn<DadosTabela, String> tableColumnVeiculoInfo;

    /*
     * tableViewInfo usado para mostrar as informações das locacoes
     */

    @FXML
    private TableView<DadosTabela> tableViewInfoLocacao;

    /*
     * paneInfoLocacao usado para mostrar/esconder as informações das locacoes
     */

    @FXML
    private Pane paneInfoLocacao;

    /*
     * paneInfoCompleta usado para mostrar/esconder as informações completas das
     * locacoes pelo ID
     */

    @FXML
    private Pane paneIDLocacao;

    /*
     * paneInfoCompleta usado para mostrar/esconder as informações completas das
     * locacoes pelo CPF
     */
    

    @FXML
    private Pane paneCPFLocacao;

    /*
     * paneInfoCompleta usado para mostrar/esconder as informações completas das
     * locacoes pela placa
     */

    @FXML
    private Pane panePlacaLocacao;

    /*
     * paneInfoCompleta usado para mostrar/esconder as informações completas das
     * locacoes pela data
     */

    @FXML
    private Pane paneDataLocacao;

    /*
     * paneInfoCompleta usado para mostrar/esconder as informações completas das
     * locacoes pelo periodo
     */

    @FXML
    private Pane panePeriodoLocacao;

    /*
     * paneInfoCompleta usado para mostrar/esconder as informações completas das
     * locacoes pelo ID
     */
    @FXML
    private TextField textFieldIDLocacao;

    /*
     * textFieldIDLocacao usado para mostrar/esconder as informações completas das
     * locacoes pelo cpf
     */
    @FXML
    private TextField textFieldCPFLocacao;

    /*
     * textFieldIDLocacao usado para mostrar/esconder as informações completas das
     */
    @FXML
    private TextField textFieldPlacaLocacao;

    /*
     * textFieldcpf usado para mostrar/esconder as informações completas das
     * locacoes pelo cpf
     */
    @FXML
    private TextField textFieldCPF;

    /*
     * textFieldIDLocacao usado para mostrar/esconder as informações completas das
     */
    @FXML
    private TextField textFieldPlaca;

    /*
     * textFieldIDLocacao usado para mostrar/esconder as informações completas das
     */
    @FXML
    private DatePicker pickerDataInicial;

    /*
     * textFieldIDLocacao usado para mostrar/esconder as informações completas das
     * locacoes pela data final
     */

    @FXML
    private DatePicker pickerDataFinal;

    /*
     * textFieldIDLocacao usado para mostrar/esconder as informações completas das
     * locacoes pelo seguro
     */

    //

    @FXML
    private ChoiceBox<String> choiceSeguro;

    /*
     * textFieldIDLocacao usado para mostrar/esconder as informações completas das
     * locacoes pela data
     */

    @FXML
    private DatePicker datePickerDataLocacao;

    /*
     * textFieldIDLocacao usado para mostrar/esconder as informações completas das
     * locacoes pela data inicial
     */

    @FXML
    private DatePicker datePickerDataInicialLocacao;

    /*
     * textFieldIDLocacao usado para mostrar/esconder as informações completas das
     * locacoes pela data final
     */

    @FXML
    private DatePicker datePickerDataFinalLocacao;

    /*
     * listaClientes usado para armazenar as locacoes
     */
    private ListaLocacoes listaLocacoes;
    
    /*
     * listaClientes usado para armazenar os clientes
     */

    private ListaClientes listaClientes;

    /*
     * listaVeiculos usado para armazenar os veiculos
     */

    private ListaVeiculos listaVeiculos;

    /*
     * mostrarEsconderInfoCompleta usado para mostrar/esconder a tabela com as
     * informações completas das locacoes
     */
    private boolean mostrarEsconderInfoCompleta = true;

    /*
     * mostrarEsconderInfoLocacao usado para mostrar/esconder a tabela com as
     * informações das locacoes
     */

    private boolean mostrarEsconderInfoLocacao = true;

    /*
     * mostrarEsconderInfoLocacaoID usado para mostrar/esconder a tabela com as
     * informações das locacoes pelo ID
     */

    private boolean mostrarEsconderInfoLocacaoID = true;

    /*
     * mostrarEsconderInfoLocacaoCPF usado para mostrar/esconder a tabela com as
     * informações das locacoes pelo CPF
     */

    private boolean mostrarEsconderInfoLocacaoCPF = true;

    /*
     * mostrarEsconderInfoLocacaoPlaca usado para mostrar/esconder a tabela com as
     * informações das locacoes pela placa
     */

    private boolean mostrarEsconderInfoLocacaoPlaca = true;

    /*
     * mostrarEsconderInfoLocacaoData usado para mostrar/esconder a tabela com as
     * informações das locacoes pela data
     */

    private boolean mostrarEsconderInfoLocacaoData = true;

    /*
     * mostrarEsconderInfoLocacaoPeriodo usado para mostrar/esconder a tabela com as
     * informações das locacoes pelo periodo
     */

    private boolean mostrarEsconderInfoLocacaoPeriodo = true;

    /* 
    *
    */
    private final String[] escolhaseguro = { "Sim", "Não" };

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

    /**
        * Método usado para mostrar/esconder a tabela com as informações completas das
        * locacoes
        @param escolhaseguro adicionar seguro pela escolha
        
     */
    
    @FXML
    void initialize() {

        choiceSeguro.getItems().addAll(escolhaseguro);

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

        tableColumnDataFinalInfo.setCellValueFactory(dadosTabela -> {
            Locacao locacao = dadosTabela.getValue().getLocacao();
            return new SimpleObjectProperty<Calendar>(locacao.getDataFinal());
        });
        tableColumnDataFinalInfo.setCellFactory(column -> {
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

        tableColumnDataInicialInfo.setCellValueFactory(dadosTabela -> {
            Locacao locacao = dadosTabela.getValue().getLocacao();
            return new SimpleObjectProperty<Calendar>(locacao.getDataInicial());
        });
        tableColumnDataInicialInfo.setCellFactory(column -> {
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
        tableColumnIDInfo.setCellValueFactory(dadosTabela -> {
            Locacao locacao = dadosTabela.getValue().getLocacao();
            return new SimpleObjectProperty<Integer>(locacao.getCodigo());
        });
        tableColumnSeguroInfo.setCellValueFactory(dadosTabela -> {
            Locacao locacao = dadosTabela.getValue().getLocacao();
            return new SimpleObjectProperty<Boolean>(locacao.getSeguro());
        });

        tableColumnVeiculoInfo.setCellValueFactory(dadosTabela -> {
            Veiculo veiculo = dadosTabela.getValue().getVeiculo();
            return new SimpleObjectProperty<String>(veiculo.getPlaca());
        });
        tableColumnCPFInfo.setCellValueFactory(dadosTabela -> {
            Cliente cliente = dadosTabela.getValue().getCliente();
            return new SimpleObjectProperty<String>(cliente.getCpf());
        });

        listaLocacoes = ControllerMenuLocadora.getListaLocacoes();
        listaClientes = ControllerMenuLocadora.getListaClientes();
        listaVeiculos = ControllerMenuLocadora.getListaVeiculos();
    }

    ////////////////////////////////////// FALTA
    ////////////////////////////////////// ESSE////////////////////////////////

    /**
     * Método que mostra/esconde os campos de pesquisa
     * 
     * @param event evento de mostrar/esconder os campos de pesquisa
     */
    @FXML
    void infoFullLocacao(ActionEvent event) {

        if (tableViewInfoLocacao.isVisible()) {
            tableViewInfoLocacao.setVisible(false);
        }

        if (paneInfoLocacao.isVisible() || paneIDLocacao.isVisible() || paneCPFLocacao.isVisible()
                || panePlacaLocacao.isVisible() || paneDataLocacao.isVisible() || panePeriodoLocacao.isVisible()) {
            paneInfoLocacao.setVisible(false);
            paneIDLocacao.setVisible(false);
            paneCPFLocacao.setVisible(false);
            panePlacaLocacao.setVisible(false);
            paneDataLocacao.setVisible(false);
            panePeriodoLocacao.setVisible(false);

            mostrarEsconderInfoLocacao = true;
            mostrarEsconderInfoLocacaoID = true;
            mostrarEsconderInfoLocacaoCPF = true;
            mostrarEsconderInfoLocacaoPlaca = true;
            mostrarEsconderInfoLocacaoData = true;
            mostrarEsconderInfoLocacaoPeriodo = true;
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
            } catch (NumberFormatException e) {
                alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
            } catch (NullPointerException e) {
                alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
            }
            tableViewInfoCompleta.setItems(observableListLocacoes);
        }
    }

    /**
     * Método para mostrar/esconder os campos de pesquisa
     * 
     * @param event evento de mostrar/esconder os campos de pesquisa
     */
    @FXML
    void mostrarEsconderCampos(ActionEvent event) {

        if (tableViewInfoLocacao.isVisible()) {
            tableViewInfoLocacao.setVisible(false);
        }
        if (tableViewInfoCompleta.isVisible() || paneIDLocacao.isVisible() || paneCPFLocacao.isVisible()
                || panePlacaLocacao.isVisible() || paneDataLocacao.isVisible() || panePeriodoLocacao.isVisible()) {
            tableViewInfoCompleta.setVisible(false);
            paneIDLocacao.setVisible(false);
            paneCPFLocacao.setVisible(false);
            panePlacaLocacao.setVisible(false);
            paneDataLocacao.setVisible(false);
            panePeriodoLocacao.setVisible(false);

            mostrarEsconderInfoCompleta = true;
            mostrarEsconderInfoLocacaoID = true;
            mostrarEsconderInfoLocacaoCPF = true;
            mostrarEsconderInfoLocacaoPlaca = true;
            mostrarEsconderInfoLocacaoData = true;
            mostrarEsconderInfoLocacaoPeriodo = true;
        }

        paneInfoLocacao.setVisible(mostrarEsconderInfoLocacao);
        mostrarEsconderInfoLocacao = !mostrarEsconderInfoLocacao;
    }


    /**
     * Método para mostrar/esconder os campos de pesquisa
     * 
     * @param event evento de mostrar/esconder os campos de pesquisa
     */
    @FXML
    void mostrarPesquisaID(ActionEvent event) {

        if (tableViewInfoLocacao.isVisible()) {
            tableViewInfoLocacao.setVisible(false);
        }

        if (paneCPFLocacao.isVisible() || panePlacaLocacao.isVisible() || paneDataLocacao.isVisible()
                || panePeriodoLocacao.isVisible()) {
            paneCPFLocacao.setVisible(false);
            panePlacaLocacao.setVisible(false);
            paneDataLocacao.setVisible(false);
            panePeriodoLocacao.setVisible(false);

            mostrarEsconderInfoLocacaoCPF = true;
            mostrarEsconderInfoLocacaoPlaca = true;
            mostrarEsconderInfoLocacaoData = true;
            mostrarEsconderInfoLocacaoPeriodo = true;
        }

        paneIDLocacao.setVisible(mostrarEsconderInfoLocacaoID);
        mostrarEsconderInfoLocacaoID = !mostrarEsconderInfoLocacaoID;
    }

    @FXML
    void mostrarPesquisaCPF(ActionEvent event) {

        if (tableViewInfoLocacao.isVisible()) {
            tableViewInfoLocacao.setVisible(false);
        }

        if (paneIDLocacao.isVisible() || panePlacaLocacao.isVisible() || paneDataLocacao.isVisible()
                || panePeriodoLocacao.isVisible()) {
            paneIDLocacao.setVisible(false);
            panePlacaLocacao.setVisible(false);
            paneDataLocacao.setVisible(false);
            panePeriodoLocacao.setVisible(false);

            mostrarEsconderInfoLocacaoID = true;
            mostrarEsconderInfoLocacaoPlaca = true;
            mostrarEsconderInfoLocacaoData = true;
            mostrarEsconderInfoLocacaoPeriodo = true;
        }

        paneCPFLocacao.setVisible(mostrarEsconderInfoLocacaoCPF);
        mostrarEsconderInfoLocacaoCPF = !mostrarEsconderInfoLocacaoCPF;
    }


    /**
     * Método para mostrar/esconder os campos de pesquisa
     * 
     * @param event evento de mostrar/esconder os campos de pesquisa
     */
    @FXML
    void mostrarPesquisaPlaca(ActionEvent event) {

        if (tableViewInfoLocacao.isVisible()) {
            tableViewInfoLocacao.setVisible(false);
        }

        if (paneIDLocacao.isVisible() || paneCPFLocacao.isVisible() || paneDataLocacao.isVisible()
                || panePeriodoLocacao.isVisible()) {
            paneIDLocacao.setVisible(false);
            paneCPFLocacao.setVisible(false);
            paneDataLocacao.setVisible(false);
            panePeriodoLocacao.setVisible(false);

            mostrarEsconderInfoLocacaoID = true;
            mostrarEsconderInfoLocacaoCPF = true;
            mostrarEsconderInfoLocacaoData = true;
            mostrarEsconderInfoLocacaoPeriodo = true;
        }

        panePlacaLocacao.setVisible(mostrarEsconderInfoLocacaoPlaca);
        mostrarEsconderInfoLocacaoPlaca = !mostrarEsconderInfoLocacaoPlaca;
    }


    /**
     * Método para mostrar/esconder os campos de pesquisa
     * 
     * @param event evento de mostrar/esconder os campos de pesquisa
     */
    @FXML
    void mostrarPesquisaData(ActionEvent event) {

        if (tableViewInfoLocacao.isVisible()) {
            tableViewInfoLocacao.setVisible(false);
        }

        if (paneIDLocacao.isVisible() || paneCPFLocacao.isVisible() || panePlacaLocacao.isVisible()
                || panePeriodoLocacao.isVisible()) {
            paneIDLocacao.setVisible(false);
            paneCPFLocacao.setVisible(false);
            panePlacaLocacao.setVisible(false);
            panePeriodoLocacao.setVisible(false);

            mostrarEsconderInfoLocacaoID = true;
            mostrarEsconderInfoLocacaoCPF = true;
            mostrarEsconderInfoLocacaoPlaca = true;
            mostrarEsconderInfoLocacaoPeriodo = true;
        }

        paneDataLocacao.setVisible(mostrarEsconderInfoLocacaoData);
        mostrarEsconderInfoLocacaoData = !mostrarEsconderInfoLocacaoData;
    }


    /**
     * Método para mostrar/esconder os campos de pesquisa
     * 
     * @param event evento de mostrar/esconder os campos de pesquisa
     */
    @FXML
    void mostrarPesquisaPeriodo(ActionEvent event) {

        if (tableViewInfoLocacao.isVisible()) {
            tableViewInfoLocacao.setVisible(false);
        }

        if (paneIDLocacao.isVisible() || paneCPFLocacao.isVisible() || panePlacaLocacao.isVisible()
                || paneDataLocacao.isVisible()) {
            paneIDLocacao.setVisible(false);
            paneCPFLocacao.setVisible(false);
            panePlacaLocacao.setVisible(false);
            paneDataLocacao.setVisible(false);

            mostrarEsconderInfoLocacaoID = true;
            mostrarEsconderInfoLocacaoCPF = true;
            mostrarEsconderInfoLocacaoPlaca = true;
            mostrarEsconderInfoLocacaoData = true;
        }

        panePeriodoLocacao.setVisible(mostrarEsconderInfoLocacaoPeriodo);
        mostrarEsconderInfoLocacaoPeriodo = !mostrarEsconderInfoLocacaoPeriodo;
    }


    /**
     * Método para pesquisar uma locação pelo ID
     * 
     * @param event evento de pesquisa
     */
    @FXML
    void pesquisarLocacaoID(ActionEvent event) {
        String id = textFieldIDLocacao.getText();

        try {
            if (id.isEmpty()) {
                throw new EmptyFieldException("Preencha o campo ID");
            }

            int codigoLocacao = Integer.parseInt(id);

            if (!listaLocacoes.existe(codigoLocacao)) {
                throw new LocacaoNotFoundException("Locação não encontrada");
            }

            Locacao locacao = listaLocacoes.get(codigoLocacao);
            String seguro = locacao.getSeguro() ? "Sim" : "Não";
            String cpf = locacao.getCliente().getCpf();
            String placa = locacao.getVeiculo().getPlaca();

            Calendar dataInicial = locacao.getDataInicial();
            Calendar dataFinal = locacao.getDataFinal();

            Instant instantInicial = dataInicial.toInstant();
            Instant instantFinal = dataFinal.toInstant();

            LocalDate localDateInicial = instantInicial.atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate localDateFinal = instantFinal.atZone(ZoneId.systemDefault()).toLocalDate();

            textFieldCPF.setText(cpf);
            textFieldPlaca.setText(placa);
            pickerDataInicial.setValue(localDateInicial);
            pickerDataFinal.setValue(localDateFinal);
            choiceSeguro.setValue(seguro);

        } catch (NumberFormatException e) {
            alertInterface("ERRO", "Preencha o campo corretamente!", AlertType.ERROR);
        } catch (EmptyFieldException | LocacaoNotFoundException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }
    }

    /**
     * Método para pesquisar uma locação pelo CPF
     * 
     * @param event evento de pesquisa
     */
    @FXML
    void pesquisarLocacaoCPF(ActionEvent event) {

        String cpf = textFieldCPFLocacao.getText();

        ObservableList<DadosTabela> observableListLocacoes = FXCollections.observableArrayList();

        Cliente cliente;

        try {

            long cpfLong = Long.parseLong(cpf);

            if (cpf.isEmpty()) {
                throw new EmptyFieldException("Preencha o campo CPF");
            }

            if (!listaClientes.existe(cpfLong)) {
                throw new ClienteNotFoundException("Cliente não encontrado");
            }

            cliente = listaClientes.get(cpfLong);

            String[] dadosLocacoes = listaLocacoes.getLocacoesByCliente(cliente).split("\n");

            for (String dados : dadosLocacoes) {
                String[] campos = dados.split(";");
                int codigoLocacao = Integer.parseInt(campos[0].split(": ")[1]);

                Locacao locacao = listaLocacoes.get(codigoLocacao);
                DadosTabela dadosTabela = new DadosTabela(locacao, locacao.getVeiculo(), locacao.getCliente());
                observableListLocacoes.add(dadosTabela);
            }
            tableViewInfoLocacao.setVisible(true);
            tableViewInfoLocacao.setItems(observableListLocacoes);

            paneCPFLocacao.setVisible(false);
            mostrarEsconderInfoLocacaoCPF = true;
        } catch (NumberFormatException e) {
            alertInterface("ERRO", "Preencha o campo corretamente!", AlertType.ERROR);
        } catch (EmptyFieldException | ClienteNotFoundException | LocacaoNotFoundException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }
    }


    /**
     * Método para pesquisar uma locação pela placa
     * 
     * @param event evento de pesquisa
     */
    @FXML
    void pesquisarLocacaoPlaca(ActionEvent event) {

        String placa = textFieldPlacaLocacao.getText();

        ObservableList<DadosTabela> observableListLocacoes = FXCollections.observableArrayList();

        Veiculo veiculo;

        try {
            if (placa.isEmpty()) {
                throw new EmptyFieldException("Preencha o campo placa");
            }

            if (!listaVeiculos.existe(placa)) {
                throw new VeiculoNotFoundException("Veiculo não encontrado");
            }

            veiculo = listaVeiculos.get(placa);

            String[] dadosLocacoes = listaLocacoes.getLocacoesByVeiculo(veiculo).split("\n");

            for (String dados : dadosLocacoes) {
                String[] campos = dados.split(";");
                int codigoLocacao = Integer.parseInt(campos[0].split(": ")[1]);

                Locacao locacao = listaLocacoes.get(codigoLocacao);
                DadosTabela dadosTabela = new DadosTabela(locacao, locacao.getVeiculo(), locacao.getCliente());
                observableListLocacoes.add(dadosTabela);
            }
            tableViewInfoLocacao.setVisible(true);
            tableViewInfoLocacao.setItems(observableListLocacoes);

            panePlacaLocacao.setVisible(false);
            mostrarEsconderInfoLocacaoPlaca = true;
        } catch (NumberFormatException e) {
            alertInterface("ERRO", "Preencha o campo corretamente!", AlertType.ERROR);
        } catch (EmptyFieldException | VeiculoNotFoundException | LocacaoNotFoundException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }

    }


    /**
     * Método para pesquisar uma locação pela data
     * 
     * @param event evento de pesquisa
     */
    @FXML
    void pesquisarLocacaoData(ActionEvent event) {

        ObservableList<DadosTabela> observableListLocacoes = FXCollections.observableArrayList();
        try {

            if (datePickerDataLocacao.getValue() == null) {
                throw new EmptyFieldException("Selecione uma data!");
            }

            LocalDate data = datePickerDataLocacao.getValue();
            Date date = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());

            Calendar dataCalendar = Calendar.getInstance();
            dataCalendar.setTime(date);

            String[] dadosLocacoes = listaLocacoes.getLocacoesByDiaMesAno(dataCalendar).split("\n");

            for (String dados : dadosLocacoes) {
                String[] campos = dados.split(";");
                int codigoLocacao = Integer.parseInt(campos[0].split(": ")[1]);

                Locacao locacao = listaLocacoes.get(codigoLocacao);
                DadosTabela dadosTabela = new DadosTabela(locacao, locacao.getVeiculo(), locacao.getCliente());
                observableListLocacoes.add(dadosTabela);
            }
            paneDataLocacao.setVisible(false);
            mostrarEsconderInfoLocacaoData = true;

            tableViewInfoLocacao.setVisible(true);
            tableViewInfoLocacao.setItems(observableListLocacoes);
        } catch (NumberFormatException e) {
            alertInterface("ERRO", "Preencha o campo corretamente!", AlertType.ERROR);
        } catch (EmptyFieldException | LocacaoNotFoundException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }
    }


    /**
     * Método para pesquisar uma locação por um período
     * 
     * @param event evento de pesquisa
     */
    @FXML
    void pesquisarLocacaoPeriodo(ActionEvent event) {
        ObservableList<DadosTabela> observableListLocacoes = FXCollections.observableArrayList();
        try {

            if (datePickerDataInicialLocacao.getValue() == null) {
                throw new EmptyFieldException("Selecione a data inicial!");
            }

            if (datePickerDataFinalLocacao.getValue() == null) {
                throw new EmptyFieldException("Selecione a data final!");
            }

            LocalDate dataInicial = datePickerDataInicialLocacao.getValue();
            Date dateInicial = Date.from(dataInicial.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Calendar dataInicialCalendar = Calendar.getInstance();
            dataInicialCalendar.setTime(dateInicial);

            LocalDate dataFinal = datePickerDataFinalLocacao.getValue();
            Date dateFinal = Date.from(dataFinal.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Calendar dataFinalCalendar = Calendar.getInstance();
            dataFinalCalendar.setTime(dateFinal);

            if (dataInicialCalendar.after(dataFinalCalendar)) {
                throw new DateDifferenceException("Data inicial maior que a data final!");
            }

            String[] dadosLocacoes = listaLocacoes.getLocacoesByPeriodo(dataInicialCalendar, dataFinalCalendar)
                    .split("\n");

            for (String dados : dadosLocacoes) {
                String[] campos = dados.split(";");
                int codigoLocacao = Integer.parseInt(campos[0].split(": ")[1]);

                Locacao locacao = listaLocacoes.get(codigoLocacao);
                DadosTabela dadosTabela = new DadosTabela(locacao, locacao.getVeiculo(), locacao.getCliente());
                observableListLocacoes.add(dadosTabela);
            }
            panePeriodoLocacao.setVisible(false);
            mostrarEsconderInfoLocacaoPeriodo = true;

            tableViewInfoLocacao.setVisible(true);
            tableViewInfoLocacao.setItems(observableListLocacoes);
        } catch (NumberFormatException e) {
            alertInterface("ERRO", "Preencha o campo corretamente!", AlertType.ERROR);
        } catch (EmptyFieldException | LocacaoNotFoundException | DateDifferenceException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }
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
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de uma locacao por ID
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnPesquisarLocacaoID(MouseEvent event) {
        btnPesquisarLocacaoID.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de uma locacao por CPF
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnPesquisarLocacaoCPF(MouseEvent event) {
        btnPesquisarLocacaoCPF.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de uma locacao por placa
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnPesquisarLocacaoPlaca(MouseEvent event) {
        btnPesquisarLocacaoPlaca.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de uma locacao por data
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnPesquisarLocacaoData(MouseEvent event) {
        btnPesquisarLocacaoData.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de uma locacao por periodo
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnPesquisarLocacaoPeriodo(MouseEvent event) {
        btnPesquisarLocacaoPeriodo
                .setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de uma locacao por periodo
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }


    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de uma locacao por periodo
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnMostrarEsconderCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de uma locacao por periodo
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnMostrarPesquisaID(MouseEvent event) {
        btnPesquisaID.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");

    }


    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de uma locacao por periodo
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnMostrarPesquisaCPF(MouseEvent event) {
        btnPesquisaCPF.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");

    }


    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de uma locacao por periodo
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnMostrarPesquisaPlaca(MouseEvent event) {
        btnPesquisaPlaca.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");

    }


    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de uma locacao por periodo
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnMostrarPesquisaData(MouseEvent event) {
        btnPesquisaData
                .setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de uma locacao por periodo
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnMostrarPesquisaPeriodo(MouseEvent event) {
        btnPesquisaPeriodo.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
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
     * Efeito de hover ao tirar o mouse no botão de mostrar/esconder os campos de
     * pesquisa
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */

    /**
     * Esse aqui de baixo acho que pode tirar era como estava o nome antigo depois
     * que eu mudei "btnMostrarEsconderCampos"
     */
    @FXML
    void notHoverBtnMostrarCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
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
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todas as locacoes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnMostrarEsconderCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todas as locacoes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnMostrarPesquisaID(MouseEvent event) {
        btnPesquisaID.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todas as locacoes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnMostrarPesquisaCPF(MouseEvent event) {
        btnPesquisaCPF.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todas as locacoes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnMostrarPesquisaPlaca(MouseEvent event) {
        btnPesquisaPlaca.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todas as locacoes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnMostrarPesquisaData(MouseEvent event) {
        btnPesquisaData.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todas as locacoes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnMostrarPesquisaPeriodo(MouseEvent event) {
        btnPesquisaPeriodo.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todas as locacoes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnPesquisarLocacaoID(MouseEvent event) {
        btnPesquisarLocacaoID.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");

    }


    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todas as locacoes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnPesquisarLocacaoCPF(MouseEvent event) {
        btnPesquisarLocacaoCPF.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");

    }


    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todas as locacoes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnPesquisarLocacaoPlaca(MouseEvent event) {
        btnPesquisarLocacaoPlaca.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }


    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todas as locacoes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnPesquisarLocacaoData(MouseEvent event) {
        btnPesquisarLocacaoData.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");

    }


    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todas as locacoes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnPesquisarLocacaoPeriodo(MouseEvent event) {
        btnPesquisarLocacaoPeriodo
                .setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

}
