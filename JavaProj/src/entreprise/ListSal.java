package entreprise;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import service.Service;

public class ListSal {
	private List<Salarie> importList;
	private List<Salarie> exportList;

    Service ss = new Service();

		public ListSal() {
			 Connexion.getCon();

			importList = new ArrayList<Salarie>();
			 for(Salarie s :ss.findAll())
			importList.add(new Salarie(s.getMatricule(),s.getNom(),s.getEmail(),s.getDateEmbauche(),s.getSalaire(),s.getCategorie()));
		
			exportList = new ArrayList<Salarie>(); 
		} 
		public List<Salarie> getImportList() {
			return importList;
		} 
		public List<Salarie> getExportList() {
			return exportList; 
		} public void setExportList(List<Salarie> exportList) {
	
			this.exportList.addAll(exportList);
			for(Salarie p :this.exportList)
				System.out.println(p); 
		} 
		

}
