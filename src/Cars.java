import com.sun.javafx.geom.Vec2d;

import java.awt.*;
/**
 * Cars is an abstract base class for all cars which
 * allows the creation of cars with different attributes.
 * <br>
 * A Cars object encapsulates all state information necessary
 * for creating different types of car objects. This state information
 * includes:
 * <ul>
 *     <li>The current vector</li>
 *     <li>The current point</li>
 *     <li>Amount of doors</li>
 *     <li>Amount of engine power</li>
 *     <li>The current speed</li>
 *     <li>The color</li>
 *     <li>The model name</li>
 * </ul>
 * <br>
 * @author Stefan Chan
 * @version %I% %G%
 * @since 1.8
 */
public class Cars implements Moveable {

    private Vec2d vector = new Vec2d(0,1); // Vector of the car
    private Vec2d point = new Vec2d(0,0); // Point of the car
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    /**
     *
     * Class constructor.
     */
    public Cars() {
        setNrDoors(4);
        setColor(Color.WHITE);
        setEnginePower(100);
    }

    /**
     * @return number of doors in the car-object.
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     *
     * @return the engine power of the car-object.
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     *
     * @return the current speed of the car-object.
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     *
     * @return the color of the car-object.
     */
    public Color getColor(){
        return color;
    }

    /**
     *
     * @return the model name of the car-object.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     *
     * @return the vector
     */
    public Vec2d getVector() {return vector;}

    /**
     *
     * @return the point of the car
     */
    public Vec2d getPoint() {return point;}

    /**
     *
     * @param name the model name. A String.
     */
    public void setModelName(String name) {
        modelName = name;
    }

    /**
     *
     * @param clr the color. A enum from Color.
     */

    public void setColor(Color clr){
        color = clr;
    }

    /**
     *
     * @param enginePower the engine power. A double.
     */
    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    /**
     *
     * @param doors the amount of doors. A int.
     */
    public void setNrDoors(int doors) {
        nrDoors = doors;
    }

    /**
     * Sets currentSpeed to 0,1.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets currentSpeed to 0.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     *
     * @return the speed factor for the car-object.
     */
    protected double speedFactor() {
        return enginePower * 0.01;
    }

    /**
     * Increments currentSpeed depending on the argument. Cannot decrement currentSpeed.
     * @param amount the amount to increment or decrement. A double.
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decreases currentSpeed depending on the argument. Cannot increment currentSpeed.
     * @param amount the amount to increment or decrement. A double.
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Public method that increases a cars currentSpeed.
     * @param amount a double that controls how much currentSpeed is incremented,
     */

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount >= 0.0 && amount <= 1.0) {
            incrementSpeed(amount);
        }
    }

    /**
     * Public method that decreases a cars currentSpeed.
     * @param amount a double that controls how much currentSpeed is decremented.
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    /**
     * Interface method which modifies the cars point depending on currentSpeed.
     */
    @Override
    public void move() {
        this.point.x += vector.x * getCurrentSpeed();
        this.point.y += vector.y * getCurrentSpeed();
    }

    /**
     * Modifies the cars direction it travels depending on the argument, uses vector multiplication.
     * @param angle the angle in degrees which the car is to be turned. A double.
     */
    @Override
    public void turnLeft(Double angle) {
        angle = Math.toRadians(angle);
        double temp = vector.x;
        vector.x = vector.x * Math.cos(angle) - vector.y * Math.sin(angle);
        vector.y =  temp * Math.sin(angle) + vector.y * Math.cos(angle);
    }

    /**
     * Same as turnLeft, but the angle is inverted in order to turn right.
     * @see "turnLeft"
     * @param angle the angle in degrees which the car is to be turned. A double.
     */
    @Override
    public void turnRight(Double angle) {
        turnLeft(angle * -1);
    }
}
