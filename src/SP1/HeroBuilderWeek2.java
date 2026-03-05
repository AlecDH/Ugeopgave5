void main() {
    //THOR
    //Character info
    String characterName1 = "Thor";
    int currentHealth1 = 85;
    int maxHealth1 = 100;
    int level1 = 5;
    int xp1 = 2300;
    double gold1 = 156.50;
    boolean isAlive1 = true;
    char fighterClass1 = 'W';
    String[] inventory1 = {"Hammer", "Belt", "Gloves"};

    //Printing Character sheet
    System.out.println("=== CHARACTER SHEET ===");
    System.out.println("Name: " + characterName1);
    System.out.println("Class: " + fighterClass1);
    System.out.println("Level: " + level1);
    System.out.println("Health: " + currentHealth1 + "/" + maxHealth1);
    System.out.println("XP: " + xp1);
    System.out.println("Gold: " + gold1);
    System.out.println("Alive: " + isAlive1);
    System.out.println("");
    System.out.println("Inventory (" + inventory1.length + " items):");
    System.out.println("");

    //Status
    System.out.println("=== STATUS ===");
    if (xp1 > 1000 * level1) {
        System.out.println("Ready to level up!");
    } else {
        System.out.println(1000 * level1 - xp1 + " xp points to next level");
    }
    System.out.println("");

    //Combat
    System.out.println("=== COMBAT ===");
    int round = 1;
    while (isAlive1 && round < 6) {
        System.out.println("ROUND " + round);
        int incomingDamage = 15;
        System.out.println(characterName1 + " takes " + incomingDamage + " damage!");
        int newHealth1 = currentHealth1 - incomingDamage;
        if (newHealth1 < 0) {
            newHealth1 = 0;
        }
        System.out.println("Health: " + currentHealth1 + " -> " + (newHealth1));
        currentHealth1 = newHealth1;
        if (currentHealth1 > 0.25 * maxHealth1) {
            switch (fighterClass1) {
                case 'W':
                    System.out.println(characterName1 + " is still standing strong!");
                    break;
                case 'M':
                    System.out.println(characterName1 + " is feeling fine!");
                    break;
                case 'R':
                    System.out.println(characterName1 + " is still fit for fight!");
                    break;
            }
        } else if (currentHealth1 <= 0.25 * maxHealth1 && currentHealth1 > 0) {
            switch (fighterClass1) {
                case 'W':
                    System.out.println("WARNING: " + characterName1 + " is heavily damaged!");
                    break;
                case 'M':
                    System.out.println("WARNING: " + characterName1 + " is in severe pain!");
                    break;
                case 'R':
                    System.out.println("WARNING: " + characterName1 + " is gravely wounded!");
                    break;
            }
        } else if (currentHealth1 <= 0) {
            isAlive1 = false;
        }
        System.out.println("");
        round++;
    }
    //After combat
    System.out.println("COMBAT OVER");
    if (isAlive1) {
        System.out.println(characterName1 + " has claimed victory on the battlefield!");
    } else {
        System.out.println(characterName1 + " has died in honorable combat.");
    }


    //LOKI

    //Character Sheet
    /*
    String characterName2 = "Loki";
    int currentHealth2 = 45;
    int maxHealth2 = 65;
    int level2 = 4;
    int xp2 = 1900;
    double gold2 = 423.75;
    boolean isAlive2 = true;
    char fighterClass2 = 'R';
    String[] inventory2 = {"Winged shoes", "Magic dice", "Charm", "Finger ring"};

    System.out.println("=== CHARACTER SHEET ===");
    System.out.println("Name: " + characterName2);
    System.out.println("Class: " + fighterClass2);
    System.out.println("Level: " + level2);
    System.out.println("Health: " + currentHealth2 + "/" + maxHealth2);
    System.out.println("XP: " + xp2);
    System.out.println("Gold: " + gold2);
    System.out.println("Alive: " + isAlive2);
    System.out.println("");
    System.out.println("Inventory (" + inventory2.length + " items):");
    for (String object : inventory2) {
        System.out.println("- " + object);
    }
    System.out.println("")
    */
}
