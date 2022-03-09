/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Cours;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.ServiceCours;

/**
 * FXML Controller class
 *
 * @author Sahar Zouari
 */
public class ModifierCoursController implements Initializable {

    @FXML
    private TextField IDm;
    @FXML
    private Button modifyCours;
    @FXML
    private TextField getTitreM ;
    @FXML
    private TextField getNomeM;
    @FXML
    private ChoiceBox getTypeM,getImcM;
    @FXML
    private TextField getNb_heureM;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ObservableList<String> langs1 = FXCollections.observableArrayList("RPM", "Body Pump", "Yoga", "Boxe","Zumba","Musculation","Pilates");
        getTypeM.setItems(langs1);
        ObservableList<String> langs = FXCollections.observableArrayList("Endurance", "Souplesse", "Résistance", "Equilibre","Vitesse");
        getImcM.setItems(langs);
    } 
      public void setTextID (String message)
    {
        this.IDm.setText(message);
    }
    public void setItems (int id)
    {
       
         ServiceCours sp= new ServiceCours();
                 
         List<Cours> ll = sp.afficherId(id);
         getTitreM.setText(String.valueOf(ll.get(0).gettitre()));
            getNomeM.setText(String.valueOf(ll.get(0).getNomE()));
            getTypeM.setValue(ll.get(0).getType());
            getImcM.setValue(ll.get(0).getImc());
            getNb_heureM.setText(String.valueOf(ll.get(0).getNb_heure()));
            
            ModifItems(id);
    }
    
    public void ModifItems (int id)
    {
                 ServiceCours sp=new ServiceCours();
            List<Cours> ll = sp.afficherId(id);
        modifyCours.setOnAction(e -> {
        String titre = getTitreM.getText();
        String nome = getNomeM.getText();
        int nbheure = Integer.parseInt(getNb_heureM.getText());
        String type = getTypeM.getValue().toString();
        String imc = getImcM.getValue().toString();
       
         if ((titre.equals("")) || (nome.equals("")) || (type.equals("")) || (nbheure == 0)||(imc.equals(""))) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("champs manquants !");
            alert.showAndWait();
        } else if (Pattern.matches("[a-zA-Z]+", titre) == false) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Le champ 'Nom de cours' doit etre composé de lettres uniquement !");
            alert.showAndWait();
        } else if (Pattern.matches("[a-zA-Z]+", nome) == false) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Le champ 'Nom d'entraineur' doit etre composé de lettres uniquement !");
            alert.showAndWait();
        } else if (getNb_heureM.getText().matches("\\d+") == false) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Le champ 'Nombre d'heure' doit etre composé de lettres uniquement !");
        }else{
        Cours t = new Cours(id,titre,nome,type,imc,nbheure);
      
            sp.modifier(t);
            ((Node)(e.getSource())).getScene().getWindow().hide();
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Cours modifié!");
            alert.show(); 
            ServiceCours tt = new ServiceCours();
                
           
        }});
        

    }
}
