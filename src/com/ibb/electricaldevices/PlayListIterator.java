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
 * @param <E>
 */
public class PlayListIterator<E> implements Iterator<PlayListComponent> {

    Stack<Iterator<PlayListComponent>> stack = new Stack<>();

    public PlayListIterator(Iterator<PlayListComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public PlayListComponent next() {
        if (hasNext()) {
            Iterator<PlayListComponent> iterator = stack.peek();
            PlayListComponent component = iterator.next();
            stack.push(component.createIterator());
            return component;
        } else {
            return null;
        }
    }
    
    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator<PlayListComponent> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

   
}
