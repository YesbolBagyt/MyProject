public class Main {
    public static void main(String[] args) {
        Animal tiger = new Animal("Tiger", "Panthera tigris", 5);
        Animal elephant = new Animal("Elephant", "Elephas maximus", 10);

        Zookeeper zookeeper1 = new Zookeeper("Adil Ramazan", 101, 8);
        Zookeeper zookeeper2 = new Zookeeper("Isabay Bekarys", 102, 5);

        Zoo zoo = new Zoo("Greenland Zoo", "Astana", 2010);

        System.out.println("--- Animal Details ---");
        tiger.displayInfo();
        System.out.println();
        elephant.displayInfo();

        System.out.println("\n--- Zookeeper Details ---");
        zookeeper1.displayInfo();
        System.out.println();
        zookeeper2.displayInfo();

        System.out.println("\n--- Zoo Details ---");
        zoo.displayInfo();

        System.out.println("\nComparing Animals: " + tiger.getName() + " and " + elephant.getName());
        System.out.println("Same Species: " + tiger.getSpecies().equals(elephant.getSpecies()));
        System.out.println("Same Age: " + (tiger.getAge() == elephant.getAge()));
    }
}
