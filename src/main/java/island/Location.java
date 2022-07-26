package island;

import animals.herbivores.Herbivore;
import animals.predators.Predator;
import plants.Plant;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;


    // Списки где будут хранитсья находящиеся на локации сущности
    List<Herbivore> herbivores = new ArrayList<>();
    List<Predator> predators = new ArrayList<>();
    List<Plant> plants = new ArrayList<>();

    public Location(String name) {
        this.name = name;
        herbivores =  new ArrayList<>();
        predators = new ArrayList<>();
        plants = new ArrayList<>();
    }

    public void addHerbivoreToLocation(Herbivore herbivore) {
        herbivores.add(herbivore);
    }

    public void addPredatorToLocation(Predator predator) {
        predators.add(predator);
    }

    public void addPlantToLocation(Plant plant) {
        plants.add(plant);
    }


    // ОПИСЫВАЕМ СОБЫТИЯ НА ЛОКАЦИИ
    public void calculate() {

        // В ЦИКЛЕ ПЕРЕБИРАЕМ ХИЩНИКОВ ИЗ ЛИСТА
        // И КАЖДОМУ ПО ОЧЕРЕДИ СУЕМ СПИСОК ТРАВОЯДНЫХ
        for (int i = 0; i < predators.size(); i++) {
            Predator predator = predators.get(i);
            predator.eat(herbivores);

            // РАЗМНОЖАЕМСЯ
            predator.breed();

            // ДВИГАЕМСЯ
            predator.chooseDirection();
        }

        // ТО ЖЕ САМОЕ ДЕЛАЕМ ДЛЯ ТРАВОЯДНЫХ

        for (int i = 0; i < herbivores.size(); i++) {
            // ... //
        }
        
    }

    public void printAnimals() {

        System.out.printf("%s, herbivores: %s, predators: %s, plants: %s\n",this, herbivores.size(), predators.size(), plants.size());
    }

    @Override
    public String toString() {
        return "Location =[" + name + "]";
    }
}

