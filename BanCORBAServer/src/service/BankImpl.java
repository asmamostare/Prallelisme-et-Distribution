package service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BankCORBA.BankPOA;
import BankCORBA.Compte;

public class BankImpl extends BankPOA{
	Compte compte;
	public BankImpl(){

		compte = new Compte(10,10000);
	}
	

	@Override
	public void verser(double montant) {
		compte.solde = compte.solde+ montant;
		
	}

	@Override
	public void retirer(double montant) {
		compte.solde = compte.solde+ montant;		
	}

	@Override
	public Compte getCompte() {
		return compte;
	}

}
