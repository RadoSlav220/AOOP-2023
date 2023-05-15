package blogic;

public enum AnimalType {
    BIRD("Птица"),
    MAMMAL("бозайник"),
    REPTILE("влечуго"),
    FISH("риба");

    private final String typeName;

    private AnimalType(String typeName){
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
