package island;

public class Island {

    Location[][] locations = new Location[Config.WIDTH][Config.HEIGHT];

    public void initialize(){
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                locations[x][y] = new Location(String.format("x = %d, y = %d", x, y));
            }
        }
    }

    public void printStatus(){
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                System.out.print(locations[i][j]);
            }
            System.out.println();
        }
    }

    public void getAnimalsFromLocation() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j].printAnimals();

            }

        }
    }

    public Location[][] getLocations() {
        return locations;
    }
}
