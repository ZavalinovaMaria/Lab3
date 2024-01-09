package world;

public enum Day_time {
    MORNING("утро"),
    AFTERNOON("день"),
    EVENING("вечер"),
    NIGHT("ночь");
    private final String time;
    Day_time(String time){
        this.time = time;
    }
    @Override
    public String toString(){
        return time;
    }
}



