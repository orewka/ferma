package farm.units;

public class Farm {
    private Farmer farmer;

    public Farm(Farmer farmer) {
        this.farmer = farmer;
    }

    Predators[] predators = new Predators[3];
    Pets[] pets = new Pets[4];

    public void addPredators(Predators ...newPredators) {
        for (int i = 0; i < newPredators.length; i++) {
            predators[i] = newPredators[i];
        }
    }

    public void addPets(Pets ...newPets) {
        for (int i = 0; i < newPets.length; i++) {
            pets[i] = newPets[i];
        }
    }

    public void passDay() {
        // счетчик дней
        int day = 1;

        // переключатель конца игры
        boolean theEnd = false;
       while (theEnd == false) {

           // считаем хищников
           int aLivePredators = 0;
           for (int i = 0; i < predators.length; i++) {
               if (predators[i] != null) {
                   aLivePredators++;
               }
           }

           // считаем петов
           int countPet = 0;
           for (int i = 0; i < pets.length; i++) {
               if (pets[i] != null) {
                   countPet++;
               }
           }

           // фермер тратит ресурсы
           farmer.resources -= 2;

           if (farmer.resources <= 0) {
               System.out.println("Фермер проиграл");
               theEnd = true;

           } else if (aLivePredators == 0) {
               System.out.println("Фермер победил");
               theEnd = true;

           } else if (aLivePredators > 0) {

               // выбираем рандомного зверя при условии что есть кого атаковать
               if (countPet > 0) {
                   double rnd = Math.random() * predators.length;
                   int rndPredator = (int) rnd;
                   while (predators[rndPredator] == null) {
                       rnd = Math.random() * predators.length;
                       rndPredator = (int) rnd;
                   }

                   // срабатывает шанс что фермер прогонит зверя либо нет и зверь начнет атаковать
                   if (farmer.driveAway()) {
                       predators[rndPredator].prognali += 1;
                       System.out.println(farmer.name + " прогнал " + predators[rndPredator].name);
                   } else {
                       predators[rndPredator].attack(pets);
                   }
               }

               // ведем подсчет ресурсов
               int res = 0;
               for (int i = 0; i < pets.length; i++) {
                   if (pets[i] != null) {
                       res += pets[i].resources;
                   }
               }

               // если ресурсов нет то фермер сьедает пета
               if (res == 0) {
                   farmer.eatAnimal(pets);
               }

               // считаем петов
               countPet = 0;
               for (int i = 0; i < pets.length; i++) {
                   if (pets[i] != null) {
                       countPet++;
                   }
               }

               // если петы еще остались то фермер их кормит и собирает ресурсы
               if (countPet > 0) {
                       farmer.feed(pets);
                       farmer.collect(pets);
               }

               // если зверя прогнали 3 раза то он больше не вернется
               for (int i = 0; i < predators.length; i++) {
                   if (predators[i] != null) {
                       if (predators[i].prognali == 3) {
                           System.out.println(predators[i].name + " изгоняется навсегда ");
                           predators[i] = null;
                       }
                   }
               }

               // петы генерируют ресурсы
               for (int i = 0; i < pets.length; i++) {
                   if (pets[i] != null) {
                       pets[i].generateResources();
                   }
               }
               // вывод счетчика дня и количество ресурсов фермера наданный день
               System.out.println("День " + day + " прошел");
               day++;
               System.out.println("У фермера осталось " + farmer.resources + " ресурсов");
           }
       }
    }
}
