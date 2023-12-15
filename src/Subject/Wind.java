package Subject;

import Humanity.Enums.Body;
import Humanity.Human;
import Subject.Tree.Trees;
import Subject.Tree.Vetki;

public class Wind {
    public Wind(){}

    public void howl(Vetki vetki,Trees tree){
        System.out.println("'УУУУУ'-  только дико завывал "+toString()+" в "+vetki.anotherForm()+" вокруг "+tree);
    }
    public void touch(Human human){
        System.out.println(toString()+" взметнул "+ Body.HAIR);
    }
    @Override
    public String toString(){
        return "ветер";
    }

}
