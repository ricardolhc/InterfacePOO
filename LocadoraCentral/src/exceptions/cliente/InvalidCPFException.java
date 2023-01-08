package exceptions.cliente;

public class InvalidCPFException extends IllegalArgumentException {
    public InvalidCPFException(String message) {
        super(message);
    }
}
