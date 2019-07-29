package animals;

import animals.model.Animal;

import java.util.function.Consumer;

public abstract class AnimalPrinter {
    protected void doThatThingWithAnimals (Consumer<Animal> thing) {
        for (Animal animal : getAnimals()) {
            thing.accept(animal);
        }
    }

    protected abstract Animal[] getAnimals();
}
