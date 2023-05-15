package blogic;

public class Animal {

    public static final String[] REGIONS = {"Africa", "Asia", "Australia", "Europe", "America"};

    String name;
    AnimalType animalType;
    boolean predator;
    String region;
    boolean endangered;

    public Animal(String name, AnimalType animalType, boolean predator, String region, boolean endangered) {
        setName(name);
        setAnimalType(animalType);
        setPredator(predator);
        setRegion(region);
        setEndangered(endangered);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public boolean isPredator() {
        return predator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        for (String reg : REGIONS){
            if (region.equals(reg)){
                this.region = region;
                return;
            }
        }
        this.region = "Unknown";
    }

    public boolean isEndangered() {
        return endangered;
    }

    public void setEndangered(boolean endangered) {
        this.endangered = endangered;
    }

    @Override
    public String toString() {
        return "Animal{" +
                name +
                ", type=" + animalType +
                ", predator=" + predator +
                ", region=" + region +
                ", endangered=" + endangered +
                '}';
    }
}
