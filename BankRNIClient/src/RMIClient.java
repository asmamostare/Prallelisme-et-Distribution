import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import service.IBank;

public class RMIClient {

	public static void main(String[] args) {
		try {
			
			//utilisation de naming		
			//IBank stub = (IBank) Naming.lookup("rmi://localhost:1099/BK");
			
			
			// utilisation du contexte jndi
			
			Context ctx = new InitialContext();
			
			// context config
			
			ctx.addToEnvironment(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
			ctx.addToEnvironment(Context.PROVIDER_URL, "rmi://localhost:1099/BK");
			
			// creation de stub
			
			IBank stub  = (IBank) ctx.lookup("BK");
			
			System.out.println("====================== convertion de 203 Euro ---> DH =========================");
			System.out.println("203 Euro vaut: "+stub.convertionEurToDh(203)+"DHs");
			
			System.out.println("====================== Dolde de compte N 10 =========================");
			System.out.println("Solde du compte 10 ="+stub.getCompte(10).getSolde()+"DHs");

			System.out.println("================= transfer 100 euro from C10 to C20 ==================");
			stub.transfert(10, 20, 100);
			
			System.out.println("Solde du compte 10 ="+stub.getCompte(10).getSolde()+"DHs");
			System.out.println("Solde du compte 20 ="+stub.getCompte(20).getSolde()+"DHs");

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
