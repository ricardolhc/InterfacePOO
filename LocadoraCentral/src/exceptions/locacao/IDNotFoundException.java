package exceptions.locacao;

public class IDNotFoundException extends NullPointerException {
    public IDNotFoundException(String message) {
        super(message);
    }
}
