package controller;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import lista.ListaClientes;
import lista.ListaLocacoes;
import lista.ListaVeiculos;

/**
 * A classe ControllerMenuLocadora é responsável por controlar a tela principal
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ControllerMenuLocadora {

    /*
     * rootPane usado para mostrar a tela principal
     */
    @FXML
    private AnchorPane rootPane;

    /*
     * btnAdicionaCliente usado para acessar a tela de adicionar cliente
     */
    @FXML
    private Button btnAdicionaCliente;

    /*
     * btnAdicionaLocacao usado para acessar a tela de adicionar locação
     */
    @FXML
    private Button btnAdicionaLocacao;

    /*
     * btnAdicionaVeiculo usado para acessar a tela de adicionar veículo
     */
    @FXML
    private Button btnAdicionaVeiculo;

    /*
     * btnAlteraInformacoesCliente usado para acessar a tela de alterar informações
     * do cliente
     */
    @FXML
    private Button btnAlteraInformacoesLocacao;

    /*
     * btnAlteraInformacoesVeiculo usado para acessar a tela de alterar informações
     * do veículo
     */
    @FXML
    private Button btnAlteraInformacoesVeiculo;

    /*
     * btnAlterarInformacoesCliente usado para acessar a tela de alterar informações
     * do cliente
     */
    @FXML
    private Button btnAlterarInformacoesCliente;

    /*
     * btnClientesExpandir usado para expandir o menu de clientes
     */
    @FXML
    private Button btnClientesExpandir;

    /*
     * btnClientesFechar usado para fechar o menu de clientes
     */
    @FXML
    private Button btnClientesFechar;

    /*
     * btnLocacoesExpandir usado para expandir o menu de locações
     */
    @FXML
    private Button btnLocacoesExpandir;

    /*
     * btnLocacoesFechar usado para fechar o menu de locações
     */
    @FXML
    private Button btnLocacoesFechar;

    /*
     * btnRemoveCliente usado para acessar a tela de remover cliente
     */
    @FXML
    private Button btnRemoveCliente;

    /*
     * btnRemoveLocacao usado para acessar a tela de remover locação
     */
    @FXML
    private Button btnRemoveLocacao;

    /*
     * btnRemoveVeiculo usado para acessar a tela de remover veículo
     */
    @FXML
    private Button btnRemoveVeiculo;

    /*
     * btnVeiculosExpandir usado para expandir o menu de veículos
     */
    @FXML
    private Button btnVeiculosExpandir;

    /*
     * btnVeiculosFechar usado para fechar o menu de veículos
     */
    @FXML
    private Button btnVeiculosFechar;

    /*
     * btnVisualizaInformacoesCliente usado para acessar a tela de visualizar
     * informações do cliente
     */
    @FXML
    private Button btnVisualizaInformacoesCliente;

    /*
     * btnVisualizaInformacoesLocacao usado para acessar a tela de visualizar
     * informações da locação
     */
    @FXML
    private Button btnVisualizaInformacoesLocacao;

    /*
     * btnVisualizaInformacoesVeiculo usado para acessar a tela de visualizar
     * informações do veículo
     */
    @FXML
    private Button btnVisualizaInformacoesVeiculo;

    /*
     * paneMenuClientesExpandido usado para mostrar o menu de clientes expandido
     */
    @FXML
    private Pane paneMenuClientesExpandido;

    /*
     * paneMenuClientesFechado usado para mostrar o menu de clientes fechado
     */
    @FXML
    private Pane paneMenuClientesFechado;

    /*
     * paneMenuLocacoesExpandido usado para mostrar o menu de locações expandido
     */
    @FXML
    private Pane paneMenuLocacoesExpandido;

    /*
     * paneMenuLocacoesFechado usado para mostrar o menu de locações fechado
     */
    @FXML
    private Pane paneMenuLocacoesFechado;

    /*
     * paneMenuVeiculosExpandido usado para mostrar o menu de veículos expandido
     */
    @FXML
    private Pane paneMenuVeiculosExpandido;

    /*
     * paneMenuVeiculosFechado usado para mostrar o menu de veículos fechado
     */
    @FXML
    private Pane paneMenuVeiculosFechado;

    /*
     * listaClientes usado para receber a lista de clientes
     */
    private static ListaClientes listaClientes;

    /*
     * listaLocacoes usado para receber a lista de locações
     */
    private static ListaLocacoes listaLocacoes;

    /*
     * listaVeiculos usado para receber a lista de veículos
     */
    private static ListaVeiculos listaVeiculos;

    /**
     * Método usado para inicializar o menu principal
     */
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * Método usado para acessar a tela de adicionar cliente
     * @param event evento de clique no botão
     */
    @FXML
    void adicionaCliente(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/cliente/viewAdicionaCliente.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
            alertInterface("ERRO", "Não foi possível entrar na tela de adicionar cliente", AlertType.ERROR);
        }
    }

    /**
     * Método usado para acessar a tela de adicionar locação
     * @param event evento de clique no botão
     */
    @FXML
    void adicionaLocacao(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/locacao/viewAdicionaLocacao.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
            alertInterface("ERRO", "Não foi possível entrar na tela de adicionar locação", AlertType.ERROR);
        }
    }

    /**
     * Método usado para acessar a tela de adicionar veículo
     * @param event evento de clique no botão
     */
    @FXML
    void adicionaVeiculo(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/veiculo/viewAdicionaVeiculo.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
            alertInterface("ERRO", "Não foi possível entrar na tela de adicionar veículo", AlertType.ERROR);
        }  
    }

    /**
     * Método usado para acessar a tela de alterar informações da locacao
     * @param event evento de clique no botão
     */
    @FXML
    void alteraInformacoesLocacao(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/locacao/viewAlteraLocacao.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
            alertInterface("ERRO", "Não foi possível entrar na tela de alterar locação", AlertType.ERROR);
        }
    }

    /**
     * Método usado para acessar a tela de alterar informações do veículo
     * @param event evento de clique no botão
     */
    @FXML
    void alteraInformacoesVeiculo(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/veiculo/viewAlteraVeiculo.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
            alertInterface("ERRO", "Não foi possível entrar na tela de alterar veículo", AlertType.ERROR);
        }
    }

    /**
     * Método usado para acessar a tela de alterar informações do cliente
     * @param event evento de clique no botão
     */
    @FXML
    void alterarInformacoesCliente(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/cliente/viewAlteraCliente.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
            alertInterface("ERRO", "Não foi possível entrar na tela de alterar cliente", AlertType.ERROR);
        }   
    }

    /**
     * Método usado para acessar a tela de remover clientes
     * @param event evento de clique no botão
     */
    @FXML
    void removeCliente(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/cliente/viewRemoveCliente.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
            alertInterface("ERRO", "Não foi possível entrar na tela de remover cliente", AlertType.ERROR);
        }   
    }

    /**
     * Método usado para acessar a tela de remover locações
     * @param event evento de clique no botão
     */
    @FXML
    void removeLocacao(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/locacao/viewRemoveLocacao.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
            alertInterface("ERRO", "Não foi possível entrar na tela de remover locação", AlertType.ERROR);
        }   
    }

    /**
     * Método usado para acessar a tela de remover veículos
     * @param event evento de clique no botão
     */
    @FXML
    void removeVeiculo(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/veiculo/viewRemoveVeiculo.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
            alertInterface("ERRO", "Não foi possível entrar na tela de remover veículo", AlertType.ERROR);
        } 
    }

    /**
     * Método usado para acessar a tela de visualizar informações dos clientes
     * @param event evento de clique no botão
     */
    @FXML
    void visualizaInformacoesCliente(ActionEvent event) {
        try {
            AnchorPane anchorPaneInfoCliente = FXMLLoader.load(getClass().getResource("../views/cliente/viewInfoCliente.fxml"));
            rootPane.getChildren().setAll(anchorPaneInfoCliente);
        } catch (Exception e) {
            System.out.println(e);
            alertInterface("ERRO", "Não foi possível entrar na tela de visualizar informações cliente", AlertType.ERROR);
        }
    }

    /**
     * Método usado para acessar a tela de visualizar informações das locações
     * @param event evento de clique no botão
     */
    @FXML
    void visualizaInformacoesLocacao(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/locacao/viewInfoLocacao.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
            alertInterface("ERRO", "Não foi possível entrar na tela de visualizar informações locação", AlertType.ERROR);
        }
    }

    /**
     * Método usado para acessar a tela de visualizar informações dos veículos
     * @param event evento de clique no botão
     */
    @FXML
    void visualizaInformacoesVeiculo(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/veiculo/viewInfoVeiculo.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
            alertInterface("ERRO", "Não foi possível entrar na tela de visualizar informações veículo", AlertType.ERROR);
        }  
    }

    /**
     * Método usado para mostrar o menu de clientes
     * @param event evento de clique no botão
     */
    @FXML
    void expandirMenuClientes(ActionEvent event) {
        paneMenuClientesFechado.setVisible(false);
        paneMenuClientesExpandido.setVisible(true);
    }

    /**
     * Método usado para mostrar o menu de locações
     * @param event evento de clique no botão
     */
    @FXML
    void expandirMenuLocacoes(ActionEvent event) {
        paneMenuLocacoesFechado.setVisible(false);
        paneMenuLocacoesExpandido.setVisible(true);
    }

    /**
     * Método usado para mostrar o menu de veículos
     * @param event evento de clique no botão
     */
    @FXML
    void expandirMenuVeiculos(ActionEvent event) {
        paneMenuVeiculosFechado.setVisible(false);
        paneMenuVeiculosExpandido.setVisible(true);
    }

    /**
     * Método usado para fechar o menu de clientes
     * @param event evento de clique no botão
     */
    @FXML
    void fecharMenuClientes(MouseEvent event) {
        paneMenuClientesExpandido.setVisible(false);
        paneMenuClientesFechado.setVisible(true);
    }

    /**
     * Método usado para fechar o menu de locações
     * @param event evento de clique no botão
     */
    @FXML
    void fecharMenuLocacoes(MouseEvent event) {
        paneMenuLocacoesExpandido.setVisible(false);
        paneMenuLocacoesFechado.setVisible(true);
    }

    /**
     * Método usado para fechar o menu de veículos
     * @param event evento de clique no botão
     */
    @FXML
    void fecharMenuVeiculos(MouseEvent event) {
        paneMenuVeiculosExpandido.setVisible(false);
        paneMenuVeiculosFechado.setVisible(true);
    }

    /**
     * Efeito de hover ao passar o mouse no menu de clientes fechado
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnClienteFechado(MouseEvent event) {
        paneMenuClientesFechado.setVisible(false);
        paneMenuClientesExpandido.setVisible(true);
    }

    /**
     * Efeito de hover ao passar o mouse no menu de clientes aberto
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnClienteExpandido(MouseEvent event) {
        btnClientesFechar.setStyle("-fx-background-color: #2e0513; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de clientes fechado
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnClienteExpandido(MouseEvent event) {
        btnClientesFechar.setStyle("-fx-background-color: #370617;");
    }

    /**
     * Efeito de hover ao passar o mouse no menu de veiculos fechado
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnVeiculoFechado(MouseEvent event) {
        paneMenuVeiculosFechado.setVisible(false);
        paneMenuVeiculosExpandido.setVisible(true);
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de veiculos fechado
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnVeiculoFechado(MouseEvent event) {
        btnVeiculosExpandir.setStyle("-fx-background-color: #45081d;");
        paneMenuVeiculosFechado.setStyle("-fx-background-color: #45081d;");
    }

    /**
     * Efeito de hover ao passar o mouse no menu de veiculos aberto
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnVeiculoExpandido(MouseEvent event) {
        btnVeiculosFechar.setStyle("-fx-background-color: #3e081a; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de veiculos aberto
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnVeiculoExpandido(MouseEvent event) {
        btnVeiculosFechar.setStyle("-fx-background-color: #45081d;");
    }

    /**
     * Efeito de hover ao passar o mouse no menu de locacoes fechado
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnLocacaoFechado(MouseEvent event) {
        paneMenuLocacoesFechado.setVisible(false);
        paneMenuLocacoesExpandido.setVisible(true);
    }

    /**
     * Efeito de hover ao passar o mouse no menu de locacoes aberto
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnLocacaoExpandido(MouseEvent event) {
        btnLocacoesFechar.setStyle("-fx-background-color: #500922; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de locacoes fechado
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverBtnLocacaoExpandido(MouseEvent event) {
        btnLocacoesFechar.setStyle("-fx-background-color: #5c0a27;");
    }
    
    /**
     * Efeito de hover ao passar o mouse no botão de adicionar cliente
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverAdicionaCliente(MouseEvent event) {
        btnAdicionaCliente.setStyle("-fx-background-color: #2e0513; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de adicionar locação
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverAdicionaLocacao(MouseEvent event) {
        btnAdicionaLocacao.setStyle("-fx-background-color: #500922; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de adicionar veículo
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverAdicionaVeiculo(MouseEvent event) {
        btnAdicionaVeiculo.setStyle("-fx-background-color: #3e081a; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de alterar informações do cliente
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverAlteraInformacoesCliente(MouseEvent event) {
        btnAlterarInformacoesCliente.setStyle("-fx-background-color: #2e0513; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de alterar informações da locação
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverAlteraInformacoesLocacao(MouseEvent event) {
        btnAlteraInformacoesLocacao.setStyle("-fx-background-color: #500922; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de alterar informações do veículo
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverAlteraInformacoesVeiculo(MouseEvent event) {
        btnAlteraInformacoesVeiculo.setStyle("-fx-background-color: #3e081a; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de remover cliente
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverRemoveCliente(MouseEvent event) {
        btnRemoveCliente.setStyle("-fx-background-color: #2e0513; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de remover locação
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverRemoveLocacao(MouseEvent event) {
        btnRemoveLocacao.setStyle("-fx-background-color: #500922; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de remover veículo
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverRemoveVeiculo(MouseEvent event) {
        btnRemoveVeiculo.setStyle("-fx-background-color: #3e081a; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de visualizar informações do cliente
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverVisualizaInformacoesCliente(MouseEvent event) {
        btnVisualizaInformacoesCliente.setStyle("-fx-background-color: #2e0513; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de visualizar informações da locação
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverVisualizaInformacoesLocacao(MouseEvent event) {
        btnVisualizaInformacoesLocacao.setStyle("-fx-background-color: #500922; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de visualizar informações do veículo
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverVisualizaInformacoesVeiculo(MouseEvent event) {
        btnVisualizaInformacoesVeiculo.setStyle("-fx-background-color: #3e081a; -fx-cursor: hand;");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de adicionar clientes
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverAdicionaCliente(MouseEvent event) {
        btnAdicionaCliente.setStyle("-fx-background-color: #370617");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de adicionar locação
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverAdicionaLocacao(MouseEvent event) {
        btnAdicionaLocacao.setStyle("-fx-background-color: #5c0a27");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de adicionar veículo
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverAdicionaVeiculo(MouseEvent event) {
        btnAdicionaVeiculo.setStyle("-fx-background-color: #45081d");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de alterar informações do cliente
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverAlteraInformacoesCliente(MouseEvent event) {
        btnAlterarInformacoesCliente.setStyle("-fx-background-color: #370617");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de alterar informações da locação
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverAlteraInformacoesLocacao(MouseEvent event) {
        btnAlteraInformacoesLocacao.setStyle("-fx-background-color: #5c0a27");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de alterar informações do veículo
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverAlteraInformacoesVeiculo(MouseEvent event) {
        btnAlteraInformacoesVeiculo.setStyle("-fx-background-color: #45081d");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de remover cliente
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverRemoveCliente(MouseEvent event) {
        btnRemoveCliente.setStyle("-fx-background-color: #370617");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de remover locação
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverRemoveLocacao(MouseEvent event) {
        btnRemoveLocacao.setStyle("-fx-background-color: #5c0a27");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de remover veículo
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverRemoveVeiculo(MouseEvent event) {
        btnRemoveVeiculo.setStyle("-fx-background-color: #45081d");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de visualizar informações do cliente
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverVisualizaInformacoesCliente(MouseEvent event) {
        btnVisualizaInformacoesCliente.setStyle("-fx-background-color: #370617");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de visualizar informações da locação
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
    @FXML
    void notHoverVisualizaInformacoesLocacao(MouseEvent event) {
        btnVisualizaInformacoesLocacao.setStyle("-fx-background-color: #5c0a27");
    }

    /**
     * Efeito de hover ao tirar o mouse do menu de visualizar informações do veículo
     * 
     * @param event evento de hover ao tirar o mouse do botão
     */
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
