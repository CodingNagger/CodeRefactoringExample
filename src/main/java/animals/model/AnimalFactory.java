package animals.model;

public class AnimalFactory {
    private static AnimalFactory instance;

    Dog dog;
    Spider spider;
    BlueFish blueFish;
    Kraken kraken;
    CodingNagger codingNagger;

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
        codingNagger = new CodingNagger();
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

    public Animal[] getCodingAnimals() {
        return new Animal[] {
                codingNagger
        };
    }
}
