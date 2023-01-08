package exceptions.cliente;

/**
 * A classe ClienteNotFoundException é responsável por exibir uma mensagem de erro caso o cliente não seja encontrado
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class ClienteNotFoundException extends NullPointerException {

    /**
     * Construtor da classe ClienteNotFoundException
     * @param message mensagem de erro a ser exibida
     */
    public ClienteNotFoundException(String message) {
        super(message);
    }
}