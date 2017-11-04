package com.example.jb.radar.Draw;

import com.example.jb.radar.Entity.Entity;
import com.example.jb.radar.Entity.LocalPlayer;
import static java.lang.Math.*;
/**
 * Created by jb on 2017-05-27.
 */

public class RadarPositionConverter {

    private Radar radar;
    private static final int sightSize = 5;
    private static final double scaleSize = 2.2;//1.1;
    public RadarPositionConverter(Radar radar) {
        this.radar = radar;
    }

    public int [] convertPosition(Entity entity, LocalPlayer localPlayer) {
        Double angle = localPlayer.getEyePosition()[1] * (Math.PI/180);

        double radarX = (localPlayer.getPositionX() -  entity.getPositionX()) / sightSize;
        double radarY = (localPlayer.getPositionY() - entity.getPositionY()) /sightSize;

        Double playerRadarPositionX = radarY * cos(angle) - radarX * sin(angle);
        Double playerRadarPositionY = radarY * sin(angle) + radarX * cos(angle);

        playerRadarPositionX *=scaleSize;
        playerRadarPositionX +=radar.getCenterX();

        System.out.println("CENTER " + radar.getCenterX());
        playerRadarPositionY *=scaleSize;
        playerRadarPositionY +=radar.getCenterY();

        int [] position = new int[2];
        position[0] = playerRadarPositionX.intValue();
        position[1] = playerRadarPositionY.intValue();
        return position;
    }

    private Double getDistanceOfPlayer(Entity entity, LocalPlayer localPlayer) {
        Double [] dist = new Double[3];
        dist[0] = localPlayer.getPositionX() - entity.getPositionX();
        dist[1] = localPlayer.getPositionY() - entity.getPositionY();
        dist[2] = localPlayer.getPositionZ() - entity.getPositionZ();

        return Math.sqrt( (dist[0]*dist[0]) + (dist[1]*dist[1]) + (dist[2]*dist[2]));

    }

}
