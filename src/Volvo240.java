import java.awt.*;

/**
 * Volvo240 is a subclass to the superclass Cars.
 * <br>
 * A Volvo240 object has all the instance variables defined in Cars, with the exception
 * of unique instance variables only existing within Saab95. This state information includes:
 * <ul>
 *     <li>Every instance variable in Cars</li>
 *     <li>A static double</li>
 * </ul>
 */
public class Volvo240 extends Cars {

    private final static double trimFactor = 1.25; // The trim factor of a Volvo240 car

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
     * @return the speedFactor of a Volvo240 object.
     */
    @Override
    protected double speedFactor(){
            return getEnginePower() * 0.01 * trimFactor;
        }

}
