package humans.interfaces;


public interface BrainActions {
    default void  think(String thoughts){
        System.out.println("Подумал:' " +thoughts+"'");
    }
      void feel(boolean touch);





}
