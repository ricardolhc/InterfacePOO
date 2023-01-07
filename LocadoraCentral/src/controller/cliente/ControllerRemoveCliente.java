package controller.cliente;

import controller.ControllerMenuLocadora;
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

/**
 * A classe ControllerRemoveCliente é responsável por controlar a tela de
 * remover cliente
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ControllerRemoveCliente {

    /*
     * rootPane usado para mostrar a tela de remover clientes
     */
    @FXML
    private AnchorPane rootPane;

    /*
     * btnRemover usado para remover um cliente
     */
    @FXML
    private Button btnRemover;

    /*
     * btnLimpar usado para limpar os campos
     */
    @FXML
    private Button btnLimpar;

    /*
     * btnVoltar usado para voltar para a tela principal
     */
    @FXML
    private ImageView btnVoltar;

    /*
     * textFieldCPF usado para receber o cpf do cliente
     */
    @FXML
    private TextField textFieldCPF;

    /*
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
     * Método usado para remover um cliente através do seu cpf
     * @param event evento de clicar no botão de remover
     */
    @FXML
    void removerCliente(ActionEvent event) {

        String cpf = textFieldCPF.getText();

        try {
            /* VERIFICAR SE O CAMPO ESTÁ VAZIO */
            if (cpf.isEmpty()) {
                throw new NullPointerException("Campo cpf vazio");
            }

            long cpfLong = Long.parseLong(cpf);

            if (cpf.length() != 11) {
                throw new IllegalArgumentException("CPF inválido");
            }

            /* VERIFICAR SE O CPF JÁ ESTÁ CADASTRADO */
            if (!listaClientes.existe(cpfLong)) {
                throw new NullPointerException("CPF não existente");
            }
            if (!listaClientes.remove(cpfLong)) {
                throw new NullPointerException("Erro ao remover cliente");
            } else {
                alertInterface("SUCESSO", "Cliente removido com sucesso!", AlertType.INFORMATION);
                limparCampos(null);
            }
        } catch (NumberFormatException e) {
            alertInterface("ERRO", "Preencha os campos corretamente!", AlertType.ERROR);
        } catch (NullPointerException | IllegalArgumentException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }

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
     * Efeito de hover ao passar o mouse no botão de remover
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnRemover(MouseEvent event) {
        btnRemover.setStyle("-fx-background-color: #682121;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de voltar
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltarHover.png"));
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
        rootPane.requestFocus();
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
     * Efeito de hover ao tirar o mouse do botão de remover
     * 
     * @param event efeito de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnRemover(MouseEvent event) {
        btnRemover.setStyle("-fx-background-color: #7d2727;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse do botão de voltar
     * 
     * @param event efeito de hover ao tirar o mouse do botão
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
