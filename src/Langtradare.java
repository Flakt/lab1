import java.util.List;

/**
 * The type Langtradare.
 */
public class Langtradare extends Cars implements Ibiltransport {

    private Biltransport biltransport = new Biltransport(this);

    public Langtradare() {
        setModelName("Långtradare");
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

    @Override
    public void offLoadCar() {
        biltransport.offLoadCar();
    }

    /**
     * Starts engine if flak is not down.
     *
     * @see "startEngine at Cars"
     */

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
    public void gas(double amount) {
        if (!biltransport.isFlakDown()) {
            super.gas(amount);
        }
    }

    /**
     * Moves the transport first, then all other cars in the transports load follows.
     */
    public void move() {
        super.move();
        biltransport.move();
    }

}
