import Controllers.CarController;
import Controllers.CarModel;
import Controllers.CarView;
import Vehicles.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by schan on 2017-12-07.
 */
public class App {
    private static CarView frame;
    private static CarModel carModel = new CarModel();
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private static final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private static Timer timer = new Timer(delay, new TimerListener());

    public static void main(String[] args) {
        // Instance of this class
        carModel = new CarModel();
        CarController cc = new CarController(carModel);
        carModel.addVehicle(carModel.saab95());
        carModel.addVehicle(carModel.volvo240());
        carModel.addVehicle(carModel.scania());

        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0", carModel);
        frame.setButtonObserver(cc);

        // Start the timer
        timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
 * view to update its images. Change this method to your needs.
 * */
    private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle: carModel.getVehicles()) {
                carModel.updateVehicle(vehicle);
            }
            frame.getDrawPanel().repaint();
        }
    }
}
