package subject;

import subject.interfaces.MakeSound;

public class Tree implements MakeSound {
    String title;
    public double volume;
    public int perscentOfIllumination = 0;

    public Tree(double volume) {
        this.title = "деревья";
        this.volume = volume;
    }

    public class Trunk extends Tree {
        public Trunk(double volume) {
            super( volume);
            this.title ="ствол";

        }

        @Override
        public String toString() {
            return "стволах";
        }
    }

    public class Branch extends Tree {
        public Branch( double volume) {
            super(volume);
            this.title ="ветка";
        }
        @Override
        public String toString() {
            return "веток";
        }

        public String anotherForm() {
            return "ветвях";
        }
    }
    public void makeSound() {
        class Noise {
            final double probability;
            Noise() {
                probability = Math.random();
            }
        }
        Noise silence = new Noise();
        volume = volume * (1 - silence.probability);
    }

    public int getPerscentOfIllumination(){
        return perscentOfIllumination;
    }
    public void setPerscentOfIllumination(int lightCharacteristic) {
        perscentOfIllumination = getPerscentOfIllumination()+lightCharacteristic;

    }
    @Override
    public String toString() {
        return "деревьев";
    }
}
