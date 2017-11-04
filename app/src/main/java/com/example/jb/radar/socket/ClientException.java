package com.example.jb.radar.socket;

/**
 * Created by jb on 2017-05-26.
 */

public class ClientException extends Exception {

    public ClientException() { super(); }
    public ClientException(String message) { super(message); }
    public ClientException(String message, Throwable cause) { super(message, cause); }
    public ClientException(Throwable cause) { super(cause); }
}
