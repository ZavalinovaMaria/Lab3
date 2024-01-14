package humans;
import world.Day_time;
import humans.enums.*;
import humans.interfaces.*;
import subject.*;
import world.*;


public class Luis extends Human implements  Sigh, Fall, Look, GoAfter {


    public Luis(int x, int y) {
        super("Luis", x, y);
    }


    public void goAfter(Way way,Human follower,Human leader) {
        if (health >= 0 && getCondition() != Condition.SLEEP) {
            if (leader.getKnowledge()) {
                follower.setCondition(Condition.CONFIDENCE);
                System.out.printf("%s двигался  c уверенностью, что пока он идет за %s он в безопасности",follower,leader);}
            if (!follower.equals(leader) && follower.hashCode() != leader.hashCode()) {
                follower.walk(way,leader.getPlace());}
            else{
                System.out.printf("%s и %s  находятся в одном месте",follower,leader);
            }
        }
    }

    public void sigh() {
        if (health >= 0) {
            Body.CHEST.setAnotherPosition("поднялась");
            Body.CHEST.setAnotherPosition(Body.CHEST.getDefaultPosition());
            if (getCondition() == Condition.UNSERTAIN) {
                System.out.printf("%s вздохнул с облегчением",name);

            } else {
                System.out.printf( "%s вздохнул", name);
            }
        }
    }
    @Override
    public void walk(Way way, Place place) {
        if (health >= 0 && getCondition() != Condition.SLEEP) {
            int startIndex = 0;
            switch (place) {
                case TOP -> {
                    if (getPlace() == Place.CENTRE_OF_HEAP) {
                        startIndex = 0;}
                    if (getPlace() == Place.FLASHLIGHT) {
                        startIndex = 1;}
                    if (getPlace() == Place.LEFT_SLOPE) {
                        startIndex = 2;}
                    if (getPlace() == Place.MIDDLE_SLOPE) {
                        startIndex = 3;}
                    for (int i = startIndex; i < way.wayFromCentreToTop.size(); i++) {
                        go(way.wayFromCentreToTop.get(i));
                    }
                }
                case PLAIN_1 -> {
                    if (getPlace() == Place.TOP) {
                        startIndex = 0;}
                    if (getPlace() == Place.MIDDLE_SLOPE) {
                        startIndex = 1;}
                    if (getPlace() == Place.RIGHT_SLOPE) {
                        startIndex = 2;}
                    for (int i = startIndex; i < way.wayFromTopToPlain.size(); i++) {
                        go(way.wayFromTopToPlain.get(i));}
                }
            }
        }
    }

    public void fall() {
        if (health > 0) {
            double damage = 30 * getCondition().getReceptivity();
            setHealth(-damage);
            if (damage == 0) {
                System.out.printf( "%s не падал ни вперед ни назад",name);
            } else if (damage == damage) {
                System.out.printf("%s споткнулся ",name);
            } else {
                System.out.printf("%s упал. Здоровье на данный момент: %s",name, getHealth());
            }
            checkHealth();
        }
    }

    public void look() {
        if (health >= 0 && getCondition() != Condition.SLEEP) {
            if (getHeadPosition() == HeadPosition.STRAIGHT) {
                System.out.printf( "%s не смотрел %s или %s ", name, HeadPosition.DOWN, HeadPosition.TO_SIDE);
            }
            if (getHeadPosition() == HeadPosition.DOWN) {
                System.out.printf("%s смотрел %s ",name,HeadPosition.DOWN);
            }
        }
    }


    public void see(Human human, World world) {
        if (health >= 0 && getCondition() != Condition.SLEEP) {
            int signal;
            if (getPlace() == human.getPlace()) {
                if (world.getTime() == Day_time.EVENING || world.getTime() == Day_time.NIGHT) {
                    System.out.printf("%s сквозь темноту видит %s на %s",name, human, getPlace());
                    signal = 1;
                } else {
                    System.out.printf( "%s видит %s", name, human);
                    signal = 1;}}

            else{signal = 0;
                setCondition(Condition.UNSERTAIN);
                System.out.printf( "%s не видит %s ", name, human);
            }
            brainSignals.add(signal);
        }

    }

    @Override
    public void stand(Tree tree) {
        if (health >= 0 && getCondition() != Condition.SLEEP) {
            Body.LEGS.setAnotherPosition("врозь");
            System.out.printf("%s остановился на миг, расставвив %s %s на %s",name,Body.LEGS ,Body.LEGS.getAnotherPosition(),tree);
        }
    }

    @Override
    public void think(String thoughts) {
        if (health >= 0 && getCondition()!=Condition.SLEEP) {
            switch (thoughts){
                case "я сплю?"-> setCondition(Condition.UNSERTAIN);
                case " "-> setCondition(Condition.SLEEP);
                case "у меня получится забраться "->setCondition(Condition.GOOD);
            }
            brainSignals.add(1);
            }
        else brainSignals.add(0);
        }

    }






