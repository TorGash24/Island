package ru.javarush.entity.herbivores;

import ru.javarush.factory.HerbivoreFactory;
import ru.javarush.entity.Animal;
import ru.javarush.entity.plants.Plant;
import ru.javarush.system.Config;

import java.util.*;

public abstract class Herbivore extends Animal {

    Herbivore(Config.AnimalType type, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        super(type, weight, maxCountFromLocation, maxSpeed, maxSatiety);
    }

    public void eatPlant(List<Plant> plantList) {
        List<Plant> copyPlantList = new ArrayList<>(plantList);

        for (int i = 0; i < copyPlantList.size(); i++) {
            if (isSatiety()) {
                this.setSatiety(Math.min(
                        this.getSatiety() + Plant.getWEIGHT(), this.getMaxSatiety()));
                plantList.remove(copyPlantList.get(i));
            }
        }
    }

    @Override
    public Animal breed() {
        HerbivoreFactory herbivoreFactory = new HerbivoreFactory();
        return herbivoreFactory.createInstance(this.getType());
    }
}