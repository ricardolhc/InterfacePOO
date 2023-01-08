package exceptions.locacao;

/**
 * A classe RemoveLocacaoException é responsável por exibir uma mensagem de erro caso a locação não seja removida 
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class RemoveLocacaoException extends Exception {

    /**
     * Construtor da classe RemoveLocacaoException
     * 
     * @param message Mensagem de erro
     */
    public RemoveLocacaoException(String message) {
        super(message);
    }
}
