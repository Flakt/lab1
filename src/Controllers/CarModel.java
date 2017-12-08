package Controllers;

import java.awt.*;
import java.util.*;
import java.util.List;

import Vehicles.*;

public class CarModel implements ModelObserver {

    private ArrayList<Vehicle> vehicles;

    public CarModel() {
        vehicles = new ArrayList<>(10);
    }


    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Vehicle getVehicle(int index) {
        if (vehicles != null && isInRange(index)) {
            return vehicles.get(index);
        }

        return null;
    }

    public void addVehicle(Cars car) {
        vehicles.add(car);
    }

    public void removeVehicle(int index) {
        if (isInRange(index) && !vehicles.isEmpty()) {
            vehicles.remove(index);
        }
    }

    protected void addRandomCar() {
        if (vehicles.size() < 10) {
            int rand = (int) (Math.random() * 3);
            switch (rand) {
                case 0:
                    addVehicle(volvo240());
                    break;
                case 1:
                    addVehicle(saab95());
                    break;
                case 2:
                    addVehicle(scania());
                    break;
                default:
                    addVehicle(volvo240());
            }
        }
    }

    protected void removeRandomCar() {
        int rand = (int) (Math.random() * vehicles.size());
        removeVehicle(rand);
    }


    private boolean isInRange(int index) {
        return (0 <= index && index < vehicles.size());
    }

    // Calls the gas method for each car once
    void gas(double amount) {
        double gas = amount / 100;
        for (Vehicle vehicle : vehicles
                ) {
            vehicle.gas(gas);
        }
    }

    /**
     * Brake.
     *
     * @param amount the amount
     */
    void brake(double amount) {
        double brake = amount / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    /**
     * Start engine.
     */
    void startEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    /**
     * Stop engine.
     */
    void stopEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    /**
     * Turbo on.
     */
    void turboOn() {
        for (Vehicle vehicle : vehicles) {
            if (checkModel(vehicle, "Saab95")) {
                ((Saab95) vehicle).setTurboOn();
                System.out.println("Turbo on");
            }
        }
    }

    /**
     * Turbo off.
     */
    void turboOff() {
        for (Vehicle vehicle : vehicles) {
            if (checkModel(vehicle, "Saab95")) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    /**
     * Raise flak.
     */
    void raiseFlak() {
        for (Vehicle vehicle : vehicles) {
            if (checkModel(vehicle, "Scania")) {
                ((Scania) vehicle).setFlakDown(false);
            }
        }
    }

    /**
     * Lower flak.
     */
    void lowerFlak() {
        for (Vehicle vehicle : vehicles) {
            if (checkModel(vehicle, "Scania")) {
                ((Scania) vehicle).setFlakDown(true);
                System.out.println("Flak lowered");
            }
        }
    }

    private boolean checkModel(Vehicle vehicle, String name) {
        return vehicle.getModelName().equals(name);
    }

    public void draw(Graphics g) {
        int i = 0;
        for (Vehicle vehicle : vehicles) {
            g.drawImage(vehicle.getImage(), (int) vehicle.getPoint().x, (int) vehicle.getPoint().y + 100 * i, null); // see javadoc for more info on the parameters
            i++;
        }
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicle.move();
        int x = Math.min((int) Math.round(vehicle.getPoint().x), 700);
        int y = (int) Math.round(vehicle.getPoint().y);
        //frame.drawPanel.moveit(x, y);
        if (vehicle.getPoint().x > 700) {
            vehicle.turnLeft(180.0);
            vehicle.getPoint().x = 699;
        }
        if (vehicle.getPoint().x < 0) {
            vehicle.turnLeft(180.0);
            vehicle.getPoint().x = 1;
        }
        // repaint() calls the paint Component method of the panel
    }


    public Saab95 saab95() {
        return VehicleFactory.createSaab95();
    }

    public Volvo240 volvo240() {
        return VehicleFactory.createVolvo240();
    }

    public Scania scania() {
        return VehicleFactory.createScania();
    }


    @Override
    public void actOnModelChange(Graphics g) {
        draw(g);
    }
}
