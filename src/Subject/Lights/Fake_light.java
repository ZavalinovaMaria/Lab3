package Subject.Lights;

import Subject.Bones;
import Subject.Lights.Light;
import Subject.Tree.Trees;
import Subject.Tree.Vetki;

public class Fake_light extends Light {
    public Fake_light(String name){
        super(name);
        brightness=100;
        T=0;
    }
    public void shine(Bones b, Trees t, Vetki v){
        System.out.println(name+" ярко oветил груду..(" +b+"?).. поваленных "+ t + " и " + v);
    }

}
