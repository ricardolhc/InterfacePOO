package exceptions.cliente;

public class RemoveClientException extends IllegalArgumentException {
    public RemoveClientException(String message) {
        super(message);
    }
}