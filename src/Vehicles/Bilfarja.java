package Vehicles;

import java.util.List;

/**
 * The type Vehicles.Bilfarja.
 */
public class Bilfarja extends Vehicle implements Ibiltransport {

    Biltransport biltransport = new Biltransport(this);

    /**
     * Instantiates a new Vehicles.Bilfarja.
     *
     * @param load the load
     */
    public Bilfarja(int load) {
        setModelName("Vehicles.Bilfarja");
        biltransport.setMaxLoad(load);
    }

    /**
     * Overridden method of offLoadCar in superclass
     * see @Vehicles.Biltransport offLoadCar
     */
    public void offLoadCar() {
        if (!biltransport.getLoad().isEmpty() && biltransport.isFlakDown()) {
            biltransport.getLoad().get(0).setIsLoaded(false);
            biltransport.getLoad().remove(0);
        }
    }


    /**
     * Starts engine if flak is not down.
     *
     * @see "startEngine at Vehicles.Cars"
     */
    @Override
    public void startEngine() {
        if (!biltransport.isFlakDown()) {
            super.startEngine();
        }
    }

    /**
     * Gas if flak is not down.
     *
     * @param amount a double that controls how much currentSpeed is incremented,
     */
    @Override
    public void gas(double amount) {
        if (!biltransport.isFlakDown()) {
            super.gas(amount);
        }
    }

    /**
     * Moves the transport first, then all other cars in the transports load follows.
     */
    @Override
    public void move() {
        super.move();
        biltransport.move();
    }

    @Override
    public int getMaxLoad() {
        return biltransport.getMaxLoad();
    }

    @Override
    public List<Cars> getLoad() {
        return biltransport.getLoad();
    }

    @Override
    public boolean isFlakDown() {
        return biltransport.isFlakDown();
    }

    @Override
    public void setFlakDown(boolean flakDown) {
        biltransport.setFlakDown(flakDown);
    }

    @Override
    public void loadCar(Cars car) {
        biltransport.loadCar(car);
    }

}
