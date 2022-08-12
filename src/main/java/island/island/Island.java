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

    public void addAnimals() {
//        List<String> types = Config.ALL_TYPES_ANIMALS;
//        HerbivoreFactory factory = new HerbivoreFactory();
//
////        for (int x = 0; x < locations.length; x++) {
////            for (int y = 0; y < locations[x].length; y++) {
////                locations[x][y].addAnimalsFromLocation();
////            }
////        }
//
//        for (int x = 0; x < locations.length; x++) {
//            for (int y = 0; y < locations[x].length; y++) {
//                for (int i = 0; i < types.size(); i++) {
//                    int randomCountType = new Random().nextInt(50);
//                    for (int z = 0; z < randomCountType % types.size(); z++) {
//                        Animal animal = factory.createInstance(types.get(z));
//                        locations[x][y].addAnimals(animal);
//                    }
//                }
//            }
//        }
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