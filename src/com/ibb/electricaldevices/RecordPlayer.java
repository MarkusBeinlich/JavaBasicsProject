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
public class RecordPlayer implements MusicSource {

    private Record record;
    private Track currentTrack;
    // cdStatus (play, pause, stop)
    // eventuell flag für change durch CdPlayer
    // Klasse für Play-Tread - wird durch play gestartet
    // durch stop beendet
    // durch CD-Ende beendet

    //public enum State {
    //    PLAY, PAUSE, STOP
    //};
    private State state;
    ListIterator<Track> rpIterator;

    public RecordPlayer() {
        this(null);
    }

    public RecordPlayer(Record record) {
        setRecord(record);
        state = State.STOP;
    }

    @Override
    public void play() {
        // TODO Automatisch generierter Methodenstub
        final PlayerRun playerRun = new PlayerRun(this);
        System.out.println("Record: " + getRecord().getTitle() + " Track: " + getCurrentTrack().getTitle() + " wird abgespielt.");
        //cdRun muss nur gestartet werden, wenn noch kein Instanz läuft.
        if (state == State.STOP) {
            playerRun.start();
        }
        state = State.PLAY;
    }

    @Override
    public void pause() {
        // TODO Automatisch generierter Methodenstub
        state = State.PAUSE;
        System.out.println("Schallplatte ist angehalten.");
    }

        @Override
    public void stop() {
        // TODO Automatisch generierter Methodenstub
        state = State.STOP;
        System.out.println("Schallplatte ist gestoppt.");
    }
    
    @Override
    public void next() {
        // TODO Automatisch generierter Methodenstub
        // System.out.println("current " + getCurrentTrack() + " length "+ getRecord().getTracks().length);
        PlayListComponent track = rpIterator.next();
        if (track instanceof Track){
            setCurrentTrack((Track)track);
        }
        //if(getCurrentTrack() >= getRecord().getTracks().length - 1) {
        //    System.out.println("Das Ende der Schallplatte: " + getRecord().getTitle() + " Track: " + getRecord().getTracks()[getCurrentTrack()].getTitle() + " ist erreicht.");
        //    state = State.STOP;
        //} else {
        //    setCurrentTrack(getCurrentTrack() + 1);
        //}
    }

    /**
     *
     */
    @Override
    public void previous() {
        // TODO Automatisch generierter Methodenstub
        System.out.println("Das geht bei Schallplatten nicht.");
    }

    /**
     * @return cd
     */
    @Override
    public Record getRecord() {
        return record;
    }

    /**
     * @param record
     */
    public final void setRecord(Record record) {
        this.record = record;
        this.rpIterator = record.getTracks().listIterator();
        setCurrentTrack( rpIterator.next());
        System.out.println("Schallplatte: " + record.getTitle() + " wurde aufgelegt.");
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
        String st = (getCurrentTrack() == null) ? " nix" : getCurrentTrack().getTitle();
        return "\nMusikquelle: " + this.getClass().getSimpleName()
                + "\nStatus: " + this.state
                + "\nRecord: " + record.getTitle()
                + "\nTrack: " + st;
    }
}
