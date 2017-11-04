package com.example.jb.radar.Task;

import android.os.AsyncTask;
import android.view.View;

import com.example.jb.radar.Entity.EntitiesExtractor;
import com.example.jb.radar.Messages.MessagePool;
import com.example.jb.radar.socket.ClientException;
import com.example.jb.radar.socket.RadarException;
import com.example.jb.radar.socket.RadarSession;
import com.example.jb.radar.socket.ServerInformation;

/**
 * Created by jb on 2017-05-26.
 */

public class DataTask extends AsyncTask<String, String, String> {

    private ServerInformation serverInfo;
    private RadarSession radarSession;
    private MessagePool pool;
    private View radarDrawingView;



    public DataTask(ServerInformation serverInfo, View radarDrawingView, MessagePool pool) {
        this.serverInfo = serverInfo;
        this.pool = pool;
        this.radarDrawingView = radarDrawingView;
    }



    @Override
    protected String doInBackground(String... params) {
        System.out.println("BACKGORUND FUN!");
        radarSession = createRadarSession();
        dataTask();
        return "done";
    }

    private void dataTask() {
        while(isCancelled() == false) {
            String data = null;
            try {
                data = readDataFromServer();
            }catch(ClientException e) {
                return;
            }
            EntitiesExtractor entitiesExtractor = new EntitiesExtractor();
            entitiesExtractor.createEntities(data);

            pool.setEntities(entitiesExtractor);

            publishProgress(data);
            sendDataToServer("OK\n");
        }
        closeConnection();
    }

    @Override
    protected void onProgressUpdate(String ... progress) {
        radarDrawingView.invalidate();
    }

    private RadarSession createRadarSession() {
        try {
            return new RadarSession(serverInfo);
        }catch(RadarException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private String readDataFromServer() throws ClientException {
            return radarSession.getClient().readData();

    }

    private void sendDataToServer(String data) {
        try {
            radarSession.getClient().sendData(data);
            System.out.println("SENT!");
        }catch(ClientException e) {
            System.out.println("FAILED TO SEND DATA");
        }
    }

    private void closeConnection() {
        try {
            radarSession.getClient().closeConnection();
        }catch(ClientException e) {
            System.out.println("Closing the client!");
        }

    }
}


