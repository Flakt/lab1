import com.sun.javafx.geom.Vec2d;

import java.awt.*;

/**
 * Created by schan on 2017-11-07.
 */
public class Vehicle implements Movable {
    private Vec2d vector = new Vec2d(0,1); // Vector of the car
    private Vec2d point = new Vec2d(0,0); // Point of the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    public Vehicle() {
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