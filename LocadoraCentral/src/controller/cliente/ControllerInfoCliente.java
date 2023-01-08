package controller.cliente;

import controller.ControllerMenuLocadora;
import exceptions.cliente.ClienteNotFoundException;
import exceptions.cliente.InvalidCPFException;
import exceptions.geral.EmptyFieldException;
import exceptions.geral.EmptyList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import lista.Cliente;
import lista.ListaClientes;

/**
 * Classe responsável por controlar a tela de visualização de informações de
 * clientes
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ControllerInfoCliente {

    /*
     * btnInfoFullCliente usado para mostrar informações completas do cliente
     */
    @FXML
    private Button btnInfoFullCliente;

    /*
     * btnInfoResumoCliente usado para mostrar informações resumidas do cliente
     */
    @FXML
    private Button btnInfoResumoCliente;

    /*
     * btnLimpar usado para limpar os campos de texto
     */
    @FXML
    private Button btnLimpar;

    /*
     * btnMostrarEsconderCampos usado para mostrar/esconder os campos de texto
     */
    @FXML
    private Button btnMostrarEsconderCampos;

    /*
     * btnPesquisar usado para pesquisar um cliente
     */
    @FXML
    private Button btnPesquisar;

    /*
     * btnVoltar usado para voltar para a tela principal
     */
    @FXML
    private ImageView btnVoltar;

    /*
     * rootPane usado para mostrar a tela de informações de clientes
     */
    @FXML
    private AnchorPane rootPane;

    /*
     * textFieldCPF usado para receber o CPF do cliente
     */
    @FXML
    private TextField textFieldCPF;

    /*
     * textFieldNome usado para receber o nome do cliente
     */
    @FXML
    private TextField textFieldNome;

    /*
     * textFieldEndereco usado para receber o endereço do cliente
     */
    @FXML
    private TextField textFieldEndereco;

    /*
     * textFieldTelefone usado para receber o telefone do cliente
     */
    @FXML
    private TextField textFieldTelefone;

    /*
     * textFieldCarteiraMotorista usado para receber o número da carteira de
     * motorista do cliente
     */
    @FXML
    private TextField textFieldCarteiraMotorista;

    /*
     * labelCPF usado para mostrar o texto CPF na tela
     */
    @FXML
    private Label labelCPF;

    /*
     * labelNome usado para mostrar o texto Nome na tela
     */
    @FXML
    private Label labelNome;

    /*
     * labelEndereco usado para mostrar o texto Endereco na tela
     */
    @FXML
    private Label labelEndereco;

    /*
     * labelTelefone usado para mostrar o texto Telefone na tela
     */
    @FXML
    private Label labelTelefone;

    /*
     * labelCarteiraMotorista usado para mostrar o texto Carteira de Motorista na
     * tela
     */
    @FXML
    private Label labelCarteiraMotorista;

    /*
     * tableViewInfoCompleta usado para mostrar as informações completas do cliente
     * nas informações completas
     */
    @FXML
    private TableView<Cliente> tableViewInfoCompleta;

    /*
     * tableColumnCpfInfoCompleta usado para mostrar o CPF do cliente nas
     * informações completas
     */
    @FXML
    private TableColumn<Cliente, String> tableColumnCpfInfoCompleta;

    /*
     * tableColumnNomeInfoCompleta usado para mostrar o nome do cliente nas
     * informações completas
     */
    @FXML
    private TableColumn<Cliente, String> tableColumnNomeInfoCompleta;

    /*
     * tableColumnEnderecoInfoCompleta usado para mostrar o endereço do cliente nas
     * informações completas
     */
    @FXML
    private TableColumn<Cliente, String> tableColumnEnderecoInfoCompleta;

    /*
     * tableColumnTelefoneInfoCompleta usado para mostrar o telefone do cliente nas
     * informações completas
     */
    @FXML
    private TableColumn<Cliente, Long> tableColumnTelefoneInfoCompleta;

    /*
     * tableColumnCarteiraMotoristaInfoCompleta usado para mostrar o número da
     * carteira de motorista do cliente nas informações completas
     */
    @FXML
    private TableColumn<Cliente, Long> tableColumnCarteiraMotoristaInfoCompleta;

    /*
     * tableViewInfoResumo usado para mostrar as informações resumidas do cliente
     */
    @FXML
    private TableView<Cliente> tableViewInfoResumo;

    /*
     * tableColumnCpfInfoResumo usado para mostrar o CPF do cliente nas informações
     * resumidas
     */
    @FXML
    private TableColumn<Cliente, String> tableColumnCpfInfoResumo;

    /*
     * tableColumnNomeInfoResumo usado para mostrar o nome do cliente nas
     * informações resumidas
     */
    @FXML
    private TableColumn<Cliente, String> tableColumnNomeInfoResumo;

    /*
     * mostrarEsconderCampos usado para mostrar/esconder as informaçoes de um
     * cliente
     */
    private boolean mostrarEsconderInfoCliente = true;

    /*
     * mostrarEsconderInfoCompleta usado para mostrar/esconder a tabela com as
     * informações completas do cliente
     */
    private boolean mostrarEsconderInfoCompleta = true;

    /*
     * mostrarEsconderInfoResumo usado para mostrar/esconder a tabela com as
     * informações resumidas do cliente
     */
    private boolean mostrarEsconderInfoResumo = true;

    /*
     * listaClientes usado para armazenar os clientes
     */
    private ListaClientes listaClientes;

    /*
     * Método usado para inicializar as colunas das tabelas de informações completas
     * e resumidas dos clientes e também para inicializar a lista de clientes
     */
    @FXML
    void initialize() {
        tableColumnCpfInfoCompleta.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        tableColumnNomeInfoCompleta.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        tableColumnEnderecoInfoCompleta.setCellValueFactory(new PropertyValueFactory<Cliente, String>("endereco"));
        tableColumnTelefoneInfoCompleta.setCellValueFactory(new PropertyValueFactory<Cliente, Long>("telefone"));
        tableColumnCarteiraMotoristaInfoCompleta
                .setCellValueFactory(new PropertyValueFactory<Cliente, Long>("numeroCarteiraMotorista"));

        tableColumnCpfInfoResumo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        tableColumnNomeInfoResumo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));

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
            alertInterface("ERRO", "Não foi possível voltar para o menu principal", AlertType.ERROR);
        }
    }

    /**
     * Método usado para buscar as informações de um cliente utilizando o cpf
     * 
     * @param event evento de clicar no botão
     */
    @FXML
    void infoCliente(ActionEvent event) {
        /* VERIFICAR SE O CAMPO ESTÁ VAZIO */

        String cpf = textFieldCPF.getText();

        try {
            if (cpf.isEmpty()) {
                throw new EmptyFieldException("Campo CPF vazio");
            }
            if (cpf.length() != 11) {
                throw new InvalidCPFException("CPF inválido");
            }

            long cpfLong = Long.parseLong(cpf);

            /* VERIFICAR SE O CPF JÁ ESTÁ CADASTRADO */
            if (!listaClientes.existe(cpfLong)) {
                throw new ClienteNotFoundException("CPF não existente!");
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

        } catch (NumberFormatException e) {
            alertInterface("ERRO", "Preencha os campos corretamente!", AlertType.ERROR);
        } catch (EmptyFieldException | InvalidCPFException | ClienteNotFoundException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }

    }

    /**
     * Método usado para mostrar as informações completas (cpf, nome, endereco,
     * telefone, carteirademotorista) de todos os clientes
     * 
     * @param event evento de clicar no botão
     */
    @FXML
    void infoFullCliente(ActionEvent event) {
        if (labelCPF.isVisible() || tableViewInfoResumo.isVisible()) {
            labelCPF.setVisible(false);
            labelNome.setVisible(false);
            labelEndereco.setVisible(false);
            labelTelefone.setVisible(false);
            labelCarteiraMotorista.setVisible(false);

            textFieldCPF.setVisible(false);
            textFieldNome.setVisible(false);
            textFieldEndereco.setVisible(false);
            textFieldTelefone.setVisible(false);
            textFieldCarteiraMotorista.setVisible(false);

            btnPesquisar.setVisible(false);
            btnLimpar.setVisible(false);

            tableViewInfoResumo.setVisible(false);

            mostrarEsconderInfoCliente = true;
            mostrarEsconderInfoResumo = true;
        }

        tableViewInfoCompleta.setVisible(mostrarEsconderInfoCompleta);
        mostrarEsconderInfoCompleta = !mostrarEsconderInfoCompleta;

        if (tableViewInfoCompleta.isVisible()) {
            ObservableList<Cliente> observableListClientes = FXCollections.observableArrayList();

            try {
                String[] dadosClientes = listaClientes.getInfo().split("\n");
                for (String dados : dadosClientes) {
                    String[] campos = dados.split(";");
                    long cpf = Long.parseLong(campos[1].split(": ")[1]);

                    Cliente cliente = listaClientes.get(cpf);
                    observableListClientes.add(cliente);
                }
            } catch (NumberFormatException e) {
                alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
            } catch (ClienteNotFoundException | EmptyList e) {
                alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
            }
            tableViewInfoCompleta.setItems(observableListClientes);
        }
    }

    /**
     * Método usado para mostrar as informações resumidas (cpf, nome) de todos os
     * clientes
     * 
     * @param event evento de clicar no botão
     */
    @FXML
    void infoResumoCliente(ActionEvent event) {
        if (labelCPF.isVisible() || tableViewInfoCompleta.isVisible()) {
            labelCPF.setVisible(false);
            labelNome.setVisible(false);
            labelEndereco.setVisible(false);
            labelTelefone.setVisible(false);
            labelCarteiraMotorista.setVisible(false);

            textFieldCPF.setVisible(false);
            textFieldNome.setVisible(false);
            textFieldEndereco.setVisible(false);
            textFieldTelefone.setVisible(false);
            textFieldCarteiraMotorista.setVisible(false);

            btnPesquisar.setVisible(false);
            btnLimpar.setVisible(false);

            tableViewInfoCompleta.setVisible(false);

            mostrarEsconderInfoCliente = true;
            mostrarEsconderInfoCompleta = true;
        }

        tableViewInfoResumo.setVisible(mostrarEsconderInfoResumo);
        mostrarEsconderInfoResumo = !mostrarEsconderInfoResumo;

        if (tableViewInfoResumo.isVisible()) {
            ObservableList<Cliente> observableListClientes = FXCollections.observableArrayList();

            try {
                String[] dadosClientes = listaClientes.getResumoInfo().split("\n");
                for (String dados : dadosClientes) {
                    String[] campos = dados.split(";");
                    long cpf = Long.parseLong(campos[1].split(": ")[1]);

                    Cliente cliente = listaClientes.get(cpf);
                    observableListClientes.add(cliente);
                }

            } catch (ClienteNotFoundException | EmptyList e) {
                alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
            } catch (NumberFormatException e) {
                alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
            }
            tableViewInfoResumo.setItems(observableListClientes);
        }
    }

    /**
     * Método para mostrar/esconder os campos de pesquisa
     * 
     * @param event evento de mostrar/esconder os campos de pesquisa
     */
    @FXML
    void mostrarEsconderCampos(ActionEvent event) {
        if (tableViewInfoCompleta.isVisible() || tableViewInfoResumo.isVisible()) {

            tableViewInfoCompleta.setVisible(false);
            tableViewInfoResumo.setVisible(false);

            mostrarEsconderInfoResumo = true;
            mostrarEsconderInfoCompleta = true;
        }

        limparCampos(null);
        labelCPF.setVisible(mostrarEsconderInfoCliente);
        labelNome.setVisible(mostrarEsconderInfoCliente);
        labelEndereco.setVisible(mostrarEsconderInfoCliente);
        labelTelefone.setVisible(mostrarEsconderInfoCliente);
        labelCarteiraMotorista.setVisible(mostrarEsconderInfoCliente);

        textFieldCPF.setVisible(mostrarEsconderInfoCliente);
        textFieldNome.setVisible(mostrarEsconderInfoCliente);
        textFieldEndereco.setVisible(mostrarEsconderInfoCliente);
        textFieldTelefone.setVisible(mostrarEsconderInfoCliente);
        textFieldCarteiraMotorista.setVisible(mostrarEsconderInfoCliente);

        btnPesquisar.setVisible(mostrarEsconderInfoCliente);
        btnLimpar.setVisible(mostrarEsconderInfoCliente);

        mostrarEsconderInfoCliente = !mostrarEsconderInfoCliente;
    }

    /**
     * Efeito de hover ao passar o mouse no botão de mostrar/esconder os campos de
     * pesquisa
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnMostrarEsconderCampo(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar/esconder os campos de
     * pesquisa
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnEsconderMostrarCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * completas de todos os clientes
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnInfoFullCliente(MouseEvent event) {
        btnInfoFullCliente.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de mostrar todas as informações
     * resumidas de todos os clientes
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnInfoResumoCliente(MouseEvent event) {
        btnInfoResumoCliente.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de limpar os campos de texto
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar/esconder os campos de
     * pesquisa
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnMostrarCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao passar o mouse no botão de pesquisar
     * 
     * @param event evento de hover ao passar o mouse no botão
     */
    @FXML
    void hoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 50;");
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
        textFieldNome.clear();
        textFieldEndereco.clear();
        textFieldTelefone.clear();
        textFieldCarteiraMotorista.clear();
        rootPane.requestFocus();
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todos os clientes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnInfoFullCliente(MouseEvent event) {
        btnInfoFullCliente.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar todas as informações
     * resumidas de todos os clientes
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnInfoResumoCliente(MouseEvent event) {
        btnInfoResumoCliente.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de limpar os campos de texto
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de mostrar/esconder os campos de
     * pesquisa
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnMostrarCampos(MouseEvent event) {
        btnMostrarEsconderCampos.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de pesquisar
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 50;");
    }

    /**
     * Efeito de hover ao tirar o mouse no botão de voltar
     * 
     * @param event evento de hover ao tirar o mouse no botão
     */
    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("views/cliente/pngVoltar.png"));
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
