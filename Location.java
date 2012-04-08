import java.io.Serializable;

public class Location implements Serializable {
    private int x;
    private int y;
    
    public Location(){
        x = 0;
        y = 0;
    }
    
    public Location(int a, int b){
        x = a;
        y = b;
    }
    
    public void setLocation(int a, int b){
        x = a;
        y = b;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}
