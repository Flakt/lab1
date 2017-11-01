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

    private Vec2d vector; // Vector of the car
    private Point point; // Point of the car
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
    private double speedFactor() {
        return enginePower * 0.01;
    }

    /**
     * Increments currentSpeed depending on the argument.
     * @param amount the amount to increment or decrement. A double.
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decreases currentSpeed depending on the argument.
     * @param amount the amount to increment or decrement. A double.
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    @Override
    public void move() {
        this.point.x += vector.x * getCurrentSpeed();
        this.point.y += vector.y * getCurrentSpeed();
    }

    @Override
    public void turnLeft(Double angle) {
        vector.x = vector.x * Math.cos(angle) - vector.y * Math.sin(angle);
        vector.y =  vector.x * Math.sin(angle) + vector.y * Math.cos(angle);
    }

    @Override
    public void turnRight(Double angle) {
        turnLeft(angle * -1);
    }
}
