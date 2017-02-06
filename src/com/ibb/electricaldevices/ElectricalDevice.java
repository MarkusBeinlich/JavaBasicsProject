/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibb.electricaldevices;

/**
 *
 * @author Markus Beinlich
 */
public abstract class ElectricalDevice {

    private String name;
    private boolean power;
    private boolean onOffSwitch;
    private String location;

    public ElectricalDevice(String name) {
        this(name, "Sonstwo");
    }

    public ElectricalDevice(String name, String location) {
        this(name, location, false);
    }

    public ElectricalDevice(String name, String location, boolean power) {
        this(name, location, power, false);
    }

    public ElectricalDevice(String name, String location, boolean power, boolean onOffSwitch) {
        this.name = name;
        this.location = name;
        this.power = power;
        this.onOffSwitch = onOffSwitch;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the onOffSwitch
     */
    public boolean isOnOffSwitch() {
        return onOffSwitch;
    }

    /**
     * @param onOffSwitch the onOffSwitch to set
     */
    public void setOnOffSwitch(boolean onOffSwitch) {
        if (onOffSwitch == true & this.isPower() == false){
            System.out.println("Bitte erst für Strom sorgen. Gerät kann nicht eingeschaltet werden.");
        } else {
            this.onOffSwitch = onOffSwitch;
            System.out.println(this.name + " Gerät ist " + (power ? "an." : "aus."));
        }
    }

    /**
     * @return the power
     */
    public boolean isPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(boolean power) {
        this.power = power;
        System.out.println(this.name + " Strom ist " + (power ? "an." : "aus."));
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nGerätename: " + this.getName()
                + "\nStandort: " + location
                + "\nStrom vorhanden: " + power
                + "\nGerät eingeschaltet:" + onOffSwitch;
    }
}
