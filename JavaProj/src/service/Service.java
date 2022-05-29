package service;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import entreprise.Salarie;
import library.lib;

public class Service implements lib<Salarie> {

	public boolean delete(Salarie s) {
		try {
            PreparedStatement ps = Connexion.getCon().prepareStatement("delete from entreprise where matricule=?");
            ps.setInt(1,s.getMatricule());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur ");
        }
        return false;
    }

		
	@Override
	public Salarie findByMat(int mat) {
		try {
            String req = "select * from entreprise where matricule=" + mat;
            Statement stmt = Connexion.getCon().createStatement();
            ResultSet r = stmt.executeQuery(req);
            if (r.next()) {
                return new Salarie(r.getInt("matricule"), r.getString("nom"), r.getString("email"), r.getDouble("dateEmbauche"), r.getDouble("salaire"),r.getString("categorie"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur");
        }
        return null;
    }


	 @Override
	    public List<Salarie> findAll() {
	        List<Salarie> salaries = new ArrayList<>();
	        try {
	            String req = "select * from entreprise";
	            Statement st = Connexion.getCon().createStatement();
	            ResultSet r = st.executeQuery(req);
	            while (r.next()) {
	                salaries.add(new Salarie(r.getInt("matricule"), r.getString("nom"), r.getString("email"), r.getDouble("dateEmbauche"), r.getDouble("salaire"),r.getString("categorie")));
	            }
	 
	        } catch (SQLException ex) {
	            System.out.println("Erreur");
	        }
	        return salaries;
	    }
	
}