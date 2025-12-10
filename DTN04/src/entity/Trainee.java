package entity;

public class Trainee {
    private int id;
    private String name;

    // Constructor
    public Trainee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trainee{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
