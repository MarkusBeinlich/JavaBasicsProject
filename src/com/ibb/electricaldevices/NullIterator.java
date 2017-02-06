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
import java.util.*;
  
public class NullIterator implements Iterator<PlayListComponent> {
   
	public PlayListComponent next() {
		return null;
	}
  
	public boolean hasNext() {
		return false;
	}

}

