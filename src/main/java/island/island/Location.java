package island.island;

import island.animals.Animal;
import island.animals.herbivores.Herbivore;
import island.animals.predators.Predator;
import island.plants.Plant;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Location {
    @Getter
    private final Lock lock = new ReentrantLock(true);

    @Getter
    private final Coord coord;

    @Getter
    private final List<Herbivore> herbivores;

    @Getter
    private final List<Predator> predators;

    @Getter
    private final List<Plant> plants;

    public Location(Coord coord) {
        this.coord = coord;
        this.herbivores = addAnimalToLocation(new HerbivoreFactory());
        this.predators = addAnimalToLocation(new PredatorsFactory());
        this.plants = addPlantsToLocation();
    }

    private <T extends Animal> List<T> addAnimalToLocation(AbstractFactory<T> factory) {
        List<T> newAnimals = new ArrayList<>();
        AnimalType[] types = AnimalType.values();
        for (AnimalType type : types) {
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

    // добавляем в список животное
    public void addAnimals(Animal animal) {
        if (animal instanceof Predator) {
            long count = (int) predators.stream().filter(x -> animal.getClass().getSimpleName().equals(x.getClass().getSimpleName())).count();
            if (count < animal.maxCountFromLocation) {
                predators.add((Predator) animal);
            }

        } else if (animal instanceof Herbivore) {
            long count = (int) herbivores.stream().filter(x -> animal.getClass().getSimpleName().equals(x.getClass().getSimpleName())).count();
            if (count < animal.maxCountFromLocation) {
                herbivores.add((Herbivore) animal);
            }

        }
    }

    // удаляем из списка животное
    public void leave(Animal animal) {
        if (animal instanceof Predator) {
            predators.remove(animal);
        } else if (animal instanceof Herbivore) {
            herbivores.remove(animal);
        }
    }

    // ОПИСЫВАЕМ СОБЫТИЯ НА ЛОКАЦИИ
    public void calculate() {

        eating();
        moving();
        breeding();
        endOfTheDAy();

    }

    private void breeding() {
        List<Predator> readyToBreedPredators = new ArrayList<>();
        List<Herbivore> readyToBreedHerbivores = new ArrayList<>();


        for (int i = 0; i < predators.size(); i++) {
            Predator predator = predators.get(i);
            readyToBreedPredators.addAll(0, predator.breed(this));
        }

        predators.addAll(predators.size(), readyToBreedPredators);

        for (int i = 0; i < herbivores.size(); i++) {
            Herbivore herbivore = herbivores.get(i);
            readyToBreedHerbivores.addAll(0, herbivore.breed(this));
        }

        herbivores.addAll(herbivores.size(), readyToBreedHerbivores);


    }

    private void endOfTheDAy() {
        List<Predator> predatorList = predators;
        List<Herbivore> herbivoreList = herbivores;

        Iterator<Predator> predatorIterator = predatorList.iterator();
        Iterator<Herbivore> herbivoreIterator = herbivoreList.iterator();

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


    }


    private void moving() {

        for (int i = 0; i < predators.size(); i++) {
            Predator predator = predators.get(i);
            predator.chooseDirection(this, Island.getIsland());
        }

        for (int i = 0; i < herbivores.size(); i++) {
            Herbivore herbivore = herbivores.get(i);
            herbivore.chooseDirection(this, Island.getIsland());
        }
    }

    private void eating() {
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


    }

    @Override
    public String toString() {
        HashMap<String, Long> statisticsPredatorsToLocation = new HashMap<>();
        HashMap<String, Long> statisticsHerbivoresToLocation = new HashMap<>();

        for (Predator predator : predators) {
            String imagePredator = predator.getType().image;

            Long value = statisticsPredatorsToLocation.get(imagePredator);
            if (value == null) {
                statisticsPredatorsToLocation.put(imagePredator, 1L);
            } else {
                statisticsPredatorsToLocation.put(imagePredator, value + 1);
            }
        }

        for (Herbivore herbivore : herbivores) {
            String imageHerbivore = herbivore.getType().image;

            Long value = statisticsHerbivoresToLocation.get(imageHerbivore);
            if (value == null) {
                statisticsHerbivoresToLocation.put(imageHerbivore, 1L);
            } else {
                statisticsHerbivoresToLocation.put(imageHerbivore, value + 1);
            }
        }


        return "Location " +
                coord + "\n" + "countPredator = " + predators.size() + ", countHerbivores = " + herbivores.size() + ", countPlants = " + plants.size()
                + "\nPredators =" + statisticsPredatorsToLocation.toString()
                + "\nHerbivores = " + statisticsHerbivoresToLocation.toString()
                + "\nPlants = {" + Plant.getType().image + "=" + plants.size() + "}\n";


    }

    public void comeToLocation(Animal animal) {
        if (animal instanceof Predator) {
            predators.add((Predator) animal);
        } else if (animal instanceof Herbivore) {
            herbivores.add((Herbivore) animal);
        }
    }
}

