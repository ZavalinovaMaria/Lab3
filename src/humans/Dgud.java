package humans;

import humans.enums.*;
import subject.*;
import world.*;

public class Dgud extends Human {
    public Dgud(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void go(Direction direction) {
        if (health >= 0) {
            switch (direction) {
                case LEFT -> {
                    setx(getx() - 1);
                    sety(gety());
                    System.out.println(name + " свернул налево от " + place);
                }
                case RIGHT -> {
                    setx(getx() + 1);
                    sety(gety());
                }
                case UP -> {
                    setx(getx());
                    sety(gety() + 1);
                    if (getCondition() == Condition.CONFIDENCE && getHeadPosition() == HeadPosition.STRAIGHT) {
                        System.out.println("Без промедления,даже не осмотревшись " + name + " полез вверх");
                    } else {
                        System.out.println("поднимается ");
                    }
                }
                case DOWN -> {
                    setx(getx());
                    sety(gety() - 1);
                    System.out.println(name + " cпускается с " + place + " постепенно исчезая из виду");
                }
            }
            checkplace();
        }
    }

    @Override
    public void move() {
        if (health >= 0) {
            if (getCondition() == Condition.CONFIDENCE) {
                System.out.println("Он шел, как человек, хорошо знающий, куда ведет путь.");
            }
        }
    }
    @Override
    public void stand(Tree tree) {
        if (health >= 0) {
            System.out.println(name + " стоит на " + getPlace());}}
    @Override
    public void see(Human human, World world) {
        if (health >= 0) {
            if (world.getTime() == Day_time.EVENING || world.getTime() == Day_time.NIGHT) {
                System.out.println(name + " почти ничего не  видит ");
            } else {
                System.out.println(name + " видит " + human);
            }
        }
    }

}





