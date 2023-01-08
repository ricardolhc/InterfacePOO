package exceptions.cliente;

public class ClienteNotFoundException extends NullPointerException {
    public ClienteNotFoundException(String message) {
        super(message);
    }
}

