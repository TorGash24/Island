package island.island;

import island.animals.Animal;
import island.animals.herbivores.*;
import island.animals.predators.*;

public class PredatorsFactory implements AbstractFactory<Predator> {

    @Override
    public Predator createInstance(AnimalType animalType) {
        return switch (animalType) {
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case FOX -> new Fox();
            case SNAKE -> new Snake();
            case WOLF -> new Wolf();
            default -> null;
        };
    }
}
