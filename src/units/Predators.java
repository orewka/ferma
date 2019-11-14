package farm.units;

public class Predators extends Animals {
    protected int powerHit;
    protected int prognali = 0;

    public Predators(String name, int weight, int speed, int powerHit) {
        super(name, weight, speed);
        this.powerHit = powerHit;
    }
    // атака петов
    public void attack(Pets ...newPets) {
        // выбираем на кого нападать
        double rnd = Math.random() * newPets.length;
        int rndPet = (int) rnd;
        while (newPets[rndPet] == null) {
            rnd = Math.random() * newPets.length;
            rndPet = (int) rnd;
        }
        // нападение
        if (this.speed >= newPets[rndPet].speed) {
                newPets[rndPet].health -= this.powerHit;
                if (newPets[rndPet].health > 0) {
                    System.out.println(this.name + " наносит " + newPets[rndPet].name + " " + this.powerHit + " урона ");
                } else {
                    System.out.println(this.name + " наносит " + newPets[rndPet].name + " " + this.powerHit + " урона и сьедает");
                    newPets[rndPet] = null;
                }

        } else {
                System.out.println(newPets[rndPet].name + " убежал от " + this.name);
            }
    }
}



