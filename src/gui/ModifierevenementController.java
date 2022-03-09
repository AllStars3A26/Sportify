/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Evenement;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.Serviceevenement;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ModifierevenementController implements Initializable {

    @FXML
    private TextField IDm;
    @FXML
    private TextField getlibelle_E;
    @FXML
    private TextField gettype_E;
    @FXML
    private DatePicker getdate_E;
    @FXML
    private Button modifyevenement;

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
      
        
         Serviceevenement sp= new Serviceevenement();
                 
         List<Evenement> ll = sp.afficherid(id);
   
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateToString = df.format(ll.get(0).getDate_evenement());
       
        LocalDate date = LocalDate.parse(dateToString);
        System.out.println(date);
        getlibelle_E.setText(String.valueOf(ll.get(0).getLibelle_evenement()));
          System.out.println("rani mawjoud2");
        gettype_E.setText(String.valueOf(ll.get(0).getType_evenement()));
         System.out.println("rani mawjoud2");
        getdate_E.setValue(date);
            
           System.out.println("rani mawjoud2");
            ModifItems(id);
             
    }
    
    public void ModifItems (int id)
    {
         System.out.println("rani mawjoud2");
                 Serviceevenement sp=new Serviceevenement ();
            List<Evenement > ll = sp.afficher();
        modifyevenement.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent e) {
                 String libelleAjout = getlibelle_E.getText();
                 String typeAjout = gettype_E.getText();
                 
                 
                 ZoneId defaultZoneId = ZoneId.systemDefault();
                 Date dateAjout = Date.from(getdate_E.getValue().atStartOfDay(defaultZoneId).toInstant());
                 
                 
                 Evenement t = new Evenement(libelleAjout,typeAjout,dateAjout);
                 
                 sp.Modifier(t);
                 ((Node)(e.getSource())).getScene().getWindow().hide();
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Success");
                 alert.setContentText("evenement modifié!");
                 alert.show(); Serviceevenement tt = new Serviceevenement();
             }
         });
        }

    
}
