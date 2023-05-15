package vue;

import blogic.Animal;
import blogic.AnimalInstance;
import blogic.AnimalType;

import java.util.Arrays;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {
    private static final int SAMPLES_COUNT = 20;
    private static final int ANIMALS_COUNT = 6;
    private Random generator;
    private AnimalInstance[] samples;
    private Animal[] animals;

    @FXML
    private Button btnShowSorted;

    @FXML
    private Button btnShuffle;

    @FXML
    private Button btnDistributions;

    @FXML
    private Button btnShowEndangered;

    @FXML
    private Button btnQuit;

    @FXML
    private TextArea txtOutput;

    public void initialize(){
        generator = new Random();

        animals = new Animal[ANIMALS_COUNT];
        animals[0] = new Animal("Тигър", AnimalType.MAMMAL, true, "Asia", true);
        animals[1] = new Animal("Фламинго", AnimalType.BIRD, false, "Africa", true);
        animals[2] = new Animal("Гущер", AnimalType.REPTILE, true, "Australia", true);
        animals[3] = new Animal("Пъстърва", AnimalType.FISH, false, "Europe", false);
        animals[4] = new Animal("Делфин", AnimalType.MAMMAL, false, "Australia", true);
        animals[5] = new Animal("Вълк", AnimalType.MAMMAL, true, "America", false);

        samples = new AnimalInstance[SAMPLES_COUNT];
        for (int i=0; i<SAMPLES_COUNT; ++i){
            int animalKey = generator.nextInt(ANIMALS_COUNT);
            samples[i] = new AnimalInstance(animalKey,
                    animals[animalKey].getName(),
                    generator.nextInt(21) + 10);
        }
    }

    private void printSamples(){
        txtOutput.clear();
        StringBuilder text = new StringBuilder();
        for (int i=0; i<samples.length; ++i){
            text.append(samples[i].toString() + "\n");
        }

        txtOutput.setText(text.toString());
    }

    @FXML
    void btnShowSortedOnAction(ActionEvent event) {
        for (int i=0; i<samples.length-1; ++i){
            int minIndex = i;
            for (int j=i+1; j<samples.length; ++j){
                if (samples[minIndex].getAnimalAge() > samples[j].getAnimalAge()){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                AnimalInstance temp = samples[i];
                samples[i] = samples[minIndex];
                samples[minIndex] = temp;
            }
        }

        printSamples();
    }

    @FXML
    void btnShuffleOnAction(ActionEvent event) {
        for (int i=0; i<samples.length; ++i){
            int rand = generator.nextInt(samples.length);
            AnimalInstance temp = samples[i];
            samples[i] = samples[rand];
            samples[rand] = temp;
        }
        printSamples();
    }

    private Animal getAnimal(AnimalInstance sample){
        for (int i=0; i<animals.length; ++i){
            if (sample.getAnimalName().equals(animals[i].getName())){
                return animals[i];
            }
        }
        throw new RuntimeException("Unknown sample");
    }

    @FXML
    void btnDistributionsOnAction(ActionEvent event) {
        int count[] = new int[Animal.REGIONS.length];
        for (int i=0; i<samples.length; ++i){
            Animal currentAnimal = getAnimal(samples[i]);
            for (int j=0; j<Animal.REGIONS.length; ++j){
                if (currentAnimal.getRegion().equals(Animal.REGIONS[j])){
                    count[j]++;
                }
            }
        }

        StringBuilder text = new StringBuilder();
        for (int i=0; i<count.length; ++i){
            text.append(String.format("%14s %14d\n", Animal.REGIONS[i], count[i]));
        }
        txtOutput.clear();
        txtOutput.setText(text.toString());
    }

    @FXML
    void btnShowEndangeredOnAction(ActionEvent event) {
        int count[] = new int[AnimalType.values().length];
        for (int i=0; i<samples.length; ++i){
            Animal currentAnimal = getAnimal(samples[i]);
            for (int j=0; j<AnimalType.values().length; ++j){
                if (currentAnimal.isEndangered() && currentAnimal.getAnimalType().equals(AnimalType.values()[j])){
                    count[j]++;
                }
            }
        }

        StringBuilder text = new StringBuilder();
        for (int i=0; i<count.length; ++i){
            text.append(String.format("%14s %14d\n", AnimalType.values()[i], count[i]));
        }
        txtOutput.clear();
        txtOutput.setText(text.toString());
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        System.exit(0);
    }
}
