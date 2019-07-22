package animals.model;

public class AnimalFactory {
    private static AnimalFactory instance;

    Dog dog;
    Spider spider;
    BlueFish blueFish;
    Kraken kraken;

    public static AnimalFactory instance() {
        if (instance == null) {
            instance = new AnimalFactory();
        }

        return instance; 
    }

    private AnimalFactory() {
        dog = new Dog();
        spider = new Spider();
        blueFish = new BlueFish();
        kraken = new Kraken();
    }

    public Animal get(AnimalFamily type) {
        switch (type.description()) {
            case "Doggo": return dog;
            case "Spider": return spider;
            case "Blue Fish": return blueFish;
            case "Kraken": return kraken;
        
            default: throw new IllegalArgumentException(type.description());
        }
    }
}
