package entreprise;

import java.util.HashMap;


public class Entreprise {
	private String nomE ; 
 HashMap<Integer, Salarie> listeSal;
	public Entreprise() {
		listeSal = new HashMap<Integer, Salarie>();
	}
public Entreprise(String nomE) {
	super();
	this.nomE = nomE;
}
public String getNomE() {
	return nomE;
}
public void setNomE(String nomE) {
	this.nomE = nomE;
}


int getNBemployes() {
	return listeSal.size();
}

@Override
public String toString() {
	return "entreprise [nomE=" + nomE + ", liste=" + listeSal + "]";
}
}
