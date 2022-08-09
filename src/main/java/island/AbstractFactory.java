package island;

import animals.Animal;

public interface AbstractFactory<T> {
    T createInstance(String animal);

}
