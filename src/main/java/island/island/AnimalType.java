package island.island;

public enum AnimalType {

    BEAR("\uD83D\uDC3B"),
    SNAKE("\uD83D\uDC0D"),
    EAGLE("\uD83E\uDD85"),
    FOX("\uD83E\uDD8A"),
    WOLF("\uD83D\uDC3A"),
    BUFFALO("\uD83D\uDC03"),
    CATERPILLAR("\uD83D\uDC1B"),
    DEER("\uD83E\uDD8C"),
    DUCK("\uD83E\uDD86"),
    GOAT("\uD83D\uDC10"),
    HORSE("\uD83D\uDC0E"),
    MOUSE("\uD83D\uDC01"),
    RABBIT("\uD83D\uDC07"),
    HOG("\uD83D\uDC17"),
    PLANT("\uD83C\uDF3F"),
    SHEEP("\uD83D\uDC11");

    public String image;

    AnimalType(String image) {
        this.image = image;
    }
}
