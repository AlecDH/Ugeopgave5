void main() {
    String characterName1 = "Thor";
    int currentHealth1 = 85;
    int maxHealth1 = 100;
    int level1 = 5;
    int xp1 = 2300;
    double gold1 = 156.50;
    boolean isAlive1 = true;
    char fighterClass1 = 'W';
    String[] inventory1 = {"Hammer", "Belt", "Gloves"};

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
    System.out.println("- " + inventory1[0]);
    System.out.println("- " + inventory1[1]);
    System.out.println("- " + inventory1[2]);
    System.out.println("");

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
    System.out.println("- " + inventory2[0]);
    System.out.println("- " + inventory2[1]);
    System.out.println("- " + inventory2[2]);
    System.out.println("- " + inventory2[3]);
}
