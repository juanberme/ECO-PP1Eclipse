package view;

import java.io.IOException;
import java.util.ArrayList;


import com.google.gson.Gson;


import model.Asteroides;
import model.Bicho;
import model.Pulpo;
import model.naves;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet implements onMessageListener{
	int pantalla;

	private PImage menu1;
	private PImage menu2;
	private PImage pantalla1;
	private PImage ganador;
	private PImage instrucciones;
	private PImage aste;
	private PImage pulpito;
	private PImage bichin;
	private PImage naveAzul;
	private PImage naveVerde;
	private PImage naveVioleta;
	private PImage naveRosa;
	private PImage vidaAzul;
	private PImage vidaVioleta;
	private naves vidanave;
	int puntaje;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");
		
	
	}
	private ArrayList <Bicho> bic;
	private ArrayList <Asteroides> ast;
	private ArrayList <Pulpo> pulp;
	private ArrayList<Disparo> disparos;
	private TCPSingleton tcp;
	int contador = 30;
	Coordenada c;
	
	public void settings() {
		size(1200,700);
		
		
	}
	
	public void setup() {
		pantalla = 4;
		
		//imagenes
		menu1 = loadImage ("images/menu1.png");
		menu2= loadImage ("images/menu2.png");
		pantalla1= loadImage ("images/pantalla1.png");
		ganador= loadImage ("images/ganador.png");
		instrucciones = loadImage ("images/instrucciones.png");
		aste= loadImage ("images/asteroide.png");
		pulpito= loadImage ("images/pulpo.png");
		bichin= loadImage ("images/ojo.png");
		naveAzul = loadImage ("images/naveAzul.png");
		naveVerde= loadImage ("images/naveVerde.png");
		naveVioleta= loadImage ("images/naveVioleta.png");
		naveRosa= loadImage ("images/naveRosa.png");
		vidaAzul= loadImage ("images/vidaAzul.png");
		vidaVioleta= loadImage ("images/VidaVioleta.png");
		
		disparos = new ArrayList<Disparo>();
		
		// tcp
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
		
		
		 new Thread( 
				 () -> {
				 while (contador > 0) {
                        if (pantalla == 3 ) {
                           contador --;
                           
                          } 
                     
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                      
                    }
                	
				 } 
				 }
           ).start();
		
	}
	
	public void draw() {
		background(0);

		/*for(int i = 0; i < 2; i++ ) {
			Session sesion = tcp.getSesiones().get(i);
		}*/
		//ArrayList<Session> sesiones = tcp.getSesiones();
		

		switch (pantalla) {
			case 1:
				//para ir a juego
				image (menu1,0,0);
				
				break;
			case 2:
				//para ir a instruciones
				image (menu2,0,0);
				
				break;
			case 3:
				//pantalla de juego
				image (pantalla1,0,0);
				textSize(18);
				text("puntos:",100,120);
				text("puntos:",820,120);
				text("Jugador 1",30,80);
				text("jugador 2",1108,80);
				text("TIEMPO",550,80);
				text(contador,570,100);
			if(contador == 0) {
				pantalla = 5;
			}
//crear asteroides
				for (int i = 0; i < ast.size(); i++) {
					Asteroides as = ast.get(i);
					as.mover();
					
					image(aste, as.getAx(), as.getAy(), 150,150);
				}
				//crear pulpo 
				for (int o = 0; o < pulp.size(); o++) {
					Pulpo pu = pulp.get(o);
					pu.mover();
					
					image(pulpito,pu.getPx(), pu.getPy(), 80, 80);
				}
			//crear bicho
				for (int n = 0; n < bic.size(); n++) {
					Bicho bi = bic.get(n);
					bi.mover();
					fill(0,200,200);
					image(bichin,bi.getBx()+20, bi.getBy()+20, 80, 80);
				}
				
				

				/*for(int i = 0; i < 2; i++ ) {
					Session sesion = tcp.getSesiones().get(i);
				}*/
				ArrayList<Session> sesiones = tcp.getSesiones();
				//crear navecita 1
				for(int i = 0; i < sesiones.size(); i++) {
					if(i == 0) {
						//Coordenada c = sesiones.get(i).getCoordenada();
						 c = sesiones.get(i).getCoordenada();
						image(naveAzul,c.getX(), c.getY() , 100, 100);
						
					}else if(i == 1) { //crear navecita 2
						//Coordenada c = sesiones.get(i).getCoordenada();
						 c = sesiones.get(i).getCoordenada();
						image(naveVioleta,c.getX(), c.getY() , 100, 100);
					}	
				}
				//crear disparos y que desaparezcan al llegar al borde de abajo del mapa
				for(int i = 0; i<disparos.size(); i++) {
					Disparo d = disparos.get(i);
					ellipse(d.getX(), d.getY(), 20, 20);
					d.setY(d.getY()+d.getVel());
					if(d.getY() > height || d.getX() > width || d.getX() <  0 || d.getY() < 0) {
						disparos.remove(d);
					}
					//si las balas golpean a un pulpo, que le haga da�o
					for(int p = 0; p < pulp.size(); p++) {
						Pulpo pul = pulp.get(p);
						if(dist(pul.getPx()+40, pul.getPy()+40, d.getX(), d.getY())<40) {
							pul.setVida(pul.getVida()-1) ;
							if(pul.getVida() == 0 ) {
									pulp.remove(p);
							disparos.remove(i);
								
							}
						
							
						}
						
					}
					//si le hace da�o a un bicho que lo golpee
					for(int b = 0; b < bic.size(); b++) {
						Bicho biho = bic.get(b);
						if(dist(biho.getBx()+40, biho.getBy()+40, d.getX(), d.getY())<40) {
							bic.remove(b);
							disparos.remove(i);
							
						}
					}
					//si le hace da�o a un bicho que le baje resistencia
					for(int a = 0; a < ast.size(); a++) {
						Asteroides asteroide = ast.get(a);
						if(dist(asteroide.getAx()+75, asteroide.getAy()+75, d.getX(), d.getY())<75) {
							ast.remove(a);
							disparos.remove(i);
						
						
						}
					}
				}
				
				break;
			case 4: 
				//instrucciones
				image(instrucciones,0,0);
				
			break; 
			case 5: 
				//ganador
				image (ganador,0,0);
				textSize(24);
				text("ganador 1",555,350);
				text("ganador 2",555,350);
				break;
		
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

public void mousePressed() {
	Disparo d = new Disparo(5, mouseX, mouseY);
	disparos.add(d);
}


}
