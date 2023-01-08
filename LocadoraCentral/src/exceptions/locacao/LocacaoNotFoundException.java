package exceptions.locacao;

public class LocacaoNotFoundException extends NullPointerException {
    public LocacaoNotFoundException(String message) {
        super(message);
    }
}

