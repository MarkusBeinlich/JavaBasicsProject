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
public class PlayerRun extends Thread {

    private final MusicSource player;

    PlayerRun(MusicSource player) {
        this.player = player;
    }

    @Override
    public void run() {
        int i = 0;
        while (player.getState() != MusicSource.State.STOP) {
            // Pause gedrückt -> Zeit läuft nicht weiter
            if (player.getState() != MusicSource.State.PAUSE) {
                // Track ist zu Ende -> nächsten Track aufrufen
                if ((i / 10) >= player.getCurrentTrack().getPlayingTime()) {
                    player.next();
                    i = 0;
                }
                // Record kann kann durch player next zu ende sein. Deswegen State nochmal abfragen
                if (player.getState() != MusicSource.State.STOP) {
                    // alle 3 Sekunden die Zeit ausgeben
                    if (i++ % 30 == 0) {
                        System.out.println(player.getClass().getSimpleName() + " Track:" + player.getCurrentTrack().getTitle() + " Time: " + (i / 10));
                    }
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                interrupt();
            }

        }
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
