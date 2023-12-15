package Humanity.Enums;

public enum HeadPosition {
    SRTAIGHT("прямо"),
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
