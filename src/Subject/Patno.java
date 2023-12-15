package Subject;

import Humanity.Human;
import World.Place;

public class Patno {
    int size;
    int brightness;

    public Patno(int size, int brightness) {
        this.brightness = brightness;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public void newview(Human h,Human h1) {
        if(h.getPlace()==h1.getPlace()&& h.getPlace()==Place.FLASHLIGHT){
        setBrightness(getBrightness() + 10);
        setSize(getSize() - 2);
        System.out.println(toString() + "стало меньше(" + size + ") и  еще ярче(" + brightness + ")");}
        else{
            System.out.println(toString()+ " осталось неизменным");;
        }

    }

    @Override
    public String toString() {
        return "Пятно света ";
    }



}


