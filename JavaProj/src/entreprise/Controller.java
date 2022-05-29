package entreprise;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


import connexion.Connexion;
public class Controller implements Initializable {
    @FXML
	private Button supp;
	@FXML
	private Button add;
	@FXML
	private Button edit;
	@FXML
	private Button importBt;
	@FXML
	private Button ExportBt;
    @FXML
    private TableView <Salarie> table;
    @FXML
    private TableColumn<Salarie,Integer> matCol;
    @FXML
    private TableColumn<Salarie,String> nomCol;
    @FXML
    private TableColumn <Salarie,String> emailCol;
    @FXML
    private TableColumn<Salarie,Double> dateEmbCol;
    @FXML
    private TableColumn <Salarie,Double> SalCol;
    @FXML
    private TableColumn <Salarie,Double> HSupp;
    @FXML
    private TableColumn <Salarie,Double> PHSupp;
    @FXML
    private TableColumn <Salarie,String> Categorie;
    @FXML
	private TextField matField;
	@FXML
	private TextField nomField;
	@FXML
	private TextField mailField;
	@FXML
	private TextField DateEmbField;
	@FXML
	private TextField SalField;
	@FXML
	private TextField CatField;

	
	private ListSal listSal;
	Connection con = null;
    PreparedStatement ps  =null;
	Service ss = new Service();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	       this.listSal=new ListSal() ;		
	       matCol.setCellValueFactory(new PropertyValueFactory<Salarie,Integer>("matricule"));
	       nomCol.setCellValueFactory(new PropertyValueFactory<Salarie,String>("nom"));
	       emailCol.setCellValueFactory(new PropertyValueFactory<Salarie,String>("email"));
	       dateEmbCol.setCellValueFactory(new PropertyValueFactory<Salarie,Double>("DateEmbauche"));
	       SalCol.setCellValueFactory(new PropertyValueFactory<Salarie,Double>("salaire"));
	       Categorie.setCellValueFactory(new PropertyValueFactory<Salarie,String>("categorie"));
		 Connexion.getCon();
	}

	@FXML
	protected void Ajouter()
	{ 
	            String req = "insert into entreprise (matricule,nom,email,dateEmbauche,salaire,categorie) values ('" + matField.getText() + "', '" + nomField.getText()+ "', '" + mailField.getText() + "', '" + Double.parseDouble(SalField.getText())+  "', '" + Double.parseDouble(DateEmbField.getText())+  "', '" + CatField.getText()+"')";

	            Statement st;
				try {
					st = Connexion.getCon().createStatement();
					 st.executeUpdate(req);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				 Salarie s = new Salarie (Integer.parseInt(matField.getText()),nomField.getText(),mailField.getText(),Double.parseDouble(SalField.getText()),Double.parseDouble(DateEmbField.getText()),CatField.getText());
			   		listSal.getImportList().add(s);
			   		table.getItems().add(s);
	}
	
	@FXML
	protected void Supprimer()
{ 
		Salarie s = table.getSelectionModel().getSelectedItem();
		table.getItems().remove(s);
	        ss.delete(ss.findByMat(s.getMatricule()));
}
	
	@FXML
	protected void ImportSalarie()
	{ 
		   table.getItems().clear();
		  
	 table.getItems().addAll(listSal.getImportList());

	}

	
	public void select() {
	
	    Salarie s = table.getSelectionModel().getSelectedItem();
        matField.setText(String.valueOf(s.getMatricule()));
        nomField.setText(s.getNom());
        mailField.setText(s.getEmail());
        DateEmbField.setText(String.valueOf(s.getSalaire()));
        SalField.setText(String.valueOf(s.getDateEmbauche()));
        CatField.setText(s.getCategorie());
        table.getItems().remove(s);
	}
	public void update() {  
		
	    String req = "update entreprise set nom ='"+nomField.getText()+"', email ='"+mailField.getText()+"',salaire ='"+ Double.parseDouble(DateEmbField.getText())+"' , dateEmbauche ='"+Double.parseDouble(SalField.getText())+"',categorie ='"+CatField.getText()+"' where matricule = "+matField.getText();
        try {
			Statement st = Connexion.getCon().createStatement();
			 st.executeUpdate(req);
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	 
        Salarie s = new Salarie (Integer.parseInt(matField.getText()),nomField.getText(),mailField.getText(),Double.parseDouble(SalField.getText()),Double.parseDouble(DateEmbField.getText()),CatField.getText());
   		listSal.getImportList().add(s);
   		
   		table.getItems().add(s);
	}
	
	@FXML
	protected void ExportSalarie()
	{ 
		  Salarie s = table.getSelectionModel().getSelectedItem();
	   		listSal.getImportList().add(s);
	 table.getItems().addAll(listSal.getExportList());
	 FileWriter writer = null;
	try {
		writer = new FileWriter("ListeSalarie.txt");
	} catch (IOException e1) {
		e1.printStackTrace();
	} 
	 for(Salarie str: listSal.getImportList()) {
	   try {
		writer.write(str + System.lineSeparator());
	} catch (IOException e) {
		e.printStackTrace();
	}
	 }
	 try {
		writer.close();
	} catch (IOException e) {
		e.printStackTrace();
	}

	}


}