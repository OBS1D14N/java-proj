package entreprise;

public class Vendeurs extends Salarie {
	private double Vente ; 
	private double Pourcentage ; 


public Vendeurs(int matricule, String nom, String email, double DateEmbauche, double salaire, String Categorie,
			double vente, double pourcentage) {
		super(matricule, nom, email, DateEmbauche, salaire, Categorie);
		Vente = vente;
		Pourcentage = pourcentage;
	}

public double getVente() {
	return Vente;
}

public void setVente(double vente) {
	Vente = vente;
}

public double getPourcentage() {
	return Pourcentage;
}

public void setPourcentage(double pourcentage) {
	Pourcentage = pourcentage;
}

@Override
public String toString() {
	return "Vendeurs [Vente=" + Vente + ", Pourcentage=" + Pourcentage + "]";
}



}
