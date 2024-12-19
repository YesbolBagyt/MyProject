class Animal {
    private String name;
    private String species;
    private int age;

    // Constructor
    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method to display animal details
    public void displayInfo() {
        System.out.println("Animal Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Age: " + age);
    }
}

class Zookeeper {
    private String name;
    private int employeeId;
    private int yearsOfExperience;

    // Constructor
    public Zookeeper(String name, int employeeId, int yearsOfExperience) {
        this.name = name;
        this.employeeId = employeeId;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    // Method to display zookeeper details
    public void displayInfo() {
        System.out.println("Zookeeper Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Years of Experience: " + yearsOfExperience);
    }
}

class Zoo {
    private String name;
    private String location;
    private int establishedYear;

    // Constructor
    public Zoo(String name, String location, int establishedYear) {
        this.name = name;
        this.location = location;
        this.establishedYear = establishedYear;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(int establishedYear) {
        this.establishedYear = establishedYear;
    }

    // Method to display zoo details
    public void displayInfo() {
        System.out.println("Zoo Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Established Year: " + establishedYear);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create instances of Animal class
        Animal tiger = new Animal("Tiger", "Panthera tigris", 5);
        Animal elephant = new Animal("Elephant", "Elephas maximus", 10);

        // Create instances of Zookeeper class
        Zookeeper zookeeper1 = new Zookeeper("Adil Ramazan", 101, 8);
        Zookeeper zookeeper2 = new Zookeeper("Isabay Bekarys", 102, 5);

        // Create instance of Zoo class
        Zoo zoo = new Zoo("Greenland Zoo", "Astana", 2010);

        // Display details
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

        // Comparing animals
        System.out.println("\nComparing Animals: " + tiger.getName() + " and " + elephant.getName());
        System.out.println("Same Species: " + tiger.getSpecies().equals(elephant.getSpecies()));
        System.out.println("Same Age: " + (tiger.getAge() == elephant.getAge()));
    }
}
