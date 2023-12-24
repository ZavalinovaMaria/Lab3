import exception.*;
import humans.*;
import humans.enums.*;
import subject.*;
import subject.lights.*;
import world.*;


public class Main {
    public static void main(String[] args) {
        World world = new World(Day_time.NIGHT);
        Luis l = new Luis("Luis",0,0);

        Dgud d = new Dgud("Dgud",0,0);
        Fake_light flashlight = new Fake_light("Луч фонаря ");
        Natural_light ray =new Natural_light("Cвет");
        Light.Spot spot = new Light.Spot(30,100);

        Brushwood brushwood = new Brushwood();
        Tree trees = new Tree("деревья",30);
        Tree.Trunk trunk = trees.new Trunk("ствол",10);
        Tree.Branch branch = trees.new Branch("ветка",5);
        Author author = new Author();
        Wind wind = new Wind();

        world.putPlaces(Place.BORDER,Place.TOP,Place.CENTRE_OF_HEAP,Place.FLASHLIGHT);
        world.putPeople(l,d);

        Subjects bag = new Subjects("пакет ");
        Subjects shovel = new Subjects("лопата ");
        Subjects bones= new Subjects("костей ");

        Luis.RightArm arm1 =  l. new RightArm();
        Luis.LeftArm arm2 =  l. new LeftArm();
        l.takeToArm(arm1,bag);
        l.takeToArm(arm2,shovel);

        l.thinking("Это сон, я так и не проснулся после дневного праздничного обеда");
        l.decides("Ни за что больше не подойду к этому валежнику");
        d.go(Direction.LEFT);
        l.go(Direction.LEFT);


        flashlight.shine(bones,trees,branch);


        spot.newView(l,d);

        d.go(Direction.RIGHT);
        d.setCondition(Condition.CONFIDENCE);
        d.go(Direction.UP);
        d.move();
        l.goAfter(l,d);
        l.look();
        l.setCondition(Condition.CONFIDENCE);
        l.move();
        author.comment("Это, конечно, было так же глупо, как верить в охранительную силу медальона или крестика. Но это действовало.");
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
        author.comment("Да, это была именно граница — зачем это скрывать?");
        l.checkplace();
        l.stand(trunk);
        l.turnHead(HeadPosition.DOWN);
        l.look();
        l.replaceSubjects(arm1,arm2);


        l.turnHead(HeadPosition.TO_SIDE);
        l.feel();
        wind.touch(l);
        l.thinking("Холодный, чистый... всегда неизменный.");
        l.setCondition(Condition.UNSERTAIN);
        l.go(Direction.DOWN);
        branch.makeSound();
       try{
           l.hear(branch);}
       catch (LowSoundException e){
           System.out.println(e.getMessage());
       }
        l.move();
        l.fall();
        l.sighed();

    }
}
