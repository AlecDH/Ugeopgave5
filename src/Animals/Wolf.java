package Animals;

import java.util.Random;

public class Wolf extends Animal{

    Wolf(String name){
        super(name, 200);
    }

    @Override
    public int attack(){
        Random random = new Random();
        return random.nextInt(90)+1;
    }
}
