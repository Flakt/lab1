package Vehicles;

import java.awt.*;

/**
 * The type Saab 95.
 */
public class Saab95 extends Cars {
    /**
     * Vehicles.Saab95 is a subclass to the superclass Vehicles.Cars.
     * <br>
     * A Vehicles.Saab95 object has all the instance variables defined in Vehicles.Cars, with the exception
     * of unique instance variables only existing within Vehicles.Saab95. This state information includes:
     *  <ul>
     *      <li>Every instance variable in Vehicles.Cars</li>
     *      <li>A boolean determining if the turbo is on</li>
     *  </ul>
     */

    private boolean turboOn; // The current state of turbo.

    /**
     * Default class constructor.
     */
    public Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
        turboOn = false;
        setModelName("Saab95");
        stopEngine();
    }

    /**
     * Changes turboOn to true.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Changes turboOff to false.
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * Gets turbo on.
     *
     * @return turboOn turbo on
     */
    protected boolean getTurboOn() {
        return turboOn;
    }

    /**
     * Calculates speedfactor depending whether turbo is on or not.
     * @return speedFactor speedFactor
     */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}