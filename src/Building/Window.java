package Building;

public class Window {
    private int widthCm;
    private int heightCm;

    Window(int width, int height){
        widthCm = width;
        heightCm = height;
    }

    public String toString(){
        return widthCm + " x " + heightCm;
    }

    public int getAreaCm2(){
        return widthCm*heightCm;
    }
}
