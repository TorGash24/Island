package island.animals.herbivores;

import island.animals.predators.Predator;
import island.island.*;
import island.animals.Animal;
import island.plants.Plant;

import java.util.*;

public abstract class Herbivore extends Animal {
    public static int count;

    public Herbivore(AnimalType type, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        super(type, weight, maxCountFromLocation, maxSpeed, maxSatiety);
        count++;
    }

    public <T> List<T> breed(Location currentLocation) {
        AnimalType typeAnimalOne = this.getType();

        List<Herbivore> herbivores = currentLocation.getHerbivores();
        List<T> newHerbivore = new ArrayList<>();

        Iterator<Herbivore> iteratorHerbivore = herbivores.iterator();

        AbstractFactory factory = new PredatorsFactory();

        while (iteratorHerbivore.hasNext()) {
            AnimalType typeAnimalTwo = iteratorHerbivore.next().getType();
            if (typeAnimalOne == typeAnimalTwo && this.satiety == maxSatiety) {
                newHerbivore.add((T)factory.createInstance(typeAnimalOne));
            }
        }
        return newHerbivore;
    }

    public void eatPlant(List<Plant> plants) {

        Herbivore herbivore = this;
        Iterator<Plant> iterator = plants.iterator();

        while (iterator.hasNext()) {
            Plant plant = iterator.next();
            if (herbivore.satiety < herbivore.maxSatiety) {
                herbivore.satiety = Math.min(herbivore.satiety + Plant.getWeight(), herbivore.maxSatiety);
                iterator.remove();
                return;
            }

        }


    }
}
