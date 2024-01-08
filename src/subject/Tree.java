package subject;

import subject.interfaces.MakeSound;

public class Tree implements MakeSound {
    String title;
    public double volume;
    public Tree(String title,double volume){
        this.title = title;
        this.volume = volume;
    }
    public  class Trunk extends Tree {
        public Trunk(String title,double volume){
            super(title,volume);
        }
        @Override
        public String toString() {
            return "стволах";
        }
    }
    public class Branch extends Tree  {
        public Branch(String title,double volume) {
            super(title,volume);
        }

        @Override
        public String toString() {
            return "веток";
        }
        public String anotherForm(){
            return "ветвях";
        }
    }
    public void makeSound(){
         class Noise{
             final double probability;
            Noise(){
                probability= Math.random();
            }
        }
        Noise silence = new Noise();
        volume= volume*(1- silence.probability);
    }


    @Override
    public String toString() {
        return "деревьев";
    }
}
