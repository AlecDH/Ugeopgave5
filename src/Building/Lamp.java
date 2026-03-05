package Building;

public class Lamp {
    private int watt;
    private boolean isOn;

    Lamp(int watt){
        this.watt = watt;
        isOn = false;
    }

    public String toString(){
        return watt+"";
    }

    public int getWatt(){
        return watt;
    }

    public void turnOn(){
        isOn = true;
    }

    public void turnOff(){
        isOn = false;
    }

}