package humans;

import humans.enums.*;
import humans.interfaces.*;
import world.Place;
import subject.*;
import exception.*;
import world.World;

import java.util.ArrayList;
import java.util.Objects;
public abstract class Human implements TurnHead, Go,GoAfter,Hear {
    public final String name;

    private int x;
    private int y;
    protected int health;
    protected Condition condition;
    protected Place place;
    protected HeadPosition position;

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
        health +=  i;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public HeadPosition getHeadPosition() {
        return position;
    }

    public void setHeadPosition(HeadPosition position) {
        this.position = position;
    }

    public void turnHead(HeadPosition position) {
        if (health > 0 && getCondition()!=Condition.SLEEP) {
            switch (position) {
                case BACK -> {
                    setHeadPosition(HeadPosition.BACK);
                    System.out.println(name + " повернул голову " + HeadPosition.BACK);
                }
                case TO_SIDE -> {
                    setHeadPosition(HeadPosition.TO_SIDE);
                    System.out.println(name + " повернул лицо в сторону  ");
                }
                case DOWN -> {
                    setHeadPosition(HeadPosition.DOWN);
                    System.out.println("Голова " + name + " опущена " + HeadPosition.DOWN);
                }
                case STRAIGHT -> {
                    setHeadPosition(HeadPosition.STRAIGHT);
                    System.out.println(name + " голова находится в обычном положении");
                }
            }
        }
    }

    public void go(Direction direction) {
        if (health >= 0 && getCondition()!=Condition.SLEEP) {
            switch (direction) {
                case LEFT -> {
                    setx(getx() - 1);
                    sety(gety());
                    System.out.println(name + " идет налево от " + place);
                }
                case RIGHT -> {
                    setx(getx() + 1);
                    sety(gety());
                    System.out.println(name + " идет вправо ");
                }
                case UP -> {
                    setx(getx());
                    sety(gety() + 1);
                    System.out.print("поднимается на " + place);
                }
                case DOWN -> {
                    setx(getx());
                    sety(gety() - 1);
                    System.out.println("Спускается с " + place);
                }
            }
            checkplace();
        }
    }

    public void checkplace() {
        setPlace(null);
        Place[] places = Place.values();
        for (Place place : places) {
            if (place.getCoordinateX() == getx() && place.getCoordinateY() == gety()) {
                setPlace(place);
            }
        }
        if (getPlace() == null) chekUnknownPlace();
    }

    public void chekUnknownPlace() throws HumanWithoutPlaceException {
        if (getPlace() == null)
            throw new HumanWithoutPlaceException(String.format("%s находится в неизвестном месте ", name), null);
    }

    public void wantToGo(Place place) {
        if (health >= 0 && getCondition() != Condition.SLEEP) {
            switch (place) {
                case TOP -> {
                    setCondition(Condition.CONFIDENCE);
                }
                case CENTRE_OF_HEAP -> {
                    setCondition(Condition.UNSERTAIN);
                }
                case FLASHLIGHT -> {
                    setCondition(Condition.GOOD);
                }
            }
        }
    }

    public abstract void move();

    public abstract void stand(Tree tree);

    public abstract void see(Human human, World world);

    public void goAfter(Human p, Human h) {
        if (p.health >= 0 && p.getCondition() != Condition.SLEEP) {
            if (!p.equals(h) && p.hashCode() != h.hashCode()) {
                p.setx(h.getx());
                p.sety(h.gety());
                System.out.println(p.getName() + " следует за " + h.getName());
                p.checkplace();
            } else {
                System.out.println(p + " и " + h + " находятся в одном месте");
            }
        }
    }

    public void hear(Tree tree) throws LowSoundException {
        if (health >= 0) {
            double sound = tree.volume * getCondition().getReceptivity();
            if (sound == 0.0) throw new LowSoundException(String.format(name + " ничего не слышит"));
            else System.out.printf("%s слышит звук громкости %.2f", name, sound);
        }
    }

    public void checkhealth() {
        try {
            takepill();
        } catch (InvalidValueException e) {
            System.out.println(e.getMessage());
        }
    }

    public void takepill() throws InvalidValueException {
        if (getHealth() <= 0) throw new InvalidValueException(String.format("%s мертв", name));
        else {
            if (getHealth() <= 20) {
                potion.recoverHealth();
            } else if (getHealth() < 50) {
                pill.recoverHealth();
            }
            System.out.println("Здоровье :" + health);
        }
    }

    Medicine pill = () -> setHealth(5);
    Medicine potion = () -> setHealth(20);

    public interface Medicine {
        void recoverHealth();
    }

    public  class LeftArm {
        public ArrayList<Subjects> leftArms;
        int weight = 0;
        static int count = 0;

        {
            try {
                checkCoutL();
            } catch (InvalidValueException e) {
                throw new RuntimeException(e);
            }
        }

        public void checkCoutL() throws InvalidValueException {
            if (count >= world.World.sizeOfHumans)
                throw new InvalidValueException(String.format("У %s уже есть подобная  рука", name));
            else {
                leftArms = new ArrayList<>();
                count++;
            }
        }

        public void haveSubject(Subjects s) {
                weight += s.getWeight();
                leftArms.add(s);

        }
    }



    public class RightArm {
        public ArrayList<Subjects> rightArms;
        static int count = 0;

        {
            try {
                checkCoutR();
            } catch (InvalidValueException e) {
                throw new RuntimeException(e);
            }
        }

        public void checkCoutR() throws InvalidValueException {
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

                    System.out.println("В правой руке " + name + " теперь есть " + arm.rightArms);
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

                    System.out.println("В левой руке " + name + "  теперь есть " + arm.leftArms);
                }
            }
        }



    public void replaceSubjects(Human.RightArm arm1, Human.LeftArm arm2) {
        if (health > 0 && getCondition() != Condition.SLEEP) {
            ArrayList<Subjects> help = new ArrayList<>(arm1.rightArms);
            arm1.rightArms = arm2.leftArms;
            arm2.leftArms = help;
            System.out.println(name + " преложил вещи из одной руки в другую");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(place);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null||getClass()==obj.getClass()) return false;

        Human human = (Human) obj;
        return place ==human.place;
         }
    }





























