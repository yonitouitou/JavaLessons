package animal;

public class Cat extends Animal {

    @Override
    public void talk() {
        System.out.println("miaou miaou");
    }

    @Override
    public int getNbOfLeggs() {
        return 4;
    }
}
