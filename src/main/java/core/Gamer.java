package core;

public class Gamer {
    private int id;
    private String name;
    private int points;

    public String toString(){
        return "Name : " + name + " -- points : " + points;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
