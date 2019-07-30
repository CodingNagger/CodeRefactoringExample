package animals;

import animals.model.Animal;
import animals.model.AnimalFactory;

import java.io.PrintStream;

public class CodingAnimalPrinter extends AnimalPrinter {
    protected CodingAnimalPrinter(AnimalFactory animalFactory, PrintStream printStream) {
        super(animalFactory, printStream);
    }

    public static CodingAnimalPrinter instance(AnimalFactory animalFactory, PrintStream printStream) {
        return new CodingAnimalPrinter(animalFactory, printStream);
    }

    @Override
    protected Animal[] getAnimals() {
        return new Animal[0];
    }

    @Override
    protected String getFamilyQualifier() {
        return "coding";
    }
}
