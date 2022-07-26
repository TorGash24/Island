package animals.predators;


import animals.Animal;
import animals.herbivores.Herbivore;

import java.util.List;

public abstract class Predator extends Animal {

    public abstract void eat(List<Herbivore> herbivores);

}
