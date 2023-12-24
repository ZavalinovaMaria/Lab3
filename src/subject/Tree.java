package subject;

public class Tree {
    String title;
    public double volume;
    public Tree(String title,double volume){
        this.title = title;
        this.volume = volume;
    }
    public class Trunk extends Tree {
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
        public String anotherForm2(){
            return "ветка";
        }
    }
    public void makeSound(){
         class Noise{
            double probability;
            Noise(){
                probability= Math.random();
            }
        }
        Noise silence = new Noise();
        volume= volume*(1- silence.probability);
    }
    public String hasTitle(){
        return title;
    }
    @Override
    public String toString() {
        return "деревьев";
    }
}