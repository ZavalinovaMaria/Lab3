package Subject.Tree;

import Humanity.Enums.Condition;
import Humanity.*;

public class Vetki extends Trees {

    public Vetki(String title) {
        super(title);
    }


    @Override
    public void sound(Human human) {
        if (human.getCondition() == Condition.INATTENTIVE) {
            System.out.println("Под ногой "+human.name + " хрустнула толстая "+ anotherForm2());

        } else {
            System.out.println("Cухие ветки не 'стреляют ' под ногами ");
        }

    }





    @Override
    public String toString() {
        return "веток";
    }
    public String anotherForm(){
        return "ветвях";
    }
    public String anotherForm2(){
        return "ветка";
    }

}



