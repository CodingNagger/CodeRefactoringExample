package animals;

import animals.model.Animal;
import animals.model.AnimalFactory;

import java.io.PrintStream;
import java.util.function.Consumer;

public abstract class AnimalPrinter {
    private final AnimalFactory animalFactory;
    private final PrintStream printStream;

    protected AnimalPrinter(AnimalFactory animalFactory, PrintStream printStream) {
        this.animalFactory = animalFactory;
        this.printStream = printStream;
    }

    protected AnimalFactory getAnimalFactory() {
        return animalFactory;
    }

    protected void doThatThingWithAnimals (Consumer<Animal> thing) {
        for (Animal animal : getAnimals()) {
            thing.accept(animal);
        }
    }

    protected void printAnimalsDetails() {
        doThatThingWithAnimals(animal ->
                getPrintStream().println(String.format(
                        "The %s has an average position above sea is %d meters.",
                        animal.name(), animal.averagePositionAboveSea() ))
        );
    }

    protected abstract Animal[] getAnimals();

    protected PrintStream getPrintStream() {
        return printStream;
    }
}
