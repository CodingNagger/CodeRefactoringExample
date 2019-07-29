package animals;

import animals.model.Animal;
import animals.model.AnimalFactory;

import java.io.PrintStream;

public class SeaAnimalPrinter extends AnimalPrinter {
    private int averagePositionAboveSea;
    private int animalsCount;

    public SeaAnimalPrinter(AnimalFactory animalFactory, PrintStream printStream) {
        super(animalFactory, printStream);
    }

    public static SeaAnimalPrinter instance(AnimalFactory animalFactory, PrintStream printStream) {
        return new SeaAnimalPrinter(animalFactory, printStream);
    }

    public void print() {
        printSeaAnimalsSummary();
        printAnimalsDetails();
    }

    private void printSeaAnimalsSummary() {
        animalsCount = 0;
        averagePositionAboveSea = 0;

        doThatThingWithAnimals(animal ->
            {
                animalsCount++;
                averagePositionAboveSea += animal.averagePositionAboveSea();
            }
        );

        getPrintStream().println(String.format(
                "There are %d sea animals. Their average position above sea is %d meters.",
                animalsCount, averagePositionAboveSea));
    }

    @Override
    protected Animal[] getAnimals() {
        return getAnimalFactory().getSeaAnimals();
    }
}