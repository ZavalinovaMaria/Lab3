package subject;

import humans.enums.*;
import humans.Human;
import subject.interfaces.*;

public class Wind  implements Touch {
    double volume;
    double power;
    public Wind(){
        volume = 0.0;
        power = 1.0;
    }
    public void howl(Tree.Branch branch, Tree tree){
        volume = Math.random();
        System.out.printf("'УУУУУ'-  только дико завывал %s в %s вокруг %s",this,branch.anotherForm(),tree);
    }
    public boolean touch(Human human){
        power +=  Math.random();
        if(power>1.5) {
            Body.HAIR.setAnotherPosition("взъерошенные");
            System.out.printf("%s взметнул %s",this,Body.HAIR);
        return true;}
        else return false;
    }
    @Override
    public String toString(){
        return "ветер";
    }

}
