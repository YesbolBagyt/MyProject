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
        System.out.println("Zookeeper Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Years of Experience: " + yearsOfExperience);
    }
}
