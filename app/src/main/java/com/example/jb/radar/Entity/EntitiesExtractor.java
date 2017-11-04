package com.example.jb.radar.Entity;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

/**
 * Created by jb on 2017-05-26.
 */

public class EntitiesExtractor {

    private static final String ENTITIES = "Entities";
    private static final String LOCALPLAYER = "LocalPlayer";
    private static final String HEALTH = "Health";
    private static final String TEAM = "Team";
    private static final String POSITION = "Position";
    private static final String EYEPOSITION = "EyePosition";

    private LocalPlayer localPlayer;
    private ArrayList<Entity> entityList;

    public EntitiesExtractor() {
        entityList = new ArrayList<Entity>();
    }

    public void createEntities(String json) {
        JSONParser parser = new JSONParser();
        try {
            Object o = parser.parse(json);
            JSONObject jsonObject = (JSONObject) o;

            addEntitiesToArray(jsonObject);
            localPlayer = createLocalPlayer(jsonObject);

        }catch(ParseException e) {

        }
    }

    public LocalPlayer getLocalPlayer() {
        return localPlayer;
    }
    public ArrayList<Entity> getEntityList() {
        return entityList;
    }

    private void addEntitiesToArray(JSONObject jsonObject) {
        //entityList = new ArrayList<Entity>(); //reinitalize it!
        JSONArray entities = (JSONArray)jsonObject.get(ENTITIES);
        for(int i=0; i< entities.size(); i++) {
            JSONObject entityObject = (JSONObject) entities.get(i);
            Entity entity = createEntity(entityObject);
            entityList.add(entity);
        }
    }

    private Entity createEntity(JSONObject entityObject) {
        Long health = (Long) entityObject.get(HEALTH);
        Long team = (Long) entityObject.get(TEAM);

        Double [] position = convertJsonObjectToDoubleArray((JSONObject) entityObject.get(POSITION));
        return new Entity(health, team, position);
    }

    private Double[] convertJsonObjectToDoubleArray(JSONObject jsonObject) {
        Double [] doubleArray = new Double[3];
        if(jsonObject != null) {
            String temp = (String) jsonObject.get("x");
            doubleArray[0] = Double.valueOf(temp);
            temp = (String) jsonObject.get("y");
            doubleArray[1] = Double.valueOf(temp);
            temp = (String) jsonObject.get("z");
            doubleArray[2] = Double.valueOf(temp);
        }
        return doubleArray;
    }

    private LocalPlayer createLocalPlayer(JSONObject jsonObject) {
       JSONObject localPlayerObject = (JSONObject) jsonObject.get(LOCALPLAYER);
        if(localPlayerObject != null) {
            Long health = (Long) localPlayerObject.get(HEALTH);
            Long team = (Long) localPlayerObject.get(HEALTH);

            Double [] position = convertJsonObjectToDoubleArray((JSONObject) localPlayerObject.get(POSITION));
            Double [] eyePosition = convertJsonObjectToDoubleArray((JSONObject) localPlayerObject.get(EYEPOSITION));
            return new LocalPlayer(health, team, position, eyePosition);
        }
        return null;

    }

    private Double [] convertJSONArrayToDoubleArray(JSONArray jsonArray) {
        Double[] doubleArray = new Double[3];
        if(jsonArray != null ) {
            for(int i = 0; i < jsonArray.size(); i++ ){
                doubleArray[i] = (Double) jsonArray.get(i);
            }
        }
        return doubleArray;
    }
}

