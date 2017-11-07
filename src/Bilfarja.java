
public class Bilfarja extends Biltransport {

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
