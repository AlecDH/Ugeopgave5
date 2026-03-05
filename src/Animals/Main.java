package Animals;

import java.util.ArrayList;

public class Main {
    public void main(){
        // Gathering animals
        Animal mane = new Lion("Mane");
        Animal snout = new Wolf("Snout");
        Animal tail = new Wolf("Tail");
        Animal ears = new Rabbit("Ears");
        ArrayList<Animal> contestants = new ArrayList<>();
        contestants.add(mane);
        contestants.add(snout);
        contestants.add(tail);
        contestants.add(ears);

        // Semifinals!
        Contest firstSemifinal = new Contest(contestants.get(0), contestants.get(1));
        Contest secondSemifinal = new Contest(contestants.get(2), contestants.get(3));

        System.out.println("=== Semifinal ===");
        System.out.println(contestants.get(0).getName() + " vs. " + contestants.get(1).getName());
        while (firstSemifinal.getContestant1().isActive() && firstSemifinal.getContestant2().isActive()){
            firstSemifinal.playRound();
        }
        System.out.println(firstSemifinal.getWinner().getName() + " wins!");
        System.out.println("");
        System.out.println("=== Semifinal ===");
        System.out.println(contestants.get(2).getName() + " vs. " + contestants.get(3).getName());
        while (secondSemifinal.getContestant1().isActive() && secondSemifinal.getContestant2().isActive()){
            secondSemifinal.playRound();
        }
        System.out.println(secondSemifinal.getWinner().getName() + " wins!");
        System.out.println("");
        // The final!
        System.out.println("=== Final ===");
        System.out.println(firstSemifinal.getWinner().getName() + " vs. " + secondSemifinal.getWinner().getName());
        Contest grandFinal = new Contest(firstSemifinal.getWinner(),secondSemifinal.getWinner());
        while (grandFinal.getContestant1().isActive() && grandFinal.getContestant2().isActive()){
            grandFinal.playRound();
        }
        System.out.println(grandFinal.getWinner().getName() + " wins!");
    }
}