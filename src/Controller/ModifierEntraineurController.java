/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Entraineur;
import Entities.Utilisateur;
import Services.UserUtiles;
import Services.UtilisateurService;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ModifierEntraineurController implements Initializable {
 UserUtiles uUtiles = new UserUtiles();
    @FXML
    private TextField Nom_E;
    @FXML
    private TextField Prenom_E;
    @FXML
    private TextField Adresse_E;
    @FXML
    private TextArea ima;
    @FXML
    private TextField Username_E;
    @FXML
    private TextField Email_E;
    @FXML
    private TextField Type_E;
    @FXML
    private DatePicker Date_con;
    @FXML
    private TextField Duré;
    @FXML
    private TextField num_e;
    @FXML
    private PasswordField password_E;
    @FXML
    private Button ModifyE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    public void setItems (int id)
    {
        UtilisateurService sp= new UtilisateurService();
       List<Entraineur> ll = sp.afficherIdEntraineur(id);
         
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateToString = df.format(ll.get(0).getDate_contract());
      LocalDate date = LocalDate.parse(dateToString);
         
       Prenom_E.setText(String.valueOf(ll.get(0).getPrenom()));
        Nom_E.setText(String.valueOf(ll.get(0).getNom()));
        Adresse_E.setText(String.valueOf(ll.get(0).getAdresse()));
        Username_E.setText(String.valueOf(ll.get(0).getLogin()));
        Email_E.setText(String.valueOf(ll.get(0).getEmail()));
        Type_E.setText(String.valueOf(ll.get(0).getType_E()));
        Date_con.setValue(date);
        Duré.setText(String.valueOf(ll.get(0).getDure()));
       num_e.setText(String.valueOf(ll.get(0).getNum()));
 
            
            ModifItems(id);
    }
      public void alert_Box(String title, String message) {
	Alert dg = new Alert(Alert.AlertType.WARNING);
	dg.setTitle(title);
	dg.setContentText(message);
	dg.show();
    }
    public void ModifItems (int id)
    {
                UtilisateurService sp=new UtilisateurService();
            List<Entraineur> ll = sp.afficherIdEntraineur(id);
        ModifyE.setOnAction(e -> {
           String PenomAjout = Prenom_E.getText();
        String NomAjout =Nom_E.getText();
        String AdresseAjout =Adresse_E.getText();
        String LoginAjout =Username_E.getText();
        
        String emailAjout =Email_E.getText();
        String TypeAjout =Type_E.getText();
        String Date_contractAjout =Date_con.getValue().toString();
        int DureAjout = Integer.parseInt(Duré.getText());
        String numAjout =num_e.getText();
        if (PenomAjout.isEmpty() || NomAjout.isEmpty() || LoginAjout.isEmpty() ) {
	    alert_Box("Verification", "Votre nom/prenom/username ne doit pas être vide");
	}else if (!uUtiles.testEmail(emailAjout)) {
	    alert_Box("Verifier votre mail", "veillez saisir une adresse mail valide");
	} else if (!uUtiles.testTel(numAjout)) {
	    alert_Box("Verifier votre numero telephone", "Veillez mettre un numero de telephone valide");
	} else{

            sp.ModifierEntraineur(NomAjout,PenomAjout,AdresseAjout,LoginAjout, numAjout, emailAjout, TypeAjout,DureAjout,Date_contractAjout);
            ((Node)(e.getSource())).getScene().getWindow().hide();
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Entraineur modifié!");
            alert.show(); 
                
           
        }});
        

                }
}
