/**
 * Scania is a subclass to the superclass Cars.
 * <br>
 * A Scania object has all the instance variables defined in Cars, with the exception
 * of unique instance variables only existing within Saab95. This state information includes:
 *  <ul>
 *      <li>Every instance variable in Cars</li>
 *      <li>A double describing the angle of the flak</li>
 *  </ul>
 */
public class Scania extends Cars {

    private double flakAngle;

    /**
     * Instantiates a new Scania.
     */
    public Scania() {
        setNrDoors(2);
        setModelName("Scania");
        setFlakAngle(1);
        stopEngine();
    }

    /**
     * Gets flakAngle.
     *
     * @return the flakAngle
     */
    public double getFlakAngle() {
        return flakAngle;
    }


    /**
     * Sets flakAngle. Only sets if angle <= 70 and angle >= 0.
     * If currentSpeed == 0, sets flakAngle if angle != 0.
     * @param angle the angle
     */
    public void setFlakAngle(double angle) {
        angle = Math.toRadians(angle);
        if (angle >= 0.0 && angle <= 70.0) {
            if (getCurrentSpeed() == 0 && angle != 0) {
                flakAngle = angle;
            }
            else if (getCurrentSpeed() != 0) {
                flakAngle = angle;
            }
        }
    }
}
