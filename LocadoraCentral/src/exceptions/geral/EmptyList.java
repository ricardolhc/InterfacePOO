package exceptions.geral;

/**
 * A classe EmptyList é responsável por exibir uma mensagem de erro caso a lista esteja vazia
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class EmptyList extends NullPointerException {

    /**
     * Construtor da classe EmptyList
     * @param message Mensagem de erro
     */ 
    public EmptyList(String message) {
        super(message);
    }
}
