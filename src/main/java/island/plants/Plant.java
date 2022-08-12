package island.plants;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;
import island.animals.Animal;
import lombok.Getter;

public class Plant {
    @Getter
    private static AnimalType type = AnimalType.PLANT;

    public String name;
    public static int count;
    public static double weight = 1;
    @Getter
    private static int maxCountFromLocation = 200;

    public Plant() {
        name = "plant " + count;
        count++;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                '}';
    }
}
