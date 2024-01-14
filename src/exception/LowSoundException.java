package exception;

public class LowSoundException extends Exception {
    public static int count;

    public LowSoundException(String message) {
        super(message);
        count++;
    }

}
