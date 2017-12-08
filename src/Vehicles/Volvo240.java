package Vehicles;

import java.awt.*;

/**
 * Vehicles.Volvo240 is a subclass to the superclass Vehicles.Cars.
 * <br>
 * A Vehicles.Volvo240 object has all the instance variables defined in Vehicles.Cars, with the exception
 * of unique instance variables only existing within Vehicles.Saab95. This state information includes:
 * <ul>
 *     <li>Every instance variable in Vehicles.Cars</li>
 *     <li>A static double</li>
 * </ul>
 */
public class Volvo240 extends Cars {

    private final static double trimFactor = 1.25; // The trim factor of a Vehicles.Volvo240 car

    /**
     * A default class constructor.
     */
    public Volvo240(){
            setColor(Color.BLACK);
            setModelName("Volvo240");
            stopEngine();
        }

    /**
     *
     * @return the speedFactor of a Vehicles.Volvo240 object.
     */
    @Override
    protected double speedFactor(){
            return getEnginePower() * 0.01 * trimFactor;
        }

}
