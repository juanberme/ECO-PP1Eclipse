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
import java.util.zip.InflaterInputStream;

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
	
	public void setObserver(onMessageListener observer) {
		this.observer = observer;
	}
	
	public void run() {
		try {
			
			server = new ServerSocket(5000);
			
			while(true) {
				System.out.println("Waiting client...");
				Socket servidor = server.accept();
				Session session = new Session(servidor);
				session.setObserver(observer);
				session.start();
				System.out.println("Successfully connected");
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
