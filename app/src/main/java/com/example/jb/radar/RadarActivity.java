package com.example.jb.radar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.jb.radar.Draw.RadarDrawingView;
import com.example.jb.radar.Messages.MessagePool;
import com.example.jb.radar.Task.DataTask;
import com.example.jb.radar.socket.ServerInformation;

public class RadarActivity extends AppCompatActivity {

    private DataTask dataTask;
    private int height;
    private int width;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent radarActivity = getIntent();
        ServerInformation serverInfo = (ServerInformation) radarActivity.getSerializableExtra("ServerInformation");



        MessagePool pool = new MessagePool();
        RadarDrawingView radarView = createRadarView(pool);
        addRadarViewToLinearLayout(radarView);

        dataTask = new DataTask(serverInfo, radarView, pool);
        dataTask.execute();

    }

    private RadarDrawingView createRadarView(MessagePool pool) {
        RadarDrawingView radarView = new RadarDrawingView(this, pool);
        radarView.setBackgroundColor(Color.parseColor("#00ffa5"));

       radarView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return radarView;
    }
    private void addRadarViewToLinearLayout(RadarDrawingView radarView) {
        final LinearLayout linLayout = (LinearLayout) findViewById(R.id.radarlayout);
        linLayout.addView(radarView);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        dataTask.cancel(true);
    }
}


