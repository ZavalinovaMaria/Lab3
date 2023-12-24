package subject;

import humans.enums.Body;
import humans.Human;
import subject.*;

public class Wind {
    public Wind(){}

    public void howl(Tree.Branch branch, Tree tree){
        System.out.println("'УУУУУ'-  только дико завывал "+toString()+" в "+branch.anotherForm()+" вокруг "+tree);
    }
    public void touch(Human human){
        System.out.println(toString()+" взметнул "+Body.HAIR);
    }
    @Override
    public String toString(){
        return "ветер";
    }

}
