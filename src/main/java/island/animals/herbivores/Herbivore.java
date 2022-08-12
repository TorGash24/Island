package island.animals.herbivores;

import island.island.AnimalType;
import island.island.Config;
import island.island.Location;
import island.animals.Animal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class Herbivore extends Animal {
    public static int count;

    public Herbivore(AnimalType type, String name, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        super(type, name, weight, maxCountFromLocation, maxSpeed, maxSatiety);
        count++;
    }

    @Override
    public <T extends Animal> void eat(List<T> victim, Location location) {

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

    }
}
