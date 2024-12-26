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
        System.out.println("Zoo Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Established Year: " + establishedYear);
    }
}
