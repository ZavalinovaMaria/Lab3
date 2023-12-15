package Humanity;
import Humanity.Enums.*;
import Humanity.Interfaces.BrainProcesses;
import Subject.*;
import Subject.Tree.*;
import World.Place;


public class Luis extends Human implements BrainProcesses {
    public Luis(String name, int x, int y) {
        super(name,x,y);
    }


    public void thinking(String thoughts){
        System.out.println(name+" подумал:' " +thoughts+"'");
    }
    public void decides(String decision ){
        System.out.println(name+" решил:'"+decision+"'"+reflections());

    }
    public String reflections(){
        return ("Но мне кажется, я смогу перелезть. На самом деле. Значит, я действительно сплю?");}

    @Override
    public  void  ConfidenceMan(){
        if(getCondition()== Condition.CONFIDENCE){
            System.out.println("К "+name+" пришла странная уверенность, что пока он идет он в безопасности");
        }
    }
    public  void  WarinesseMan(){
        if(getCondition()== Condition.INATTENTIVE){
            System.out.println("он не обратил на это внимания ");
        }
        else{
            System.out.println("был внимательный к мелочам ");
        }
    }

    public void sighed() {
        if (getCondition() == Condition.INATTENTIVE) {
            System.out.println(name + " вздохнул с облегчением");
        } else {
            System.out.println(name + " вздохнул");
        }
    }

    public void fall() {
        if (getCondition() == Condition.INATTENTIVE) {
            System.out.println(name + " чуть не упал");
        } else if (getCondition() == Condition.CONFIDENCE){
            System.out.println(name+" не падал ни вперед ни назад");}
        else {
            setHealth(20);
            System.out.println(name + " упал. Здоровье на данный момент:" +setHealth(20) );
        }
    }




    public void exchange(Lopata l,Pakagee p){
        System.out.println(name+" перекладывает вещи одной руки в другую");
        Body change = l.getlocation();
        l.setlocation(p.getlocation());
        p.setlocation(change);
    }


    public void look(){
        if(getHeadPosition()==HeadPosition.SRTAIGHT ){
            System.out.println(name + " не смотрел "+HeadPosition.DOWN + " или "+ HeadPosition.TO_SIDE );
        }

        if (getHeadPosition() == HeadPosition.DOWN && getPlace() == Place.TOP) {
                System.out.println(name + " не стал оглядываться ");
            }
        }
        public void feel(){
            System.out.print("Почувствовал, что ");
        }


    @Override
    public void see(Human human) {
        System.out.println(name + " видит " +"стоящего "+human+" на "+ getPlace());}



    @Override
    public void stand(Stvol stvol) {
        System.out.println(name + " остановился на миг, расставвив " + Body.LEGS +" на ненадежных скользких "+ stvol);
    }

}