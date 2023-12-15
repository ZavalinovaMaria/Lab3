package Humanity;

import Subject.Tree.Stvol;
import Humanity.Enums.*;

public class Dgud extends Human {
    public Dgud(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void go(Direction direction) {
        switch (direction) {
            case LEFT -> {
                setx(getx() - 1);
                sety(gety());
                System.out.print(name + " свернул налево от " + place);
            }
            case RIGHT -> {
                setx(getx() + 1);
                sety(gety());
            }
            case UP -> {
                setx(getx());
                sety(gety() + 1);
                if (getCondition() == Condition.CONFIDENCE && getHeadPosition()== HeadPosition.SRTAIGHT) {
                    System.out.print("Без промедления,даже не осмотревшись " + name + " полез");
                } else {
                    System.out.print("поднимается ");
                }
            }
            case DOWN -> {
                setx(getx());
                sety(gety() - 1);
                System.out.println(name+" cпускается с " + place+ " постепенно исчезая из виду");
            }
        }
        location();
    }

    @Override
    public void ConfidenceMan() {
        if (getCondition() == Condition.CONFIDENCE) {
            System.out.println(" Он шел, как человек, хорошо знающий, куда ведет путь.");
        }
    }
    @Override
    public void stand(Stvol stvol) {
        System.out.println(name + " стоит на " + getPlace());
    }
    @Override
    public void see(Human human) {
        System.out.println(name + " видит " + getPlace());}
    @Override
    public String toString(){
        return name;
    }

}





