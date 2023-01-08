package controller.veiculo;

import controller.ControllerMenuLocadora;
import exceptions.geral.EmptyFieldException;
import exceptions.veiculo.PlacaNotFoundException;
import exceptions.veiculo.RemoveVeiculoException;
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

import lista.ListaVeiculos;

/**
 * A classe ControllerRemoveVeiculo é responsável por controlar a tela de
 * remover veiculo
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ControllerRemoveVeiculo {

    /*
     * btnLimpar usado para limpar os campos
     */
    @FXML
    private Button btnLimpar;

    /*
     * btnRemover usado para remover um cliente
     */
    @FXML
    private Button btnRemover;

    /*
     * btnVoltar usado para voltar para a tela principal
     */
    @FXML
    private ImageView btnVoltar;

    /*
     * rootPane usado para mostrar a tela de remover clientes
     */
    @FXML
    private AnchorPane rootPane;

    /*
     * textFieldCPF usado para receber a placa do veículo
     */
    @FXML
    private TextField textFieldPlaca;

    /*
     * listaVeiculos usado para receber a lista de veículos
     */
    private ListaVeiculos listaVeiculos;

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
     * Método usado para inicializar a lista de veiculos a partir do menu principal
     */
    @FXML
    void initialize() {
        listaVeiculos = ControllerMenuLocadora.getListaVeiculos();
    }

    /**
     * Método usado para remover um veiculo através da sua placa
     * @param event evento de clicar no botão de remover
     */
    @FXML
    void removerVeiculo(ActionEvent event) {
        String placa = textFieldPlaca.getText();

        // PREENCHIDO CORRETAMENTE O CAMPO
        try {
            if (placa.isEmpty()) {
                throw new EmptyFieldException("O campo de placa está vazio!");
            }
            if (!listaVeiculos.existe(placa)) {
                throw new PlacaNotFoundException("O veículo não foi encontrado na lista de veículos!");
            } else {
                if (!listaVeiculos.remove(placa)) {
                    throw new RemoveVeiculoException("O veículo não foi encontrado na lista de veículos!");            
                } else {
                    alertInterface("SUCESSO", "O veículo foi removido com sucesso!", AlertType.INFORMATION);
                    limparCampos(null);
                }
            }
        } catch (EmptyFieldException | PlacaNotFoundException | RemoveVeiculoException e) {
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
        textFieldPlaca.setText("");
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
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
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
     * Efeito de hover ao passar o mouse no botão de remover
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnRemover(MouseEvent event) {
        btnRemover.setStyle("-fx-background-color: #682121;-fx-cursor: hand; -fx-background-radius: 50;");
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

}
