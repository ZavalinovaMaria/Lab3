package Humanity;

import  Humanity.Enums.*;
import Humanity.Interfaces.Head;
import Humanity.Interfaces.Walk;
import World.Place;
import Subject.Tree.*;

import java.util.Objects;

public abstract class Human implements Head, Walk {
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
        position = HeadPosition.SRTAIGHT;
        //
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
    public int getHealth(){
        return health;
    }
    public int setHealth(int i){
       return health-=i;
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
    public HeadPosition getHeadPosition(){
        return position;
    }
    public  void  setHeadPosition(HeadPosition position )
    {
        this.position = position;
    }
    public void turnHead(HeadPosition position){
        switch (position) {
            case BACK -> {
                setHeadPosition(HeadPosition.BACK);
                System.out.println(name+ " повернул голову " +HeadPosition.BACK);
            }
            case TO_SIDE -> {
                setHeadPosition(HeadPosition.TO_SIDE);
                System.out.println(name+" повернул лицо в сторону  " );
            }
            case DOWN -> {
                setHeadPosition(HeadPosition.DOWN);
                System.out.println("Голова "+name+ " опущена "+ HeadPosition.DOWN);
            }
            case SRTAIGHT -> {
                setHeadPosition(HeadPosition.SRTAIGHT);
                System.out.println(name+ " голова находится в обычном положении");
            }
        }
    }

    public void go(Direction direction) {
        switch (direction) {
            case LEFT -> {
                setx(getx() - 1);
                sety(gety());
                System.out.print(getName() + " идет налево от " + getPlace());

            }
            case RIGHT -> {
                setx(getx() + 1);
                sety(gety());
                System.out.print(getName()+ " идет вправо ");

            }
            case UP -> {
                setx(getx());
                sety(gety() + 1);
                System.out.print("поднимается ");

            }
            case DOWN -> {
                setx(getx());
                sety(gety() - 1);
                System.out.println("Спускается с " + place);
            }
        }
        location();
    }

    public void location() {
        if (getx() == 0 && gety() == 0) {
            setPlace(Place.CENTRE_OF_HEAP);

        } else if (getx() == 0 && gety() == 1) {
            setPlace(Place.TOP);
            System.out.println( " на " + place);

        } else if (getx() == -1 && gety() == 0) {
            setPlace(Place.FLASHLIGHT);
            System.out.println( " к  " + place);

        } else {
            setPlace(Place.UNKNOWN);
        }
    }
    public abstract void ConfidenceMan();
    public abstract void stand(Stvol stvol);
    public abstract void see(Human human);
    public void chekplace() {
        if (getx() == 0 && gety() == 0) {
            setPlace(Place.CENTRE_OF_HEAP);
            System.out.println(getName()+" находится на "+ place);
        } else if (getx() == 0 && gety() == 1) {
            setPlace(Place.TOP);
            System.out.println(getName()+" находится на "+ place);

        } else if (getx() == -1 && gety() == 0) {
            setPlace(Place.FLASHLIGHT);
            System.out.println(getName()+" находится y  "+ place);

        } else {
            setPlace(Place.UNKNOWN);
            System.out.println(getName()+" потерялся  ");
        }
    }
    public void goAfter(Human p,Human h){
        p.setx(h.getx());
        p.sety(h.gety());
        System.out.print(p.getName()+" следует за "+h.getName());
        p.location();
    }
    public void be_health(){
        if(getHealth()<=0){}
            // исключение будет
        }
    @Override
    public String toString(){
        return name;
    }
    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;

        Human human = (Human) obj;
        return Objects.equals(this.name, human.name);
    }
    }

























