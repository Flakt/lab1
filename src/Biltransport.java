import java.util.ArrayList;
import java.util.List;

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
        if (load.size() < maxLoad && isClose(car)) {
            load.add(car);
        }
    }

    private boolean isClose(Cars car) {
        double rangeX = Math.abs(getPoint().x - car.getPoint().x);
        double rangeY = Math.abs(getPoint().y - car.getPoint().y);
        double range = Math.sqrt((rangeX * rangeX) + (rangeY * rangeY));
        if (range <= 1) {
            return true;
        }
        return false;
    }

}
