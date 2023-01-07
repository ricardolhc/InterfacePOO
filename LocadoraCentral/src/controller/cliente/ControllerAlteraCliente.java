package controller.cliente;

import controller.ControllerMenuLocadora;
import exceptions.cliente.CPFNotFoundException;
import exceptions.cliente.ClienteNotFoundException;
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

import lista.Cliente;
import lista.ListaClientes;

/**
 * Classe responsável por controlar a tela de alteração de clientes
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ControllerAlteraCliente {

    /**
     * rootPane usado para carregar a tela de adicionar cliente
     */
    @FXML
    private AnchorPane rootPane;

    /**
     * btnProcurar usado para buscar um cliente na lista de clientes
     */
    @FXML
    private Button btnProcurar;

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
     * textFieldCarteiraMotorista usado para receber o número da carteira de
     * motorista do cliente
     */
    @FXML
    private TextField textFieldCarteiraMotorista;

    /**
     * textFieldEndereco usado para receber o endereço do cliente
     */
    @FXML
    private TextField textFieldEndereco;

    /**
     * textFieldNome usado para receber o nome do cliente
     */
    @FXML
    private TextField textFieldNome;

    /**
     * textFieldTelefone usado para receber o telefone do cliente
     */
    @FXML
    private TextField textFieldTelefone;

    /**
     * listaClientes usado para receber a lista de clientes
     */
    private ListaClientes listaClientes;

    /**
     * cpfAlterar usado para receber o CPF do cliente a ser alterado
     */
    private String cpfAlterar;

    /**
     * Método utilizado para inicializar a lista de clientes a partir do menu
     * principal
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
     * Método usado para procurar um cliente na lista de clientes apartir do cpf
     * 
     * @param event evento usado para buscar um cliente na lista de clientes
     */
    @FXML
    void procurarCliente(ActionEvent event) {
        cpfAlterar = textFieldCPF.getText();

        try {
            if (cpfAlterar.isEmpty()) {
                throw new EmptyFieldException("Campo CPF vazio");
            }

            /* POSSIVEL NUMBERFORMATEXCEPTION */
            long cpfLong = Long.parseLong(cpfAlterar);

            if (cpfAlterar.length() != 11) {
                throw new InvalidCPFException("CPF inválido");
            }
            if (!listaClientes.existe(cpfLong)) {
                throw new ClienteNotFoundException("Cliente não encontrado");
            } else {
                Cliente cliente = listaClientes.get(cpfLong);

                long cnh = cliente.getNumeroCarteiraMotorista();
                long telefone = cliente.getTelefone();
                String nome = cliente.getNome();
                String endereco = cliente.getEndereco();

                textFieldNome.setText(nome);
                textFieldEndereco.setText(endereco);
                textFieldTelefone.setText(String.valueOf(telefone));
                textFieldCarteiraMotorista.setText(String.valueOf(cnh));
            }

        } catch (InvalidCPFException | ClienteNotFoundException | EmptyFieldException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }

    }

    /**
     * Método usado para alterar informações cpf, cnh, telefone, nome, endereco, de
     * um cliente
     * 
     * @param event evento usado para alterar informações de um cliente
     */
    @FXML
    void alterarCliente(ActionEvent event) {

        String cpf = textFieldCPF.getText();
        String cnh = textFieldCarteiraMotorista.getText();
        String telefone = textFieldTelefone.getText();
        String nome = textFieldNome.getText();
        String endereco = textFieldEndereco.getText();
        long cpfLong;
        long cnhLong;
        long telefoneLong;

        String cpfFinal = textFieldCPF.getText();

        try {
            if (cpf.isEmpty() || cnh.isEmpty() || telefone.isEmpty() || nome.isEmpty() || endereco.isEmpty()) {
                throw new EmptyFieldException("Preencha todos os campos");
            }
            if (!cpfAlterar.equals(cpfFinal)) {
                throw new IllegalArgumentException("CPF não pode ser alterado sem pressionar o botão procurar!");
            }

            /* POSSIVEL NUMBERFORMATEXCEPTION */
            cnhLong = Long.parseLong(cnh);
            telefoneLong = Long.parseLong(telefone);
            cpfLong = Long.parseLong(cpf);

            if (cpf.length() != 11) {
                throw new InvalidCPFException("CPF inválido");
            }
            if (telefone.length() != 11 && telefone.length() != 10) {
                throw new InvalidTelefoneException("Telefone inválido");
            }
            if (!listaClientes.existe(cpfLong)) {
                throw new CPFNotFoundException("CPF não existente!");
            } else {

                /* ADICIONA CLIENTE */
                Cliente cliente = listaClientes.get(cpfLong);

                cliente.setNome(nome);
                cliente.setEndereco(endereco);
                cliente.setTelefone(telefoneLong);
                cliente.setNumeroCarteira(cnhLong);

                limparCampos(null);

                alertInterface("SUCESSO", "Cliente alterado com sucesso!", AlertType.INFORMATION);
            }

        } catch (InvalidCPFException | CPFNotFoundException | EmptyFieldException | InvalidTelefoneException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }

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
        btnVoltar.setImage(new Image("views/cliente/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
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
     * Efeito de hover ao passar o mouse no botão de procurar
     * 
     * @param event evento hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnProcurar(MouseEvent event) {
        btnProcurar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse do botão de procurar
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnProcurar(MouseEvent event) {
        btnProcurar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
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
     * Efeito de hover ao tirar o mouse do botão de alterar
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnAlterar(MouseEvent event) {
        btnAlterar.setStyle("-fx-background-color: #807d0a;-fx-cursor: hand; -fx-background-radius: 50;");
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
