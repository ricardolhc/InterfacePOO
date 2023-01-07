package controller.cliente;

import controller.ControllerMenuLocadora;
import exceptions.cliente.CPFAlreadyAdd;
import exceptions.cliente.InvalidCPFException;
import exceptions.cliente.InvalidTelefoneException;
import exceptions.geral.EmptyFieldException;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import lista.ListaClientes;
import lista.Cliente;

/**
 * A classe ControllerAdicionaCliente é responsável por controlar a tela de
 * adicionar cliente
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ControllerAdicionaCliente {

    /**
     * rootPane usado para carregar a tela de adicionar cliente
     */
    @FXML
    private AnchorPane rootPane;

    /**
     * btnVoltar usado para voltar ao menu principal
     */
    @FXML
    private ImageView btnVoltar;

    /**
     * textFieldCPF usado para receber o CPF do cliente
     */
    @FXML
    private TextField textFieldCPF;

    /**
     * textFieldCarteiraMotorista usado para receber a CNH do cliente
     */
    @FXML
    private TextField textFieldCarteiraMotorista;

    /**
     * textFieldTelefone usado para receber o telefone do cliente
     */
    @FXML
    private TextField textFieldTelefone;

    /**
     * textFieldNome usado para receber o nome do cliente
     */
    @FXML
    private TextField textFieldNome;

    /**
     * textFieldEndereco usado para receber o endereço do cliente
     */
    @FXML
    private TextField textFieldEndereco;

    /**
     * btnAdicionar usado para adicionar um cliente
     */
    @FXML
    private Button btnAdicionar;

    /**
     * btnLimpar usado para limpar os campos
     */
    @FXML
    private Button btnLimpar;

    /**
     * listaClientes usado para receber a lista de clientes
     */
    private ListaClientes listaClientes;

    /**
     * Método usado para inicializar a lista de clientes a partir do menu principal
     */
    @FXML
    void initialize() {
        listaClientes = ControllerMenuLocadora.getListaClientes();
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
     * Método usado para adicionar um cliente recebendo seu cpf, nome, cnhLong,
     * endereco, telefoneLong, ao clicar no botão de adicionar
     * 
     * @param event evento de clicar no botão de adicionar
     */
    @FXML
    void adicionarCliente(ActionEvent event) {

        String cpf = textFieldCPF.getText();
        String cnh = textFieldCarteiraMotorista.getText();
        String telefone = textFieldTelefone.getText();
        String nome = textFieldNome.getText();
        String endereco = textFieldEndereco.getText();
        long cpfLong;
        long cnhLong;
        long telefoneLong;

        try {
            /* VERIFICAR SE O CAMPO ESTÁ VAZIO */
            if (cpf.isEmpty() || cnh.isEmpty() || telefone.isEmpty() || nome.isEmpty() || endereco.isEmpty()) {
                throw new EmptyFieldException("Preencha todos os campos!");
            }

            /* POSSÍVEL NUMBERFORMATEXCEPTION */
            cnhLong = Long.parseLong(cnh);
            telefoneLong = Long.parseLong(telefone);
            cpfLong = Long.parseLong(cpf);

            if (cpf.length() != 11) {
                throw new InvalidCPFException("CPF inválido!");
            }
            if (telefone.length() != 11 && telefone.length() != 10) {
                throw new InvalidTelefoneException("Telefone inválido!");
            }
            /* VERIFICAR SE O CPF ESTÁ CADASTRADO */
            if (listaClientes.existe(cpfLong)) {
                throw new CPFAlreadyAdd("CPF já cadastrado!");
            } else {
                /* ADICIONA CLIENTE */
                listaClientes.add(new Cliente(cpf, nome, cnhLong, endereco, telefoneLong));

                limparCampos(null);

                alertInterface("SUCESSO", "Cliente adicionado com sucesso!", AlertType.INFORMATION);
            }
        } catch (EmptyFieldException | InvalidCPFException | InvalidTelefoneException | CPFAlreadyAdd e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }
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
     * Método para limpar os campos de texto presentes na tela
     * 
     * @param event evento de limpar os campos de texto presentes na tela
     */
    @FXML
    void limparCampos(MouseEvent event) {
        textFieldNome.clear();
        textFieldCPF.clear();
        textFieldCarteiraMotorista.clear();
        textFieldTelefone.clear();
        textFieldEndereco.clear();
        rootPane.requestFocus();
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
