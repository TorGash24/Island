package island.island;

import island.animals.herbivores.*;
import island.animals.predators.*;
import island.animals.Animal;


public class HerbivoreFactory implements AbstractFactory<Herbivore> {

    @Override
    public Herbivore createInstance(AnimalType animalType) {

        return switch (animalType) {
            case BUFFALO -> new Buffalo();
            case CATERPILLAR -> new Caterpillar();
            case DEER -> new Deer();
            case DUCK -> new Duck();
            case GOAT -> new Goat();
            case HOG -> new Hog();
            case HORSE -> new Horse();
            case RABBIT -> new Rabbit();
            case SHEEP -> new Sheep();
            case MOUSE -> new Mouse();
            default -> null;
        };
    }
}
