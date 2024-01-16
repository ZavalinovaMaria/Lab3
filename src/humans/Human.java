package humans;

import humans.enums.*;
import humans.interfaces.*;
import world.*;
import subject.*;
import exception.*;
import java.util.ArrayList;
import java.util.Objects;
public abstract class Human implements TurnHead, Go, Hear, BrainActions,Know,CheckBrain,CheckLocation,CheckHealth,Fall,TakeToArm {
    public final String name;
    private int x;
    private int y;
    protected int health;
    protected Condition condition;
    protected Place place;
    protected Head head;
    protected LeftArm leftArm;
    protected RightArm rightArm;
    protected Leg rightLeg;
    protected Leg leftLeg;
    protected Lungs lungs;

    protected boolean knowledge = false;
    public ArrayList<Integer> brainSignals;
    {brainSignals= new ArrayList<>();}

    public Human(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        health = 100;
        condition = Condition.GOOD;
        head = new Head();
        leftArm = new LeftArm();
        rightArm = new RightArm();
        rightLeg = new Leg();
        leftLeg = new Leg();
        lungs = new Lungs();
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
    public void takeRequirement() throws InvalidValueException{
        if (getCondition() == Condition.SLEEP) throw new InvalidValueException(String.format("Человек не может нормально функционировать"));
        else if(health<0) checkHealth();
    }
    public void checkRequirement(){
        try{
            takeRequirement();
        } catch (InvalidValueException e){
            System.out.println(e.getMessage());}}

    public void turnHead(Direction direction) {
        checkRequirement();
            switch (direction) {
                case RIGHT -> {
                    double degree = Math.random()*(90.00-20)+20.0;
                    head.setDegreeToSide(degree);
                }
                case LEFT -> {
                    double degree = -Math.random()*(90.00-20)-20.0;
                    head.setDegreeToSide(degree);
                }
                case DOWN -> {
                    double degree = -Math.random()*(90.00-30)-30.0;
                    head.setDegreeUpDown(degree);
                }
                case UP -> {
                    double degree = Math.random()*(90.00-30)+30.0;
                    head.setDegreeUpDown(degree);
                }
                case STRAIGHT ->{
                        double degreeToSide = Math.random()*(20.0-(-20.0))-20.0;
                        double degree = Math.random()*(30.0-(-30.0)) -30.0;
                        head.setDegreeToSide(degreeToSide);
                        head.setDegreeUpDown(degree);
                }
            }
        }


    public void go(Direction direction) {
        checkRequirement();
            leftLeg.setDegrees(15.0);
            rightLeg.setDegrees(13.0);
            double distance = Math.sin(leftLeg.degrees+rightLeg.degrees);
            rightLeg.setDistanceBetweenLegs(leftLeg,distance);
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
                    leftLeg.setHeightLift(Math.random()*20);
                    rightLeg.setHeightLift(Math.random()*20);
                }
                case DOWN -> {
                    setX(getX());
                    setY(getY() - 1);
                    leftLeg.setHeightLift(Math.random()*5);
                    rightLeg.setHeightLift(Math.random()*5);
                }
            }
            checkPlace();
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
    public abstract void fall();

    public void wakeUp(){
        setCondition(Condition.GOOD);
    }

