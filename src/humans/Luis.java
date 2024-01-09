package humans;
import world.Day_time;
import humans.enums.*;
import humans.interfaces.*;
import subject.*;
import world.*;


public class Luis extends Human implements BrainProcesses, Sigh, Fall,Look{
    public Luis( int x, int y) {
        super("Luis",x,y);
    }
    @Override
    public  void  move() {
        if (health >= 0 && getCondition() != Condition.SLEEP) {
            if (getCondition() == Condition.CONFIDENCE) {
                System.out.println(name + " двигался со странной уверенностью, что пока он идет он в безопасности");
            }
            else if (getCondition() == Condition.UNSERTAIN) {
                System.out.println(name +" двигается, не обращая внимания на то, что вокруг");
            }
            else {
                System.out.println(name +"двигается ");
            }
        }
    }

    public void sigh() {
        if (health >= 0 ) {
            if (getCondition() == Condition.UNSERTAIN) {
                System.out.println(name + " вздохнул с облегчением");
            } else {
                System.out.println(name + " вздохнул");
            }
        }
    }

    public void fall() {
        if (health > 0 ) {
            double damage = 30 * getCondition().getReceptivity();
            setHealth(-damage);
            if (damage == 0) {
                System.out.println(name + " не падал ни вперед ни назад");
            } else if (damage == damage) {
                System.out.println(name + " споткнулся ");
            } else {
                System.out.println(name + " упал. Здоровье на данный момент:" + getHealth());
            }
            checkhealth();
        }
    }

    public void look() {
        if (health >= 0 && getCondition() != Condition.SLEEP) {
            if (getHeadPosition() == HeadPosition.STRAIGHT) {
                System.out.println(name + " не смотрел " + HeadPosition.DOWN + " или " + HeadPosition.TO_SIDE);
            }
            if (getHeadPosition() == HeadPosition.DOWN && getPlace() == Place.TOP) {
                System.out.println(name + " не стал оглядываться ");
            }
        }
    }

    @Override
    public void see(Human human,World world) {
        if(health >=0 && getCondition() != Condition.SLEEP){
            if(world.getTime() == Day_time.EVENING || world.getTime() ==Day_time.NIGHT){
        System.out.println(name + " сквозь темноту видит " +"стоящего "+human+" на "+ getPlace());}
        else {
                System.out.println(name+" видит " +human);}}}

    @Override
    public void stand(Tree tree) {
        if (health >= 0 && getCondition() != Condition.SLEEP) {
            System.out.println(name + " остановился на миг, расставвив " + Body.LEGS + " на ненадежных скользких " + tree);
        }
    }
    @Override
    public void think(String thoughts) {
        if (health >= 0) {
            switch (thoughts) {
                case " " -> {
                    setCondition(Condition.SLEEP);
                }
                case "я сплю" -> {
                    setCondition(Condition.GOOD);
                }
            }
        }
    }
}

