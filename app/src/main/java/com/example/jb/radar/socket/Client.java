package com.example.jb.radar.socket;

/**
 * Created by jb on 2017-05-25.
 */

public interface Client  {

    void connect(String ip, String port) throws ClientException ;
    boolean isConnected();
    String readData() throws ClientException;
    void sendData(String data) throws ClientException;
    void closeConnection() throws ClientException;
}
