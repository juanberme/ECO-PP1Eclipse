package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.UUID;

import com.google.gson.Gson;

public class Session extends Thread{
	
	private Socket servidor;
	private BufferedReader reader;
	private BufferedWriter writer;
	private onMessageListener observer;
	private String id;
	private Coordenada coordenada;
	
	public Session(Socket socket) {
		this.servidor = socket;
		this.id = UUID.randomUUID().toString();
		coordenada = new Coordenada(0,0);
	}
	
	public void setObserver(onMessageListener observer) {
		this.observer = observer;
	}
	
	@Override
	public void run() {
		
		try {
			InputStream is = servidor.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));
			
			OutputStream os = servidor.getOutputStream();
			writer = new BufferedWriter(new OutputStreamWriter(os));
			
			while(true) {
				String linea = reader.readLine();
				System.out.println(linea);
				
				Gson gson = new Gson();
				Generic gen = gson.fromJson(linea, Generic.class);
				System.out.println("Tipo recibido"+gen.type);
				
				switch(gen.type) {
				case "Coordenada":
					Coordenada coor = gson.fromJson(linea, Coordenada.class);
					System.out.println("Coordenada:"+","+coor.getX()+","+coor.getY());
					observer.coorReceived(coor);
					break;
				case "Disparo":
					Disparo shoot = gson.fromJson(linea, Disparo.class);
					System.out.println("Disparo:"+","+ shoot.getX()+","+shoot.getY()+","+shoot.getVel());
					observer.shootReceived(shoot);
					break;
				}
				//observer.onMessage(this, linea);
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendMessage(String msg) {
		new Thread(
				()->{
					try {
						writer.write(msg+"\n");
						writer.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				).start();
	}
	
	
	
	public String getID() {
		return this.id;
	}
	
	public Coordenada getCoordenada() {
		return this.coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
		
	}

}
