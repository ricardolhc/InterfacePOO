package controller.locacao;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import controller.ControllerMenuLocadora;
import exceptions.cliente.ClienteNotFoundException;
import exceptions.cliente.InvalidCPFException;
import exceptions.geral.EmptyFieldException;
import exceptions.locacao.DateDifferenceException;
import exceptions.locacao.IDNotFoundException;
import exceptions.locacao.LocacaoNotFoundException;
import exceptions.locacao.LocacaoSwitchedException;
import exceptions.veiculo.VeiculoNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
 * Classe responsável por controlar a tela de alteração de locacoes
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ControllerAlteraLocacao {

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
     * btnPesquisar usado para pesquisar um cliente na lista de clientes
     */
    @FXML
    private Button btnPesquisar;

    /**
     * btnVoltar usado para voltar para a tela principal
     */
    @FXML
    private ImageView btnVoltar;

    /**
     * choiceSeguro usado para escolher se a locacao terá seguro ou não
     */
    @FXML
    private ChoiceBox<String> choiceSeguro;

    /**
     * escolhaseguro string com as opções de seguro
     */
    private final String[] escolhaseguro = { "Sim", "Não" };

    /**
     * pickerDataFinal usado para escolher a data final da locacao
     */
    @FXML
    private DatePicker pickerDataFinal;

    /**
     * pickerDataInicial usado para escolher a data inicial da locacao
     */
    @FXML
    private DatePicker pickerDataInicial;

    /**
     * rootPane usado para carregar a tela de adicionar locacao
     */
    @FXML
    private AnchorPane rootPane;

    /**
     * textFieldCPF usado para receber o cpf do cliente
     */
    @FXML
    private TextField textFieldCPF;

    /**
     * textFieldID usado para receber o id da locacao
     */
    @FXML
    private TextField textFieldID;

    /**
     * textFieldPlaca usado para receber a placa do veiculo
     */
    @FXML
    private TextField textFieldPlaca;

    /**
     * IDAlterar usado para receber o id da locacao a ser alterada
     */
    private String IDAlterar;

    /**
     * listaLocacao usado para receber a lista de locacoes
     */
    private ListaLocacoes listaLocacao;

    /**
     * listaVeiculo usado para receber a lista de veiculos
     */
    private ListaVeiculos listaVeiculo;

    /**
     * listaClientes usado para receber a lista de clientes
     */
    private ListaClientes listaClientes;

    /**
     * Método usado para inicializar a lista de locacoes a partir do menu principal
     */
    @FXML
    void initialize() {
        choiceSeguro.getItems().addAll(escolhaseguro);

        listaLocacao = ControllerMenuLocadora.getListaLocacoes();
        listaClientes = ControllerMenuLocadora.getListaClientes();
        listaVeiculo = ControllerMenuLocadora.getListaVeiculos();
    }

    /**
     * Método usado para voltar ao menu principal
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
     * Método usado para pesquisar uma locacao usando o id, na lista de locacoes
     * @param event evento de clicar no botão
     */
    @FXML
    void pesquisarLocacao(ActionEvent event) {
        IDAlterar = textFieldID.getText();

        try {
            int idInt = Integer.parseInt(IDAlterar);

            if (IDAlterar.isEmpty()) {
                throw new EmptyFieldException("Campo ID vazio!");
            }

            if (!listaLocacao.existe((idInt))) {
                throw new IDNotFoundException("ID não encontrado!");
            } else {
                Locacao locacao = listaLocacao.get(idInt);

                String seguro = locacao.getSeguro() ? "Sim" : "Não";

                Calendar dataInicial = locacao.getDataInicial();
                Calendar dataFinal = locacao.getDataFinal();

                Instant instantInicial = dataInicial.toInstant();
                Instant instantFinal = dataFinal.toInstant();

                LocalDate localDateInicial = instantInicial.atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate localDateFinal = instantFinal.atZone(ZoneId.systemDefault()).toLocalDate();

                textFieldPlaca.setText(locacao.getVeiculo().getPlaca());
                textFieldCPF.setText(locacao.getCliente().getCpf());
                choiceSeguro.setValue(seguro);
                pickerDataInicial.setValue(localDateInicial);
                pickerDataFinal.setValue(localDateFinal);
            }
        } catch (NumberFormatException e) {
            alertInterface("ERRO", "ID inválido!", AlertType.ERROR);
        } catch (EmptyFieldException | IDNotFoundException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }
    }

    /**
     * Método usado para alterar as informações placa, cpf, seguro, datainicial,
     * datafinal de uma locacao
     * @param event evento de clicar no botão
     */
    @FXML
    void alterarLocacao(ActionEvent event) {

        String locacaoFinal = textFieldID.getText();
        String placa = textFieldPlaca.getText();
        String cpf = textFieldCPF.getText();

        try {
            long cpfLong = Long.parseLong(cpf);

            if (locacaoFinal.isEmpty() || placa.isEmpty() || cpf.isEmpty()
                    || choiceSeguro.getValue() == null
                    || pickerDataInicial.getValue() == null || pickerDataFinal.getValue() == null) {
                throw new EmptyFieldException("Preencha todos os campos!");
            }

            if (!locacaoFinal.equals(IDAlterar)) {
                throw new LocacaoSwitchedException("Pesquise o ID alterado antes de alterar!");
            }
            if (pickerDataInicial.getValue().isAfter(pickerDataFinal.getValue())) {
                throw new DateDifferenceException("Data final deve ser maior que a data inicial!");
            }

            LocalDate dataInicial = pickerDataInicial.getValue();
            LocalDate dataFinal = pickerDataFinal.getValue();

            Date date = Date.from(dataInicial.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date date2 = Date.from(dataFinal.atStartOfDay(ZoneId.systemDefault()).toInstant());

            Calendar dataInicialC = Calendar.getInstance();
            dataInicialC.setTime(date);

            Calendar dataFinalC = Calendar.getInstance();
            dataFinalC.setTime(date2);

            String escolhaseguro = choiceSeguro.getValue();

            boolean seguroBoolean = false;
            int codigoFinal = Integer.parseInt(locacaoFinal);
            cpfLong = Long.parseLong(cpf);

            if (escolhaseguro.equals("Sim")) {
                seguroBoolean = true;
            } else {
                seguroBoolean = false;
            }

            if (cpf.length() != 11) {
                throw new InvalidCPFException("CPF inválido!");
            }

            if (!listaClientes.existe(cpfLong)) {
                throw new ClienteNotFoundException("CPF não encontrado!");
            } else {

                if (!listaVeiculo.existe(placa)) {
                    throw new VeiculoNotFoundException("Placa não encontrada!");
                } else {

                    /* alterar locacao */
                    Locacao locacao = listaLocacao.get(codigoFinal);
                    Cliente Cliente = listaClientes.get(cpfLong);
                    Veiculo Veiculo = listaVeiculo.get(placa);

                    locacao.setSeguro(seguroBoolean);
                    locacao.setDataInicial(dataInicialC);
                    locacao.setDataFinal(dataFinalC);
                    locacao.setCliente(Cliente);
                    locacao.setVeiculo(Veiculo);

                    limparCampos(null);

                    alertInterface("SUCESSO", "Locação alterada com sucesso!", AlertType.INFORMATION);
                }
            }

        } catch (NumberFormatException e) {
            alertInterface("ERRO", "Preencha os campos corretamente!", AlertType.ERROR);
        } catch (InvalidCPFException | ClienteNotFoundException | VeiculoNotFoundException | EmptyFieldException | DateDifferenceException | LocacaoNotFoundException | LocacaoSwitchedException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }
    }

    /**
     * Método para imprimir um alerta na tela
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
     * Método para limpar os campos de texto presentes na tela
     * @param event evento de limpar os campos de texto presentes na tela
     */
    @FXML
    void limparCampos(MouseEvent event) {
        textFieldID.clear();
        textFieldCPF.clear();
        textFieldPlaca.clear();
        rootPane.requestFocus();
    }

    /**
     * Efeito de hover ao passar o mouse no botão de alterar
     * @param event evento hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnAlterar(MouseEvent event) {
        btnAlterar.setStyle("-fx-background-color: #676508;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de limpar
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de voltar
     * @param event evento hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/locacao/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao tirar o mouse do botão de alterar
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnAlterar(MouseEvent event) {
        btnAlterar.setStyle("-fx-background-color: #807d0a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse do botão de limpar
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse do botão de voltar
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/locacao/pngVoltar.png"));
    }

    /**
     * Efeito de hover ao passar o mouse no botão de pesquisar
     * @param event evento hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse do botão de procurar
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    
}
