package Building;

public class Main {
    public void main(){
        // Creating objects
        Building gym = new Building("Fictional Fitness");

        Room cardioRoom = new Room("Cardio Building.Room");
        Room weightsArea = new Room("Weights Area");
        Room women = new Room("Women's Locker Building.Room");
        Room men = new Room("Men's Locker Building.Room");
        Room office = new Room("Staff Office");

        Lamp ceiling = new Lamp(12);
        Lamp desk = new Lamp(4);
        Lamp wall = new Lamp(9);

        Window singleFrame = new Window(50, 80);
        Window doubleFrame = new Window(100, 80);
        Window panel = new Window(500, 200);

        // Putting everything in place
        cardioRoom.addSeveralLamps(ceiling, 2);
        cardioRoom.addSeveralLamps(wall, 4);
        cardioRoom.addWindow(panel);

        weightsArea.addSeveralLamps(ceiling, 4);
        weightsArea.addSeveralWindows(panel, 2);

        women.addSeveralLamps(wall, 2);
        women.addSeveralLamps(ceiling, 2);
        women.addWindow(singleFrame);

        men.addSeveralLamps(wall, 2);
        men.addSeveralLamps(ceiling, 2);
        men.addWindow(singleFrame);

        office.addWindow(doubleFrame);
        office.addLamp(ceiling);
        office.addLamp(desk);

        gym.addRoom(cardioRoom);
        gym.addRoom(weightsArea);
        gym.addRoom(women);
        gym.addRoom(men);
        gym.addRoom(office);

        // Print
        gym.printBuilding();
        System.out.println("");
        System.out.println("Total lamp count: " + gym.getTotalLampCount());
        System.out.println("Total wattage: " + gym.getTotalWatt() + " watt");

    }
}
