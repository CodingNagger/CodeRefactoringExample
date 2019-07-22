package animals.model;

import static animals.model.SeaAnimalFamily.BLUE_FISH;

public class BlueFish implements Animal {
    public String name() {
        return BLUE_FISH.description();
    }

    public int averagePositionAboveSea() {
        return -100;
    }
}
