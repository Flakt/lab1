package Vehicles;

import java.util.List;

/**
 * Created by schan on 2017-11-16.
 */
public interface Ibiltransport {

    int getMaxLoad();


    /**
     * Gets load.
     *
     * @return the load
     */
    List<Cars> getLoad();

    /**
     * Is flak down boolean.
     *
     * @return the boolean
     */
    boolean isFlakDown();

    /**
     * Sets flak down.
     *
     * @param flakDown the flak down
     */
    void setFlakDown(boolean flakDown);

    /**
     * Load car.
     *
     * @param car the car
     */
    void loadCar(Cars car);


    /**
     * Off load car.
     */
    void offLoadCar();


    /**
     * Starts engine if flak is not down.
     *
     * @see "startEngine at Vehicles.Cars"
     */
    void startEngine();

    /**
     * Gas if flak is not down.
     *
     * @param amount a double that controls how much currentSpeed is incremented,
     */
    void gas(double amount);


    /**
     * Moves the transport first, then all other cars in the transports load follows.
     */
    void move();
}
