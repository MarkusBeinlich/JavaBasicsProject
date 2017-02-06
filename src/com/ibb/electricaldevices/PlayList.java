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
public class PlayList extends PlayListComponent {

    PlayListIterator<PlayListComponent> iterator = null;
    ArrayList<PlayListComponent> playListComponents = new ArrayList<>();
    String name;
    String description;

    /**
     *
     * @param name
     * @param description
     */
    public PlayList(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     *
     * @param playListComponent
     */
    @Override
    public void add(PlayListComponent playListComponent) {
        playListComponents.add(playListComponent);
    }

    @Override
    public void remove(PlayListComponent playListComponent) {
        playListComponents.remove(playListComponent);
    }

    @Override
    public PlayListComponent getChild(int i) {
        return playListComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Iterator<PlayListComponent> createIterator() {
        if (iterator == null) {
            iterator = new PlayListIterator(playListComponents.iterator());
        }
        return iterator;
    }

    @Override
    public String toString() {
        return "\nPlaylist: " + this.getName()
                + "\nBeschreibung: " + this.getDescription()
                + "\nTracks: " + this.playListComponents.toString();
    }
}
