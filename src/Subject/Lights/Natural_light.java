package Subject.Lights;

import Subject.Lights.Light;
import Subject.Tree.Vetki;
import World.Place;

public class Natural_light extends Light {
    public Natural_light(String name){
        super(name);
        brightness=1000;
        T=1;
    }
    public void shine(Vetki v){
        System.out.println(name+" мелькал между спутанных "+v +" на той стороне.."+ Place.BORDER);
    }


}
