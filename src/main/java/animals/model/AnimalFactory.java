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

    public Animal[] getSeaAnimals() {
        return new Animal[] {
                blueFish,
                kraken
        };
    }

    public Animal[] getLandAnimals() {
        return new Animal[] {
                dog,
                spider
        };
    }
}
