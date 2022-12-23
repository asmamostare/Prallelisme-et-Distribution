import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Communication extends Thread {
	
	private Socket socket;
	private int num;
	
	public Communication() {
		super();
	}
	
	public Communication(Socket socket, int num) {
		super();
		this.socket = socket;
		this.num = num;
	}
	
	@Override
	public void run() {
	
	try {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
		System.out.println("Connexion de client N°" + num + " son IP est " + socket.getRemoteSocketAddress());
		printWriter.println("Vous etes le client N°" + num);
		while (true) {
			printWriter.println("J'attend une chaine de char ...");
			String nom = bufferedReader.readLine();
			String rep = "Bonjour Mr/Mlle/Mme " + nom + " votre nom est composé de " + nom.length() + " chars";
			printWriter.println(rep);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
}