package animals;

import animals.model.Animal;
import animals.model.AnimalFactory;
import animals.model.LandAnimalFamily;

import java.util.EnumSet;

public class LandAnimalPrinter {
    private final AnimalFactory animalFactory;
    private int averagePositionAboveSea = 0;

    private LandAnimalPrinter(AnimalFactory animalFactory) {
        this.animalFactory = animalFactory;
    }

    public static LandAnimalPrinter instance(AnimalFactory animalFactory) {
        return new LandAnimalPrinter(animalFactory);
    }

    public void print() {
        printLandAnimalsSummary();
        printLandAnimalsDetails();
    }

    private void printLandAnimalsSummary() {
        int animalsCount = EnumSet.allOf(LandAnimalFamily.class).size();
        averagePositionAboveSea = 0;

        EnumSet.allOf(LandAnimalFamily.class).forEach(
                t -> averagePositionAboveSea += animalFactory.get(t).averagePositionAboveSea()
        );

        System.out.println(String.format(
                "There are %d land animals. Their average position above sea is %d meters.",
                animalsCount, averagePositionAboveSea));
    }

    private void printLandAnimalsDetails() {
        EnumSet.allOf(LandAnimalFamily.class).forEach(type -> {
            Animal animal = animalFactory.get(type);
            System.out.println(String.format(
                    "The %s has an average position above sea is %d meters.",
                    animal.name(), animal.averagePositionAboveSea() ));
        });
    }
}