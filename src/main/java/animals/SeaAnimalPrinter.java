package animals;

import animals.model.Animal;
import animals.model.AnimalFactory;

import java.io.PrintStream;

public class SeaAnimalPrinter extends AnimalPrinter {

    public SeaAnimalPrinter(AnimalFactory animalFactory, PrintStream printStream) {
        super(animalFactory, printStream);
    }

    public static SeaAnimalPrinter instance(AnimalFactory animalFactory, PrintStream printStream) {
        return new SeaAnimalPrinter(animalFactory, printStream);
    }

    @Override
    protected String getFamilyQualifier() {
        return "sea";
    }

    @Override
    protected Animal[] getAnimals() {
        return getAnimalFactory().getSeaAnimals();
    }
}