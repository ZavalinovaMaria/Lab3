package humans.interfaces;
import humans.enums.Direction;
import world.*;


public interface Go {
    void go(Direction direction);
    void walk(Way way, Place place);

}
