package Animals;

public class Lion extends Animal{

    Lion(String name) {
        super(name, 100);
    }

    @Override
    public int attack() {
        return 90;
    }
}