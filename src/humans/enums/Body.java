package humans.enums;

public enum Body {
    LEGS("ноги"),
    HAIR("волосы");
    private String bodypart;
    Body(String bodypart){
        this.bodypart = bodypart;
    }
    @Override
    public String toString(){
        return bodypart;
    }
}
