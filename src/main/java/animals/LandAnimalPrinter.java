package animals;

import animals.model.Animal;
import animals.model.AnimalFactory;

import java.io.PrintStream;

public class LandAnimalPrinter extends AnimalPrinter {
    public LandAnimalPrinter(AnimalFactory animalFactory, PrintStream printStream) {
        super(animalFactory, printStream);
    }

    public static LandAnimalPrinter instance(AnimalFactory animalFactory, PrintStream printStream) {
        return new LandAnimalPrinter(animalFactory, printStream);
    }

    @Override
    protected String getFamilyQualifier() {
        return "land";
    }

    @Override
    protected Animal[] getAnimals() {
        return getAnimalFactory().getLandAnimals();
    }
}