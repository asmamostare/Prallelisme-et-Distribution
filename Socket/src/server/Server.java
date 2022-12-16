package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(6700);
			
			System.out.println("Pending connexion...");
			
			// Acception de la connection
			
			Socket socket = serverSocket.accept();

			
			System.out.println("Connected.");
			// Etablir la communication 
			
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			
			System.out.println("J'attend un nombre");
			
			// Reception du nombre 			
			
			int nbr= inputStream.read();
			
			// Traitement 
			
			int rep = nbr*3;
			
			outputStream.write(rep);
			//  Fermer la connexion 
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
