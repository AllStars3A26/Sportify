/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.match;
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
import services.ServiceMatch;

/**
 * FXML Controller class
 *
 * @author Sahar Zouari
 */
public class ModifierMatchController implements Initializable {

    @FXML
    private TextField IDm;
    @FXML
    private Button modifymatch;
    @FXML
    private TextField getEquipe1;
    @FXML
    private TextField getEquipe2;
    @FXML
    private TextField getResultatm;
    @FXML
    private DatePicker getDate_match;

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
       
        
         ServiceMatch sp= new ServiceMatch();
                 
         List<match> ll = sp.afficherId(id);
        System.out.println(ll);
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateToString = df.format(ll.get(0).getDate_match());
 LocalDate date = LocalDate.parse(dateToString);
 
        getEquipe1.setText(String.valueOf(ll.get(0).getId_equipe1()));
            getEquipe2.setText(String.valueOf(ll.get(0).getId_equipe2()));
            getResultatm.setText(String.valueOf(ll.get(0).getResultat_match()));
            getDate_match.setValue(date);
            
            
            ModifItems(id);
    }
    
    public void ModifItems (int id)
    {
                 
          
        modifymatch.setOnAction(e -> {
             
        int equipe1a = Integer.parseInt(getEquipe1.getText());
          int equipe2a = Integer.parseInt(getEquipe2.getText());
             int resultatm = Integer.parseInt(getResultatm.getText());
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date dateajout = Date.from(getDate_match.getValue().atStartOfDay(defaultZoneId).toInstant());
       
        
        match p = new match(id,equipe1a,equipe2a,dateajout,resultatm);
        ServiceMatch sp= new ServiceMatch();
            sp.modifier(p);
            ((Node)(e.getSource())).getScene().getWindow().hide();
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Match modifié!");
            alert.show(); ServiceMatch tt = new ServiceMatch();
                
           
        });
        }
    
}
