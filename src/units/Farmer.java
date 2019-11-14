package farm.units;

public class Farmer extends Humans {

    public Farmer(String name, int resources) {
        super(name, resources);
    }


    @Override
    public String toString() {
        return "Farmer{" +
                "resources=" + resources +
                ", name='" + name + '\'' +
                '}';
    }
}
