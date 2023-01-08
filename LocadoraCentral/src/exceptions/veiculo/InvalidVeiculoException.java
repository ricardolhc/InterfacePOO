package exceptions.veiculo;

/**
 * A classe InvalidVeiculoException é responsável por exibir uma mensagem de erro caso o tipo de veículo seja inválido
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class InvalidVeiculoException extends IllegalArgumentException {

    /**
     * @param message Mensagem de erro
     */
    public InvalidVeiculoException(String message) {
        super(message);
    }
}
