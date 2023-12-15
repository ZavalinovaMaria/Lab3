package Subject.Tree;

import Humanity.Enums.Condition;
import Humanity.Human;

public class Stvol extends Trees {
    public Stvol(String title){
        super(title);
    }
    @Override
    public void sound(Human human) {
        if (human.getCondition() == Condition.GOOD) {
            System.out.println("скр скр скр ");
        } else {
            System.out.println("Не слышно скрипа стволов ");
        }


    }
    @Override
    public String toString() {
        return "стволах";
    }
}
