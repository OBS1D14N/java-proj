package entreprise;

public class Salarie {
 private int Mat ; 
 private String Nom ; 
 private String Email ; 
 private double DateEmbauche ;
 private double Salaire ; 
 private String Categorie;

public Salarie(int matricule, String nom, String email, double DateEmbauche , double salaire,String Categorie) {
	super();
	Mat = matricule;
	Nom = nom;
	Email = email;
	this.DateEmbauche = DateEmbauche;
	Salaire=salaire;
	this.Categorie=Categorie;
}
 
public int getMatricule() {
	return Mat;
}
public void setMatricule(int matricule) {
	Mat = matricule;
}
public String getNom() {
	return Nom;
}
public void setNom(String nom) {
	Nom = nom;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public double getDateEmbauche() {
	return DateEmbauche;
}
public void setDateEmbauche(double DateEmbauche) {
	this.DateEmbauche = DateEmbauche;
}


public String getCategorie() {
	return Categorie;
}

public void setCategorie(String categorie) {
	Categorie = categorie;
}

public double getSalaire() {
	if (this.getDateEmbauche()<2005.0) {
		return Salaire+=400;
	}else {
		return Salaire+=280;
	}
}

public void setSalaire(double salaire) {
	Salaire=salaire;
	}


@Override
public String toString() {
	return "Salarie [Mat=" + Mat + ", Nom=" + Nom + ", Email=" + Email + ", DateEmbauche=" + DateEmbauche + ", Salaire="
			+ Salaire + ", Categorie=" + Categorie + "]";
}



}
