package Subject;

import Humanity.Enums.Body;

public class Pakagee {
    public Body location;
    public Pakagee(Body location){
        this.location = location;
    }
    public Body getlocation(){
        return location ;
    }
    public void setlocation(Body body){
        this.location = body;
        System.out.println("Новое местооположение " +toString() + body);


    }
    @Override
    public  String toString(){
        return " пакетa ";
    }

}
