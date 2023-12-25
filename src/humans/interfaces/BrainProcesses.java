package humans.interfaces;

public interface BrainProcesses {
    default void  think(String thoughts){
        System.out.println("Подумал:' " +thoughts+"'");
    }
    default void decide (String decision){
        System.out.println("Pешил:'"+decision+"'");
    }
    default void feel(){
        System.out.print("Почувствовал, что ");
    }

}
