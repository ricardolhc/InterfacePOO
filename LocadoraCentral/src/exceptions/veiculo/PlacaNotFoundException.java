package exceptions.veiculo;

public class PlacaNotFoundException extends NullPointerException {
    public PlacaNotFoundException(String message) {
        super(message);
    }
}
