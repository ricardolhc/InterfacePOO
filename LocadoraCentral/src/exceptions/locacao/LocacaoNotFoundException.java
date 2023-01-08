package exceptions.locacao;

/**
 * A classe LocacaoNotFoundException é responsável por exibir uma mensagem de erro caso a locacao não seja encontrada
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class LocacaoNotFoundException extends NullPointerException {

    /**
     * Construtor da classe LocacaoNotFoundException
     * @param message Mensagem de erro
     */
    public LocacaoNotFoundException(String message) {
        super(message);
    }
}
