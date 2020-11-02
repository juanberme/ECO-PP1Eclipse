package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.zip.InflaterInputStream;

import com.google.gson.Gson;

public class TCPSingleton extends Thread{
	
	private static TCPSingleton unica;
	
	public static TCPSingleton getInstance() {
		if(unica == null) {
			unica = new TCPSingleton();
			//unica.start();
		}
		return unica;
	}
	
	
	private TCPSingleton(){}
	
	private onMessageListener observer;
	private ServerSocket server;
	private BufferedReader reader;
	private ArrayList<Session> sesiones;
	
	public void setObserver(onMessageListener observer) {
		this.observer = observer;
	}
	
	public void run() {
		try {
			sesiones = new ArrayList<Session>();
			server = new ServerSocket(5000);
			//sesiones = new Session();
			while(sesiones.size()<2) {
				System.out.println("Waiting client...");
				Socket socket = server.accept();
				Session sesion = new Session(socket);
				sesion.setObserver(observer);
				sesion.start();
				sesiones.add(sesion);
				System.out.println("Successfully connected");
				
				////
				
				/*InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				reader = new BufferedReader(isr);
				
				String linea = reader.readLine();*/
				
				
				
				/*System.out.println("Sesion:"+s.getID()+","+msg);
				
				Coordenada coorRecibida = gson.fromJson(msg, Coordenada.class);
				s.setCoordenada(coorRecibida);
				/*x = coorRecibida.getX();
				y = coorRecibida.getY();*/
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Session> getSesiones() {
		// TODO Auto-generated method stub
		return this.sesiones;
	}
	
	
	
}
