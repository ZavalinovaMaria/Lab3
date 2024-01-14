package subject;

import humans.*;
import subject.interfaces.ApplyDamage;

public class Brushwood implements ApplyDamage {
    public Brushwood(){}
    public  void applyDamage(Human human) {
        double damade = -20*human.getCondition().getReceptivity();
        human.setHealth(damade);
        System.out.printf("Здоровье %s после падения на %s: %s ",human,this,human.getHealth());
        human.checkHealth();
    }

    @Override
    public String toString(){
        return "валежник";
    }


    }



