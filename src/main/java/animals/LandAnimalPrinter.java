package animals;

import animals.model.Animal;
import animals.model.AnimalFactory;

import java.io.PrintStream;

public class LandAnimalPrinter extends AnimalPrinter {
    private int averagePositionAboveSea;
    private int animalsCount;

    public LandAnimalPrinter(AnimalFactory animalFactory, PrintStream printStream) {
        super(animalFactory, printStream);
    }

    public static LandAnimalPrinter instance(AnimalFactory animalFactory, PrintStream printStream) {
        return new LandAnimalPrinter(animalFactory, printStream);
    }

    public void print() {
        printLandAnimalsSummary();
        printLandAnimalsDetails();
    }

    private void printLandAnimalsSummary() {
        animalsCount = 0;
        averagePositionAboveSea = 0;

        doThatThingWithAnimals(animal ->
                {
                    animalsCount++;
                    averagePositionAboveSea += animal.averagePositionAboveSea();
                }
        );

        getPrintStream().println(String.format(
                "There are %d land animals. Their average position above sea is %d meters.",
                animalsCount, averagePositionAboveSea));
    }

    private void printLandAnimalsDetails() {
        doThatThingWithAnimals(animal ->
                getPrintStream().println(String.format(
                        "The %s has an average position above sea is %d meters.",
                        animal.name(), animal.averagePositionAboveSea() ))
        );
    }

    @Override
    protected Animal[] getAnimals() {
        return getAnimalFactory().getLandAnimals();
    }
}