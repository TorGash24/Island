package island.island;

import island.animals.Animal;
import island.animals.herbivores.Herbivore;
import island.animals.predators.Predator;
import island.plants.Plant;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
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


        // В ЦИКЛЕ ПЕРЕБИРАЕМ ХИЩНИКОВ ИЗ ЛИСТА
        // И КАЖДОМУ ПО ОЧЕРЕДИ СУЕМ СПИСОК ТРАВОЯДНЫХ

        for (int i = 0; i < predators.size(); i++) {
            Predator predator = predators.get(i);


//            if ((predator.satiety < predator.maxSatiety * 20 /100) || predator.weight <= 0) {
//                predators.remove(predator);
//                break;
//            }
            predator.eat(herbivores, this);
            predator.eat(predators, this);

            // РАЗМНОЖАЕМСЯ
//            predator.breed(this);

            // ДВИГАЕМСЯ

            predator.chooseDirection(this, Island.getIsland());
        }


//        for (int i = 0; i < predators.size(); i++) {
//            Predator predator = predators.get(i);
//            day(predator);
//        }

        // ТО ЖЕ САМОЕ ДЕЛАЕМ ДЛЯ ТРАВОЯДНЫХ

        for (int i = 0; i < herbivores.size(); i++) {
            Herbivore herbivore = herbivores.get(i);
            day(herbivore);

            if ((herbivore.satiety < herbivore.maxSatiety * 20 / 100) || herbivore.weight <= 0) {
                herbivores.remove(herbivore);
                break;
            }
//            herbivore.eat(this);
            herbivore.breed(this);
            herbivore.chooseDirection(this, Island.getIsland());
        }

        for (int i = 0; i < plants.size(); i++) {
            Plant plant = plants.get(i);

        }


    }

    public void day(Animal animal) {
        animal.satiety = animal.satiety - animal.satiety * 0.4;
        animal.weight = animal.weight - animal.weight * 0.4;
    }

//    @Override
//    public String toString() {
//        return "Location " +
//                coord + "\n" + "countPredator = " + predators.size() + ", countHerbivores = " + herbivores.size() + ", countPlants = " + plants.size() + "\n" +
//                "herbivores=" + herbivores + "\n" +
//                "predators=" + predators + "\n" +
//                "plants=" + plants + "\n";
//    }

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
                + "\n Predators =" + statisticsPredatorsToLocation.toString()
                + "\n Herbivores = " + statisticsHerbivoresToLocation.toString()
                + "\n Plants = {"+ Plant.getType().image +"=" + plants.size() + "}\n";


    }

    public void comeToLocation(Animal animal) {
        if (animal instanceof Predator) {
            predators.add((Predator) animal);
        } else if (animal instanceof Herbivore) {
            herbivores.add((Herbivore) animal);
        }
    }
}

