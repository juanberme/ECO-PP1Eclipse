package model;

import processing.core.PApplet;

public class Bicho {


	PApplet app;
	float bx,by, velbX,velbY;
	int vida,puntos;
	
public Bicho(float px,float py){
	super();
	//this.bx = bx;
	//this.by = by;
	
	vida = 3;
	puntos = 50;
	
	

	this.bx = (int)(Math.random()*1000);
	this.by = (int)(Math.random()*700);
	this.velbX = (int)(Math.random()*5);
	this.velbY = (int)(Math.random()*5);
	
	
	
	
}
	
	public void mover() {
		
		bx = bx + velbX;
		by = by + velbY;
		
		
		if( bx > 1200){
			bx = 0;
		}
		
		if(by > 700 ){
				by = 0  ;
		}
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public float getBx() {
		return bx;
	}

	public void setBx(float bx) {
		this.bx = bx;
	}

	public float getBy() {
		return by;
	}

	public void setBy(float by) {
		this.by = by;
	}

	public float getVelbX() {
		return velbX;
	}

	public void setVelbX(float velbX) {
		this.velbX = velbX;
	}

	public float getVelbY() {
		return velbY;
	}

	public void setVelbY(float velbY) {
		this.velbY = velbY;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	
}
