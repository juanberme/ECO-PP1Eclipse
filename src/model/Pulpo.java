package model;

import processing.core.PApplet;

public class Pulpo {

	PApplet app;
	float px,py, velpX,velpY;
	int vida,puntos;
	
public Pulpo(float px,float py){
	super();
	this.px = px;
	this.py = py;
	vida = 5;
	puntos = 100;
	
	this.velpX = (int)(Math.random()*2);
	this.velpY = (int)(Math.random()*5);
	
	if(velpX == 0 && velpY == 0) {
		velpX = 1;
		velpY = 1;
	}
	
	
}
	
	public void mover() {
		
		px = px + velpX;
		py = py + velpY;
		
		
		if( px > 1200){
			px = 0;
		}
		
		if(py > 700 ){
				py = 0  ;
		}
		
	}
	
	
	public int getVida() {
	return vida;
}

public void setVida(int vida) {
	this.vida = vida;
}

public int getPuntos() {
	return puntos;
}

public void setPuntos(int puntos) {
	this.puntos = puntos;
}


	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public float getPx() {
		return px;
	}

	public void setPx(float px) {
		this.px = px;
	}

	public float getPy() {
		return py;
	}

	public void setPy(float py) {
		this.py = py;
	}

	public float getVelpX() {
		return velpX;
	}

	public void setVelpX(float velpX) {
		this.velpX = velpX;
	}

	public float getVelpY() {
		return velpY;
	}

	public void setVelpY(float velpY) {
		this.velpY = velpY;
	}


	
}
