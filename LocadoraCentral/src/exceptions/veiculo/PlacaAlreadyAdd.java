package exceptions.veiculo;

/**
 * A classe PlacaAlreadyAdd é responsável por exibir uma mensagem de erro caso a placa já tenha sido adicionada
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class PlacaAlreadyAdd extends IllegalArgumentException {

    /**
     * Construtor da classe PlacaAlreadyAdd
     * @param message Mensagem de erro
     */
    public PlacaAlreadyAdd(String message) {
        super(message);
    }
}
