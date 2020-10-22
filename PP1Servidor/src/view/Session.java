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
				observer.onMessage(this, linea);
				
				
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
