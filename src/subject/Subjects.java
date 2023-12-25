package subject;

public class Subjects {
    String name;
    int weight;

    public Subjects(String name,int weight){

        this.name = name;
        this.weight =weight;
    }
    public int getWeight(){
        return weight;
    }
    @Override
    public String toString(){
        return name;
    }
}

