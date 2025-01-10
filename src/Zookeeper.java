import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Zookeeper {
    private String name;
    private int employeeId;
    private int yearsOfExperience;

    public Zookeeper(String name, int employeeId, int yearsOfExperience) {
        this.name = name;
        this.employeeId = employeeId;
        this.yearsOfExperience = yearsOfExperience;
    }

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

    public void displayInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Zookeeper { " +
                "Name='" + name + '\'' +
                ", Employee ID=" + employeeId +
                ", Years of Experience=" + yearsOfExperience +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zookeeper zookeeper = (Zookeeper) o;
        return employeeId == zookeeper.employeeId &&
                yearsOfExperience == zookeeper.yearsOfExperience &&
                Objects.equals(name, zookeeper.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employeeId, yearsOfExperience);
    }
}

class SeniorZookeeper extends Zookeeper {
    private String specialty;

    public SeniorZookeeper(String name, int employeeId, int yearsOfExperience, String specialty) {
        super(name, employeeId, yearsOfExperience);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialty: " + specialty);
    }

    @Override
    public String toString() {
        return super.toString() + ", Specialty='" + specialty + '\'' + " }";
    }
}

class ZookeeperDataPool {
    private List<Zookeeper> zookeepers;

    public ZookeeperDataPool() {
        this.zookeepers = new ArrayList<>();
    }

    public void addZookeeper(Zookeeper zookeeper) {
        zookeepers.add(zookeeper);
    }

    public void displayAllZookeepers() {
        zookeepers.forEach(Zookeeper::displayInfo);
    }

    public List<Zookeeper> filterByExperience(int minYears) {
        return zookeepers.stream()
                .filter(zookeeper -> zookeeper.getYearsOfExperience() >= minYears)
                .collect(Collectors.toList());
    }

    public Zookeeper searchByName(String name) {
        return zookeepers.stream()
                .filter(zookeeper -> zookeeper.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Zookeeper> sortByExperience() {
        return zookeepers.stream()
                .sorted(Comparator.comparingInt(Zookeeper::getYearsOfExperience).reversed())
                .collect(Collectors.toList());
    }
}

class Main {
    public static void main(String[] args) {
        ZookeeperDataPool dataPool = new ZookeeperDataPool();

        Zookeeper zookeeper1 = new Zookeeper("Alice", 101, 5);
        SeniorZookeeper zookeeper2 = new SeniorZookeeper("Bob", 102, 10, "Large Mammals");
        SeniorZookeeper zookeeper3 = new SeniorZookeeper("Charlie", 103, 15, "Reptiles");

        dataPool.addZookeeper(zookeeper1);
        dataPool.addZookeeper(zookeeper2);
        dataPool.addZookeeper(zookeeper3);

        System.out.println("All Zookeepers:");
        dataPool.displayAllZookeepers();

        System.out.println("\nFilter by Experience (>= 10 years):");
        dataPool.filterByExperience(10).forEach(System.out::println);

        System.out.println("\nSearch by Name (Bob):");
        System.out.println(dataPool.searchByName("Bob"));

        System.out.println("\nSort by Years of Experience:");
        dataPool.sortByExperience().forEach(System.out::println);
    }
}
