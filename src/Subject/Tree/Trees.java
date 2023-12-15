package Subject.Tree;

import Humanity.Human;

public class Trees  {
    String title;
    public Trees(String title){
        this.title = title;
    }
    public void sound(Human human){
        System.out.println("шшшшш");
    }

    public String hasTitle(){
        return title;

    }

    @Override
    public String toString() {
        return "деревьев";
    }
}
