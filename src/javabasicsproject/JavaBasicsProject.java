/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicsproject;

import com.ibb.electricaldevices.*;
import com.ibb.electricaldevices.Track;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.sound.midi.*;

/**
 *
 * @author IBB Teilnehmer
 */
public class JavaBasicsProject {

    /**
     * @param args the command line
     */
    public static void main(String[] args) {
        new JavaBasicsProject().go();
    }

    private void go() {
        // TODO code application logic here
        //    ElectricalDevice hoover = new ElectricalDevice("Staubi");
        //    System.out.println("Staubsauger: "+ hoover);
        MusicSystem kitchenRadio = new MusicSystem("Küchenradio");
        System.out.println(kitchenRadio);
        kitchenRadio.setOnOffSwitch(true);
        kitchenRadio.play();
        kitchenRadio.setPower(true);
        kitchenRadio.setOnOffSwitch(true);
        Radio radio = new Radio("Bayern3");
        kitchenRadio.addSource(radio);
        try {
            kitchenRadio.setActiveSource(radio);
        } catch (IllegaleSourceException ex) {
            Logger.getLogger(JavaBasicsProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        kitchenRadio.play();
        radio.setRadioStation("swr9");
        kitchenRadio.play();
        kitchenRadio.previous();
        kitchenRadio.next();

        // CD's
        Record cd1 = new Record("CD 1");
        cd1.addTrack(new Track("Track1", 10));
        cd1.addTrack(new Track("Track2", 5));
        cd1.addTrack(new Track("Track3", 8));
        Record cd2 = new Record("CD 2");
        cd2.addTrack(new Track("Track1", 8));
        cd2.addTrack(new Track("Track2", 5));
        Record cd3 = new Record("CD 3");
        cd3.addTrack(new Track("Track1", 10));
        cd3.addTrack(new Track("Track2", 12));
        cd3.addTrack(new Track("Track3", 5));
        cd3.addTrack(new Track("Track4", 5));

        //Platten
        Record record1 = new Record("Platte 1");
        record1.addTrack(new Track("Track1", 10));
        record1.addTrack(new Track("Track2", 5));
        record1.addTrack(new Track("Track3", 8));
        
        //PlayList
        PlayList pl = new PlayList("Playlist 1", "Erster Versuch");
        pl.add(new Track("Track91", 7));
        pl.add(new Track("Track92", 7));
 //       pl.add(record1);
        pl.add(new Track("Track93", 7));
        pl.add(new Track("Track94", 7));
 //       pl.add(cd3);
        pl.add(new Track("Track95", 7));
        pl.add(new Track("Track96", 7));
        pl.add(new Track("Track97", 7));
        System.out.println("Playlist: " + pl);
        
//        PlayListIterator<PlayListComponent> plIterator = pl.createIterator();
//        System.out.println("++++ PlayList mit Iterator next() durchlaufen:");
//        while (plIterator.hasNext()) {
//        	 System.out.println( plIterator.next() + " Index:" + plIterator.getTrackIndex());
//		}
//        System.out.println("++++ PlayList mit Iterator previous() durchlaufen:");
//        while (plIterator.hasPrevious()) {
//       	 System.out.println( plIterator.previous()+ " Index:" + plIterator.getTrackIndex());
//		}
        Iterator<PlayListComponent> plIterator = pl.createIterator();        
        PlayListComponent plc = plIterator.next();
        System.out.println("PlayListComponent 1: " + plc);
        System.out.println("PlayListComponent 2: " + plIterator.next());
        System.out.println("PlayListComponent 3: " + plIterator.next());
        System.out.println("PlayListComponent 4: " + plIterator.next());
        System.out.println("PlayListComponent 5: " + plIterator.next());
        System.out.println("PlayListComponent 6: " + plIterator.next());
        System.out.println("PlayListComponent 7: " + plIterator.next());
        System.out.println("PlayListComponent 8: " + plIterator.next());
        System.out.println("PlayListComponent 9: " + plIterator.next());
        System.out.println("PlayListComponent 10: " + plIterator.next());
        System.out.println("PlayListComponent 11: " + plIterator.next());
        System.out.println("PlayListComponent 12: " + plIterator.next());
        System.out.println("PlayListComponent 13: " + plIterator.next());
        System.out.println("PlayListComponent 14: " + plIterator.next());
        System.out.println("PlayListComponent 15: " + plIterator.next());
        System.out.println("PlayListComponent 16: " + plIterator.next());
        System.out.println("PlayListComponent 17: " + plIterator.next());

        MusicSystem hifi = new MusicSystem("HiFi - Anlage");
        hifi.setLocation("Wohnzimmer");
        hifi.addSource(radio);
        CdPlayer cdPlayer = new CdPlayer(cd1);
        hifi.addSource(cdPlayer);
        RecordPlayer rP = new RecordPlayer(record1);
        hifi.addSource(rP);
        hifi.setPower(true);
        hifi.setOnOffSwitch(true);
        try {
            hifi.setActiveSource(cdPlayer);
        } catch (IllegaleSourceException ex) {
            System.out.println("Gerät kann nicht verwendet werden. Fehler: " + ex.getMessage());
            return;
        }
        //hifi.play();
        System.out.println(hifi);

        String eingabe = "";
        while (!"END".equals(eingabe.toUpperCase())) {
            System.out.println("Geben sie einen Befehl ein. Erlaubte Befehle sind: CDPLAYER RECORDPLAYER PLAY NEXT PREVIOUS PAUSE STOP STATUS END");
            eingabe = readString();
            System.out.println("Eingabe: " + eingabe);
            switch (eingabe.toUpperCase()) {
                case "CDPLAYER":
                    try {
                        hifi.setActiveSource(cdPlayer);
                    } catch (IllegaleSourceException ex) {
                        System.out.println("Gerät kann nicht verwendet werden. Fehler: " + ex.getMessage());
                        return;
                    }
                    break;
                case "RECORDPLAYER":
                    try {
                        hifi.setActiveSource(rP);
                    } catch (IllegaleSourceException ex) {
                        System.out.println("Gerät kann nicht verwendet werden. Fehler: " + ex.getMessage());
                        return;
                    }
                    break;
                case "PLAY":
                    hifi.play();
                    break;
                case "NEXT":
                    hifi.next();
                    break;
                case "PREVIOUS":
                    hifi.previous();
                    break;
                case "STOP":
                    hifi.stop();
                    break;
                case "PAUSE":
                    hifi.pause();
                    break;
                case "STATUS":
                    System.out.println(hifi);
                    break;
                case "END":
                    System.out.println("Jetzt ist Schluss.");
                    break;
                default:
                    System.out.println("Ich kann den Befehl " + eingabe + " nicht verstehen. Wollen wir trotzdem Freunde bleiben.");
            }
        }
        hifi.stop();
        System.out.println(hifi);
    }

    String readString() {
        // Mit Kanonen auf Spatzen schiessen
//        return new Scanner(System.in).nextLine();

        // effizienter:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException ex) {
            return "";
        }
    }
}
