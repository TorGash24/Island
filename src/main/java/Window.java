public class Window {//implements Runnable {

//    JFrame frame;
//    Location[][] locations;
//
//
//    Island island;
//
//
//    @Override
//    public void run() {
//        initFrame();
//        initIsland();
//        initAnimals();
//        island.printStatus();
//        frame.repaint();
//    }
//
//
//    private void initFrame() {
//        frame = new JFrame();
//        frame.setTitle("Island");
//        frame.getContentPane().setLayout(null);
//        frame.setSize(Config.WIDTH * Config.SIZE_LOCATION, Config.HEIGHT * Config.SIZE_LOCATION);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
////        frame.setResizable(false);
//        frame.setVisible(true);
////        JPanel panel = new JPanel();
////        panel.add(frame);
////        panel.repaint();
//
//
//    }
//
//    private void initIsland() {
//        island = new Island();
//        island.initialize();
//
//        for (int x = 0; x < locations.length; x++) {
//            for (int y = 0; y < locations[x].length; y++) {
//                locations[x][y] = new Location(x, y, Color.BLACK);
//                frame.add(locations[x][y]);
//
//            }
//        }
//
//
//    }
//
//    private void initAnimals() {
//        locations = island.getLocations();
//
//        for (int i = 0; i < Config.COUNT_HERBIVORES; i++) {
//            int x = new Random().nextInt(Config.WIDTH);
//            int y = new Random().nextInt(Config.HEIGHT);
//            locations[x][y].addHerbivore(new Duck());
//        }
//
//        for (int i = 0; i < Config.COUNT_PREDATORS; i++) {
//            int x = new Random().nextInt(Config.WIDTH);
//            int y = new Random().nextInt(Config.HEIGHT);
//            locations[x][y].addPredators(new Bear());
//        }
//
//        for (int i = 0; i < Config.COUNT_PLANTS; i++) {
//            int x = new Random().nextInt(Config.WIDTH);
//            int y = new Random().nextInt(Config.HEIGHT);
//        }
//        for (int x = 0; x < locations.length; x++) {
//            for (int y = 0; y < locations[x].length; y++) {
////                locations[x][y].printAnimals();
//
//            }
//        }
//
//
//    }
}
