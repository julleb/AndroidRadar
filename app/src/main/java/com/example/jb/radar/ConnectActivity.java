package com.example.jb.radar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jb.radar.socket.RadarException;
import com.example.jb.radar.socket.ServerInformation;
import com.example.jb.radar.socket.RadarSession;

public class ConnectActivity extends AppCompatActivity {

    private Button connectButton;
    private TextView ipText;
    private TextView portText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_connect);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        connectButton = (Button) findViewById(R.id.connectButton);
        ipText = (TextView) findViewById(R.id.serverIpText);
        portText = (TextView) findViewById(R.id.serverPortText);

        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ip = ipText.getText().toString();
                String port = portText.getText().toString();

                ServerInformation serverInfo = new ServerInformation(ip, port);

                Intent imageIntent = new Intent(ConnectActivity.this, RadarActivity.class);
                imageIntent.putExtra("ServerInformation", serverInfo);
                ConnectActivity.this.startActivity(imageIntent);

            }
        });
    }

}
