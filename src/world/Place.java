package world;

public enum Place {
    TOP(0,2),
    FLASHLIGHT(-1,0),
    LEFT_SLOPE(-1,1),
    MIDDLE_SLOPE(0,1),
    RIGHT_SLOPE(1,1),
    CENTRE_OF_HEAP(0,0),
    PLAIN_1(1,0),
    PLAIN_2(2,0),
    BORDER(3,0);

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






