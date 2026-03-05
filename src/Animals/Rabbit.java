package Animals;

public class Rabbit extends Animal{

    Rabbit(String name){
        super(name, 300);
    }

    @Override
    public int attack() {
        return 30;
    }
}
