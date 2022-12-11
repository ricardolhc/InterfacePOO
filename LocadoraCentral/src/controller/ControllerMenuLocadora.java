package controller;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import lista.ListaClientes;
import lista.ListaLocacoes;
import lista.ListaVeiculos;

public class ControllerMenuLocadora {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button btnAdicionaCliente;

    @FXML
    private Button btnAdicionaLocacao;

    @FXML
    private Button btnAdicionaVeiculo;

    @FXML
    private Button btnAlteraInformacoesLocacao;

    @FXML
    private Button btnAlteraInformacoesVeiculo;

    @FXML
    private Button btnAlterarInformacoesCliente;

    @FXML
    private Button btnClientesExpandir;

    @FXML
    private Button btnClientesFechar;

    @FXML
    private Button btnLocacoesExpandir;

    @FXML
    private Button btnLocacoesFechar;

    @FXML
    private Button btnRemoveCliente;

    @FXML
    private Button btnRemoveLocacao;

    @FXML
    private Button btnRemoveVeiculo;

    @FXML
    private Button btnVeiculosExpandir;

    @FXML
    private Button btnVeiculosFechar;

    @FXML
    private Button btnVisualizaInformacoesCliente;

    @FXML
    private Button btnVisualizaInformacoesLocacao;

    @FXML
    private Button btnVisualizaInformacoesVeiculo;

    @FXML
    private Pane paneMenuClientesExpandido;

    @FXML
    private Pane paneMenuClientesFechado;

    @FXML
    private Pane paneMenuLocacoesExpandido;

    @FXML
    private Pane paneMenuLocacoesFechado;

    @FXML
    private Pane paneMenuVeiculosExpandido;

    @FXML
    private Pane paneMenuVeiculosFechado;

    private static ListaClientes listaClientes;

    private static ListaLocacoes listaLocacoes;

    private static ListaVeiculos listaVeiculos;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    void adicionaCliente(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/cliente/viewAdicionaCliente.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void adicionaLocacao(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/locacao/viewAdicionaLocacao.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void adicionaVeiculo(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/veiculo/viewAdicionaVeiculo.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
        }  
    }

    @FXML
    void alteraInformacoesLocacao(ActionEvent event) {
        System.out.println("Altera Informacoes Locacao");
    }

    @FXML
    void alteraInformacoesVeiculo(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/veiculo/viewAlteraVeiculo.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void alterarInformacoesCliente(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/cliente/viewAlteraCliente.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
        }   
    }

    @FXML
    void removeCliente(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/cliente/viewRemoveCliente.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
        }   
    }

    @FXML
    void removeLocacao(ActionEvent event) {
        System.out.println("Remove Locacao");
    }

