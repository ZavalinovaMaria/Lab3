import exception.*;
import humans.*;
import humans.enums.*;
import humans.Human;
import subject.*;
import subject.lights.*;
import world.*;


public class Main {
    public static void main(String[] args) {
        World world = new World(Day_time.NIGHT);
        Luis l = new Luis(0,0);

        Dgud d = new Dgud(0,0);
        Fake_light flashlight = new Fake_light("Луч фонаря ");
        Natural_light ray =new Natural_light("Cвет");
        Light.Spot spot = new Light.Spot(30,100);

        Brushwood brushwood = new Brushwood();
        Tree trees = new Tree("деревья",30);
        Tree.Trunk trunk = trees.new Trunk("ствол",10);
        Tree.Branch branch = trees.new Branch("ветка",5);
        Wind wind = new Wind();

        world.putPlaces(Place.BORDER,Place.TOP,Place.CENTRE_OF_HEAP,Place.FLASHLIGHT);
        world.putPeople(l,d);


        Subjects bag = new Subjects("пакет ",4);
        Subjects shovel = new Subjects("лопата ",18);
        Subjects bones= new Subjects("костей ",21);
        Subjects ball = new Subjects("мяч ",16);

        Luis.RightArm arm1 =  l. new RightArm();
        Luis.LeftArm arm2 =  l. new LeftArm();
        try{
            l.takeToArm(arm1,bag,ball);
        }catch (InvalidValueException e){
            System.out.println(e.getMessage());
        }
        try{
            l.takeToArm(arm2,shovel,bones);
        } catch (InvalidValueException e){
            System.out.println(e.getMessage());
        }

        l.think("я сплю");
        l.think("я смогу сделать это");
        d.go(Direction.LEFT);
        l.go(Direction.LEFT);

        flashlight.shine(bones,trees,branch);
        spot.newView(l,d);
        d.go(Direction.RIGHT);

        d.wantToGo(Place.TOP);
        d.go(Direction.UP);
        d.move();
        l.goAfter(l,d);
        l.look();
        l.wantToGo(Place.TOP);
        l.move();
        brushwood.applyDamage(l);
        trunk.makeSound();
        try{
            l.hear(trunk);}
        catch (LowSoundException e){
            System.out.println(e.getMessage());
        }
        branch.makeSound();
        try{
            l.hear(branch);}
        catch (LowSoundException e){
            System.out.println(e.getMessage());
        }
        l.fall();
        wind.howl(branch,trees);

        d.stand(trunk);
        l.see(d,world);
        d.go(Direction.DOWN);
        ray.shine(branch);
        l.checkplace();
        l.stand(trunk);
        l.turnHead(HeadPosition.DOWN);
        l.look();
        l.replaceSubjects(arm1,arm2);

        l.turnHead(HeadPosition.TO_SIDE);
        l.feel();
        wind.touch(l);
        l.wantToGo(Place.CENTRE_OF_HEAP);
        l.go(Direction.DOWN);
        branch.makeSound();
       try{
           l.hear(branch);}
       catch (LowSoundException e){
           System.out.println(e.getMessage());
       }
        l.move();
        l.fall();
        l.sigh();

    }
}
