package humans.enums;

public enum HeadPosition {
    STRAIGHT("прямо"),
    DOWN("вниз"),
    BACK("назад"),
    TO_SIDE("по сторонам ");

    private final String position;
    HeadPosition(String position){
        this.position = position;
    }
    @Override
    public String toString(){
        return position;
    }
}
