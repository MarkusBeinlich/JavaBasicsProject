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
public abstract class PlayListComponent {
    public void add(PlayListComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public void remove(PlayListComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public PlayListComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
  
	public String getName() {
		throw new UnsupportedOperationException();
	}
	public String getDescription() {
		throw new UnsupportedOperationException();
	}

    /**
     *
     * @return
     */
    public abstract Iterator<PlayListComponent> createIterator();
 

    
}
