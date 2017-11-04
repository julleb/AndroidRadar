package com.example.jb.radar.socket;

import java.io.Serializable;

/**
 * Created by jb on 2017-05-25.
 */

public class ServerInformation implements Serializable {

    private final String ip;
    private final String port;

    public ServerInformation(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }
    public String getPort() {
        return port;
    }
}
