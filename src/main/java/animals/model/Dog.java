package animals.model;

import static animals.model.LandAnimalFamily.DOG;

public class Dog implements Animal {
    public String name() {
        return DOG.description();
    }

    public int averagePositionAboveSea() {
        return 10;
    }
}
