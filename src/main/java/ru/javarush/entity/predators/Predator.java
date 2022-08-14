package ru.javarush.entity.predators;

import ru.javarush.factory.AbstractFactory;
import ru.javarush.factory.PredatorsFactory;
import ru.javarush.entity.Animal;
import ru.javarush.system.Config;
import ru.javarush.system.Config.*;
import ru.javarush.island.Location;

import java.util.*;

public abstract class Predator extends Animal {

     Predator(AnimalType type, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        super(type, weight, maxCountFromLocation, maxSpeed, maxSatiety);
    }

    public <T extends Animal> void eatAnimal(List<T> victimList) {
        Map<AnimalType, Map<AnimalType, Integer>> probabilities = Config.PROBABILITIES;
        Iterator<T> iterator = victimList.iterator();

        while (isSatiety() && iterator.hasNext()) {
            T victim = iterator.next();
            AnimalType predatorType = this.getType();
            if (probabilities.containsKey(predatorType)) {
                Map<AnimalType, Integer> statistics = probabilities.get(predatorType);
                AnimalType victimType = victim.getType();

                if (statistics.containsKey(victimType)) {

                    int percent = statistics.get(victimType);
                    if (RandomClass.getProbability(percent)) {
                        this.setSatiety(Math.min(
                                this.getSatiety() + victim.getWeight(), this.getMaxSatiety()));
                        iterator.remove();
                    }
                }
            }
        }
    }

    @Override
    public Animal breed() {
        PredatorsFactory factory = new PredatorsFactory();
        return factory.createInstance(this.getType());
    }
}
