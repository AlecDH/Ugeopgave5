package Building;

import java.util.ArrayList;

public class Room {
    private String name;
    private ArrayList<Lamp> lamps;
    private ArrayList<Window> windows;

    Room(String name){
        this.name = name;
        lamps = new ArrayList<>();
        windows = new ArrayList<>();
    }

    public void addLamp(Lamp lamp){
        lamps.add(lamp);
    }

    public void addWindow(Window window){
        windows.add(window);
    }

    public void addSeveralLamps(Lamp lamp, int number){
        for (int i = 0; i < number; i++){
            addLamp(lamp);
        }
    }

    public void addSeveralWindows(Window window, int number){
        for (int i = 0; i < number; i++){
            addWindow(window);
        }
    }

    public int getLampCount(){
        return lamps.size();
    }

    public int getTotalWatt(){
        int total = 0;
        for (Lamp lamp : lamps){
            total += lamp.getWatt();
        }
        return total;
    }

    public int getTotalWindowArea(){
        int total = 0;
        for (Window window : windows){
            total += window.getAreaCm2();
        }
        return total;
    }

    public void printRoom(){
        System.out.println(name + ": " + getLampCount() + " lamps (" + getTotalWatt() + " watt) and "
            + getTotalWindowArea() + " cm2 of windows");
    }
}
