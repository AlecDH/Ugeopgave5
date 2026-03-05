package Building;

import java.util.ArrayList;

public class Building {
    private String name;
    private ArrayList<Room> rooms;

    Building(String name){
        this.name = name;
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public int getTotalLampCount(){
        int total = 0;
        for (Room room : rooms){
            total += room.getLampCount();
        }
        return total;
    }

    public int getTotalWatt(){
        int total = 0;
        for (Room room : rooms){
            total += room.getTotalWatt();
        }
        return total;
    }

    public void printBuilding(){
        for (Room room : rooms){
            room.printRoom();
        }
    }
}
