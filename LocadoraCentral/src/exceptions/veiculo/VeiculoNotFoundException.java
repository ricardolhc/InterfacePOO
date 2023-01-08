package exceptions.veiculo;


/**
 * A classe VeiculoNotFoundException é responsável por exibir uma mensagem de erro caso o veiculo não seja encontrado
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class VeiculoNotFoundException extends NullPointerException {

    /**
     * Construtor da classe VeiculoNotFoundException
     * @param message  Mensagem de erro
     */
    public VeiculoNotFoundException(String message) {
        super(message);
    }
}

