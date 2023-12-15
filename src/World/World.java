package World;
import java.util.ArrayList;
import Humanity.*;

public class World {
    public ArrayList<Place> places = new ArrayList<>();
    private final ArrayList<Human> humans;
    {humans = new ArrayList<>();}
    Time time = new Time(Day_time.NIGHT);

    public final class Time {
        private Day_time time;
        public Time(Day_time time) {
            this.time = time;
            System.out.println("Время суток "+ time);
        }
        public void setTime(Day_time time) {
            this.time = time;
        }
    }
    public void putPeople(Human... h) {
        for (Human human : h) {
            humans.add(human);
            human.chekplace();
        }
    }
    @Override
    public String toString() {
        return String.format ("Добро пожаловать в новый мир. Местное время суток:"+ time.toString());
    }

}




