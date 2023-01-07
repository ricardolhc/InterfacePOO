package exceptions.geral;

public class EmptyFieldException extends NullPointerException {
    public EmptyFieldException(String message) {
        super(message);
    }
}