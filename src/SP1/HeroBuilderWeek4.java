package SP1;

import java.util.ArrayList;

public class HeroBuilderWeek4 {
    class Character{
        private String name;
        private int currentHealth;
        private int maxHealth;
        private int level;
        private int xp;
        private double gold;
        private boolean isAlive;
        private char fighterClass;
        private ArrayList<Item> inventory;
        private Weapon mainHand;
        private Armor chest;
        private boolean checkForHealthPotion;

        public Character(String name, char fighterClass) {
            this.name = name;
            this.maxHealth = 100;
            this.currentHealth = maxHealth;
            this.level = 1;
            this.xp = 0;
            this.gold = 0;
            this.isAlive = true;
            this.fighterClass = fighterClass;
            this.inventory = new ArrayList<>(0);
            this.mainHand = new Weapon("Bare hand", 1);
            this.chest = new Armor("Shirt", 0);
            this.checkForHealthPotion = true;
        }

        public String getName(){
            return name;
        }

        public int getCurrentHealth(){
            return currentHealth;
        }

        public void setCurrentHealth(int value){
            currentHealth = value;
        }

        public void setIsAlive(boolean status){
            isAlive = status;
        }

        public int getDurability(){
            return chest.getDefense();
        }

        public void setDurability(int value){
            chest.setDurability(value);
        }

        public int getDefense(){
            return chest.getDefense();
        }

        public String getFighterClass() {
            switch (fighterClass) {
                case 'W':
                    return "Warrior";
                case 'R':
                    return "Rouge";
                case 'M':
                    return "Mage";
                default:
                    return "NO CLASS AVAILABLE";
            }
        }

        public void printCharacterSheet() {
            System.out.println("=== " + name.toUpperCase() + " (" + getFighterClass() + ") ===");
            System.out.println("Level: " + level + " | Health: " + currentHealth + "/" + maxHealth + " | Gold: " + gold);
            System.out.println("");
        }

        private void attack(Character foe) {
            int incomingDamage = mainHand.damage * level - foe.getDefense();
            foe.setCurrentHealth(foe.getCurrentHealth()-incomingDamage);
            if (foe.getCurrentHealth() < 0) {
                foe.setIsAlive(false);
            }
            foe.setDurability(foe.getDurability()-2);
            mainHand.durability -= 1;
            System.out.println(name + " attacks " + foe.getName() + " for " + incomingDamage + " damage!");
            if (foe.getCurrentHealth() <= 0) {
                foe.setCurrentHealth(0);
                foe.setIsAlive(false);
            }
        }

        private void attack(Mob foe) {
            int incomingDamage = mainHand.damage * level;
            foe.setCurrentHealth(foe.getCurrentHealth()-incomingDamage);
            mainHand.durability -= 1;
            System.out.println(name + " attacks the " + foe.getName() + " for " + incomingDamage + " damage!");
            if (foe.getCurrentHealth() <= 0) {
                foe.setCurrentHealth(0);
                foe.setIsAlive(false);
            }
        }

        public void equipWeapon(Weapon weapon) {
            mainHand = weapon;
        }

        public void equipArmor(Armor armor) {
            chest = armor;
        }

        public void addItem(Item object) {
            inventory.add(object);
        }

        public void removeItem(Item object){
            if (hasItem(object)){
                inventory.remove(object);
            } else {
                System.out.println(name + " does not have that item.");
            }
        }

        private boolean hasItem(Item object){
            for (Item slot : inventory){
                if (slot.equals(object)){
                    return true;
                }
            }
            return false;
        }

        public void takeHealthPotion(){
            if (hasItem(healthPotion)){
                currentHealth += 50;
                removeItem(healthPotion);
                System.out.println(name + " used a " + healthPotion.name + " to recover 50 HP!");
            } else {
                System.out.println(name + " is out of " + healthPotion.name + "s!");
            }
        }

