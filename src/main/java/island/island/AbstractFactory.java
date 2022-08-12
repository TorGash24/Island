package island.island;

import island.animals.Animal;

public interface AbstractFactory<T extends Animal> {
    T createInstance(AnimalType animalType);

}
