package farm.units;

public class Humans extends Units {
    protected int resources;

    public Humans(String name, int resources) {
        super(name);
        this.resources = resources;
    }

    public void collect(Pets ...arrPets) {
        int countRes = 0;
        for (int i = 0; i < arrPets.length; i++) {
            if (arrPets[i] != null) {
                this.resources += arrPets[i].resources;
                countRes += arrPets[i].resources;
                arrPets[i].resources = 0;
            }
        }
        System.out.println("Фермер собрал ресурсы в количестве " + countRes);
    }

    public void eatAnimal(Pets ...arrPets) {
        for (int i = 0; i < arrPets.length; i++) {
            if (arrPets[i] != null && arrPets[i] instanceof Eat) {
                this.resources += arrPets[i].weight;
                System.out.println(this.name + " сьел " + arrPets[i].name + " и восполнил " + arrPets[i].weight + " ресурсов ");
                arrPets[i] = null;
                break;
            }
        }
    }
    // прогнать хищника
    public boolean driveAway() {
        double a = Math.random() * 11;
        int b = (int) a;
        boolean c = false;
        if (a > 5) {
            c = true;
        }
        return c;
    }
    // покормить животных
    public void feed(Pets[] arrPets) {
        for (int i = 0; i < arrPets.length; i++) {
            if (arrPets[i] != null) {
                arrPets[i].rest();
            }
        }
        System.out.println(this.name + " покормил животных ");
    }


}
