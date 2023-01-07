package controller.locacao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import controller.ControllerMenuLocadora;
import exceptions.cliente.CPFNotFoundException;
import exceptions.cliente.InvalidCPFException;
import exceptions.geral.EmptyFieldException;
import exceptions.locacao.DateDifferenceException;
import exceptions.locacao.IDNotFoundException;
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
    private final String[] escolhaseguro = { "Sim", "Não"};

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
    private int IDAlterar;

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
     * locacao usado para receber a locacao a ser alterada
     */
    private Locacao locacao;

     /**
     * Método usado para inicializar a lista de locacoes a partir do menu principal
     */
    void initialize() {
        listaLocacao = ControllerMenuLocadora.getListaLocacoes();
    }

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
        }
    }

    /**
     * Método usado para pesquisar uma locacao usando o id, na lista de locacoes
     * 
     * @param event evento de clicar no botão
     */
    @FXML
    void pesquisarLocacao(ActionEvent event) {
        IDAlterar = textFieldID.getText().isEmpty() ? 0 : Integer.parseInt(textFieldID.getText());

        try {
            if (textFieldID.getText().isEmpty()) {
                throw new EmptyFieldException("Campo ID vazio!");
            }

            if (!listaLocacao.existe((IDAlterar))) {
                throw new IDNotFoundException("ID não encontrado!");
            }

        } catch (EmptyFieldException | IDNotFoundException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }
    }

    /**
     * Método usado para alterar as informações placa, cpf, seguro, datainicial, datafinal de uma locacao 
     * 
     * @param event evento de clicar no botão
     */
    @FXML
    void alterarLocacao(ActionEvent event) {
        
        try {
            if (textFieldPlaca.getText().isEmpty() || textFieldCPF.getText().isEmpty() || choiceSeguro.getValue() == null
                    || pickerDataInicial.getValue() == null || pickerDataFinal.getValue() == null) {
            throw new EmptyFieldException("Preencha todos os campos!");
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
            System.out.println("\nConversion of LocalDate to java.util.Calendar is :- \n"
                + dataInicialC.get(Calendar.DAY_OF_MONTH) + dataInicialC.get(Calendar.MONTH) + dataInicialC.get(Calendar.YEAR));

            Calendar dataFinalC = Calendar.getInstance();
            dataFinalC.setTime(date2);
            System.out.println("\nConversion of LocalDate to java.util.Calendar is :- \n"
                + dataFinalC.get(Calendar.DAY_OF_MONTH) + dataFinalC.get(Calendar.MONTH) + dataFinalC.get(Calendar.YEAR));

            
            String placa = textFieldPlaca.getText();
            String cpf = textFieldCPF.getText();
            String escolhaseguro = choiceSeguro.getValue();
            Long cpfLong;

            boolean seguroBoolean = false;
            int codigoFinal = locacao.getCodigo();
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
                throw new CPFNotFoundException("CPF não encontrado!");
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
        } catch (InvalidCPFException | CPFNotFoundException | EmptyFieldException | DateDifferenceException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }
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
     * Efeito de hover ao passar o mouse no botão de limpar
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de voltar
     * 
     * @param event evento hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/locacao/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

    /**
     * Método para limpar os campos de texto presentes na tela
     * 
     * @param event evento de limpar os campos de texto presentes na tela
     */
    @FXML
    void limparCampos(MouseEvent event) {
        textFieldCPF.clear();
        textFieldPlaca.clear();
        rootPane.requestFocus();
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
     * Efeito de hover ao tirar o mouse do botão de voltar
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/locacao/pngVoltar.png"));
    }

    /**
     * Efeito de hover ao passar o mouse no botão de pesquisar
     * 
     * @param event evento hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse do botão de procurar
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
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
