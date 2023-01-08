package exceptions.veiculo;

public class InvalidVeiculoException extends IllegalArgumentException {
    public InvalidVeiculoException(String message) {
        super(message);
    }
}
