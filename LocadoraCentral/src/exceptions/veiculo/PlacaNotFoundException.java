package exceptions.veiculo;

/**
 * A classe PlacaNotFoundException é responsável por exibir uma mensagem de erro caso a placa não seja encontrada
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class PlacaNotFoundException extends NullPointerException {

    /**
     * Construtor da classe PlacaNotFoundException
     * @param message Mensagem de erro
     */
    public PlacaNotFoundException(String message) {
        super(message);
    }
}
