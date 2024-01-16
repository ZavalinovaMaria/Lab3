package humans;
import world.Day_time;
import humans.enums.*;
import humans.interfaces.*;
import subject.*;
import world.*;


public class Luis extends Human implements  Sigh, Look, GoAfter {


    public Luis(int x, int y) {
        super("Luis", x, y);
    }


    public void goAfter(Way way, Human follower, Human leader) {
        checkRequirement();
        if (leader.getKnowledge()) {
            follower.setCondition(Condition.CONFIDENCE);
            System.out.printf("%s двигался  c уверенностью, что пока он идет за %s он в безопасности", follower, leader);
        }
        if (!follower.equals(leader) && follower.hashCode() != leader.hashCode()) {
            follower.walk(way, leader.getPlace());
        } else {
            System.out.printf("%s и %s  находятся в одном месте", follower, leader);
        }
    }


    public void sigh() {
        lungs.setVolume(500);
        lungs.setVolume(-500);
        if (getCondition() == Condition.UNSERTAIN) {
            System.out.printf("%s вздохнул с облегчением", name);
        } else {
            System.out.printf("%s вздохнул", name);
        }
    }

    @Override
    public void walk(Way way, Place place) {
        checkRequirement();
        int startIndex = 0;
        switch (place) {
            case TOP -> {
                if (getPlace() == Place.CENTRE_OF_HEAP) {
                    startIndex = 0;
                }
                if (getPlace() == Place.FLASHLIGHT) {
                    startIndex = 1;
                }
                if (getPlace() == Place.LEFT_SLOPE) {
                    startIndex = 2;
                }
                if (getPlace() == Place.MIDDLE_SLOPE) {
                    startIndex = 3;
                }
                for (int i = startIndex; i < way.wayFromCentreToTop.size(); i++) {
                    go(way.wayFromCentreToTop.get(i));
                }
            }
            case PLAIN_1 -> {
                if (getPlace() == Place.TOP) {
                    startIndex = 0;
                }
                if (getPlace() == Place.MIDDLE_SLOPE) {
                    startIndex = 1;
                }
                if (getPlace() == Place.RIGHT_SLOPE) {
                    startIndex = 2;
                }
                for (int i = startIndex; i < way.wayFromTopToPlain.size(); i++) {
                    go(way.wayFromTopToPlain.get(i));
                }
            }
        }
    }
    @Override
    public void fall() {
        checkRequirement();
        double damage = 30 * getCondition().getReceptivity();
        setHealth(-damage);
        if (damage == 0) {
            System.out.printf("%s не падал ни вперед ни назад", name);
        } else if (damage == damage) {
            System.out.printf("%s споткнулся ", name);
        } else {
            System.out.printf("%s упал. Здоровье на данный момент: %s", name, getHealth());
        }
        checkHealth();
    }


    public void look() {
        checkRequirement();
        if (head.getDegreeToSide() > 20.0 || head.getDegreeToSide() < -20.0)
            System.out.printf("%s не смотрел  по сторонам  ", name);
        if (head.getDegreeUpDown() < -30.0) System.out.printf("%s смотрел вниз ", name);
    }


    public void see(Human human, World world) {
        checkRequirement();
        int signal;
        if (getPlace() == human.getPlace()) {
            if (world.getTime() == Day_time.EVENING || world.getTime() == Day_time.NIGHT) {
                System.out.printf("%s сквозь темноту видит %s на %s", name, human, getPlace());
                signal = 1;
            } else {
                System.out.printf("%s видит %s", name, human);
                signal = 1;
            }
        } else {
            signal = 0;
            setCondition(Condition.UNSERTAIN);
            System.out.printf("%s не видит %s ", name, human);
        }
        brainSignals.add(signal);
    }


    @Override
    public void stand(Tree tree) {
        checkRequirement();
        String characteristic;
        leftLeg.setDegrees(Math.random() * (40 - 10) + 30.0);
        rightLeg.setDegrees(Math.random() * (40 - 35) + 20.0);
        double distance = 60 * (Math.abs(Math.sin(rightLeg.getDegrees() + leftLeg.getDegrees())));
        leftLeg.setDistanceBetweenLegs(rightLeg, distance);
        if (distance > 40.0) characteristic = " широко ";
        else characteristic = " ";
        System.out.printf("%s остановился на миг,%s расставвив %s %s", name, characteristic, leftLeg, tree);
    }


    @Override
    public void think(String thoughts) {
        checkRequirement();
        switch (thoughts) {
            case "я сплю?" -> setCondition(Condition.UNSERTAIN);
            case " " -> setCondition(Condition.SLEEP);
            case "у меня получится забраться " -> setCondition(Condition.GOOD);
        }
        brainSignals.add(1);
    }
}







