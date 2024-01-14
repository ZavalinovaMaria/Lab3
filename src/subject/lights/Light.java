package subject.lights;

import subject.Subjects;
import subject.Tree;
import world.Place;
import humans.Human;

import java.util.ArrayList;

public abstract class Light {
    protected int brightness;
    String name;
    protected int period;
    protected int time;

    public Light(String name,int time) {
        this.name = name;
        this.time = time;
    }

    public void shineToTree(Tree tree) {
            tree.setPerscentOfIllumination(brightness-5);
            System.out.printf("Прoцент освещенности: %s %s ",tree,tree.getPerscentOfIllumination());
            ArrayList<Integer> illumination = new ArrayList<>();
            if (period==1){
            while(illumination.size()<time){
            illumination.add(brightness);
            illumination.add(0);}}
            else{
                while (illumination.size()+1 < time) {
                    illumination.add(brightness);}
            }
        System.out.println(illumination);
    }
    public void shineToSubject(Subjects subject) {
        subject.setPerscentOfIllumination(brightness);
        System.out.printf("Прoцент освещенности: %s %s", subject, subject.getPerscentOfIllumination());
        ArrayList<Integer> illumination = new ArrayList<>();
        if(period == 1){
        while (illumination.size()+1 < time) {
            illumination.add(brightness);
            illumination.add(0);}}
        else{
            while (illumination.size()+1 < time) {
                illumination.add(brightness);}
        }
        System.out.println(illumination);
    }
    public String lightCharacteristic() {
        if (brightness > 10 && period == 1) {
            return "ярко светит мелькая";
        } else {
            if (brightness > 10) {
                return "ярко светит";
            } else if (period == 1) {
                return "мелькая светит";
            } else {
                return " светит ";
            }
        }
    }


    public static class Spot {
        private double size;
        private double brightness;

        public Spot(double size, double brightness) {
            this.brightness = brightness;
            this.size = size;
        }

        public double getSize() {
            return size;
        }

        public double getBrightness() {
            return brightness;
        }

        public void setSize(double size) {
            this.size = size;
        }

        public void setBrightness(double brightness) {
            this.brightness = brightness;
        }

        public void newView(Human firstHuman, Human secondHuman) {
            if (firstHuman.equals(secondHuman) && firstHuman.getPlace() == Place.FLASHLIGHT) {
                setBrightness(getBrightness() +Math.random()+2);
                setSize(getSize() - Math.random()+22);
                System.out.printf("%s стало меньше (%s) и  еще ярче(%s)",this,size,brightness);


            } else {
                System.out.printf( "%s осталось неизменным",this);

            }

        }

        @Override
        public String toString() {
            return "Пятно света ";
        }
    }
}




