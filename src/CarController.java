import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

/**
 * The type Car controller.
 */
public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    /**
     * The Frame.
     */
// The frame that represents this instance View of the MVC pattern
    CarView frame;
    /**
     * The constant cars.
     */
// A list of cars, modify if needed
   public static List<Cars> cars = new ArrayList<>();

    //methods:

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cars car : cars) {
                car.move();
                int x = Math.min((int) Math.round(car.getPoint().x),700);
                int y = (int) Math.round(car.getPoint().y);
                //frame.drawPanel.moveit(x, y);
                if (car.getPoint().x > 700) {
                    car.turnLeft(180.0);
                    car.getPoint().x = 699;
                }
                if (car.getPoint().x < 0) {
                    car.turnLeft(180.0);
                    car.getPoint().x = 1;
                }
                // repaint() calls the paint Component method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    /**
     * Gas.
     *
     * @param amount the amount
     */
// Calls the gas method for each car once
    void gas(double amount) {
        double gas = amount / 100;
        for (Cars car : cars
                ) {
            car.gas(gas);
        }
    }

    /**
     * Brake.
     *
     * @param amount the amount
     */
    void brake(double amount) {
        double brake = amount / 100;
        for (Cars car : cars) {
            car.brake(brake);
        }
    }

    /**
     * Start engine.
     */
    void startEngine() {
        for (Cars car: cars) {
            car.startEngine();
        }
    }

    /**
     * Stop engine.
     */
    void stopEngine() {
        for (Cars car: cars) {
            car.stopEngine();
        }
    }

    /**
     * Turbo on.
     */
    void turboOn() {
        for (Cars car: cars) {
            if (checkModel(car, "Saab95")) {
                ((Saab95)car).setTurboOn();
            }
        }
    }

    /**
     * Turbo off.
     */
    void turboOff() {
        for (Cars car: cars) {
            if (checkModel(car, "Saab95")) {
                ((Saab95)car).setTurboOff();
            }
        }
    }

    /**
     * Raise flak.
     */
    void raiseFlak() {
        for (Cars car: cars) {
            if (checkModel(car, "Scania")) {
                ((Scania)car).setFlakDown(false);
            }
        }
    }

    /**
     * Lower flak.
     */
    void lowerFlak() {
        for (Cars car: cars) {
            if (checkModel(car, "Scania")) {
                ((Scania)car).setFlakDown(true);
            }
        }
    }

    private boolean checkModel(Cars car, String name) {
        return car.getModelName().equals(name);
    }

}

