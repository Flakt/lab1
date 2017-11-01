import java.awt.*;

public class Saab95 extends Cars {

    public boolean turboOn;

    public Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
        turboOn = false;
        setModelName("Saab95");
        stopEngine();
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}