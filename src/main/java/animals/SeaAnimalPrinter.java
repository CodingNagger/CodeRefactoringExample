package animals;

import animals.model.Animal;
import animals.model.AnimalFactory;
import animals.model.SeaAnimalFamily;

import java.io.PrintStream;
import java.util.EnumSet;

public class SeaAnimalPrinter {
    private final AnimalFactory animalFactory;
    private int averagePositionAboveSea = 0;
    private PrintStream printStream;

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
        int animalsCount = EnumSet.allOf(SeaAnimalFamily.class).size();
        averagePositionAboveSea = 0;

        EnumSet.allOf(SeaAnimalFamily.class).forEach(
                t -> averagePositionAboveSea += animalFactory.get(t).averagePositionAboveSea()
        );

        printStream.println(String.format(
                "There are %d land animals. Their average position above sea is %d meters.",
                animalsCount, averagePositionAboveSea));
    }

    private void printSeaAnimalsDetails() {
        EnumSet.allOf(SeaAnimalFamily.class).forEach(type -> {
            Animal animal = animalFactory.get(type);
            printStream.println(String.format(
                    "The %s has an average position above sea is %d meters.",
                    animal.name(), animal.averagePositionAboveSea() ));
        });
    }
}