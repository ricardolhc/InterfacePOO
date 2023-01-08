package exceptions.cliente;

public class CPFAlreadyAdd extends IllegalArgumentException {
    public CPFAlreadyAdd(String message) {
        super(message);
    }
}
