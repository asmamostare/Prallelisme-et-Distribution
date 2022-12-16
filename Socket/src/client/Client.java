package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		try {
			
			// Etablir la connexion
			
			System.out.println("Pending connexion...");
			Socket socket= new Socket("localhost",6700);
			
			// Creation des objet de communication 
			
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream(); 
			
			Scanner clavier = new Scanner(System.in);
			System.out.println("Saisissez un nombre");
			int nbr = clavier.nextInt();
			
			// Envoi de la valeur 
			
			outputStream.write(nbr);
			
			// Reception du resultat
			
			int res = inputStream.read();
			
			System.out.println("Res = "+res);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
