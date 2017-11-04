package com.example.jb.radar;


import com.example.jb.radar.socket.Client;
import com.example.jb.radar.socket.ClientException;
import com.example.jb.radar.socket.ClientTCP;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jb on 2017-05-25.
 */

public class ClientTCPTest {


    @Test
    public void testConnection() throws ClientException {
        Client client = new ClientTCP();

        client.connect("127.0.0.1", "8080");


       // System.out.println(client.readData());

        while(true) {
            client.sendData("OK\n");
        }
        //client.sendData("OK\n");




        //assertTrue(client.isConnected());
    }

}
