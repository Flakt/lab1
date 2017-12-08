package Controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vehicles.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

/**
 * The type Car controller.
 */
public class CarController implements buttonObserver {
    private CarModel carModel;

    public CarController(CarModel carModel) {
        this.carModel = carModel;
    }


    @Override
    public void actOnGas(double amount) {
        carModel.gas(amount);
    }

    @Override
    public void actOnBrake(double amount) {
        carModel.brake(amount);
    }

    @Override
    public void actOnStartEngine() {
        carModel.startEngine();
    }

    @Override
    public void actOnStopEngine() {
        carModel.stopEngine();
    }

    @Override
    public void actOnFlakDown() {
        carModel.lowerFlak();
    }

    @Override
    public void actOnFlakUp() {
        carModel.raiseFlak();
    }

    @Override
    public void actOnTurboOn() {
        carModel.turboOn();
    }

    @Override
    public void actOnTurboOff() {
        carModel.turboOff();
    }

    @Override
    public void actOnRemoveCar() {
        carModel.removeRandomCar();
    }

    @Override
    public void actOnAddCar() {
        carModel.addRandomCar();
    }


}

