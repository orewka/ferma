package farm.units;

public class Animals extends Units {
    protected int weight;
    protected int speed;

    public Animals(String name, int weight, int speed) {
        super(name);
        this.weight = weight;
        this.speed = speed;
    }
}
