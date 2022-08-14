package ru.javarush.entity.herbivores;

import ru.javarush.factory.AbstractFactory;
import ru.javarush.factory.PredatorsFactory;
import ru.javarush.entity.Animal;
import ru.javarush.entity.plants.Plant;
import ru.javarush.system.Config;
import ru.javarush.island.Location;

import java.util.*;

public abstract class Herbivore extends Animal {
    public static int count;

    public Herbivore(Config.AnimalType type, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        super(type, weight, maxCountFromLocation, maxSpeed, maxSatiety);
        count++;
    }

    @Override
    public <T extends Animal> T breed(Location currentLocation) {
        AbstractFactory factory = new PredatorsFactory();

        return (T) factory.createInstance(this.getType());
    }

    public void eatPlant(List<Plant> plants) {
        Herbivore herbivore = this;
        Iterator<Plant> iterator = plants.iterator();

        while (iterator.hasNext() && isSatiety()) {
            herbivore.setSatiety(Math.min(
                    herbivore.getSatiety() + Plant.getWeight(), herbivore.getMaxSatiety()));
            iterator.remove();
            return;
        }


    }
}
