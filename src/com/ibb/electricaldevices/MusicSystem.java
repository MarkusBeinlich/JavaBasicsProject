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
public class MusicSystem extends ElectricalDevice implements MusicSource {

    private int volume;
    private MusicSource activeSource;
    final private LinkedList<MusicSource> sources;

    public MusicSystem(String name) {
        this(name, "Sonstwo");
    }

    public MusicSystem(String name, String location) {
        this(name, location, false);
    }

    public MusicSystem(String name, String location, boolean power) {
        this(name, location, power, false);
    }

    public MusicSystem(String name, String location, boolean power, boolean onOffSwitch) {
        super(name, location, power, onOffSwitch);
        this.sources = new LinkedList<>();
    }

    /**
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(int volume) {
        if (volume > 100) {
            System.out.println("Die maximale Lautstärke ist 100.");
            this.volume = 100;
        } else if (volume < 0) {
            System.out.println("Die minimal Lautstärke ist 0.");
            this.volume = 0;
        } else {
            this.volume = volume;
        }
    }

    @Override
    public void play() {
        boolean ok = true;
        if (activeSource == null) {
            System.out.println("Sie müssen erst mit 'setActiveSource(???) eine Music-Quelle angeben.");
            ok = false;
        }
        if (this.isPower() == false) {
            System.out.println("Bitte erst für Strom sorgen. Gerät kann nicht eingeschaltet werden.");
            ok = false;
        }
        if (this.isOnOffSwitch() == false) {
            System.out.println("Bitte das Gerät erst einschalten.");
            ok = false;
        }
        if (ok == true) {
            activeSource.play();
        }
    }
    
    @Override
    public void pause() {
        activeSource.pause();
    }
    
    @Override
    public void stop() {
        activeSource.stop();
    }

    @Override
    public void previous() {
        activeSource.previous();
    }

    @Override
    public void next() {
        activeSource.next();
    }

    /**
     * @return the activeSource
     */
    public MusicSource getActiveSource() {
        return activeSource;
    }

    /**
     * @param activeSource the activeSource to set
     * @throws com.ibb.electricaldevices.IllegaleSourceException
     */
    public void setActiveSource(MusicSource activeSource) throws IllegaleSourceException {
        //prüfen, ob die zu aktivierende Source zu den vorhandenen Sourcen gehört
        if (-1 == sources.indexOf(activeSource)){
            throw new IllegaleSourceException("Source is not part of sources");
//            System.out.println("Sie versuchen eine Source zu aktivieren, die gar nicht an dem System hängt. Sie müssen die Source erst mit addSource zum System hinzufügen.");
//            return;
        }
        //prüfen, ob es bereits eine aktive Source gibt und diese gegebenfalls stoppen
        if (this.activeSource != null){
            this.activeSource.stop();
        }
        this.activeSource = activeSource;
    }

    /**
     * @param source the activeSource to set
     */
    public void addSource(MusicSource source) {
        source.stop();
        this.sources.add(source);
    }

    @Override
    public String toString() {
        String as =  (this.getActiveSource() == null) ? "" : "\nAktive Quelle:" + this.getActiveSource().getClass().getSimpleName();
        return "\nGerätename: " + this.getName()
                + "\nStandort: " + this.getLocation()
                + "\nStrom vorhanden: " + isPower()
                + "\nGerät eingeschaltet:" + isOnOffSwitch()
                + as
                + "\nQuellen: " + this.sources.toString();
    }

    @Override
    public State getState() {
        return activeSource.getState();
    }

    @Override
    public Record getRecord() {
        return activeSource.getRecord();
    }

    @Override
    public Track getCurrentTrack() {
        return activeSource.getCurrentTrack();
    }

}
