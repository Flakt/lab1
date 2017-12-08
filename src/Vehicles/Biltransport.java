package Vehicles;

import java.util.*;

/**
 * The type Vehicles.Biltransport.
 */
public class Biltransport implements Loadable {

    private boolean flakDown;
    private int maxLoad;
    private List<Cars> load = new ArrayList<>();
    private Vehicle v;


    /**
     * Instantiates a new Vehicles.Biltransport.
     */
    protected Biltransport(Vehicle v) {
        setFlakDown(false);
        setMaxLoad(10);
        this.v = v;
    }

    /**
     * Sets max load.
     *
     * @param maxLoad the max load
     */
    protected void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    /**
     * Gets max load.
     *
     * @return the max load
     */
    public int getMaxLoad() {
        return maxLoad;
    }


    /**
     * Gets load.
     *
     * @return the load
     */
    public List<Cars> getLoad() {
        return load;
    }

    /**
     * Is flak down boolean.
     *
     * @return the boolean
     */
    public boolean isFlakDown() {
        return flakDown;
    }

    /**
     * Sets flak down.
     *
     * @param flakDown the flak down
     */
    public void setFlakDown(boolean flakDown) {
        if (flakDown && v.getCurrentSpeed() == 0) {
            this.flakDown = flakDown;
        } else if (!flakDown) {
            this.flakDown = flakDown;
        }
    }

    /**
     * Load car.
     *
     * @param car the car
     */
    public void loadCar(Cars car) {
        if (load.size() < maxLoad && isClose(car) && isFlakDown() && !car.getIsLoaded()) {
            car.stopEngine();
            car.setIsLoaded(true);
            load.add(car);
        }
    }


    /**
     * Off load car.
     */
    public void offLoadCar() {
        if (!load.isEmpty() && isFlakDown()) {
            load.get(load.size() - 1).setIsLoaded(false);
            load.remove(load.size() - 1);
        }
    }

    /**
     * Is close boolean.
     *
     * @param car the car
     * @return the boolean
     */
    private boolean isClose(Cars car) {
        double rangeX = Math.abs(v.getPoint().x - car.getPoint().x);
        double rangeY = Math.abs(v.getPoint().y - car.getPoint().y);
        double range = Math.sqrt((rangeX * rangeX) + (rangeY * rangeY));
        if (range <= 1) {
            return true;
        }
        return false;
    }


    /**
     * Moves all cars in the transports load.
     */
    public void move() {

        for (int i = 0; i < load.size(); i++) {
            load.get(i).setPoint(v.getPoint());
        }
    }

}
