package ir.dotin.exception;

public class InvalidAmountException extends Exception {
    public InvalidAmountException() {
    }

    public InvalidAmountException(String message) {
        super(message);
    }

    public InvalidAmountException(Throwable cause) {
        super(cause);
    }
}
