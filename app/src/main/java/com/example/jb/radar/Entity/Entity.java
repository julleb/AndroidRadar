package com.example.jb.radar.Entity;

/**
 * Created by jb on 2017-05-26.
 */

public class Entity {

    private Double [] position;
    private long team;
    private long health;
    private long dormant;

    public Entity(long health, long team, Double [] position) {
        this.health = health;
        this.team = team;
        this.position=position;
    }
    public Entity(long health, long team) {
        this.health = health;
        this.team = team;
    }

    public long getHealth() {
        return health;
    }
    public long getTeam() {
        return team;
    }
    public Double getPositionX() {
        return position[0];
    }
    public Double getPositionY() {
        return position[1];
    }
    public Double getPositionZ() { return position[2];}
}
