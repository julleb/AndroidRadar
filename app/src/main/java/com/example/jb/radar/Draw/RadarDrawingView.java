package com.example.jb.radar.Draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.jb.radar.Entity.EntitiesExtractor;
import com.example.jb.radar.Entity.Entity;
import com.example.jb.radar.Entity.LocalPlayer;
import com.example.jb.radar.Messages.MessagePool;

import java.util.Random;

/**
 * Created by jb on 2017-05-26.
 */

public class RadarDrawingView extends FrameLayout {


    private Paint drawPaint;
    private Radar radar;
    private MessagePool pool;
    private final int RADAR_COLOR = Color.BLACK;
    private RadarPositionConverter positionConverter;

   public RadarDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupPaint();
    }

    public RadarDrawingView(Context context, MessagePool pool) {
        super(context);
        setupPaint();
        this.pool = pool;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        radar = new Radar(getHeight() , getWidth());
        positionConverter = new RadarPositionConverter(radar);
        drawRadar(canvas);

        //EntitiesExtractor entities = pool.take();
        EntitiesExtractor entities = pool.getEntities();
        if(entities != null) {
            System.out.println("Size from Drawing " + pool.size());
            LocalPlayer localPlayer = entities.getLocalPlayer();
            for(int i = 0; i < entities.getEntityList().size(); i++) {
                Entity entity = entities.getEntityList().get(i);
                int [] position = positionConverter.convertPosition(entity, localPlayer);
                if(entity.getTeam() == 2) {
                    drawRedDot(canvas, position[0], position[1]);
                }else if(entity.getTeam() == 3) {
                    drawBlueDot(canvas, position[0], position[1]);
                }
            }

        }
    }

    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setColor(RADAR_COLOR);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        drawPaint.setStyle(Paint.Style.FILL);
    }

    private void drawRadar(Canvas canvas) {

        float centerY = (float) radar.getCenterY();
        float centerX = (float) radar.getCenterX();
        float width = (float)radar.getWidth();
        float height = (float)radar.getHeight();

        drawPaint.setColor(RADAR_COLOR);
        canvas.drawLine(0, centerY, width,  centerY, drawPaint);
        canvas.drawLine(centerX, 0, centerX, height, drawPaint);
        canvas.drawLine(centerX, centerY, width, 0, drawPaint);
        canvas.drawLine(centerX, centerY, 0, 0, drawPaint);
    }

    private void drawDotOfColor(Canvas canvas, int color, int x, int y) {
        drawPaint.setColor(color);
        canvas.drawCircle(x, y, 20, drawPaint);
    }

    private void drawBlueDot(Canvas canvas, int x , int y) {
        drawDotOfColor(canvas, Color.BLUE, x, y);
    }

    private void drawRedDot(Canvas canvas, int x , int y) {
        drawDotOfColor(canvas, Color.RED, x, y);
    }


}

