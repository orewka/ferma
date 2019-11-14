package farm.units;

public class Сhicken extends Pets implements Eat {
    private int maxHealth = 2;

    public void generateResources() {
        this.resources += 2;
    }

    public Сhicken(String name, int weight, int speed, int resources, int health) {
        super(name, weight, speed, resources, health);
    }
}

