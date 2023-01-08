package exceptions.cliente;

public class InvalidTelefoneException extends IllegalArgumentException {
    public InvalidTelefoneException(String message) {
        super(message);
    }
}
