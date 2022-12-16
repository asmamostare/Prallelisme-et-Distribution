package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
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
			
			//InputStream inputStream = socket.getInputStream();
			//OutputStream outputStream = socket.getOutputStream();
			
			// Creer les objets de communication 

			// Lecture

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
			
			
			// Ecriture
			
			System.out.println("J'attend une chaine de char");
			
			// Reception du nombre 			
			
			String nom= bufferedReader.readLine();
			
			// Traitement 
			
			String rep = "Bonjour MR/Mlle/Mme " +nom +" votre nom est compose de " + nom.length()+" char";
			
			printWriter.println(rep);
			//printWriter.flush();  ----> au cas ou le dexieme ergument de print writer est false
			//  Fermer la connexion 
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
