/**
 * The type Bilfarja.
 */
public class Bilfarja extends Biltransport {

    /**
     * Instantiates a new Bilfarja.
     *
     * @param load the load
     */
    public Bilfarja(int load) {
        setModelName("Bilfarja");
        setMaxLoad(load);
    }

    @Override
    public void offLoadCar() {
        if (!getLoad().isEmpty() && isFlakDown()) {
            getLoad().remove(0);
        }
    }


}
