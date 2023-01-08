package exceptions.veiculo;

/**
 * A classe PlacaSwitchedException é responsável por exibir uma mensagem de erro caso não pesquise a placa a ser alterada
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class PlacaSwitchedException extends IllegalArgumentException {

    /**
     * Construtor da classe PlacaSwitchedException
     * @param message Mensagem de erro
     */
    public PlacaSwitchedException(String message) {
        super(message);
    }
}