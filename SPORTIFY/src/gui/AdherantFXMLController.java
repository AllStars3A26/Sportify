/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Cours;
import services.ServiceCours;
import services.ServiceSeance;
import entities.Seance;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;


/**
 * FXML Controller class
 *
 * @author emnat
 */
public class AdherantFXMLController implements Initializable {
    @FXML
    private ListView<Cours> tableCours;
    @FXML
    private ListView<Seance> tableSeance;
    @FXML
    private Button trier;
    @FXML
    private RadioButton afficher1;
     @FXML
    private Label label1;
    @FXML

    private Button reload;
    @FXML
    private Button reload1;
    @FXML
    private Button participer;

    /**
     * Initializes the controller class.
     */
     ServiceCours sr = new ServiceCours();
    List <Cours> RECC ;
      ServiceSeance ss = new ServiceSeance();
    List <Seance> REC ;
       List<Cours> lt = sr.afficher();
    List<Seance> ltt = ss.afficher();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updatelist ();
        updatelist1 ();
    }    
     @FXML 
    void reloadd(ActionEvent event) {
            ServiceCours tt = new ServiceCours();
        lt = tt.afficher();
             tableCours.getItems().clear();
         updatelist ();
          ServiceCours ss = new ServiceCours(); }
    @FXML 
    void reloadd1(ActionEvent event) {
            ServiceSeance tt = new ServiceSeance();
        ltt = tt.afficher();
             tableSeance.getItems().clear();
         updatelist1 ();
          ServiceSeance ss = new ServiceSeance(); }
    public void updatelist(){
    RECC = sr.afficher();
    tableCours.getItems().setAll(RECC);
    }
       public void updatelist1(){
    REC = ss.afficher();
    tableSeance.getItems().setAll(REC);
    }
    @FXML 
    public void participer(ActionEvent event)throws SQLException
    {  

        Seance R = new Seance();
        R =(Seance) tableSeance.getSelectionModel().getSelectedItem();
        ss.participer(R);
        updatelist1();
        label1.setText ( "réservation faite avec succès");
        
       
    }
    @FXML
    private void tri(ActionEvent event) {
        ServiceSeance tt = new ServiceSeance();
          List<Seance> ltt = tt.TrierParnom();
          tableSeance.getItems().clear();
          updatelist1();
    }
}
