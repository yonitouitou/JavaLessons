package animal;

public class Dog extends Animal {

    protected int number;

    public Dog() {
        System.out.println("Building a dog by empty constructor...");
    }

    public Dog(String id, String name, int number) {
        super(id, name, 4);
        System.out.println("Building a dog by 2nd constructor");
        this.number = number;
    }

    public void f() {
        giveFood();
    }

    @Override
    public final int getNbOfLeggs() {
        return 4;
    }

    @Override
    public void talk() {
        System.out.println("wouf wouf");
    }

    @Override
    public void run() {
        System.out.println("Run from Dog");
    }

    // Overloading
    public void run(int distance) {
        System.out.println("Run " + distance + " meters");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", nbOfLeggs=" + nbOfLeggs +
                '}';
    }
}
