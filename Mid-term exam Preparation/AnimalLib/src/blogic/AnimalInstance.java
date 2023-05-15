package blogic;

public class AnimalInstance {
    public static int COUNT = 0;

    int animalKey;
    String animalName;
    int animalAge;
    final String INSTANCE_ID;

    public AnimalInstance(int animalKey, String animalName, int animalAge) {
        setAnimalKey(animalKey);
        setAnimalName(animalName);
        setAnimalAge(animalAge);
        INSTANCE_ID = String.format("%s %03d", this.animalName, ++COUNT);
    }

    public int getAnimalKey() {
        return animalKey;
    }

    public void setAnimalKey(int animalKey) {
        this.animalKey = animalKey;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge > 0 ? animalAge : 1;
    }

    public String getINSTANCE_ID() {
        return INSTANCE_ID;
    }

    @Override
    public String toString() {
        return INSTANCE_ID + ", " + "Age: " + animalAge;
    }
}
