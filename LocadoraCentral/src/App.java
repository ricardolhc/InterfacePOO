import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lista.Cliente;
import lista.ListaClientes;
import lista.ListaLocacoes;
import lista.ListaVeiculos;

public class App extends Application {
    public static void main(String[] args) {
        
        
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("viewIndex.fxml"));
            Parent root = fxmlLoader.load();
            Scene tela = new Scene(root);

            ListaClientes listaClientes = new ListaClientes();
            listaClientes.add(new Cliente("00000000", "João", 123456789, "Rua 1", 123456789));

            ControllerMenuLocadora controller = fxmlLoader.getController();
            controller.setListaClientes(listaClientes);

            primaryStage.getIcons().add(new Image("pngIcon.png"));
            primaryStage.setTitle("Locadora Central");
            primaryStage.setScene(tela);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
