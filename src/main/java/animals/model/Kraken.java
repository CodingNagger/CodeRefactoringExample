package animals.model;

import static animals.model.SeaAnimalFamily.KRAKEN;

public class Kraken implements Animal {
    public String name() {
        return KRAKEN.description();
    }

    public int averagePositionAboveSea() {
        return -20000;
    }
}
