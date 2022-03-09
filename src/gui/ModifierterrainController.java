/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.terrain;
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
import services.Serviceterrain;

/**
 * FXML Controller class
 *
 * @author Sahar Zouari
 */
public class ModifierterrainController implements Initializable {

    @FXML
    private TextField IDm;
    @FXML
    private TextField getNom_terrainm;
    @FXML
    private TextField getType_terrainm;
    @FXML
    private TextField getDescription_terrainm;
    @FXML
    private TextField getAdresse_terrainm;
    @FXML
    private Button modifyterrain;
    @FXML
    private ChoiceBox<String> getdispom;

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
       
         Serviceterrain sp= new Serviceterrain();
                 
         List<terrain> ll = sp.afficherId(id);
 
            getNom_terrainm.setText(String.valueOf(ll.get(0).getNom_terrain()));
            getType_terrainm.setText(String.valueOf(ll.get(0).getType_terrain()));
            getDescription_terrainm.setText(String.valueOf(ll.get(0).getDescription_terrain()));
            getAdresse_terrainm.setText(String.valueOf(ll.get(0).getAdresse_terrain()));
            
            ModifItems(id);
    }
    
    public void ModifItems (int id)
    {           
        
        ObservableList<String> langs2 = FXCollections.observableArrayList("oui","non");
        getdispom.setItems(langs2);
                 Serviceterrain sp=new Serviceterrain();
            List<terrain> ll = sp.afficherId(id);
        modifyterrain.setOnAction(e -> {
        String nomAjout = getNom_terrainm.getText();
        String typeAjout = getType_terrainm.getText();
        String descriptionAjout = getDescription_terrainm.getText();
        String adresseAjout =getAdresse_terrainm.getText();
        String dispoAjout=getdispom.getValue().toString();
         
        
        terrain t = new terrain(nomAjout,typeAjout,descriptionAjout,adresseAjout,dispoAjout);
      
            sp.modifier(t);
            ((Node)(e.getSource())).getScene().getWindow().hide();
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("terrain modifié!");
            alert.show(); Serviceterrain tt = new Serviceterrain();
                
           
        });
        }

    
}
