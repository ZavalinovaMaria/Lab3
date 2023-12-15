import Humanity.*;
import Humanity.Enums.Body;
import Humanity.Enums.Condition;
import Humanity.Enums.Direction;
import Humanity.Enums.HeadPosition;
import Subject.*;
import Subject.Lights.Fake_light;
import Subject.Lights.Natural_light;
import Subject.Tree.Stvol;
import Subject.Tree.Trees;
import Subject.Tree.Vetki;
import World.*;


public class Main {
    public static void main(String[] args) {
        World world = new World();
        Luis l = new Luis("Luis",0,0);
        Dgud d = new Dgud("Dgud",0,0);
        Fake_light luchfonara = new Fake_light("Луч фонаря ");
        Natural_light luch =new Natural_light("Cвет");
        Vetki vetka = new Vetki("ветки");
        Valeshnik valeshnik = new Valeshnik();
        Bones bones =new Bones();
        Trees trees = new Trees("деревья");
        Stvol stvol = new Stvol("ствол");
        Patno patno = new Patno(30,100);
        Author author = new Author();
        Wind wind = new Wind();
        Pakagee pakagee = new Pakagee(Body.R_ARM);
        Lopata lopata =new Lopata(Body.L_ARM);
        world.putPeople(l,d);

        l.thinking("Это сон, я так и не проснулся после дневного праздничного обеда");
        l.decides("Ни за что больше не подойду к этому валежнику.");
        d.go(Direction.LEFT);
        l.go(Direction.LEFT);

        luchfonara.shine(bones,trees,vetka);
        l.chekplace();
        d.chekplace();
        patno.newview(l,d);

        d.go(Direction.RIGHT);
        d.setCondition(Condition.CONFIDENCE);

        d.go(Direction.UP);
        d.ConfidenceMan();
        l.goAfter(l,d);

        l.look();
        l.setCondition(Condition.CONFIDENCE);
        l.ConfidenceMan();
        author.comment("Это, конечно, было так же глупо, как верить в охранительную силу медальона или крестика. Но это действовало.");
        valeshnik.applyDamage(l);
        vetka.sound(l);
        stvol.sound(l);
        l.fall();
        wind.howl(vetka,trees);

        d.stand(stvol);
        l.see(d);
        d.go(Direction.DOWN);
        luch.shine(vetka);
        author.comment("Да, это была именно граница — зачем это скрывать?");

        l.chekplace();
        l.stand(stvol);
        l.turnHead(HeadPosition.DOWN);
        l.look();
        l.exchange(lopata,pakagee);

        l.turnHead(HeadPosition.TO_SIDE);
        l.feel();
        wind.touch(l);
        l.thinking("Холодный, чистый... всегда неизменный.");
        l.go(Direction.DOWN);
        l.setCondition(Condition.INATTENTIVE);
        vetka.sound(l);
        l.WarinesseMan();
        l.fall();
        l.sighed();
    }
}
