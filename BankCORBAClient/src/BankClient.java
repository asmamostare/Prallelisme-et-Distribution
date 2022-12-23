import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;

import BankCORBA.Bank;
import BankCORBA.BankHelper;

public class BankClient {

	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args, null);
			Context ctx = new InitialContext();
			
			Bank stub = BankHelper.narrow( (Object) ctx.lookup("BK"));
			
			System.out.println("============ Show Solde=========");
			System.out.println("Solde = "+stub.getCompte().solde);
			
			stub.verser(2000);
			stub.retirer(8000);
			stub.verser(4000);

			System.out.println("============ Show Solde=========");
			System.out.println("Solde = "+stub.getCompte().solde);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
