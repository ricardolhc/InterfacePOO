import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControllerMenuLocadora {

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


    @FXML
    void adicionaCliente(ActionEvent event) {
        System.out.println("Adiciona Cliente");
    }

    @FXML
    void adicionaLocacao(ActionEvent event) {
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
        paneMenuClientesFechado.setVisible(true);
        paneMenuClientesExpandido.setVisible(false);
    }

    @FXML
    void fecharMenuLocacoes(ActionEvent event) {
        paneMenuLocacoesFechado.setVisible(true);
        paneMenuLocacoesExpandido.setVisible(false);
    }

    @FXML
    void fecharMenuVeiculos(ActionEvent event) {
        paneMenuVeiculosFechado.setVisible(true);
        paneMenuVeiculosExpandido.setVisible(false);
    }

    @FXML
    void removeCliente(ActionEvent event) {
        System.out.println("Remove Cliente");
    }

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
    }

    @FXML
    void visualizaInformacoesLocacao(ActionEvent event) {
        System.out.println("Visualiza Informacoes Locacao");
    }   

    @FXML
    void visualizaInformacoesVeiculo(ActionEvent event) {
        System.out.println("Visualiza Informacoes Veiculo");
    }

    @FXML
    void hoverAdicionaCliente(MouseEvent event) {
        btnAdicionaCliente.setStyle("-fx-background-color: #2e0513;");
    }

    @FXML
    void hoverAlteraInformacoes(MouseEvent event) {
        btnAlterarInformacoesCliente.setStyle("-fx-background-color: #2e0513;");
    }

    @FXML
    void hoverRemoveCliente(MouseEvent event) {
        btnRemoveCliente.setStyle("-fx-background-color: #2e0513;");
    }

    @FXML
    void hoverVisualizaInformacoes(MouseEvent event) {
        btnVisualizaInformacoesCliente.setStyle("-fx-background-color: #2e0513;");
    }

    @FXML
    void notHoverAdicionaCliente(MouseEvent event) {
        btnAdicionaCliente.setStyle("-fx-background-color: #370617;");
    }

    @FXML
    void notHoverAlteraInformacoes(MouseEvent event) {
        btnAlterarInformacoesCliente.setStyle("-fx-background-color: #370617;");
    }

    @FXML
    void notHoverRemoveCliente(MouseEvent event) {
        btnRemoveCliente.setStyle("-fx-background-color: #370617;");
    }

    @FXML
    void notHoverVisualizaInformacoes(MouseEvent event) {
        btnVisualizaInformacoesCliente.setStyle("-fx-background-color: #370617;");
    }


}
