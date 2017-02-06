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
public interface MusicSource {

    public enum State {
        PLAY, PAUSE, STOP
    };

    void play();

    void pause();

    void next();

    void previous();

    void stop();
    
    /**
     *
     * @return
     */
    State getState();
    
    Record getRecord();
    
    Track getCurrentTrack();

}
