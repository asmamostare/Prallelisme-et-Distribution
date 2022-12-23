package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Compte;

public interface IBank extends Remote {
	public double convertionEurToDh(double montant) throws RemoteException ;
	public Compte getCompte(int code) throws RemoteException;
	public void verser(int code , double montant) throws RemoteException;
	public void transfert(int codeSource, int codeDestination , double montant) throws RemoteException;
	public void retirer(int code , double montant) throws RemoteException;
	
}