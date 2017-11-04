package com.example.jb.radar.Messages;

import com.example.jb.radar.Entity.EntitiesExtractor;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by jb on 2017-05-26.
 */

public class MessagePool {

    Queue<EntitiesExtractor> queue;


    private EntitiesExtractor entities;

    public MessagePool() {
        queue  = new ConcurrentLinkedQueue<EntitiesExtractor>();

    }

    public void  add(EntitiesExtractor entities) {
        queue.add(entities);
    }
    public EntitiesExtractor take() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }

    public void setEntities(EntitiesExtractor ent) {
        this.entities = ent;
    }
    public EntitiesExtractor getEntities() {
        return this.entities;
    }


}

