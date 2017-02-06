package com.ibb.electricaldevices;

import java.util.*;

public class Track extends PlayListComponent {
	private String title;
	private int playingTime;
	
	public Track(String title, int playingTime){
		this.title = title;
		this.setPlayingTime(playingTime);
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

	/**
	 * @return playingTime
	 */
	public int getPlayingTime() {
		return playingTime;
	}

	/**
	 * @param playingTime das zu setzende Objekt playingTime
	 */
	public void setPlayingTime(int playingTime) {
		this.playingTime = playingTime;
	}

        @Override
	public Iterator<PlayListComponent> createIterator() {
		return new NullIterator();
	}
        @Override
	public String toString() {
		return "\nTrack: " + this.getTitle();
	}
}
