package farm;

import farm.units.*;

public class Main {
    public static void main(String[] args) {

        Farmer farmer = new Farmer("Фермер", 5);
        Farm farm = new Farm(farmer);
        Cat cat = new Cat("Кошка", 3, 10, 0, 5);
        Cow cow = new Cow("Корова", 10, 2, 4, 10);
        Rabbit rabbit = new Rabbit("Кролик", 2, 15, 0, 4);
        Сhicken chicken = new Сhicken("Курица", 1, 4, 2, 2);
        Pets[] pets = {cow, cat, rabbit, chicken};
        Bear bear = new Bear("Медведь", 10, 4, 10);
        Wolf wolf = new Wolf("Волк", 5, 6, 5);
        Fox fox = new Fox("Лиса", 3, 8, 3);
        Predators[] predators = {bear, wolf, fox};
        farm.addPredators(predators);
        farm.addPets(pets);
        farm.passDay();

        // все вопросы переделал, это конечный вариант фермы

    }
}

