package humans;
import world.Day_time;
import humans.enums.*;
import humans.interfaces.BrainProcesses;
import subject.*;
import world.*;


public class Luis extends Human implements BrainProcesses  {
    public Luis(String name, int x, int y) {
        super(name,x,y);
    }
    @Override
    public  void  move() {
        if (health >= 0) {
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

    public void sighed() {
        if (health >= 0) {
            if (getCondition() == Condition.UNSERTAIN) {
                System.out.println(name + " вздохнул с облегчением");
            } else {
                System.out.println(name + " вздохнул");
            }
        }
    }

    public void fall() {
        if (health >= 0) {
            double damage = -20 * getCondition().getReceptivity();
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
        if (health >= 0) {
            if (getHeadPosition() == HeadPosition.SRTAIGHT) {
                System.out.println(name + " не смотрел " + HeadPosition.DOWN + " или " + HeadPosition.TO_SIDE);
            }
            if (getHeadPosition() == HeadPosition.DOWN && getPlace() == Place.TOP) {
                System.out.println(name + " не стал оглядываться ");
            }
        }
    }

    @Override
    public void see(Human human,World world) {
        if(health >=0){
            if(world.getTime() == Day_time.EVENING || world.getTime() ==Day_time.NIGHT){
        System.out.println(name + " сквозь темноту видит " +"стоящего "+human+" на "+ getPlace());}
        else {
                System.out.println(name+" видит " +human);}}}

    @Override
    public void stand(Tree tree) {
        if (health >= 0) {
            System.out.println(name + " остановился на миг, расставвив " + Body.LEGS + " на ненадежных скользких " + tree);
        }
    }
}