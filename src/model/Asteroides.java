package model;

import processing.core.PApplet;

public class Asteroides {
	PApplet app;
	float ax,ay, velX,velY;
	int resistencia;
    private String type = "Asteroides";
    int puntos;

    public Asteroides() { }
	
public Asteroides(float ax,float ay){
	super();
	this.ax = ax;
	this.ay = ay;
	resistencia = 8;
	
	puntos = 200;
	
	
	this.velX = (int)(Math.random()*10)-5;
	this.velY = (int)(Math.random()*5);
	
	if(velX == 0 && velY == 0) {
		velX = 1;
		velY = 1;
	}
	
}
	
	public void mover() {
		
		ax = ax + velX;
		ay = ay + velY;
		
		
		if( ax > 1200){
			ax = 0;
		}
		
		if(ay > 700 ){
				ay = 0 ;
		
		}
		
		
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public float getAx() {
		return ax;
	}

	public void setAx(float ax) {
		this.ax = ax;
	}

	public float getAy() {
		return ay;
	}

	public void setAy(float ay) {
		this.ay = ay;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
	
//	
}
