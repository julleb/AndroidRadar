package com.example.jb.radar;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.jb.radar.socket.ClientException;
import com.example.jb.radar.socket.RadarSession;

/**
 * Created by jb on 2017-05-26.
 */

public class RadarDataThread extends Thread {


    private RadarSession radarSession;

    public RadarDataThread(RadarSession radarSession) {
        this.radarSession = radarSession;
    }

    @Override
    public void run(){
        System.out.println("MyThread running");
        try {
            String data = radarSession.getClient().readData();
            System.out.println(data);
        }catch(ClientException e) {

        }
    }
}

