package Subject;
import Humanity.*;
import Humanity.Enums.Body;
import Humanity.Enums.Condition;

public class Valeshnik {
    public Valeshnik(){}
    public  void applyDamage(Human human) {
        if (human.getCondition() == Condition.GOOD) {
            human.setHealth(10);
            System.out.println(toString() + "поранил" + Body.LEGS + human + "Здоровье на данный момент:" + human.getHealth());
        } else {
            System.out.println("Валежник не причиняет вреда");
        }
        human.be_health();
    }

    public String crush(){
        return ("хр хр хр хр ");
    }



    @Override
    public String toString(){
        return "валежник";
    }


    }



