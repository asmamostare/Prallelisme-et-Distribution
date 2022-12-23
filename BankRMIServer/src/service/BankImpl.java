package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import entity.Compte;

public class BankImpl extends UnicastRemoteObject implements IBank {


	private List<Compte> comptes;
	
	public BankImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		super();
		comptes= new ArrayList<Compte>();
		comptes.add(new Compte(10,10000));
		comptes.add(new Compte(20,20000));
		comptes.add(new Compte(30,30000));
		comptes.add(new Compte(40,40000));
		
	}
	
	@Override
	public double convertionEurToDh(double montant) throws RemoteException {
		// TODO Auto-generated method stub
		return montant*11;
	}
	
	
	@Override
	public Compte getCompte(int code) throws RemoteException {
		for (Compte cp : comptes) {
			if (cp.getCode()== code) {
				return cp;
			}
			
		}
		return null;
	}
	
	@Override
	public void verser(int code, double montant) throws RemoteException {
		for (Compte cp : comptes) {
			if (cp.getCode()== code) {
				cp.setSolde(cp.getSolde()+ montant);
			}
			
		}
		
	}

	@Override
	public void transfert(int codeSource, int codeDestination, double montant) throws RemoteException {
		retirer(codeSource, montant);
		verser(codeDestination, montant);
	}

	@Override
	public void retirer(int code, double montant) throws RemoteException {

		for (Compte cp : comptes) {
			if (cp.getCode()== code) {
				cp.setSolde(cp.getSolde()- montant);
			}
			
		}
		
	}
 




}
