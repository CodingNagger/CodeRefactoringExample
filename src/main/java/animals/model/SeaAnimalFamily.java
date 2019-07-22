package animals.model;

public enum SeaAnimalFamily implements AnimalFamily {
    BLUE_FISH("Blue Fish"),
    KRAKEN("Kraken");

    private final String description;

    SeaAnimalFamily(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
