package exception;

public class HumanWithoutPlaceException extends RuntimeException {
    public HumanWithoutPlaceException(String message,Throwable cause){
        super(message,cause);
    }
}
