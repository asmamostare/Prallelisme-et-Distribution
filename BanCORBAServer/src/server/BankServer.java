package server;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import service.BankImpl;

public class BankServer {

	public static void main(String[] args) {
		try {

			// creation  et config de serveur ORB
			ORB orb = ORB.init(args, null);
			
			// creer le POAmanager
			POA rootPOA= POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	
			// activation de POAmanager
			
			rootPOA.the_POAManager().activate();
			
			//creation de l'objet distant 
			
			BankImpl objetDistant= new BankImpl();
			
			
			// creation du contexte JNDI
			Context ctx = new InitialContext();
			
			// publication de l#objet distant
			
			ctx.rebind("BK", rootPOA.servant_to_reference(objetDistant));
			System.out.println(rootPOA.servant_to_reference(objetDistant));
			// lacement de serveur
			orb.run();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
