import java.util.*;

/**
 * The type Biltransport.
 */
public class Biltransport extends Cars implements Loadable {

    private boolean flakDown;
    private int maxLoad;
    private List<Cars> load = new ArrayList<>();

    /**
     * Instantiates a new Biltransport.
     *
     * @param load the load
     */
    Biltransport(int load) {
        setNrDoors(2);
        setModelName("Biltransport");
        setFlakDown(false);
        setMaxLoad(load);
        stopEngine();
    }

    /**
     * Sets max load.
     *
     * @param maxLoad the max load
     */
    public void setMaxLoad(int maxLoad) {
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

    public List getLoad() {
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
        if (flakDown && getCurrentSpeed() == 0) {
            this.flakDown = flakDown;
        }
        else if (!flakDown) {
            this.flakDown = flakDown;
        }
    }

    /**
     * Load car.
     *
     * @param car the car
     */
    public void loadCar(Cars car) {
        if (load.size() < maxLoad && isClose(car) && isFlakDown() && car.getClass() != this.getClass()) {
            car.stopEngine();
            load.add(car);
        }
    }


    /**
     * Off load car.
     */
    public void offLoadCar(){
        if(!load.isEmpty() && isFlakDown()){
            load.remove(load.size() - 1);
        }
    }

    /**
     * Is close boolean.
     *
     * @param car the car
     * @return the boolean
     */
    public boolean isClose(Cars car) {
        double rangeX = Math.abs(getPoint().x - car.getPoint().x);
        double rangeY = Math.abs(getPoint().y - car.getPoint().y);
        double range = Math.sqrt((rangeX * rangeX) + (rangeY * rangeY));
        if (range <= 1) {
            return true;
        }
        return false;
    }

    /**
     * Starts engine if flak is not down.
     * @see "startEngine at Cars"
     */
    @Override
    public void startEngine() {
        if (!isFlakDown()) {
            super.startEngine();
        }
    }

    /**
     * Gas if flak is not down.
     * @param amount a double that controls how much currentSpeed is incremented,
     */
    @Override
    public void gas(double amount) {
        if (!isFlakDown()) {
            super.gas(amount);
        }
    }

    /**
     * Moves the transport first, then all other cars in the transports load follows.
     */
    @Override
    public void move(){
        super.move();
        for (int i = 0; i < load.size(); i++) {
            load.get(i).setPoint(getPoint());
        }
    }

}
