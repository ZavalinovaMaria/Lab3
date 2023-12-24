package subject.lights;

import subject.*;

public final class  Fake_light extends Light {
    public Fake_light(String name){
        super(name);
        brightness=1000;
        T=0;
    }
    public void shine(Subjects b, Tree t, Tree.Branch v){
        System.out.printf("%s %s на груду..(%s?).. поваленных %s и %s ",name,lightCharacteristic(),b,t,v);
    }

}
