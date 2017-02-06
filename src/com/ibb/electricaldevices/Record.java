package com.ibb.electricaldevices;

import java.util.*;

public class Record  {

    private String title;
    private ArrayList<Track> tracks;
    
    
    public Record() {
        this("Blank");
    }
    
    public Record(String title) {
        this.title = title;
        tracks = new ArrayList<>();
    }

    /**
     * @return title
     */
    public String getTitle() {
            return title;
    }


    /**
     * @param title das zu setzende Objekt title
     */
    public void setTitle(String title) {
        this.title = title;
    }
   
    @Override
	public String toString() {
		return "\nRecord: " + this.getTitle();
	}

    /**
     * @return the tracks
     */
    public ArrayList<Track> getTracks() {
        return tracks;
    }

    /**
     * @param tracks the tracks to set
     */
    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }
    
    public void addTrack(Track track) {
        tracks.add(track);
    }
}
