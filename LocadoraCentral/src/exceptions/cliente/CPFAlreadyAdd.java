package exceptions.cliente;

/**
 * A classe CPFAlreadyADD é responsável por exibir uma mensagem de erro caso o cliente ja tenha sido adicionado no sistema
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class CPFAlreadyAdd extends IllegalArgumentException {

    /**
     * Construtor da classe CPFAlreadyAdd
     * @param message Mensagem de erro a ser exibida
     */
    public CPFAlreadyAdd(String message) {
        super(message);
    }
}
