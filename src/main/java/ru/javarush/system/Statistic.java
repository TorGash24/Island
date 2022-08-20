package ru.javarush.system;

import ru.javarush.entity.herbivores.Herbivore;
import ru.javarush.entity.predators.Predator;
import ru.javarush.island.Island;
import ru.javarush.island.Location;
import ru.javarush.system.Config.AnimalType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Statistic implements Runnable {
    AtomicInteger day = new AtomicInteger(1);
    private final Island island;
    public final Location[][] locations;

    public Statistic(Island island) {
        this.island = island;
        this.locations = island.getLocations();
    }

    @Override
    public void run() {
        printStatistic();
    }

    private void printStatistic() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                Location location = locations[i][j];
                location.getLock().lock();
                System.out.println("\nLocation [" + location.getCoordinate() + "]");
                System.out.print("Predators [ ");
                for (AnimalType animalType : AnimalType.values()) {
                    List<Predator> predators = new ArrayList<>(location.getPredators());
                    int countPredators = (int) predators.stream().filter(predator -> predator.getType() == animalType).count();
                    if (countPredators > 0) {
                        System.out.print(animalType.image + "=" + countPredators + " ");
                    }
                }
                System.out.println("]");
                System.out.print("Herbivores [ ");
                for (AnimalType animalType : AnimalType.values()) {
                    List<Herbivore> herbivores = new ArrayList<>(location.getHerbivores());
                    int countHerbivores = (int) herbivores.stream().filter(herbivore -> herbivore.getType() == animalType).count();
                    if (countHerbivores > 0) {
                        System.out.print(animalType.image + "=" + countHerbivores + " ");
                    }
                }
                System.out.println("]");
                System.out.println("Plants [ " + location.getPlants().size() + " ]");
                location.getLock().unlock();
            }
        }
        System.out.println("=".repeat(20));
        System.out.println("\tDAY = " + (day.getAndIncrement()));
        System.out.println("\tAnimals: " + island.countAnimal());
        System.out.println("\tPredators: " + island.getCountPredators());
        System.out.println("\tHerbivores: " + island.getCountHerbivores());
        System.out.println("\tPlants: " + island.getCountPlats());
        System.out.println("=".repeat(24));
    }
}