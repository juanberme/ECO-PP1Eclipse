package view;

import java.io.IOException;
import java.util.ArrayList;

import model.Asteroides;
import model.Bicho;
import model.Pulpo;
import processing.core.PApplet;

public class Main extends PApplet implements onMessageListener{



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");
		
	
	}
	private ArrayList <Bicho> bic;
	private ArrayList <Asteroides> ast;
	private ArrayList <Pulpo> pulp;
	private TCPSingleton tcp;
	
	
	public void settings() {
		size(1200,700);
		
		
	}
	
	public void setup() {
		tcp = TCPSingleton.getInstance();
		tcp.setObserver(this);
		tcp.start();
		
		
		//crear asteroides
		
		ast = new ArrayList<Asteroides>();
		ast.add(new Asteroides(500,100));
		ast.add(new Asteroides(100,450));
		ast.add(new Asteroides(240,320));
		ast.add(new Asteroides(370,200));
		ast.add(new Asteroides(580,100));
		ast.add(new Asteroides(680,30));
		ast.add(new Asteroides(7200,330));
		ast.add(new Asteroides(8300,440));
		

		//crear pulpos malvados
		
		pulp = new ArrayList<Pulpo>();
		pulp.add(new Pulpo(200,100));
		pulp.add(new Pulpo(160,60));
		pulp.add(new Pulpo(60,400));
		pulp.add(new Pulpo(90,44));
		pulp.add(new Pulpo(60,30));
		pulp.add(new Pulpo(80,47));
		pulp.add(new Pulpo(300,300));
		pulp.add(new Pulpo(600,450));	
		
		
	//crear Bichos malos
		
		bic = new ArrayList<Bicho>();
		bic.add(new Bicho(600,500));
		bic.add(new  Bicho(360,460));
		bic.add(new  Bicho(1060,100));
		bic.add(new  Bicho(1090,444));
		bic.add(new  Bicho(960,330));
		bic.add(new  Bicho(90,547));
		bic.add(new  Bicho(800,600));
		bic.add(new  Bicho(1000,450));	
		
	}
	
	public void draw() {
		background(0);
		
		
		
		for (int i = 0; i < ast.size(); i++) {
			Asteroides as = ast.get(i);
			as.mover();
			fill(255);
			ellipse(as.getAx(), as.getAy(), 50, 50);
		}
		
		for (int o = 0; o < pulp.size(); o++) {
			Pulpo pu = pulp.get(o);
			pu.mover();
			fill(255,200,200);
			ellipse(pu.getPx(), pu.getPy(), 60, 60);
		}
		
		for (int n = 0; n < bic.size(); n++) {
			Bicho bi = bic.get(n);
			bi.mover();
			fill(0,200,200);
			ellipse(bi.getBx()+20, bi.getBy()+20, 70, 70);
		}
		
		
	}

	public void onMessage( String msg) {
		
		
	}

}
