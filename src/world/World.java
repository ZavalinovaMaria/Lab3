package world;
import java.util.ArrayList;

import humans.*;

public class World {
    public static int sizeOfHumans=0;
    public  final ArrayList<Place> places;
    {places = new ArrayList<>();}
    private final ArrayList<Human> humans;
    {humans = new ArrayList<>();}
    public Day_time time;
    public World(Day_time time){
        this.time = time;
        System.out.println(this+"Тукущее ремя суток "+ time.toString());

    }

    public void putPeople(Human... h) {
        for (Human human : h) {
            humans.add(human);
            sizeOfHumans++;
            human.checkplace();
        }

    }

    public void putPlaces(Place... p) {
        for (Place place : p) {
            places.add(place);
        }
    }
    public void setTime(Day_time time){
        this.time = time;
    }
    public Day_time getTime(){
        return time;}


    public void newDayTime(){
        if(getTime()==Day_time.MORNING){
            setTime(Day_time.AFTERNOON);
        }
        if(getTime()==Day_time.AFTERNOON){
            setTime(Day_time.EVENING);
        }
        if (getTime()==Day_time.EVENING){
            setTime(Day_time.NIGHT);
        }
        else {
            setTime(Day_time.MORNING);
        }
        System.out.println("Текущее время суток:"+time);
    }





    @Override
    public String toString() {
        return "Добро пожаловать в новый мир.";
    }

}




