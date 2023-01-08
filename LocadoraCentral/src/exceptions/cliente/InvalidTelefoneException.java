package exceptions.cliente;

/**
 * A classe InvalidTelefoneException é responsável por exibir uma mensagem de erro caso o telefone do cliente seja inválido
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class InvalidTelefoneException extends IllegalArgumentException {

    /**
     * Construtor da classe InvalidTelefoneException
     * @param message Mensagem de erro
     */
    public InvalidTelefoneException(String message) {
        super(message);
    }
}
