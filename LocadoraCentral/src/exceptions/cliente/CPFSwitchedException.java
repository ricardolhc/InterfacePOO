package exceptions.cliente;

/**
 * A classe CPFSwitchedException é responsável por exibir uma mensagem de erro caso não pesquise o CPF a ser alterado
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class CPFSwitchedException extends IllegalArgumentException {

    /**
     * Construtor da classe CPFSwitchedException
     * @param message Mensagem de erro
     */
    public CPFSwitchedException(String message) {
        super(message);
    }
}