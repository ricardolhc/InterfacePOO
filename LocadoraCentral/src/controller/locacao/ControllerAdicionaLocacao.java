package controller.locacao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import controller.ControllerMenuLocadora;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lista.ListaVeiculos;
import lista.Locacao;
import veiculo.Veiculo;
import lista.Cliente;
import lista.ListaClientes;
import lista.ListaLocacoes;

/**
 * A classe ControllerAdicionaLocacao é responsável por controlar a tela de adicionar locacao
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ControllerAdicionaLocacao {

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
     * choiceSeguro usado para escolher se a locacao terá seguro ou não
     */
    @FXML
    private ChoiceBox<String> choiceSeguro;

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
     * textFieldPlaca usado para receber a placa do veiculo
     */
    @FXML
    private TextField textFieldPlaca;

    /**
     * escolhaseguro string com as opções de seguro
     */
    private final String[] escolhaseguro = { "Sim", "Não" };

    /**
     * listaClientes usado para receber a lista de veiculos
     */
    private ListaVeiculos listaVeiculos;

    /**
     * listaClientes usado para receber a lista de clientes
     */
    private ListaClientes listaClientes;

    /**
     * listaClientes usado para receber a lista de locacoes
     */
    private ListaLocacoes listaLocacoes;

    /**
     * Método usado para inicializar a lista de locacoes, veiculos e clientes a partir do menu principal
     * e também para adicionar as opções de seguro no choicebox
     */
    @FXML
    void initialize() {
        choiceSeguro.getItems().addAll(escolhaseguro);

        listaLocacoes = ControllerMenuLocadora.getListaLocacoes();
        listaVeiculos = ControllerMenuLocadora.getListaVeiculos();
        listaClientes = ControllerMenuLocadora.getListaClientes();
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
     * Método usado para adicionar uma locacao a partir da placa, cpf, seguro, datainicial, datafinal
     * @param event evento de clicar no botão
     */
    @FXML
    void adicionarLocacao(ActionEvent event) {
         
        long diferencaDias = 0L;

        String placa = textFieldPlaca.getText();
        

        // INFORMAÇÕES BÁSICAS NÃO PREENCHIDAS
        if (textFieldPlaca.getText().isEmpty() || textFieldCPF.getText().isEmpty() || choiceSeguro.getValue() == null
                || pickerDataInicial.getValue() == null || pickerDataFinal.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText("Preencha todos os campos!");
            alert.showAndWait();

        } else { 

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

            diferencaDias = (dataFinalC.getTimeInMillis() - dataFinalC.getTimeInMillis()) / (1000 * 60 * 60 * 24);
            
            String escolhaseguro = choiceSeguro.getValue();
            boolean seguroBoolean = false;
            
            if (escolhaseguro.equals("Sim")) {
                seguroBoolean = true;
            } else {
                seguroBoolean = false;
            }

            if (diferencaDias < 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText("A data final não pode ser anterior a data inicial!");
                alert.showAndWait();
            }
            
            try {
                long cpf = Long.parseLong(textFieldCPF.getText());
                Veiculo veiculo = listaVeiculos.get(placa);
                Cliente cliente = listaClientes.get(cpf);

                listaLocacoes.add(new Locacao(seguroBoolean, dataInicialC, dataFinalC, cliente, veiculo));
                limparCampos(null);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SUCESSO");
                alert.setHeaderText(null);
                alert.setContentText("Locação cadastrada com sucesso!");
                alert.showAndWait();
            } catch (NullPointerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText("Preencha os campos corretamente!");
                alert.showAndWait();
            }
    
        }
    }
        
    
    /**
     * Método para limpar os campos de texto presentes na tela
     * 
     * @param event evento de limpar os campos de texto presentes na tela
     */
    @FXML
    void limparCampos(MouseEvent event) {
        textFieldCPF.setText("");
        textFieldPlaca.setText("");
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

}
