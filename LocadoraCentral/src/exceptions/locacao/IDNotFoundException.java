package exceptions.locacao;

/**
 * A classe IDNotFoundException é responsável por exibir uma mensagem de erro caso o ID não seja encontrado
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class IDNotFoundException extends NullPointerException {

    /**
     * Construtor da classe IDNotFoundException
     * @param message Mensagem de erro
     */
    public IDNotFoundException(String message) {
        super(message);
    }
}
