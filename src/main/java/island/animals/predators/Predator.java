package island.animals.predators;


import island.island.*;
import island.animals.Animal;
import island.animals.herbivores.Herbivore;

import java.util.*;

public abstract class Predator extends Animal {

    public static int count;

    public Predator(AnimalType type, String name, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        super(type, name, weight, maxCountFromLocation, maxSpeed, maxSatiety);
    }


    @Override
    public <T extends Animal>void eat(List<T> victim, Location location) {
        Iterator<T> iterator = victim.iterator();

        while (!isSatiety() && iterator.hasNext()) {
            T animal = iterator.next();

            String predatorName = this.getClass().getSimpleName().toLowerCase();

            if (Config.PROBABILITIES.containsKey(predatorName)) {

                Map<String, Integer> statistics = Config.PROBABILITIES.get(predatorName);

                if (animal == null) {
                    System.out.println(animal + " animal null");
                    System.out.println(this + " null");
                }

                String animalName = animal.getClass().getSimpleName().toLowerCase();


                if (statistics.containsKey(animalName)) {

                    int percent = statistics.get(animalName);

                    int random = new Random().nextInt(100);


//                    if (random <= percent) {
//                        this.setParameters(animal);
//                        iterator.remove();
//
//                    }


                }
            }
        }


    }

    @Override
    public void breed(Location currentLocation) {
//        Iterator<Predator> iterator = currentLocation.getPredators().iterator();
//        List<Predator> predators = currentLocation.getPredators();
//        AbstractFactory factory = new HerbivoreFactory();
//
//        while (iterator.hasNext()) {
//            String oneAnimal = this.getClass().getSimpleName();
//            String twoAnimal = iterator.next().getClass().getSimpleName();
//
//            if (oneAnimal.equals(twoAnimal)) {
//                Predator newAnimal = (Predator) factory.createInstance(oneAnimal);
//                predators.add(newAnimal);
//            }
//
//
//        }


    }

    public void eat(List<Animal> herbivores) {
//        Iterator<Animal> iterator = herbivores.iterator();
//
//        while (!isSatiety() && iterator.hasNext()) {
//            Animal herbivore = iterator.next();
//
//            String predatorName = this.getClass().getSimpleName().toLowerCase();
//
//            if (Config.PROBABILITIES.containsKey(predatorName)) {
//
//                Map<String, Integer> statistics = Config.PROBABILITIES.get(predatorName);
//
//                String herbivoreName = herbivore.getClass().getSimpleName().toLowerCase();
//
//
//                if (statistics.containsKey(herbivoreName)) {
//
//                    int percent = statistics.get(herbivoreName);
//
//                    int random = new Random().nextInt(100);
//
//
//
//                    if (random <= percent) {
//                        if ((herbivore.weight + satiety > maxSatiety)) {
//                            satiety = maxSatiety;
//
//                        } else  {
//                            satiety += herbivore.weight;
//                        }
//                        iterator.remove();
//
//                    }
//
//                    double day = maxSatiety * 0.25;
//                    satiety -= day;
//
//
//                }
//            }
//        }


    }


}
