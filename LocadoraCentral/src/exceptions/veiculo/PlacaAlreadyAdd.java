package exceptions.veiculo;

public class PlacaAlreadyAdd extends IllegalArgumentException {
    public PlacaAlreadyAdd(String message) {
        super(message);
    }
}
