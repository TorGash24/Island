package ru.javarush.island;

import ru.javarush.entity.Animal;
import ru.javarush.entity.herbivores.Herbivore;
import ru.javarush.entity.predators.Predator;
import ru.javarush.entity.plants.Plant;

import ru.javarush.factory.AbstractFactory;
import ru.javarush.factory.HerbivoreFactory;
import ru.javarush.factory.PredatorsFactory;
import ru.javarush.system.Config;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Location {
    @Getter
    private final Lock lock = new ReentrantLock(true);

    @Getter
    private final Coordinate coordinate;

    @Getter
    private final List<Herbivore> herbivores;

    @Getter
    private final List<Predator> predators;

    @Getter
    private final List<Plant> plants;

    public Location(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.herbivores = addAnimalToLocation(new HerbivoreFactory());
        this.predators = addAnimalToLocation(new PredatorsFactory());
        this.plants = addPlantsToLocation();
    }

    public void calculate() {

        eating();
        moving();
        breeding();
        endOfTheDAy();

    }

    private <T extends Animal> List<T> addAnimalToLocation(AbstractFactory<T> factory) {
        List<T> newAnimals = new ArrayList<>();
        Config.AnimalType[] types = Config.AnimalType.values();
        for (Config.AnimalType type : types) {
            T animal = factory.createInstance(type);
            if (animal == null) {
                continue;
            }
            int countToLocation = Config.RandomClass.getRandom(0, animal.maxCountFromLocation / 2);
            for (int i = 0; i < countToLocation; i++) {
                newAnimals.add(animal);
            }
        }

        return newAnimals;
    }

    private List<Plant> addPlantsToLocation() {
        List<Plant> newPlants = new ArrayList<>();
        int countToLocation = Config.RandomClass.getRandom(Plant.MAX_COUNT_FROM_LOCATION / 2, Plant.MAX_COUNT_FROM_LOCATION);
        for (int i = 0; i < countToLocation; i++) {
            newPlants.add(new Plant());
        }

        return newPlants;
    }

    private synchronized void eating() {
        lock.lock();
        try {
            for (int i = 0; i < herbivores.size(); i++) {
                Herbivore herbivore = herbivores.get(i);
                herbivore.eatPlant(plants);
            }

            for (int i = 0; i < predators.size(); i++) {
                Predator predator = predators.get(i);
                predator.eatAnimal(predators);
            }

            for (int i = 0; i < predators.size(); i++) {
                Predator predator = predators.get(i);
                predator.eatAnimal(herbivores);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private synchronized void moving() {
        lock.lock();
        try {
            for (int i = 0; i < predators.size(); i++) {
                Predator predator = predators.get(i);
                predator.chooseDirection(this, Island.getReferenceIsland());
            }

            for (int i = 0; i < herbivores.size(); i++) {
                Herbivore herbivore = herbivores.get(i);
                herbivore.chooseDirection(this, Island.getReferenceIsland());
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private synchronized void breeding() {
        lock.lock();
        try {
            List<Predator> readyToBreedPredators = new ArrayList<>();
            List<Herbivore> readyToBreedHerbivores = new ArrayList<>();

            for (int i = 0; i < predators.size(); i++) {
                Predator predator = predators.get(i);
                Config.AnimalType typeOne = predator.getType();
                for (int j = i + 1; j < predators.size(); j++) {
                    Config.AnimalType typeTwo = predators.get(j).getType();
                    if (typeOne == typeTwo && predator.getSatiety() == predator.getMaxSatiety()) {
                        readyToBreedPredators.add((Predator) predator.breed());
                    }
                }
            }
            predators.addAll(predators.size(), readyToBreedPredators);

            for (int i = 0; i < herbivores.size(); i++) {
                Herbivore herbivore = herbivores.get(i);
                Config.AnimalType typeOne = herbivore.getType();
                for (int j = i + 1; j < herbivores.size(); j++) {
                    Config.AnimalType typeTwo = herbivores.get(j).getType();
                    if (typeOne == typeTwo && herbivore.getSatiety() == herbivore.getMaxSatiety()) {
                        readyToBreedHerbivores.add((Herbivore) herbivore.breed());
                    }
                }
            }
            herbivores.addAll(herbivores.size(), readyToBreedHerbivores);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private synchronized void endOfTheDAy() {
        lock.lock();
        try {
            List<Predator> predatorIterator = new ArrayList<>(predators);
            List<Herbivore> herbivoreIterator = new ArrayList<>(herbivores);

            for (int i = 0; i < herbivoreIterator.size(); i++) {
                Herbivore herbivore = herbivoreIterator.get(i);
                if (herbivore.checkIsDead()) {
                    herbivores.remove(herbivore);
                }
            }

            for (int i = 0; i < predatorIterator.size(); i++) {
                Predator predator = predatorIterator.get(i);
                if (predator.checkIsDead()) {
                    predators.remove(predator);
                }
            }

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void addAnimals(Animal animal) {
        if (animal instanceof Predator) {
            predators.add((Predator) animal);
        } else if (animal instanceof Herbivore) {
            herbivores.add((Herbivore) animal);
        }
    }

    public void leave(Animal animal) {
        if (animal instanceof Predator) {
            predators.remove(animal);
        } else if (animal instanceof Herbivore) {
            herbivores.remove(animal);
        }
    }
}