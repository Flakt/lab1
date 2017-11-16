import com.sun.javafx.geom.Vec2d;
import org.junit.jupiter.api.Test;


public class TestCars {
    Saab95 saab95 = new Saab95();
    Volvo240 volvo240 = new Volvo240();
    Scania scania = new Scania();
    Scania scania2 = new Scania();
    Langtradare biltransport = new Langtradare();
    Bilfarja bilfarja = new Bilfarja(10);

    @Test
    public void testSetTurboOn() {
        saab95.setTurboOn();
        assert saab95.getTurboOn();
    }

    @Test
    public void testSetTurboOff() {
        saab95.setTurboOff();
        assert !saab95.getTurboOn();
    }

    @Test
    public void testTurnLeft() {
        saab95.turnLeft(90.0);
        assert (saab95.getVector().equals(new Vec2d(6.123233995736766E-17, 1)));
    }

    @Test
    public void testTurnRight() {
        saab95.turnRight(25.0);
    }

    @Test
    public void testMoveAndLoad() {
        saab95.gas(1);
        saab95.move();
        biltransport.setFlakDown(true);
        biltransport.loadCar(volvo240);
        biltransport.loadCar(saab95);
        biltransport.setFlakDown(false);
        System.out.println(biltransport.isFlakDown());
        biltransport.startEngine();
        biltransport.gas(1);
        biltransport.move();
        biltransport.stopEngine();
        biltransport.setFlakDown(true);
        biltransport.offLoadCar();
        assert (saab95.getPoint().equals(new Vec2d(1.25,0)));
        assert (biltransport.getPoint().equals(new Vec2d(1.1,0)));
        assert (biltransport.getLoad().size() == 0);
    }

    @Test
    public void testBilfarjaLoad() {
        bilfarja.setFlakDown(true);
        bilfarja.loadCar(scania);
        bilfarja.loadCar(scania2);
        bilfarja.offLoadCar();
        assert (bilfarja.getLoad().get(0).equals(scania2));
    }

    @Test
    public void testGas() {
        saab95.gas(1);
        assert (saab95.getCurrentSpeed() == 1.25);
    }

    @Test
    public void testBrake() {
        saab95.gas(1);
        saab95.brake(1);
        assert (saab95.getCurrentSpeed() == 0);
    }

    @Test
    public void testSpeedFactor() {
        volvo240.speedFactor();
        saab95.speedFactor();
    }

    @Test
    public void testStartEngine() {
        saab95.startEngine();
        assert (saab95.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testGetModelName() {
        saab95.getModelName();
        assert (saab95.getModelName().equals("Saab95"));
    }

    @Test
    public void testGetColor() {
        saab95.getColor();
    }

    @Test
    public void testGetNrDoors() {
        saab95.getNrDoors();
    }

    @Test
    public void testGetPoint() {
        saab95.getPoint();
    }

    @Test
    public void testSetFlakAngle() {
        scania.setFlakAngle(20);
        assert (scania.getFlakAngle() == 20);
        scania2.setFlakDown(false);
        assert (scania2.getFlakAngle() == 70);
        scania2.startEngine();
        scania2.setFlakDown(true);
        assert (scania2.getFlakAngle() == 0);
    }

    @Test
    public void testScaniaFlakDown() {
        scania.startEngine();
        scania.setFlakDown(true);
        assert (scania.isFlakDown());
        assert (!scania2.isFlakDown());
    }

    @Test
    public void testGetMaxLoad() {
        biltransport.getMaxLoad();
        assert (biltransport.getMaxLoad() == 10);
    }

}
