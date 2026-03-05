package Animals;

public class Contest {
    private Animal animal1;
    private Animal animal2;
    private int count;

    Contest(Animal animal1, Animal animal2){
        this.animal1 = animal1;
        this.animal2 = animal2;
        count = 0;
    }

    public Animal getContestant1(){
        return animal1;
    }

    public Animal getContestant2(){
        return animal2;
    }

    public void playRound(){
        int damage1 = animal1.attack();
        int damage2 = animal2.attack();
        animal1.setEnergy(animal1.getEnergy()-damage2);
        animal2.setEnergy(animal2.getEnergy()-damage1);
        System.out.println("--- Round " + (count + 1) + " ---");
        System.out.println(animal1.getName() + " attacks " + animal2.getName() + " for " + damage1 + "! ("
                            + animal2.getName() + " has " + animal2.getEnergy() + " energy left)");
        System.out.println(animal2.getName() + " attacks " + animal1.getName() + " for " + damage2 + "! ("
                + animal1.getName() + " has " + animal1.getEnergy() + " energy left)");
        count++;
    }

    public Animal getWinner(){
        if (animal1.isActive() && !animal2.isActive()){
            return animal1;
        } else if (animal2.isActive() && !animal1.isActive()) {
            return animal2;
        } else {
            return null;
        }
    }

}
