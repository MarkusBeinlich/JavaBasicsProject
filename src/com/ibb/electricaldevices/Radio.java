/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibb.electricaldevices;

import java.io.IOException;

/**
 *
 * @author Markus Beinlich
 */
public class Radio implements MusicSource {

    private String radioStation;
    private final String[] radioStations = {"Bayern1", "Bayern2", "Bayern3", "swr3",};
    private int currentRadioStation;

    //public enum State {
    //    PLAY, STOP
    //};
    private State state;

    public Radio(String sender) {
        this.radioStation = sender;
        state = State.STOP;
        System.out.println(sender + " - Radio");
    }

    @Override
    public void play() {
        // TODO Automatisch generierter Methodenstub
        System.out.println(radioStation + ": blablabla");
        state = State.PLAY;
//		try {
//			new ProcessBuilder(new String[] { "cmd", "/c", "start",
//			"http://"+ radioStation +".radio.de" }).start();
//		} catch (IOException e) {
//			// TODO Automatisch generierter Erfassungsblock
//			e.printStackTrace();
//		}
    }

    @Override
    public void pause() {
        // TODO Automatisch generierter Methodenstub
        System.out.println("Pause geht beim Radio nicht.");
    }

    @Override
    public void next() {
        // TODO Automatisch generierter Methodenstub
        currentRadioStation = (currentRadioStation + 1) % radioStations.length;
        radioStation = radioStations[currentRadioStation];
        System.out.println(radioStation + ": next Radio Station");
    }

    @Override
    public void previous() {
        // TODO Automatisch generierter Methodenstub
        currentRadioStation = (radioStations.length + currentRadioStation - 1) % radioStations.length;
        radioStation = radioStations[currentRadioStation];
        System.out.println(radioStation + ": previous Radio Station");
    }

    public String getRadioStation() {
        return radioStation;
    }

    public void setRadioStation(String sender) {
        this.radioStation = sender;
    }

    @Override
    public void stop() {
        state = State.STOP;
    }

    @Override
    public String toString() {
        return "\nMusikquelle: " + this.getClass().getSimpleName()
                + "\nStatus: " + this.state
                + "\nSender: " + this.radioStation;
    }

    @Override
    public State getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Record getRecord() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Track getCurrentTrack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
