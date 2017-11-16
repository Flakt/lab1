/**
 * Vehicle is an abstract base class for all vehicles which
 * allows the creation of vehicles with different attributes.
 * <br>
 * A Vehicle object encapsulates all state information necessary
 * for creating different types of vehicle objects. This state information
 * includes:
 * <ul>
 * <li>The current vector</li>
 * <li>The current point</li>
 * <li>Amount of engine power</li>
 * <li>The current speed</li>
 * <li>The color</li>
 * <li>The model name</li>
 * </ul>
 * <br>
 *
 * @author Stefan Chan
 * @version %I% %G%
 * @since 1.8
 */

import com.sun.javafx.geom.Vec2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The type Vehicle.
 */
public abstract class Vehicle implements Movable {
    private Vec2d vector = new Vec2d(1,0); // Vector of the vehicle
    private Vec2d point = new Vec2d(0,0); // Point of the vehicle
    private double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of the vehicle
    private Color color; // Color of the vehicle
    private String modelName; // The vehicle model name
    private boolean isLoaded = false; // Is the vehicle loaded?

    /**
     * Instantiates a new Vehicle.
     */
    protected Vehicle() {
        setColor(Color.WHITE);
        setEnginePower(100);
    }

    /**
     * Get engine power double.
     *
     * @return the engine power of the car-object.
     */
    protected double getEnginePower(){
        return enginePower;
    }

    /**
     * Get current speed double.
     *
     * @return the current speed of the car-object.
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Get color color.
     *
     * @return the color of the car-object.
     */
    protected Color getColor(){
        return color;
    }

    /**
     * Gets model name.
     *
     * @return the model name of the car-object.
     */
    protected String getModelName() {
        return modelName;
    }

    /**
     * Gets vector.
     *
     * @return the vector
     */
    public Vec2d getVector() {return vector;}

    /**
     * Gets point.
     *
     * @return the point of the car
     */
    public Vec2d getPoint() {return point;}

    /**
     * Sets model name.
     *
     * @param name the model name. A String.
     */
    protected void setModelName(String name) {
        modelName = name;
    }

    /**
     * Set color.
     *
     * @param clr the color. A enum from Color.
     */
    protected void setColor(Color clr){
        color = clr;
    }

    /**
     * Sets engine power.
     *
     * @param enginePower the engine power. A double.
     */
    protected void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * Sets point.
     *
     * @param p the p
     */
    protected void setPoint(Vec2d p) {
        this.point = p;
    }

    /**
     * Gets isLoaded.
     *
     * @return the is loaded
     */
    public boolean getIsLoaded() {
        return isLoaded;
    }

    /**
     * Sets isLoaded.
     *
     * @param bool the bool
     */
    protected void setIsLoaded(boolean bool) {
        isLoaded = bool;
    }

    /**
     * Sets currentSpeed to 0,1 if isLoaded
     */
    public void startEngine(){
        if (!isLoaded) {
            currentSpeed = 0.1;
        }
    }

    /**
     * Sets currentSpeed to 0.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Speed factor double.
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
     *
     * @param amount a double that controls how much currentSpeed is incremented,
     */
    public void gas(double amount){
        if (amount >= 0.0 && amount <= 1.0 && !isLoaded) {
            incrementSpeed(amount);
        }
    }

    /**
     * Public method that decreases a cars currentSpeed.
     *
     * @param amount a double that controls how much currentSpeed is decremented.
     */
    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    protected BufferedImage getImage() {
        try {
            return ImageIO.read(new File("src\\pics\\" + getModelName() + ".jpg"));
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        return null;
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
