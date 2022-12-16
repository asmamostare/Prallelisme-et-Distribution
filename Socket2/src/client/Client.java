package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {


	public static void main(String[] args) {
		try {

			
			// Etablir la connexion
			
			System.out.println("Pending connexion...");
			Socket socket= new Socket("localhost",6700);
			
			// Creation des objet de communication 
			
			// Etablir la communication 
			
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			
			// Creer les objets de communication 


			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
			
			
			Scanner clavier = new Scanner(System.in);
			System.out.println("Saisissez votre nom");
			String nom = clavier.nextLine();
			
			
			// envoie  du nom
			
			printWriter.println(nom);
			
			// reception de la reponse 
			
			String rep = bufferedReader.readLine();
			
			// L'affichege de la reponse 
			System.out.println("Rep= "+rep);
			


			//  Fermer la connexion 
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
