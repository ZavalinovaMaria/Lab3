package subject;
import humans.*;

public class Brushwood {
    public Brushwood(){}
    public  void applyDamage(Human human) {
        double i = -20*human.getCondition().getReceptivity();
        human.setHealth(i);
        System.out.println("Здоровье "+human.getName() +" после падения на "+toString()+": "+human.getHealth());
        human.checkhealth();
    }

    @Override
    public String toString(){
        return "валежник";
    }


    }


