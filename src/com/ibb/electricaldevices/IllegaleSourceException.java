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
public class IllegaleSourceException extends Exception {

    public IllegaleSourceException() {
    }

    /**
     *
     * @param message
     */
    public IllegaleSourceException(String message) {
        super(message);
    }

    public IllegaleSourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegaleSourceException(Throwable cause) {
        super(cause);
    }

}
