package farm.units;

public class Pets extends Animals {
    protected int resources;
    protected int health;
    protected int maxHealth;

    public Pets(String name, int weight, int speed, int resources, int health) {
        super(name, weight, speed);
        this.resources = resources;
        this.health = health;
    }
    // восстановление хп
    public void rest() {
            if (this.health < this.maxHealth) {
                this.health += 1;
            }
    }

    // метод генерации ресурсов, перегружается в подклассах
    public void generateResources() {
        this.resources += 2;
    }
}


