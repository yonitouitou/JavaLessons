package zoo;

import animal.Animal;
import animal.Cat;
import animal.Dog;
import animal.Pitbull;

public class MyTester {

    public static void main(String[] args) {

        Animal dog = new Dog();
        Animal pitbull = new Pitbull();
        Animal cat = new Cat();

        Animal[] zoo = {dog, pitbull, cat};

        int counterDog = 0;
        int counterCat = 0;
        int counterPitbull = 0;

        for (Animal animal : zoo) {
            if (animal instanceof Pitbull) {
                counterPitbull++;
            }
            if (animal instanceof Dog) {
                counterDog++;
            }

            if (animal instanceof Cat) {
                counterDog++;
            }
        }

        System.out.println("Nb of Dogs : " + counterDog);
        System.out.println("Nb of Pitbulls : " + counterPitbull);
        System.out.println("Nb of Cats : " + counterCat);








    }

}
