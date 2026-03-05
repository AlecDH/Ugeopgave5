package SP1;

public class HeroBuilderWeek3 {

    //Character values
    String characterName;
    int currentHealth;
    int maxHealth;
    int level;
    int xp;
    double gold;
    char fighterClass;
    String[] inventory = new String[3];

    void main(String[] args) {
        //Character setup
        characterName = "Thor";
        currentHealth = 85;
        maxHealth = 100;
        level = 5;
        xp = 2300;
        gold = 156.50;
        fighterClass = 'W';
        inventory[0] = "Hammer";
        inventory[1] = "Belt";
        inventory[2] = "Gloves";

        printCharacterSheet();

        takeDamage(30);
        heal(20);
        addXP(500);

        if (removeGold(100.0)) {
            System.out.println("Bought a potion!");
        } else {
            System.out.println("Not enough gold!");
        }

        System.out.println("Health: " + getHealthPercentage() + "%");

        if (isHealthCritical()) {
            System.out.println("WARNING: Find a healer!");
        }

        printCharacterSheet();

    }

    void printCharacterSheet(){
        System.out.println("");
        System.out.println("=== CHARACTER SHEET ===");
        System.out.println("Name: " + characterName);
        System.out.println("Class: " + fighterClass);
        System.out.println("Level: " + level);
        System.out.println("Health: " + currentHealth + "/" + maxHealth);
        System.out.println("XP: " + xp);
        System.out.println("Gold: " + gold);
        System.out.println("Alive: " + isAlive());
        System.out.println("");
        printInventory();
        System.out.println("");
    }

    void takeDamage(int amount){
        int newHealth = currentHealth - amount;
        if (newHealth < 0) {
            newHealth = 0;
        }
        System.out.println(characterName + " takes " + amount + " damage! Health: " + currentHealth + " -> " + newHealth);
        currentHealth = newHealth;
    }

    void heal(int amount){
        int newHealth = currentHealth + amount;
        if (newHealth > maxHealth) {
            newHealth = maxHealth;
        }
        System.out.println(characterName + " heals " + amount + " HP! Health: " + currentHealth + " -> " + newHealth);
        currentHealth = newHealth;
    }

    void addGold(double amount){
        gold += amount;
    }

    boolean removeGold(double amount){
        if (gold >= amount){
            gold -= amount;
            return true;
        } else {
            return false;
        }
    }

    void addXP(int amount){
        xp += amount;
        System.out.println(characterName + " gains " + amount + " XP! Total: " + xp);
    }

    void levelUp(){
        level++;
        xp = 0;
        maxHealth *= 1.05;
    }

    boolean isHealthCritical(){
        if (getHealthPercentage() < 25){
            return true;
        } else {
            return false;
        }
    }

    boolean isAlive(){
        if (currentHealth <= 0){
            return false;
        } else {
            return true;
        }
    }

    double getHealthPercentage(){
        return (double) currentHealth / (double) maxHealth * 100;
    }

    void printInventory(){
        System.out.println("Inventory (" + inventory.length + " items)");
        for (String item : inventory) {
            System.out.println("- " + item);
        }
    }

    void addItem(String item){
        String[] newInventory = new String[inventory.length+1];
        for (int i = 0 ; i < inventory.length ; i++){
            newInventory[i] = inventory[i];
        }
        newInventory[inventory.length] = item;
        inventory = newInventory;
    }

    void removeItem(String item){
        if (hasItem(item)){
            String[] newInventory = new String[inventory.length-1];
            int j = 0;
            for (int i = 0 ; i < inventory.length ; i++){
                if (!inventory[i].equals(item)){
                    newInventory[i] = inventory[j];
                }
                j++;
            }
            inventory = newInventory;
        } else {
            System.out.println(characterName + " does not have that item.");
        }
    }

    boolean hasItem(String item){
                for (String slot : inventory){
            if (slot.equals(item)){
                return true;
            }
        }
        return false;
    }
}
