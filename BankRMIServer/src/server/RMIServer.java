package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

import service.BankImpl;

public class RMIServer {

	public static void main(String[] args) {
		try {
			// lancer l'espace de nommage en local 
			LocateRegistry.createRegistry(1099);
			
			
			// Creation de l'objet distant et le skoleton 
			BankImpl objetDistant = new BankImpl();
			
			System.out.println(objetDistant.toString());

			// Publication de l'objet distant en utilisant naming 
			
			//Naming.rebind("rmi://localhost:1099/BK", objetDistant);
			
			
			// Publication de contexte jndi
			
			Context ctx = new InitialContext();
			// publication de l'objet distant 
			ctx.rebind("BK", objetDistant);
			
			
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
