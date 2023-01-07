package exceptions.cliente;

public class CPFNotFoundException extends Exception {
    public CPFNotFoundException(String message) {
        super(message);
    }
}