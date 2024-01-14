package subject.lights;

import subject.*;
import world.Place;

public  final class NaturalLight extends Light {
    public NaturalLight(String name,int seconds){
        super(name,seconds);
        brightness=10;
        period=1;
    }
    public void shine(Tree.Branch branch){
        lightCharacteristic();
        System.out.printf("%s  %s между спутанных %s на той стороне..%s",name,lightCharacteristic(),branch,Place.BORDER);
        shineToTree(branch);
        System.out.printf("%s cветит так: %s",name,branch.getPerscentOfIllumination());
    }

}
