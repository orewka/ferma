package farm.units;

public class Cow extends Pets implements Eat {
    private int maxHealth = 12;

    public void generateResources() {
        this.resources += 4;
    }

    public Cow(String name, int weight, int speed, int resources, int health) {
        super(name, weight, speed, resources, health);
    }
}
