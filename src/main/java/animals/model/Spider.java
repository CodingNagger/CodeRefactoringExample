package animals.model;

import static animals.model.LandAnimalFamily.SPIDER;

public class Spider implements Animal {
    public String name() {
        return SPIDER.description();
    }

    public int averagePositionAboveSea() {
        return 2;
    }
}