    @FXML
    void removeVeiculo(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/veiculo/viewRemoveVeiculo.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    @FXML
    void visualizaInformacoesCliente(ActionEvent event) {
        try {
            AnchorPane anchorPaneInfoCliente = FXMLLoader.load(getClass().getResource("../views/cliente/viewInfoCliente.fxml"));
            rootPane.getChildren().setAll(anchorPaneInfoCliente);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void visualizaInformacoesLocacao(ActionEvent event) {
        System.out.println("Visualiza Informacoes Locacao");
    }

    @FXML
    void visualizaInformacoesVeiculo(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/veiculo/viewInfoVeiculo.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
        }  
    }

    @FXML
    void expandirMenuClientes(ActionEvent event) {
        paneMenuClientesFechado.setVisible(false);
        paneMenuClientesExpandido.setVisible(true);
    }

    @FXML
    void expandirMenuLocacoes(ActionEvent event) {
        paneMenuLocacoesFechado.setVisible(false);
        paneMenuLocacoesExpandido.setVisible(true);
    }

    @FXML
    void expandirMenuVeiculos(ActionEvent event) {
        paneMenuVeiculosFechado.setVisible(false);
        paneMenuVeiculosExpandido.setVisible(true);
    }

    @FXML
    void fecharMenuClientes(MouseEvent event) {
        paneMenuClientesExpandido.setVisible(false);
        paneMenuClientesFechado.setVisible(true);
    }

    @FXML
    void fecharMenuLocacoes(MouseEvent event) {
        paneMenuLocacoesExpandido.setVisible(false);
        paneMenuLocacoesFechado.setVisible(true);
    }

    @FXML
    void fecharMenuVeiculos(MouseEvent event) {
        paneMenuVeiculosExpandido.setVisible(false);
        paneMenuVeiculosFechado.setVisible(true);
    }


    @FXML
    void hoverBtnClienteFechado(MouseEvent event) {
        paneMenuClientesFechado.setVisible(false);
        paneMenuClientesExpandido.setVisible(true);
    }

    @FXML
    void hoverBtnClienteExpandido(MouseEvent event) {
        btnClientesFechar.setStyle("-fx-background-color: #2e0513; -fx-cursor: hand;");
    }

    @FXML
    void notHoverBtnClienteExpandido(MouseEvent event) {
        btnClientesFechar.setStyle("-fx-background-color: #370617;");
    }

    @FXML
    void hoverBtnVeiculoFechado(MouseEvent event) {
        paneMenuVeiculosFechado.setVisible(false);
        paneMenuVeiculosExpandido.setVisible(true);
    }

    @FXML
    void notHoverBtnVeiculoFechado(MouseEvent event) {
        btnVeiculosExpandir.setStyle("-fx-background-color: #45081d;");
        paneMenuVeiculosFechado.setStyle("-fx-background-color: #45081d;");
    }

    @FXML
    void hoverBtnVeiculoExpandido(MouseEvent event) {
        btnVeiculosFechar.setStyle("-fx-background-color: #3e081a; -fx-cursor: hand;");
    }

    @FXML
    void notHoverBtnVeiculoExpandido(MouseEvent event) {
        btnVeiculosFechar.setStyle("-fx-background-color: #45081d;");
    }



    @FXML
    void hoverBtnLocacaoFechado(MouseEvent event) {
        paneMenuLocacoesFechado.setVisible(false);
        paneMenuLocacoesExpandido.setVisible(true);
    }

    @FXML
    void hoverBtnLocacaoExpandido(MouseEvent event) {
        btnLocacoesFechar.setStyle("-fx-background-color: #500922; -fx-cursor: hand;");
    }

    @FXML
    void notHoverBtnLocacaoExpandido(MouseEvent event) {
        btnLocacoesFechar.setStyle("-fx-background-color: #5c0a27;");
    }
   



    @FXML
    void hoverAdicionaCliente(MouseEvent event) {
        btnAdicionaCliente.setStyle("-fx-background-color: #2e0513; -fx-cursor: hand;");
    }

    @FXML
    void hoverAdicionaLocacao(MouseEvent event) {
        btnAdicionaLocacao.setStyle("-fx-background-color: #500922; -fx-cursor: hand;");
    }

    @FXML
    void hoverAdicionaVeiculo(MouseEvent event) {
        btnAdicionaVeiculo.setStyle("-fx-background-color: #3e081a; -fx-cursor: hand;");
    }

    @FXML
    void hoverAlteraInformacoesCliente(MouseEvent event) {
        btnAlterarInformacoesCliente.setStyle("-fx-background-color: #2e0513; -fx-cursor: hand;");
    }

    @FXML
    void hoverAlteraInformacoesLocacao(MouseEvent event) {
        btnAlteraInformacoesLocacao.setStyle("-fx-background-color: #500922; -fx-cursor: hand;");
    }

    @FXML
    void hoverAlteraInformacoesVeiculo(MouseEvent event) {
        btnAlteraInformacoesVeiculo.setStyle("-fx-background-color: #3e081a; -fx-cursor: hand;");
    }

    @FXML
    void hoverRemoveCliente(MouseEvent event) {
        btnRemoveCliente.setStyle("-fx-background-color: #2e0513; -fx-cursor: hand;");
    }

    @FXML
    void hoverRemoveLocacao(MouseEvent event) {
        btnRemoveLocacao.setStyle("-fx-background-color: #500922; -fx-cursor: hand;");
    }

    @FXML
    void hoverRemoveVeiculo(MouseEvent event) {
        btnRemoveVeiculo.setStyle("-fx-background-color: #3e081a; -fx-cursor: hand;");
    }

    @FXML
    void hoverVisualizaInformacoesCliente(MouseEvent event) {
        btnVisualizaInformacoesCliente.setStyle("-fx-background-color: #2e0513; -fx-cursor: hand;");
    }

    @FXML
    void hoverVisualizaInformacoesLocacao(MouseEvent event) {
        btnVisualizaInformacoesLocacao.setStyle("-fx-background-color: #500922; -fx-cursor: hand;");
    }

    @FXML
    void hoverVisualizaInformacoesVeiculo(MouseEvent event) {
        btnVisualizaInformacoesVeiculo.setStyle("-fx-background-color: #3e081a; -fx-cursor: hand;");
    }

    @FXML
    void notHoverAdicionaCliente(MouseEvent event) {
        btnAdicionaCliente.setStyle("-fx-background-color: #370617");
    }

    @FXML
    void notHoverAdicionaLocacao(MouseEvent event) {
        btnAdicionaLocacao.setStyle("-fx-background-color: #5c0a27");
    }

    @FXML
    void notHoverAdicionaVeiculo(MouseEvent event) {
        btnAdicionaVeiculo.setStyle("-fx-background-color: #45081d");
    }

    @FXML
    void notHoverAlteraInformacoesCliente(MouseEvent event) {
        btnAlterarInformacoesCliente.setStyle("-fx-background-color: #370617");
    }

    @FXML
    void notHoverAlteraInformacoesLocacao(MouseEvent event) {
        btnAlteraInformacoesLocacao.setStyle("-fx-background-color: #5c0a27");
    }

    @FXML
    void notHoverAlteraInformacoesVeiculo(MouseEvent event) {
        btnAlteraInformacoesVeiculo.setStyle("-fx-background-color: #45081d");
    }

    @FXML
    void notHoverRemoveCliente(MouseEvent event) {
        btnRemoveCliente.setStyle("-fx-background-color: #370617");
    }

    @FXML
    void notHoverRemoveLocacao(MouseEvent event) {
        btnRemoveLocacao.setStyle("-fx-background-color: #5c0a27");
    }

    @FXML
    void notHoverRemoveVeiculo(MouseEvent event) {
        btnRemoveVeiculo.setStyle("-fx-background-color: #45081d");
    }

    @FXML
    void notHoverVisualizaInformacoesCliente(MouseEvent event) {
        btnVisualizaInformacoesCliente.setStyle("-fx-background-color: #370617");
    }

    @FXML
    void notHoverVisualizaInformacoesLocacao(MouseEvent event) {
        btnVisualizaInformacoesLocacao.setStyle("-fx-background-color: #5c0a27");
    }

    @FXML
    void notHoverVisualizaInformacoesVeiculo(MouseEvent event) {
        btnVisualizaInformacoesVeiculo.setStyle("-fx-background-color: #45081d");
    }

    

    public void setListaClientes(ListaClientes listaClientesNova) {
        listaClientes = listaClientesNova;
    }

    public void setListaLocacoes(ListaLocacoes listaLocacoesNova) {
        listaLocacoes = listaLocacoesNova;
    }

    public void setListaVeiculos(ListaVeiculos listaVeiculosNova) {
        listaVeiculos = listaVeiculosNova;
    }

    public static ListaClientes getListaClientes() {
        return listaClientes;
    }

    public static ListaLocacoes getListaLocacoes() {
        return listaLocacoes;
    }

    public static ListaVeiculos getListaVeiculos() {
        return listaVeiculos;
    }

}
