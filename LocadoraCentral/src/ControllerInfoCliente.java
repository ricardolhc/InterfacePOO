import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lista.ListaClientes;
import lista.Cliente;

public class ControllerInfoCliente {

    @FXML
    private Pane PaneMenuInfoCliente;

    @FXML
    private Pane PaneMenuInfoClienteOFF;

    @FXML
    private Button btnInfoFullCliente;

    @FXML
    private Button btnInfoResumoCliente;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnMostrarCPF;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnEsconderCPF;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField textFieldCPF;

    private static ListaClientes listaClientes;

    @FXML
    void initialize() {
        mascaraCPF(textFieldCPF);
        btnEsconderCPF.setVisible(false);
    }

    @FXML
    void InfoCliente(ActionEvent event) {

    }

    @FXML
    void InfoFullCliente(ActionEvent event) {

    }

    @FXML
    void InfoResumoCliente(ActionEvent event) {

    }

    @FXML
    void hoverBtnInfoFullCliente(MouseEvent event) {
        btnInfoFullCliente.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void hoverBtnInfoResumoCliente(MouseEvent event) {
        btnInfoResumoCliente.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void hoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #686868;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void hoverBtnMostrarCPF(MouseEvent event) {
        btnMostrarCPF.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void hoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void limparCampos(MouseEvent event) {
        textFieldCPF.clear();
        
        rootPane.requestFocus();
    }

    @FXML
    void mostrarCPF(ActionEvent event) {
        PaneMenuInfoCliente.setVisible(true);
        PaneMenuInfoClienteOFF.setVisible(false);
        btnEsconderCPF.setVisible(true);
        btnMostrarCPF.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void esconderCPF(ActionEvent event) {
        PaneMenuInfoCliente.setVisible(false);
        PaneMenuInfoClienteOFF.setVisible(true);
        btnEsconderCPF.setVisible(false);
    }

    @FXML
    void hoverBtnEsconderCPF(MouseEvent event) {
        btnMostrarCPF.setStyle("-fx-background-color: #245823;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void notHoverBtnEsconderCPF(MouseEvent event) {
        btnEsconderCPF.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void notHoverBtnInfoFullCliente(MouseEvent event) {
        btnInfoFullCliente.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void notHoverBtnInfoResumoCliente(MouseEvent event) {
        btnInfoResumoCliente.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void notHoverBtnLimpar(MouseEvent event) {
        btnLimpar.setStyle("-fx-background-color: #747474;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void notHoverBtnMostrarCPF(MouseEvent event) {
        btnMostrarCPF.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void notHoverBtnPesquisar(MouseEvent event) {
        btnPesquisar.setStyle("-fx-background-color: #2b6b2a;-fx-cursor: hand; -fx-background-radius: 10;");
    }

    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("pngVoltar.png"));
    }

    @FXML
    void voltarParaPrincipal(MouseEvent event) {
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("viewIndex.fxml"));
            Pane cmdPane = (Pane) fxmlLoader.load();

            rootPane.getChildren().clear();
            rootPane.getChildren().add(cmdPane);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void mascaraCPF(TextField textField) {

        textField.setOnKeyTyped((KeyEvent event) -> {
            if ("0123456789".contains(event.getCharacter()) == false) {
                event.consume();
            }

            if (event.getCharacter().trim().length() == 0) { // apagando

                if (textField.getText().length() == 4) {
                    textField.setText(textField.getText().substring(0, 3));
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 8) {
                    textField.setText(textField.getText().substring(0, 7));
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 12) {
                    textField.setText(textField.getText().substring(0, 11));
                    textField.positionCaret(textField.getText().length());
                }

            } else {

                if (textField.getText().length() == 14)
                    event.consume();

                if (textField.getText().length() == 3) {
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 7) {
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 11) {
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                }

            }
        });

        textField.setOnKeyReleased((KeyEvent evt) -> {

            if (!textField.getText().matches("\\d.-*")) {
                textField.setText(textField.getText().replaceAll("[^\\d.-]", ""));
                textField.positionCaret(textField.getText().length());
            }
        });

    }

}
