package animals.model;

public enum LandAnimalFamily implements AnimalFamily {
    SPIDER("Spider"),
    DOG("Doggo");

    private final String description;

    LandAnimalFamily(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
