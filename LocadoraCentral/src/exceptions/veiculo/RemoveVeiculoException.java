package exceptions.veiculo;

/**
 * A classe RemoveVeiculoException é responsável por exibir uma mensagem de erro caso o veiculo não seja removido 
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class RemoveVeiculoException extends IllegalArgumentException {

    /**
     * Construtor da classe RemoveVeiculoException
     * 
     * @param message Mensagem de erro
     */
    public RemoveVeiculoException(String message) {
        super(message);
    }
}
