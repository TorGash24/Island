package island;

import animals.Animal;
import animals.herbivores.Herbivore;
import animals.predators.Predator;
import lombok.Getter;
import plants.Plant;

import java.util.ArrayList;
import java.util.List;

public class Location {

    @Getter
    private final Coord coord; //локауия хранит координаты

    // Списки где будут хранитсья находящиеся на локации животные
    @Getter
    private final List<Herbivore> herbivores;

    @Getter
    private final List<Predator> predators;

    @Getter
    private final List<Plant> plants;

    public Location(Coord coord) {
        this.coord = coord;
        this.herbivores = new ArrayList<>();
        this.predators = new ArrayList<>();
        this.plants = new ArrayList<>();
    }
    // добавляем в список животное
    public void addAnimals(Animal animal) {
        if (animal instanceof Predator) {
            predators.add((Predator) animal);
        } else if (animal instanceof Herbivore) {
            herbivores.add((Herbivore)animal);
        } else if (animal instanceof Plant){
            plants.add((Plant) animal);
        }
    }
    // удаляем из списка животное
    public void leave(Animal animal) {
        if (animal instanceof Predator) {
            predators.remove(animal);
        } else if (animal instanceof Herbivore) {
            herbivores.remove(animal);
        } else if (animal instanceof Plant) {
            plants.remove(animal);
        }
    }
    // ОПИСЫВАЕМ СОБЫТИЯ НА ЛОКАЦИИ
    public void calculate() {


        // В ЦИКЛЕ ПЕРЕБИРАЕМ ХИЩНИКОВ ИЗ ЛИСТА
        // И КАЖДОМУ ПО ОЧЕРЕДИ СУЕМ СПИСОК ТРАВОЯДНЫХ

        for (int i = 0; i < predators.size(); i++) {
            Predator predator = predators.get(i);
            day(predator);

            if ((predator.satiety < predator.maxSatiety * 20 /100) || predator.weight <= 0) {
                predators.remove(predator);
                break;
            }
            predator.eat(this);

            // РАЗМНОЖАЕМСЯ
            predator.breed();

            // ДВИГАЕМСЯ
            predator.chooseDirection(this, Island.getIsland());
        }

        // ТО ЖЕ САМОЕ ДЕЛАЕМ ДЛЯ ТРАВОЯДНЫХ

        for (int i = 0; i < herbivores.size(); i++) {
            Herbivore herbivore = herbivores.get(i);
            day(herbivore);

            if ((herbivore.satiety < herbivore.maxSatiety * 20 /100) || herbivore.weight <= 0) {
                herbivores.remove(herbivore);
                break;
            }
            herbivore.eat(this);
            herbivore.breed();
            herbivore.chooseDirection(this, Island.getIsland());
        }

        for (int i = 0; i < plants.size(); i++) {
            Plant plant = plants.get(i);
            plant.breed();
        }


    }

    public void day(Animal animal) {
        animal.satiety = animal.satiety - animal.satiety * 0.4;
        animal.weight = animal.weight - animal.weight * 0.4;
    }

    @Override
    public String toString() {
        return "Location " +
                coord +"\n" + "countPredator = " + predators.size() + ", countHerbivores = " + herbivores.size() + ", countPlants = " + plants.size() + "\n" +
                "herbivores=" + herbivores+ "\n" +
                "predators=" + predators +"\n"+
                "plants=" + plants + "\n";
    }

    public void comeToLocation(Animal animal) {
        if (animal instanceof Predator) {
            predators.add((Predator) animal);
        } else if (animal instanceof Herbivore) {
            herbivores.add((Herbivore) animal);
        }
    }
}

