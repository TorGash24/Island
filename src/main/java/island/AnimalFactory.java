package island;

import animals.Animal;
import animals.herbivores.*;
import animals.predators.*;


public class AnimalFactory implements AbstractFactory<Animal> {


    @Override
    public Animal createInstance(String animal) {
        if (animal.equals("buffalo")) {
            return new Buffalo();
        } else if (animal.equals("caterpillar")) {
            return new Caterpillar();
        } else if (animal.equals("deer")) {
            return new Deer();
        } else if (animal.equals("duck")) {
            return new Duck();
        } else if (animal.equals("goat")) {
            return new Goat();
        } else if (animal.equals("hog")) {
            return new Hog();
        } else if (animal.equals("horse")) {
            return new Horse();
        } else if (animal.equals("mouse")) {
            return new Mouse();
        } else if (animal.equals("rabbit")) {
            return new Rabbit();
        } else if (animal.equals("sheep")) {
            return new Sheep();
        } else if (animal.equals("bear")) {
            return new Bear();
        } else if (animal.equals("eagle")) {
            return new Eagle();
        } else if (animal.equals("fox")) {
            return new Fox();
        } else if (animal.equals("snake")) {
            return new Snake();
        } else if (animal.equals("wolf")) {
            return new Wolf();
        }
        return null;
    }
}
