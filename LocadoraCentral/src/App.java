import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/viewIndex.fxml"));
            Parent root = fxmlLoader.load();
            Scene tela = new Scene(root);

            ListaClientes listaClientes = new ListaClientes();
            ListaVeiculos listaVeiculos = new ListaVeiculos();
            ListaLocacoes listaLocacoes = new ListaLocacoes();

            ControllerMenuLocadora controller = fxmlLoader.getController();
            controller.setListaClientes(listaClientes);
            controller.setListaVeiculos(listaVeiculos);
            controller.setListaLocacoes(listaLocacoes);

            primaryStage.getIcons().add(new Image("images/pngIcon.png"));
            primaryStage.setTitle("Locadora Central");
            primaryStage.setScene(tela);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
