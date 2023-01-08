package exceptions.cliente;

public class CPFSwitchedException extends IllegalArgumentException {
    public CPFSwitchedException(String message) {
        super(message);
    }
}