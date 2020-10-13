package view;

import java.io.IOException;

import processing.core.PApplet;

public class Main extends PApplet implements onMessageListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");
	}
	
	private TCPSingleton tcp;
	
	
	public void settings() {
		size(1200,700);
	}
	
	public void setup() {
		tcp = TCPSingleton.getInstance();
		tcp.setObserver(this);
		tcp.start();
	}
	
	public void draw() {
		background(0);
	}

	public void onMessage( String msg) {
		
		
	}

}