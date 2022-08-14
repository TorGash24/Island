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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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
        int countToLocation = Config.RandomClass.getRandom(Plant.getMaxCountFromLocation() / 2, Plant.getMaxCountFromLocation());
        for (int i = 0; i < countToLocation; i++) {
            newPlants.add(new Plant());
        }

        return newPlants;
    }

    private void eating() {
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

    private void moving() {
        lock.lock();
        try {
            for (int i = 0; i < predators.size(); i++) {
                Predator predator = predators.get(i);
                predator.chooseDirection(this, Island.getIsland());
            }

            for (int i = 0; i < herbivores.size(); i++) {
                Herbivore herbivore = herbivores.get(i);
                herbivore.chooseDirection(this, Island.getIsland());
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void breeding() {
        lock.lock();
        try {
            List<Predator> readyToBreedPredators = new ArrayList<>();
            List<Herbivore> readyToBreedHerbivores = new ArrayList<>();

            for (int i = 0; i < predators.size(); i++) {
                for (int j = 0; j < predators.size(); j++) {
                    Predator predatorOne = predators.get(i);
                    Predator predatorTwo = predators.get(j);
                    int random = ThreadLocalRandom.current().nextInt(0, 100);
                    if (predatorOne.getType() == predatorTwo.getType() && predatorOne.getSatiety() == predatorOne.getMaxSatiety() && predatorTwo.getSatiety() == predatorTwo.getMaxSatiety() && random > 60) {
                        readyToBreedPredators.add(predators.get(i).breed(this));
                    }
                }
                predators.addAll(predators.size(), readyToBreedPredators);
            }

            predators.addAll(predators.size(), readyToBreedPredators);

            for (int i = 0; i < herbivores.size(); i++) {
                Herbivore herbivore = herbivores.get(i);
                readyToBreedHerbivores.addAll(herbivore.breed(this));
            }

            herbivores.addAll(herbivores.size(), readyToBreedHerbivores);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void endOfTheDAy() {
        lock.lock();
        try {
            Iterator<Predator> predatorIterator = predators.iterator();
            Iterator<Herbivore> herbivoreIterator = herbivores.iterator();

            while (predatorIterator.hasNext()) {
                Predator predator = predatorIterator.next();
                if (!predator.checkIsLive()) {
                    predatorIterator.remove();
                }
            }

            while (herbivoreIterator.hasNext()) {
                Herbivore herbivore = herbivoreIterator.next();
                if (!herbivore.checkIsLive()) {
                    herbivoreIterator.remove();
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

    @Override
    public String toString() {
        HashMap<String, Long> statisticsPredatorsToLocation = new HashMap<>();
        HashMap<String, Long> statisticsHerbivoresToLocation = new HashMap<>();

        for (Predator predator : predators) {
            String imagePredator = predator.getType().image;
            Long countPredator = statisticsPredatorsToLocation.get(imagePredator);

            if (countPredator == null) {
                statisticsPredatorsToLocation.put(imagePredator, 1L);
            } else {
                statisticsPredatorsToLocation.put(imagePredator, countPredator + 1);
            }
        }

        for (Herbivore herbivore : herbivores) {
            String imageHerbivore = herbivore.getType().image;
            Long countHerbivore = statisticsHerbivoresToLocation.get(imageHerbivore);

            if (countHerbivore == null) {
                statisticsHerbivoresToLocation.put(imageHerbivore, 1L);
            } else {
                statisticsHerbivoresToLocation.put(imageHerbivore, countHerbivore + 1);
            }
        }

        return "Location " +
                coordinate + "\n" + "countPredator = " + predators.size() + ", countHerbivores = " + herbivores.size() + ", countPlants = " + plants.size()
                + "\nPredators =" + statisticsPredatorsToLocation.toString()
                + "\nHerbivores = " + statisticsHerbivoresToLocation.toString()
                + "\nPlants = {" + Plant.getType().image + "=" + plants.size() + "}\n";
    }
}