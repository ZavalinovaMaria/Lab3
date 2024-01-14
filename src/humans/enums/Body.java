package humans.enums;

public enum Body {
    LEGS("ноги","вместе",""),
    CHEST("грудь","в обычном положении",""),
    HAIR("волосы","приглаженные","");
    private  final String bodypart;
    private final String defaultPosition;
    private  String anotherPosition;
    Body(String bodypart,String position1,String position2){
        this.bodypart = bodypart;
        this.defaultPosition = position1;
        this.anotherPosition = position2;
    }
    @Override
    public String toString(){
        return bodypart;
    }
    public  void setAnotherPosition(String position){
        this.anotherPosition =position;
    }
    public String getDefaultPosition(){
        return defaultPosition;
    }
    public String getAnotherPosition(){
        return anotherPosition;
    }


}
