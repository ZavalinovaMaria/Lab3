package Humanity.Enums;

public enum Body {
    L_ARM("  левая рука "),
    R_ARM("правая рука "),
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
