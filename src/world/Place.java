package world;

public enum Place {
    TOP(0,1),
    FLASHLIGHT(-1,0),
    CENTRE_OF_HEAP(0,0),
    BORDER(2,0);
    private final int coordinateX;
    private final int coordinateY;
    public int getCoordinateX(){
        return coordinateX;
    }
    public int getCoordinateY(){
        return coordinateY ;
    }
    Place(int coordinateX, int coordinateY){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }
}





