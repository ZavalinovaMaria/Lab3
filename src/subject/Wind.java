package subject;

import humans.enums.Body;
import humans.Human;
import subject.interfaces.Touch;

public class Wind  implements Touch {
    public Wind(){}

    public void howl(Tree.Branch branch, Tree tree){
        System.out.println("'УУУУУ'-  только дико завывал "+this+" в "+branch.anotherForm()+" вокруг "+tree);
    }
    public void touch(Human human){
        System.out.println(this+" взметнул "+Body.HAIR);
    }
    @Override
    public String toString(){
        return "ветер";
    }

}