    public void  know (Way way, Place place) {
        int control = 0;
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
                    System.out.printf(" %s знает путь до точки назначения:", name);
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
                    System.out.printf(" %s знает путь до точки назначения:", name);
                    for (int i = startIndex; i < way.wayFromTopToPlain.size(); i++) {
                        System.out.print(way.wayFromTopToPlain.get(i) + ",");
                        control++;
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
        checkBrainSignals();
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
        finally {checkBrainSignals();}
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

    private  class LeftArm {
        public ArrayList<Subjects> leftArmsSubjects;

        {
            this.leftArmsSubjects = new ArrayList<>();
        }

        public void haveSubject(Subjects subject) {leftArmsSubjects.add(subject);}
    }


    private class RightArm {
        public ArrayList<Subjects> rightArmsSubjects;
        static int count = 0;
        {this.rightArmsSubjects = new ArrayList<>();}
        public void checkCountR() throws InvalidValueException {
            if (count >= world.World.sizeOfHumans)
                throw new InvalidValueException(String.format("У %s уже есть подобная  рука", name));
            else {
                rightArmsSubjects = new ArrayList<>();
                count++;
            }
        }

        public void haveSubject(Subjects s) {
            rightArmsSubjects.add(s);
        }
    }
        public void takeToRightArm(Subjects... s) throws InvalidValueException {
            checkRequirement();
                int weight = 0;
                for (Subjects subjects : s) {
                    weight += subjects.getWeight();
                    if (weight >= 20) throw new InvalidValueException(String.format("%s столько не унесет", name));
                    else {
                        rightArm.haveSubject(subjects);
                    }
                    System.out.printf("В правой руке  %s теперь есть %s ", name, rightArm.rightArmsSubjects);
                }
            }


        public void takeToLeftArm(Subjects... s) throws InvalidValueException {
            checkRequirement();
                int weight = 0;
                for (Subjects subjects : s) {
                    weight += subjects.getWeight();
                    if (weight >= 30) throw new InvalidValueException(String.format("%s столько не унесет", name));
                    else {
                        leftArm.haveSubject(subjects);
                    }
                    System.out.printf("В левой руке %s теперь есть %s ", name, leftArm.leftArmsSubjects);
                }
            }


    public void replaceSubjects() {
        checkRequirement();
            ArrayList<Subjects> help = new ArrayList<>(rightArm.rightArmsSubjects);
            rightArm.rightArmsSubjects = leftArm.leftArmsSubjects;
            leftArm.leftArmsSubjects = help;
            System.out.printf("%s преложил вещи из одной руки в другую", name);
        }


    protected class Head{
        protected double degreeToSide;
        protected double degreeUpDown;
        {
            degreeToSide = 0.0;
            degreeUpDown =0.0;
        }
        public double getDegreeToSide(){
            return degreeToSide;
        }
        public double getDegreeUpDown() {
            return degreeUpDown;
        }
        public void setDegreeToSide(double degree){
            this.degreeToSide = degree;
        }
        public void setDegreeUpDown(double degree) {
            this.degreeUpDown = degree;
        }
    }
    protected class Leg{
        protected double  heightLift;
        protected double degrees;
        protected double distanceToAnotherLeg;
        {
            heightLift = 5.0;
            degrees =0.0;
            distanceToAnotherLeg =0;
        }
        public double getHeightLift() {
            return heightLift;
        }
        public void setHeightLift(double height) {
            this.heightLift = height;
        }

        public double getDegrees() {
            return degrees;
        }
        public void setDegrees(double degrees) {
            this.degrees = degrees;
        }
        public  double getDistanceToAnotherLeg(){
            return distanceToAnotherLeg;
        }
        public void setDistanceToAnotherLeg(double distance){
            this.distanceToAnotherLeg = distance;
        }
        public void setDistanceBetweenLegs(Leg second, double distance){
            this.setDistanceToAnotherLeg(distance);
            second.setDistanceToAnotherLeg(distance);
        }
        @Override
        public String toString(){
            return "ноги";
        }
    }
    protected class Lungs{
        int volume;
        {volume = 2500;}
        public int getVolume() {
            return volume;
        }
        public void setVolume(int volume) {
            this.volume = getVolume()+volume;
        }
    }

    public RightArm getRightArm() {
        return rightArm;
    }

    public LeftArm getLeftArm() {
        return leftArm;
    }

    public Leg getLeftLeg() {
        return leftLeg;
    }

    public Leg getRightLeg() {
        return rightLeg;
    }

    public Lungs getLungs() {
        return lungs;
    }

    public Head getHead() {
        return head;
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

