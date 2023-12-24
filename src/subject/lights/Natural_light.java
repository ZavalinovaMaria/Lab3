package subject.lights;

import subject.*;
import world.Place;

public  final class Natural_light extends Light {
    public Natural_light(String name){
        super(name);
        brightness=100;
        T=1;
    }
    public void shine(Tree.Branch branch){
        lightCharacteristic();
        System.out.printf("%s %s  между спутанных %s на той стороне..%s",name,lightCharacteristic(),branch,Place.BORDER);
    }

}
