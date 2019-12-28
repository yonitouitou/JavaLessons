package animal;

public abstract class Animal {

    private String id;
    protected String name;
    protected int nbOfLeggs;

    public abstract void talk();

    public abstract int getNbOfLeggs();

    public Animal() {
        System.out.println("Building animal by empty constructor...");
    }

    public Animal(String id, int nbOfLeggs) {
        System.out.println("Building animal by 2nd constructor...");
        this.id = id;
        this.nbOfLeggs = nbOfLeggs;
    }

    public Animal(String id, String name, int nbOfLeggs) {
        this.id = id;
        this.name = name;
        this.nbOfLeggs = nbOfLeggs;
        System.out.println("Constructor 3");
    }

    protected void giveFood() {
        System.out.println("Give food");
    }

    public void run() {
        System.out.println("default run");
    }

}
