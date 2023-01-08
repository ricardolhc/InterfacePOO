package exceptions.locacao;

public class DateDifferenceException extends IllegalArgumentException {
    public DateDifferenceException(String message) {
        super(message);
    }
}
