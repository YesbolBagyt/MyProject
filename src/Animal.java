import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;

public class Animal {
    private String name;
    private String species;
    private int age;

    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

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

    public void displayInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Animal { " +
                "Name='" + name + '\'' +
                ", Species='" + species + '\'' +
                ", Age=" + age +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age &&
                Objects.equals(name, animal.name) &&
                Objects.equals(species, animal.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, species, age);
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, String species, int age, String breed) {
        super(name, species, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }

    @Override
    public String toString() {
        return super.toString() + ", Breed='" + breed + '\'' + " }";
    }
}

class AnimalDataPool {
    private List<Animal> animals;

    public AnimalDataPool() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void displayAllAnimals() {
        animals.forEach(Animal::displayInfo);
    }

    public List<Animal> filterBySpecies(String species) {
        return animals.stream()
                .filter(animal -> animal.getSpecies().equalsIgnoreCase(species))
                .collect(Collectors.toList());
    }

    public Animal searchByName(String name) {
        return animals.stream()
                .filter(animal -> animal.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Animal> sortByAge() {
        return animals.stream()
                .sorted(Comparator.comparingInt(Animal::getAge))
                .collect(Collectors.toList());
    }
}

class Main {
    public static void main(String[] args) {
        AnimalDataPool dataPool = new AnimalDataPool();

        Animal cat = new Animal("Whiskers", "Cat", 3);
        Dog dog = new Dog("Buddy", "Dog", 5, "Golden Retriever");

        dataPool.addAnimal(cat);
        dataPool.addAnimal(dog);

        System.out.println("All Animals:");
        dataPool.displayAllAnimals();

        System.out.println("\nFilter by Species (Dog):");
        dataPool.filterBySpecies("Dog").forEach(System.out::println);

        System.out.println("\nSearch by Name (Whiskers):");
        System.out.println(dataPool.searchByName("Whiskers"));

        System.out.println("\nSort by Age:");
        dataPool.sortByAge().forEach(System.out::println);
    }
}
