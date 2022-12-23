import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMT extends Thread {

	private int nbClients;
	
	public static void main(String[] args) {
		new ServerMT().start();
	}
	
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("Le serveur est lancé ...");
			while(true) {
				Socket socket = ss.accept();
				nbClients++;
				new Communication(socket, nbClients).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}