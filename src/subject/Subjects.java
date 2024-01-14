package subject;

public class Subjects {
    String name;
    int weight;
    public int perscentOfIllumination = 0;
    public Subjects(String name,int weight){

        this.name = name;
        this.weight =weight;
    }
    public int getWeight(){
        return weight;
    }
    public int getPerscentOfIllumination(){
        return perscentOfIllumination;
    }

    public void setPerscentOfIllumination(int lightCharacteristic) {
        perscentOfIllumination = getPerscentOfIllumination()+lightCharacteristic;
    }

    @Override
    public String toString(){
        return name;
    }
}

