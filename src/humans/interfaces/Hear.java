package humans.interfaces;
import exception.LowSoundException;
import subject.*;

public interface Hear {
    public void hear(Tree tree)throws LowSoundException;
}
