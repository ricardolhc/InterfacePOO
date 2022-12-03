

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lista.ListaClientes;
import lista.ListaLocacoes;
import lista.ListaVeiculos;

import lista.Cliente;

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

    private ListaClientes listaClientes;

    private ListaClientes listaClientes2;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    

    @FXML
    void adicionaCliente(ActionEvent event) {

        try {

            AnchorPane anchorPaneAdicionaCliente = FXMLLoader.load(getClass().getResource("viewAdicionaCliente.fxml"));
            rootPane.getChildren().setAll(anchorPaneAdicionaCliente);

            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewAdicionaCliente.fxml"));
            ControllerAdicionaCliente controllerAdicionaCliente = loader.<ControllerAdicionaCliente>getController();
            controllerAdicionaCliente.initListaClientes(listaClientes);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    @FXML
    void removeCliente(ActionEvent event) {

        try {

            AnchorPane anchorPaneRemoveCliente = FXMLLoader.load(getClass().getResource("viewRemoveCliente.fxml"));
            rootPane.getChildren().setAll(anchorPaneRemoveCliente);

            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewRemoveCliente.fxml"));
            //ControllerRemoveCliente controllerRemoveCliente = loader.<ControllerRemoveCliente>getController();
            //controllerRemoveCliente.initListaClientes(listaClientes);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    @FXML
    void adicionaLocacao(ActionEvent event) {
        System.out.println(listaClientes.get(0).toString());
        System.out.println("Adiciona Locacao");
    }

    @FXML
    void adicionaVeiculo(ActionEvent event) {
        System.out.println("Adiciona Veiculo");
    }

    @FXML
    void alteraInformacoesLocacao(ActionEvent event) {
        System.out.println("Altera Informacoes Locacao");
    }

    @FXML
    void alteraInformacoesVeiculo(ActionEvent event) {
        System.out.println("Altera Informacoes Veiculo");
    }

    @FXML
    void alterarInformacoesCliente(ActionEvent event) {
        System.out.println("Altera Informacoes Cliente");
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
    void fecharMenuClientes(ActionEvent event) {
        paneMenuClientesExpandido.setVisible(false);
        paneMenuClientesFechado.setVisible(true);
    }

    @FXML
    void fecharMenuLocacoes(ActionEvent event) {
        paneMenuLocacoesExpandido.setVisible(false);
        paneMenuLocacoesFechado.setVisible(true);
    }

    @FXML
    void fecharMenuVeiculos(ActionEvent event) {
        paneMenuVeiculosExpandido.setVisible(false);
        paneMenuVeiculosFechado.setVisible(true);
    }




    @FXML
    void hoverBtnClienteFechado(MouseEvent event) {
        btnClientesExpandir.setStyle("-fx-background-color: #2e0513; -fx-cursor: hand;");
        paneMenuClientesFechado.setStyle("-fx-background-color: #2e0513;");
    }

    @FXML
    void notHoverBtnClienteFechado(MouseEvent event) {
        btnClientesExpandir.setStyle("-fx-background-color: #370617;");
        paneMenuClientesFechado.setStyle("-fx-background-color: #370617;");
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
        btnVeiculosExpandir.setStyle("-fx-background-color: #3e081a; -fx-cursor: hand;");
        paneMenuVeiculosFechado.setStyle("-fx-background-color: #3e081a;");
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
        btnLocacoesExpandir.setStyle("-fx-background-color: #500922; -fx-cursor: hand;");
        paneMenuLocacoesFechado.setStyle("-fx-background-color: #500922;");
    }

    @FXML
    void notHoverBtnLocacaoFechado(MouseEvent event) {
        btnLocacoesExpandir.setStyle("-fx-background-color: #5c0a27;");
        paneMenuLocacoesFechado.setStyle("-fx-background-color: #5c0a27;");
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

    // @FXML
    // void removeCliente(ActionEvent event) {
    //     System.out.println("Remove Cliente");
    // }

    @FXML
    void removeLocacao(ActionEvent event) {
        System.out.println("Remove Locacao");
    }

    @FXML
    void removeVeiculo(ActionEvent event) {
        System.out.println("Remove Veiculo");
    }

    @FXML
    void visualizaInformacoesCliente(ActionEvent event) {
        System.out.println("Visualiza Informacoes Cliente");

        try {

            AnchorPane anchorPaneInfoCliente = FXMLLoader.load(getClass().getResource("viewInfoCliente.fxml"));
            rootPane.getChildren().setAll(anchorPaneInfoCliente);

            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewInfoCliente.fxml"));
            //ControllerRemoveCliente controllerRemoveCliente = loader.<ControllerRemoveCliente>getController();
            //controllerRemoveCliente.initListaClientes(listaClientes);
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
        System.out.println("Visualiza Informacoes Veiculo");
    }

    public void setListaClientes(ListaClientes listaClientes) {
        this.listaClientes = listaClientes;
    }


}
