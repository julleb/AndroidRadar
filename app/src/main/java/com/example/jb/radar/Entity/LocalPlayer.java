package com.example.jb.radar.Entity;

/**
 * Created by jb on 2017-05-26.
 */

public class LocalPlayer extends Entity {

    private Double[] eyePosition;
    public LocalPlayer(long health, long team, Double[] position, Double [] eyePosition) {
        super(health, team, position);
        this.eyePosition = eyePosition;
    }

    public Double[] getEyePosition() {
        return eyePosition;
    }



}
