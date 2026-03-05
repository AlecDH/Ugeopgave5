package Animals;

public abstract class Animal {
    private String name;
    private int energy;

    Animal(String name, int energy){
        this.name = name;
        this.energy = energy;
    }

    public String toString(){
        return getClass() + " \"" + name + "\" (energy: " + energy + ")";
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy < 0){
            energy = 0;
        }
        this.energy = energy;
    }

    public boolean isActive(){
        return energy > 0;
    }

    public abstract int attack();
}
