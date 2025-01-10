import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Zoo {
    private String name;
    private String location;
    private int establishedYear;

    public Zoo(String name, String location, int establishedYear) {
        this.name = name;
        this.location = location;
        this.establishedYear = establishedYear;
    }

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

    public void displayInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Zoo { " +
                "Name='" + name + '\'' +
                ", Location='" + location + '\'' +
                ", Established Year=" + establishedYear +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zoo zoo = (Zoo) o;
        return establishedYear == zoo.establishedYear &&
                Objects.equals(name, zoo.name) &&
                Objects.equals(location, zoo.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, establishedYear);
    }
}

class WildlifeSanctuary extends Zoo {
    private String specialty;

    public WildlifeSanctuary(String name, String location, int establishedYear, String specialty) {
        super(name, location, establishedYear);
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

class ZooDataPool {
    private List<Zoo> zoos;

    public ZooDataPool() {
        this.zoos = new ArrayList<>();
    }

    public void addZoo(Zoo zoo) {
        zoos.add(zoo);
    }

    public void displayAllZoos() {
        zoos.forEach(Zoo::displayInfo);
    }

    public List<Zoo> filterByLocation(String location) {
        return zoos.stream()
                .filter(zoo -> zoo.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    public Zoo searchByName(String name) {
        return zoos.stream()
                .filter(zoo -> zoo.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Zoo> sortByEstablishedYear() {
        return zoos.stream()
                .sorted(Comparator.comparingInt(Zoo::getEstablishedYear))
                .collect(Collectors.toList());
    }
}

class Main {
    public static void main(String[] args) {
        ZooDataPool dataPool = new ZooDataPool();

        Zoo cityZoo = new Zoo("City Zoo", "New York", 1900);
        WildlifeSanctuary sanctuary = new WildlifeSanctuary("Rainforest Sanctuary", "Amazon", 1980, "Tropical Wildlife");

        dataPool.addZoo(cityZoo);
        dataPool.addZoo(sanctuary);

        System.out.println("All Zoos:");
        dataPool.displayAllZoos();

        System.out.println("\nFilter by Location (Amazon):");
        dataPool.filterByLocation("Amazon").forEach(System.out::println);

        System.out.println("\nSearch by Name (City Zoo):");
        System.out.println(dataPool.searchByName("City Zoo"));

        System.out.println("\nSort by Established Year:");
        dataPool.sortByEstablishedYear().forEach(System.out::println);
    }
}
