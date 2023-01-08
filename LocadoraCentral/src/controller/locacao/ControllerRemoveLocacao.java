package controller.locacao;

import controller.ControllerMenuLocadora;
import exceptions.geral.EmptyFieldException;
import exceptions.locacao.IDNotFoundException;
import exceptions.locacao.RemoveLocacaoException;
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
import lista.ListaLocacoes;

/**
 * A classe ControllerRemoveLocacao é responsável por controlar a tela de
 * remover locacao
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ControllerRemoveLocacao {

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
    private ImageView btnVoltarLocacao;

    /*
     * rootPane usado para mostrar a tela de remover clientes
     */
    @FXML
    private AnchorPane rootPane;

    /*
     * textFieldLocacao usado para receber o código da locação
     */
    @FXML
    private TextField textFieldLocacao;

    /*
     * listaLocacao usado para receber a lista de locações
     */
    private ListaLocacoes listaLocacao;

    /**
     * Método usado para inicializar a lista de locacoes a partir do menu principal
     */
    @FXML
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
            alertInterface("ERRO", "Não foi possível voltar para o menu principal", AlertType.ERROR);
        }
    }

    /**
     * Método usado para remover uma locacao através do seu codigo
     * @param event evento de clicar no botão de remover
     */
    @FXML
    void removerLocacao(ActionEvent event) {
        String codigoUnico = textFieldLocacao.getText();

        try {
            if (codigoUnico.isEmpty()) {
                throw new EmptyFieldException("Campo código vazio!");
            }

            int codigo = Integer.parseInt(codigoUnico);

            if (!listaLocacao.existe(codigo)) {
                throw new IDNotFoundException("ID não encontrado!");
            } 
            if (!listaLocacao.remove(codigo)){
                throw new RemoveLocacaoException("Erro ao remover locação!");
            } else {
                alertInterface("SUCESSO", "Locação removida com sucesso!", AlertType.INFORMATION);
                limparCampos(null);
            }
        } catch (NumberFormatException | EmptyFieldException | IDNotFoundException | RemoveLocacaoException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }

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
        btnRemover.setStyle("-fx-background-color: #7d2727;-fx-cursor: hand; -fx-background-radius: 50;");

    }

    /**
     * Efeito de hover ao passar o mouse no botão de voltar
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnVoltarLocacao(MouseEvent event) {
        btnVoltarLocacao.setImage(new Image("views/cliente/pngVoltarHover.png"));
        btnVoltarLocacao.setStyle("-fx-cursor: hand;");

    }

    /**
     * Método para limpar os campos de texto presentes na tela
     * 
     * @param event evento de limpar os campos de texto presentes na tela
     */
    @FXML
    void limparCampos(MouseEvent event) {
        textFieldLocacao.clear();
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
        btnVoltarLocacao.setImage(new Image("views/locacao/pngVoltar.png"));

    }

    
}