        public void combat(Character boss) {
            System.out.println(this.name + " enters combat with " + boss.name + "!");
            while (this.isAlive && boss.isAlive) {
                if (this.currentHealth <= 50 && this.checkForHealthPotion) {
                    this.takeHealthPotion();
                    if (this.currentHealth <= 50) {
                        this.checkForHealthPotion = false;
                    }
                }
                this.attack(boss);
                if (boss.isAlive) {
                    if (boss.currentHealth <= 50 && boss.checkForHealthPotion) {
                        boss.takeHealthPotion();
                        if (boss.currentHealth <= 50) {
                            boss.checkForHealthPotion =false;
                        }
                    }
                    boss.attack(this);
                }
            }
            if (this.isAlive) {
                this.xp += 500;
                this.gold += 200;
                System.out.println(this.name + " has beaten " + boss.name + "!");
                System.out.println(this.name + " got 500 xp and 200 gold!");
            } else {
                System.out.println(this.name + " was beaten by " + boss.name);
            }
            System.out.println("");
        }

        public void combat(Mob mob) {
            System.out.println(this.name + " enters combat with a " + mob.name + "!");
            while (this.isAlive && mob.isAlive) {
                if (this.currentHealth <= 50 && this.checkForHealthPotion) {
                    this.takeHealthPotion();
                    if (this.currentHealth <= 50) {
                        this.checkForHealthPotion = false;
                    }
                }
                this.attack(mob);
                if (mob.isAlive) {
                    mob.attack(this);
                }
            }
            if (this.isAlive) {
                this.xp += 50;
                this.gold += 20;
                System.out.println(this.name + " beat a " + mob.name);
                System.out.println(this.name + " got 50 xp and 20 gold");
            } else {
                System.out.println(this.name + " died to a " + mob.name);
            }
            System.out.println("");
        }
    }

    class Mob{
        private String name;
        private int currentHealth;
        private int maxHealth;
        private int level;
        private boolean isAlive;

        public Mob(String name, int level){
            this.name = name;
            this.level = level;
            this.maxHealth = level * 20;
            this.currentHealth = maxHealth;
            this.isAlive = true;
        }

        public String getName(){
            return name;
        }

        public int getCurrentHealth(){
            return currentHealth;
        }

        public void setCurrentHealth(int value){
            currentHealth = value;
        }

        public void setIsAlive(boolean status){
            isAlive = status;
        }

        private void attack(Character player) {
            int incomingDamage = 5 * level;
            player.setCurrentHealth(player.getCurrentHealth()-incomingDamage);
            System.out.println("The " + name + " attacks " + player.getName() + " for " + incomingDamage + " damage!");
            if (player.getCurrentHealth() <= 0) {
                player.setCurrentHealth(0);
                player.setIsAlive(false);
            }
        }
    }

    class Item{
        private String name;
        private int weight;
        private double value;

        public Item(String name, int weight, double value) {
            this.name = name;
            this.weight = weight;
            this.value = value;
        }
    }

    Item healthPotion = new Item("Health Potion", 1, 100);

    class Weapon{
        private String name;
        private int damage;
        private int durability;

        public Weapon(String name, int damage) {
            this.name = name;
            this.damage = damage;
            this.durability = 100;
        }
    }

    class Armor{
        private String name;
        private int defense;
        private int durability;

        public Armor(String name, int defense) {
            this.name = name;
            this.defense = defense;
            this.durability = 100;
        }

        public int getDefense(){
            return defense;
        }

        public int getDurability() {
            return durability;
        }

        public void setDurability(int durability) {
            this.durability = durability;
        }
    }

    void main() {

        Character Thor = new Character("Thor", 'W');
        Character Loki = new Character("Loki", 'R');
        Mob troll = new Mob("troll", 1);
        Mob ogre = new Mob("ogre", 2);

        Thor.printCharacterSheet();
        Loki.printCharacterSheet();

        // Obtaining weapons, armor and items
        Weapon hammer = new Weapon("Hammer", 15);
        Weapon dagger = new Weapon("Dagger", 9);
        Armor chestplate = new Armor("Chestplate", 6);


        Thor.equipWeapon(hammer);
        Thor.equipArmor(chestplate);
        Loki.equipWeapon(dagger);
        Loki.addItem(healthPotion);

        // Combat!
        Thor.combat(troll);
        Thor.combat(ogre);
        Thor.combat(Loki);

        // Status after combat
        Thor.printCharacterSheet();
        Loki.printCharacterSheet();
    }
}
