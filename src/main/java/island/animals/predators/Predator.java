package island.animals.predators;


import island.island.*;
import island.animals.Animal;
import island.animals.herbivores.Herbivore;

import java.util.*;

public abstract class Predator extends Animal {

    public static int count;

    public Predator(AnimalType type, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        super(type, weight, maxCountFromLocation, maxSpeed, maxSatiety);
    }

    public <T>List<T> breed(Location currentLocation) {
        AnimalType typeAnimalOne = this.getType();
        List<Predator> predators = currentLocation.getPredators();
        Iterator<Predator> iteratorPredator = predators.iterator();
        AbstractFactory factory = new PredatorsFactory();

        List<T> newPredators = new ArrayList<>();



        while (iteratorPredator.hasNext()) {
            AnimalType typeAnimalTwo = iteratorPredator.next().getType();
            if (typeAnimalOne == typeAnimalTwo && this.satiety == maxSatiety) {
                newPredators.add((T)factory.createInstance(typeAnimalOne));
            }
        }
        return newPredators;
    }



    public <T extends Animal>void eatAnimal(List<T> victim) {
        Iterator<T> iterator = victim.iterator();

        while (!isSatiety() && iterator.hasNext()) {
            T animal = iterator.next();

            String predatorName = this.getClass().getSimpleName().toLowerCase();

            if (Config.PROBABILITIES.containsKey(predatorName)) {

                Map<String, Integer> statistics = Config.PROBABILITIES.get(predatorName);

                String victimName = animal.getClass().getSimpleName().toLowerCase();


                if (statistics.containsKey(victimName)) {

                    int percent = statistics.get(victimName);

                    int random = new Random().nextInt(100);


                    if (random <= percent) {
                        this.setParameters(animal);
                        iterator.remove();

                    }


                }
            }
        }


    }





}
