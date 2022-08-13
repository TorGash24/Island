package island.island;

import island.animals.Animal;
import lombok.Getter;

public class Island {

    @Getter
    private static Island island;
    @Getter
    private static Location[][] locations;

    public static Island getIsland(int width, int height) {
        island = new Island();
        locations = new Location[width][height];
        island.initialize();
        return island;
    }

    private void initialize(){
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                locations[x][y] = new Location(new Coord(x, y));
            }
        }
    }

    public void printStatus(){

        int allEntity = 0;
        for (int x = 0; x < locations.length; x++) {
            for (int y =0; y < locations[x].length; y++) {
                System.out.println(locations[x][y]);
                allEntity += locations[x][y].getPredators().size();
                allEntity += locations[x][y].getHerbivores().size();
            }
            System.out.println();
        }
        System.out.println(allEntity);
    }

    public void moveToOtherLocation(Coord coord, Animal animal) {
        Location location = getLocationByCoord(coord);
        location.addAnimals(animal);
    }

    private Location getLocationByCoord(Coord coord) {
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                Location location  = locations[x][y];
                if (location.getCoord().equals(coord)) {
                    return location;
                }
            }
        }
        throw new IllegalArgumentException();
    }
}