package humans;

import humans.enums.*;
import humans.interfaces.*;
import world.*;
import subject.*;
import exception.*;
import java.util.ArrayList;
import java.util.Objects;
public abstract class Human implements TurnHead, Go, Hear, BrainActions,Know,CheckBrain,CheckLocation,CheckHealth {
    public final String name;
    private int x;
    private int y;
    protected int health;
    protected Condition condition;
    protected Place place;
    protected HeadPosition position;
    protected boolean knowledge = false;
    public ArrayList<Integer> brainSignals;
    {brainSignals= new ArrayList<>();}

    public Human(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        health = 100;
        condition = Condition.GOOD;
        position = HeadPosition.STRAIGHT;
    }

    public String getName() {
        return name;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition co) {
        this.condition = co;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(double i) {
        health += i;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public boolean getKnowledge(){return knowledge;}
    public void setKnowledge(boolean knowledge){
        this.knowledge =knowledge;
    }

    public HeadPosition getHeadPosition() {
        return position;
    }
    public void setHeadPosition(HeadPosition position) {
        this.position = position;
    }
    public void turnHead(HeadPosition position) {
        if (health > 0 && getCondition() != Condition.SLEEP) {
            switch (position) {
                case BACK -> {
                    setHeadPosition(HeadPosition.BACK);
                    System.out.printf(" %s повернул голову %s ",name, HeadPosition.BACK);
                }
                case TO_SIDE -> {
                    setHeadPosition(HeadPosition.TO_SIDE);
                    System.out.printf( "%s повернул лицо в сторону ",name);
                }
                case DOWN -> {
                    setHeadPosition(HeadPosition.DOWN);
                    System.out.printf("Голова %s опущена %s ",name, HeadPosition.DOWN);
                }
                case STRAIGHT -> {
                    setHeadPosition(HeadPosition.STRAIGHT);
                    System.out.printf( " голова %s находится в обычном положении",name);
                }
            }
        }
    }

    public void go(Direction direction) {
        if (health >= 0 && getCondition() != Condition.SLEEP) {
            switch (direction) {
                case LEFT -> {
                    setX(getX() - 1);
                    setY(getY());
                }
                case RIGHT -> {
                    setX(getX() + 1);
                    setY(getY());
                }
                case UP -> {
                    setX(getX());
                    setY(getY() + 1);
                }
                case DOWN -> {
                    setX(getX());
                    setY(getY() - 1);
                }
            }
            checkPlace();
        }
    }
    public void checkPlace() {
        setPlace(null);
        Place[] places = Place.values();
        for (Place place : places) {
            if (place.getCoordinateX() == getX() && place.getCoordinateY() == getY()) {
                setPlace(place);
            }
        }
        if (getPlace() == null) checkUnknownPlace();
    }

    public void checkUnknownPlace() throws HumanWithoutPlaceException {
        if (getPlace() == null)
            throw new HumanWithoutPlaceException(String.format("%s находится в неизвестном месте  ", name), null);
    }
    public abstract void walk(Way way, Place place);
    public abstract void stand(Tree tree);

    public void wakeUp(){
        setCondition(Condition.GOOD);
    }

    public void  know (Way way, Place place) {
        int control = 0;
        if (health >= 0 && getCondition() != Condition.SLEEP) {
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
                    System.out.printf(" %s знает путь до точки назначения:",name);
                    for (int i = startIndex; i < way.wayFromCentreToTop.size(); i++) {
                        System.out.print(way.wayFromCentreToTop.get(i) + ", ");
                        control++;
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
                    System.out.printf(" %s знает путь до точки назначения:",name);
                    for (int i = startIndex; i < way.wayFromTopToPlain.size(); i++) {
                        System.out.print(way.wayFromTopToPlain.get(i) + ",");
                        control++;
                    }
                }
            }
        }
        System.out.println();
        if (control != 0) setKnowledge(true);
        else setKnowledge(false);

    }

    public void feel(boolean touch){
        String answer;
        if(touch ==true){ brainSignals.add(1);answer =" ";}
        else {brainSignals.add(0); answer =" не ";}
        System.out.printf("%s %S почувствовал это",name,answer);
    }

    public void hearSound(Tree tree) throws LowSoundException {
        if (health >= 0) {
            double sound = tree.volume * getCondition().getReceptivity();
            if (sound == 0.0) throw new LowSoundException(String.format(" %s ничего не слышит ",name));
            else System.out.printf ("%s слышит звук громкости %.2f", name, sound);
        }
    }
    public void hear(Tree tree,Human human) {
        try{
            human.hearSound(tree);
        }
        catch (LowSoundException e) {
            if (LowSoundException.count >10)
            {System.out.printf("Похоже %s оглох",name);
            human.setHealth(-30);}
            else System.out.println(e.getMessage());
        }
    }

    public void checkHealth() {
        try {
            takePill();
        } catch (InvalidValueException e) {
            System.out.println(e.getMessage());
        }
    }
    public void takePill() throws InvalidValueException {
        if (getHealth() <= 0) throw new InvalidValueException(String.format("%s мертв", name));
        else {
            if (getHealth() <= 20) {
                potion.recoverHealth();
            } else if (getHealth() < 50) {
                pill.recoverHealth();
            }
            System.out.printf("Здоровье : %s", health);
        }
    }

    Medicine pill = () -> setHealth(5);
    Medicine potion = () -> setHealth(20);

    public interface Medicine {
        void recoverHealth();
    }

    public void checkBrainSignals(){
        int countZeroSignals= 0;
        for(int signal = 0;signal<brainSignals.size();signal++){
            if(brainSignals.get(signal) == 0){
                countZeroSignals++;}
            else{countZeroSignals=0;}
        }
        if(countZeroSignals>5){
            setCondition(Condition.SLEEP);
        }
    }

    public  class LeftArm {
        public ArrayList<Subjects> leftArms;
        static int count = 0;
        {
            try {
                checkCountL();
            } catch (InvalidValueException e) {
                System.out.println(e.getMessage());
            }
        }

        public void checkCountL() throws InvalidValueException {
            if (count >= world.World.sizeOfHumans)
                throw new InvalidValueException(String.format("У %s уже есть подобная  рука", name));
            else {
                leftArms = new ArrayList<>();
                count++;
            }
        }
        public void haveSubject(Subjects s) {leftArms.add(s);}
    }


    public class RightArm {
        public ArrayList<Subjects> rightArms;
        static int count = 0;
        {
            try {checkCountR();}
            catch (InvalidValueException e) {
                System.out.println(e.getMessage());}
        }
        public void checkCountR() throws InvalidValueException {
            if (count >= world.World.sizeOfHumans)
                throw new InvalidValueException(String.format("У %s уже есть подобная  рука", name));
            else {
                rightArms = new ArrayList<>();
                count++;
            }
        }

        public void haveSubject(Subjects s) {
            rightArms.add(s);
        }
    }
        public void takeToArm(Human.RightArm arm, Subjects... s) throws InvalidValueException {
            if (health >= 0 && getCondition() != Condition.SLEEP) {
                int weight = 0;
                for (Subjects subjects : s) {
                    weight += subjects.getWeight();
                    if (weight >= 20) throw new InvalidValueException(String.format("%s столько не унесет", name));
                    else {
                        arm.haveSubject(subjects);
                    }
                    System.out.printf("В правой руке  %s теперь есть %s ", name, arm.rightArms);
                }
            }
        }

        public void takeToArm(Human.LeftArm arm, Subjects... s) throws InvalidValueException {
            if (health >= 0 && getCondition() != Condition.SLEEP) {
                int weight = 0;
                for (Subjects subjects : s) {
                    weight += subjects.getWeight();
                    if (weight >= 30) throw new InvalidValueException(String.format("%s столько не унесет", name));
                    else {
                        arm.haveSubject(subjects);
                    }
                    System.out.printf("В левой руке %s теперь есть %s ", name, arm.leftArms);
                }
            }
        }

    public void replaceSubjects(Human.RightArm arm1, Human.LeftArm arm2) {
        if (health > 0 && getCondition() != Condition.SLEEP) {
            ArrayList<Subjects> help = new ArrayList<>(arm1.rightArms);
            arm1.rightArms = arm2.leftArms;
            arm2.leftArms = help;
            System.out.printf("%s преложил вещи из одной руки в другую", name);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null||getClass()==obj.getClass()) return false;

        Human human = (Human) obj;
        return place ==human.place;
         }
    }

