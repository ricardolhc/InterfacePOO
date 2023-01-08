package exceptions.cliente;

/**
 * A classe InvalidCPFException é responsável por exibir uma mensagem de erro caso o CPF seja inválido
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class InvalidCPFException extends IllegalArgumentException {

    /**
     * Construtor da classe InvalidCPFException
     * 
     * @param message Mensagem de erro
     */
    public InvalidCPFException(String message) {
        super(message);
    }
}
