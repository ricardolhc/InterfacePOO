package exceptions.locacao;

/**
 * A classe LocacaoSwitchedException é responsável por exibir uma mensagem de erro caso não pesquise o ID a ser alterado
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class LocacaoSwitchedException extends IllegalArgumentException {

    /**
     * Construtor da classe LocacaoNotFoundException
     * 
     * @param message Mensagem de erro
     */
    public LocacaoSwitchedException(String message) {
        super(message);
    }
}