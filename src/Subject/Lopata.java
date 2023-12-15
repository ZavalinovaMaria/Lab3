package Subject;

import Humanity.Enums.Body;

public class Lopata {
    public  Body location;
    public Lopata(Body location){
        this.location = location;}

    public Body getlocation(){
        return location;
    }
    public void setlocation(Body body){
        this.location = body;
        System.out.println("Новое местооположение " +toString() + body);}

    public void exchange(Lopata l,Pakagee p){
        l.setlocation(p.getlocation());
        p.setlocation(l.getlocation());
        System.out.println("переложил ");
    }
    @Override
    public  String toString(){
        return " лопаты ";
    }

}
