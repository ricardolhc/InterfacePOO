package exceptions.veiculo;

public class VeiculoNotFoundException extends NullPointerException {
    public VeiculoNotFoundException(String message) {
        super(message);
    }
}

