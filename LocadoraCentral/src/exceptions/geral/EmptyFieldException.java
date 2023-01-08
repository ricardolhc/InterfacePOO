package exceptions.geral;

/**
 * A classe EmptyFieldException é responsável por exibir uma mensagem de erro caso o campo esteja vazio
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class EmptyFieldException extends NullPointerException {

    /**
     * Construtor da classe EmptyFieldException
     * @param message Mensagem de erro
     */
    public EmptyFieldException(String message) {
        super(message);
    }
}