import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


import service.IBank;

public class RMIClient {

	public static void main(String[] args) {
		try {
			
			IBank stub = (IBank) Naming.lookup("rmi://localhost:1099/BK");
			
			System.out.println("====================== convertion de 203 Euro ---> DH =========================");
			System.out.println("203 Euro vaut: "+stub.convertionEurToDh(203)+"DHs");
			
			System.out.println("====================== Dolde de compte N 10 =========================");
			System.out.println("Solde du compte 10 ="+stub.getCompte(10).getSolde()+"DHs");

			System.out.println("================= transfer 100 euro from C10 to C20 ==================");
			stub.transfert(10, 20, 100);
			
			System.out.println("Solde du compte 10 ="+stub.getCompte(10).getSolde()+"DHs");
			System.out.println("Solde du compte 20 ="+stub.getCompte(20).getSolde()+"DHs");

			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
