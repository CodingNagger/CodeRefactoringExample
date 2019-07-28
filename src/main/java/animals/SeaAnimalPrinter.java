package animals;

import animals.model.Animal;
import animals.model.AnimalFactory;

import java.io.PrintStream;
import java.util.function.Consumer;

public class SeaAnimalPrinter {
    private final AnimalFactory animalFactory;
    private PrintStream printStream;
    private int averagePositionAboveSea;
    private int animalsCount;

    public SeaAnimalPrinter(AnimalFactory animalFactory, PrintStream printStream) {
        this.animalFactory = animalFactory;
        this.printStream = printStream;
    }

    public static SeaAnimalPrinter instance(AnimalFactory animalFactory, PrintStream printStream) {
        return new SeaAnimalPrinter(animalFactory, printStream);
    }

    public void print() {
        printSeaAnimalsSummary();
        printSeaAnimalsDetails();
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

        printStream.println(String.format(
                "There are %d land animals. Their average position above sea is %d meters.",
                animalsCount, averagePositionAboveSea));
    }

    private void printSeaAnimalsDetails() {
        doThatThingWithAnimals(animal ->
            printStream.println(String.format(
                    "The %s has an average position above sea is %d meters.",
                    animal.name(), animal.averagePositionAboveSea() ))
        );
    }

    private void doThatThingWithAnimals (Consumer<Animal> thing) {
        for (Animal animal : animalFactory.getSeaAnimals()) {
            thing.accept(animal);
        }
    }
}