package humans;

import humans.enums.*;
import humans.interfaces.Fall;
import subject.*;
import subject.lights.Light;
import world.*;

public class Dgud extends Human  {

    public Dgud( int x, int y) {
        super("Dgud", x, y);
    }


    @Override
    public void stand(Tree tree) {
        checkRequirement();
        leftLeg.setDegrees(Math.random() * (40 - 10) + 30.0);
        rightLeg.setDegrees(Math.random() * (40 - 35) + 20.0);
        double distance = 60 * (Math.abs(Math.sin(rightLeg.getDegrees() + leftLeg.getDegrees())));
        leftLeg.setDistanceBetweenLegs(rightLeg, distance);
        System.out.printf( "%s стоит на %s",name, getPlace());}

    public void see(World world,Light.Spot spot,Human me,Human another) {
        checkRequirement();
            if (world.getTime() == Day_time.EVENING || world.getTime() == Day_time.NIGHT) {
                System.out.printf( "%s видит, что ",name);
                spot.newView(me,another);
                 int signal = 1;
                brainSignals.add(signal);
            } else {
                System.out.printf("%s не видит %s в светлое время суток",name,spot );
                int signal = 0;
                brainSignals.add(signal);
            }
        System.out.println();
    }
    @Override
    public void walk(Way way, Place place) {
        checkRequirement();
            if(getKnowledge() == true) {setCondition(Condition.CONFIDENCE);}
            else {setCondition(Condition.UNSERTAIN);}
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


   @Override
   public void fall() {
        checkRequirement();
            double damage = 40 * getCondition().getReceptivity();
            setHealth(-damage);
            checkHealth();
        }
    }








