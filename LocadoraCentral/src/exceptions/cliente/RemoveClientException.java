package exceptions.cliente;

/**
 * A classe RemoveClientException é responsável por exibir uma mensagem de erro caso o cliente não seja removido do sistema
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class RemoveClientException extends IllegalArgumentException {

    /**
     * Construtor da classe RemoveClientException
     * 
     * @param message Mensagem de erro
     */
    public RemoveClientException(String message) {
        super(message);
    }
}