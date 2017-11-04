package com.example.jb.radar.socket;

import java.io.Serializable;

/**
 * Created by jb on 2017-05-26.
 */

public class RadarSession implements Serializable {

    private Client client;

    public RadarSession(ServerInformation serverInfo)  throws RadarException {
        client = new ClientTCP();
        try {
            client.connect(serverInfo.getIp(), serverInfo.getPort());
        }catch(ClientException e) {
            throw new RadarException("Could not create a session. " + e.getMessage(), e);
        }
    }


    public Client getClient() {
        return client;
    }


}
