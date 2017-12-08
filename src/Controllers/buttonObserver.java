package Controllers;

/**
 * Created by schan on 2017-12-07.
 */
public interface ButtonObserver {
    void actOnGas(double amount);

    void actOnBrake(double amount);

    void actOnStartEngine();

    void actOnStopEngine();

    void actOnFlakDown();

    void actOnFlakUp();

    void actOnTurboOn();

    void actOnTurboOff();

    void actOnRemoveCar();

    void actOnAddCar();
}
