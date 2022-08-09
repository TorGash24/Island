package animals.predators;


import animals.Animal;
import island.Config;
import island.Location;

import java.util.*;

public abstract class Predator extends Animal {

    public static int count;

    public Predator(String name, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        super(name, weight, maxCountFromLocation, maxSpeed, maxSatiety);
    }


    @Override
    public void eat(Location location) {
       List<Animal> allAnimalsFromLocation = new ArrayList<>();
       allAnimalsFromLocation.addAll(location.getPredators());
       allAnimalsFromLocation.addAll(location.getHerbivores());

        Iterator<Animal> iterator = allAnimalsFromLocation.iterator();

        while (!isSatiety() && iterator.hasNext()) {
            Animal animal = iterator.next();

            String predatorName = this.getClass().getSimpleName().toLowerCase();

            if (Config.PROBABILITIES.containsKey(predatorName)) {

                Map<String, Integer> statistics = Config.PROBABILITIES.get(predatorName);

                String animalName = animal.getClass().getSimpleName().toLowerCase();


                if (statistics.containsKey(animalName)) {

                    int percent = statistics.get(animalName);

                    int random = new Random().nextInt(100);



                    if (random <= percent) {
                        this.setParameters(animal);
                        iterator.remove();

                    }




                }
            }
        }





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
