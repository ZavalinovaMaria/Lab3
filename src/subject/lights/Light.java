package subject.lights;

import world.Place;
import humans.Human;

public abstract class Light {
    protected int brightness;
    String name;
    protected int T;

    public Light(String name) {
        this.name = name;
    }

    public String lightCharacteristic() {
        if (brightness > 100 && T >= 1) {
            return "ярко светит мелькая";
        } else {
            if (brightness > 100) {
                return "ярко светит";
            } else if (T >= 0) {
                return "мелькая светит";
            } else {
                return " светит ";
            }
        }
    }

    public static class Spot {
        private int size;
        private int brightness;

        public Spot(int size, int brightness) {
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

        public void newView(Human h, Human h1) {
            if (h.equals(h1) && h.getPlace() == Place.FLASHLIGHT) {
                setBrightness(getBrightness() + 10);
                setSize(getSize() - 2);
                System.out.println(toString() + "стало меньше(" + size + ") и  еще ярче(" + brightness + ")");
            } else {
                System.out.println(toString() + " осталось неизменным");
                //;h.equals(h1) &&
            }

        }

        @Override
        public String toString() {
            return "Пятно света ";
        }
    }
}




