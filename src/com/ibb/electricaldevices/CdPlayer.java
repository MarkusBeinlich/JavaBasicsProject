/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibb.electricaldevices;

import java.util.*;

/**
 *
 * @author Markus Beinlich
 */
public class CdPlayer implements MusicSource {

    private Record cd;
    private Track currentTrack;
    // cdStatus (play, pause, stop)
    // eventuell flag für change durch CdPlayer
    // Klasse für Play-Tread - wird durch play gestartet
    // durch stop beendet
    // durch CD-Ende beendet
    ListIterator<Track> cdIterator;

    //public enum State {
    //    PLAY, PAUSE, STOP
    //};
    private State state;

    public CdPlayer() {
        this(null);
    }

    public CdPlayer(Record cd) {
        setCd(cd);
        state = State.STOP;
    }

    @Override
    public void play() {
        // TODO Automatisch generierter Methodenstub
        final PlayerRun cdRun = new PlayerRun(this);
        System.out.println("CD: " + getRecord().getTitle() + " Track: " + getCurrentTrack().getTitle() + " wird abgespielt.");
        //cdRun muss nur gestartet werden, wenn noch kein Instanz läuft.
        if (state == State.STOP) {
            cdRun.start();
        }
        state = State.PLAY;
    }

    @Override
    public void pause() {
        // TODO Automatisch generierter Methodenstub
        state = State.PAUSE;
        System.out.println("CD ist angehalten.");
    }

    @Override
    public void stop() {
        // TODO Automatisch generierter Methodenstub
        state = State.STOP;
        System.out.println("CD ist gestoppt.");
    }

    @Override
    public void next() {
        // TODO Automatisch generierter Methodenstub
        //setCurrentTrack((getCurrentTrack() + 1) % getRecord().getTracks().length);
        if (cdIterator.hasNext()) {
            setCurrentTrack(cdIterator.next());
            System.out.println("CD: " + getRecord().getTitle() + " Track: " + getCurrentTrack().getTitle() + " wird abgespielt.");
        } else {
            state = State.STOP;
            System.out.println("CD: " + getRecord().getTitle() + "beendet.");
        }
    }

    /**
     *
     */
    @Override
    public void previous() {
        // TODO Automatisch generierter Methodenstub
        //setCurrentTrack((getRecord().getTracks().length + getCurrentTrack() - 1) % getRecord().getTracks().length);
        setCurrentTrack(cdIterator.previous());
        System.out.println("CD: " + getRecord().getTitle() + " Track: " + getCurrentTrack().getTitle() + " wird abgespielt.");
    }

    /**
     * @return cd
     */
    @Override
    public Record getRecord() {
        return cd;
    }

    /**
     * @param cd das zu setzende Objekt cd
     */
    public final void setCd(Record cd) {
        this.cd = cd;
        this.cdIterator = cd.getTracks().listIterator();
        setCurrentTrack(cdIterator.next());

        System.out.println("CD: " + cd.getTitle() + " wurde eingelegt.");
    }

    /**
     * @return the currentTrack
     */
    @Override
    public Track getCurrentTrack() {
        return currentTrack;
    }

    /**
     * @param currentTrack the currentTrack to set
     */
    public void setCurrentTrack(Track currentTrack) {
        this.currentTrack = currentTrack;
    }

    /**
     * @return the state
     */
    @Override
    public State getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "\nMusikquelle: " + this.getClass().getSimpleName()
                + "\nStatus: " + this.state
                + "\nCD: " + cd.getTitle()
                + "\nTrack: " + getCurrentTrack().getTitle();
    }
}
