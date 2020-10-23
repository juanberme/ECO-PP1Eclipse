package view;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

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
		/*for(int i = 0; i < 2; i++ ) {
			Session sesion = tcp.getSesiones().get(i);
		}*/
		ArrayList<Session> sesiones = tcp.getSesiones();
		for(int i = 0; i < sesiones.size(); i++) {
			Coordenada c = sesiones.get(i).getCoordenada();
			//Coordenada c2 = sesiones.get(1).getCoordenada();
			fill(0,0,255);
			ellipse(c.getX(), c.getY() , 100, 100);
			/*fill(255,0,0);
			ellipse(c2.getX(),c2.getY(),100,100);*/
		}
		
	}

	public void onMessage(Session s, String msg) {
		System.out.println("Sesion:"+s.getID()+","+msg);
		Gson gson = new Gson();
		Coordenada coorRecibida = gson.fromJson(msg, Coordenada.class);
		s.setCoordenada(coorRecibida);
		/*x = coorRecibida.getX();
		y = coorRecibida.getY();*/
	}

}
