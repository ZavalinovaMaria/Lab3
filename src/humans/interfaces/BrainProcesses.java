package humans.interfaces;

public interface BrainProcesses {
    default void  thinking(String thoughts){
        System.out.println("Подумал:' " +thoughts+"'");
    }
    default void decides (String decision){
        System.out.println("Pешил:'"+decision+"'");
    }
    default void feel(){
        System.out.print("Почувствовал, что ");
    }

}
