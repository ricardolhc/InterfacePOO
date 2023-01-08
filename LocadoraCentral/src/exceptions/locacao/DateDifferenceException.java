package exceptions.locacao;

/**
 * A classe DateDifferenceException é responsável por exibir uma mensagem de erro caso a data de devolução seja menor que a data de locação
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class DateDifferenceException extends IllegalArgumentException {

    /**
     * Construtor da classe DateDifferenceException
     * 
     * @param message Mensagem de erro
     */
    public DateDifferenceException(String message) {
        super(message);
    }
}
