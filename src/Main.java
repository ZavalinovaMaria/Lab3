import exception.*;
import humans.*;
import humans.enums.*;
import subject.*;
import subject.lights.*;
import world.*;


public class Main {
    public static void main(String[] args) {
        World world = new World(Day_time.NIGHT);
        Luis luis = new Luis(0,0);

        Dgud dgud = new Dgud(0,0);
        FakeLight flashlight = new FakeLight("Луч фонаря ",6);
        NaturalLight ray =new NaturalLight("Cвет",5);
        Light.Spot spot = new Light.Spot(30,100);

        Brushwood brushwood = new Brushwood();
        Tree trees = new Tree("деревья",30);
        Tree.Trunk trunk = trees.new Trunk("ствол",10);
        Tree.Branch branch = trees.new Branch("ветка",5);
        Wind wind = new Wind();

        world.putPlaces(Place.BORDER,Place.TOP,Place.CENTRE_OF_HEAP,Place.FLASHLIGHT);
        world.putPeople(luis,dgud);

        Way way = new Way();

        Subjects bag = new Subjects("пакет ",4);
        Subjects shovel = new Subjects("лопата ",18);
        Subjects bones= new Subjects("костей ",21);
        Subjects ball = new Subjects("мяч ",16);

        Luis.RightArm arm1 =  luis. new RightArm();
        Luis.LeftArm arm2 =  luis. new LeftArm();
        try{
            luis.takeToArm(arm1,bag,ball);
        }catch (InvalidValueException e){
            System.out.println(e.getMessage());
        }
        try{
            luis.takeToArm(arm2,shovel,bones);
        } catch (InvalidValueException e){
            System.out.println(e.getMessage());
        }

        luis.think("я сплю?");
        luis.think("если я проснусь, больше не пойду к валежнику");
        luis.think("у меня получится забраться");

        dgud.go(Direction.LEFT);
        luis.go(Direction.LEFT);
        flashlight.shine(bones,trees,branch);
        dgud.see(world,spot,dgud,luis);

        dgud.know(way,Place.TOP);
        dgud.walk(way,Place.TOP);
        luis.goAfter(way,luis,dgud);
        luis.look();
        brushwood.applyDamage(luis);
        trunk.makeSound();
        luis.hear(trunk,luis);
        branch.makeSound();
        luis.hear(branch,luis);
        luis.fall();

        wind.howl(branch,trees);
        dgud.stand(trunk);
        luis.see(dgud,world);
        dgud.know(way,Place.PLAIN_1);
        dgud.walk(way,Place.PLAIN_1);

        ray.shine(branch);
        luis.stand(trunk);
        luis.turnHead(HeadPosition.DOWN);
        luis.look();
        luis.replaceSubjects(arm1,arm2);

        luis.turnHead(HeadPosition.TO_SIDE);
        luis.feel(wind.touch(luis));
        luis.see(dgud,world);
        luis.walk(way,Place.PLAIN_1);
        branch.makeSound();
        luis.hear(branch,luis);

        luis.fall();
        luis.sigh();

    }
}
