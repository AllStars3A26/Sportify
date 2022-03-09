/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.tournoi;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.ServiceTournoi;

/**
 * FXML Controller class
 *
 * @author Sahar Zouari
 */
public class ModifierTournoiController implements Initializable {

    @FXML
    private TextField IDm;
    @FXML
    private Button modifytournoi;
    @FXML
    private TextField getNom_tournoim;
    @FXML
    private TextField getNb_maxm;
    @FXML
    private TextField getResultatm;
    @FXML
    private TextField getheure_tournoim;
    @FXML
    private DatePicker getDate_tournoim;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
      public void setTextID (String message)
    {
        this.IDm.setText(message);
    }
    public void setItems (int id)
    {
       
         ServiceTournoi sp= new ServiceTournoi();
                 
         List<tournoi> ll = sp.afficherId(id);
  
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateToString = df.format(ll.get(0).getDate_tournoi());
 LocalDate date = LocalDate.parse(dateToString);
 
        getNom_tournoim.setText(String.valueOf(ll.get(0).getNom_tournoi()));
            getNb_maxm.setText(String.valueOf(ll.get(0).getNb_participants()));
            getResultatm.setText(String.valueOf(ll.get(0).getResultat_tournoi()));
            getDate_tournoim.setValue(date);
            getheure_tournoim.setText(String.valueOf(ll.get(0).getHeure()));
            
            ModifItems(id);
    }
    
    public void ModifItems (int id)
    {
                 ServiceTournoi sp=new ServiceTournoi();
            List<tournoi> ll = sp.afficherId(id);
        modifytournoi.setOnAction(e -> {
        String nomAjout = getNom_tournoim.getText();
        int nb_participantsAjout = Integer.parseInt(getNb_maxm.getText());
        int resultatAjout = Integer.parseInt(getResultatm.getText());
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date dateAjout = Date.from(getDate_tournoim.getValue().atStartOfDay(defaultZoneId).toInstant());
       int heureAjout = Integer.parseInt(getheure_tournoim.getText());
        
        tournoi t = new tournoi(id,nomAjout,dateAjout,nb_participantsAjout,ll.get(0).getImage_tournoi(),resultatAjout,heureAjout);
      
            sp.modifier(t);
            ((Node)(e.getSource())).getScene().getWindow().hide();
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Tournoi modifié!");
            alert.show(); ServiceTournoi tt = new ServiceTournoi();
                
           
        });
        }

    
}
