/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.equipe;
import Entities.terrain;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Services.Serviceequipe;
import Services.Serviceterrain;

/**
 * FXML Controller class
 *
 * @author Skander BELHASSEN
 */
public class ModifierEquipeController implements Initializable {

    @FXML
    private TextField IDm;
    @FXML
    private Button modifyequipe;
    @FXML
    private TextField getNom_equipem;
    @FXML
    private TextField getType_equipem;
    @FXML
    private TextField getDescription_equipem;
    @FXML
    private TextField getMail_equipem;
    @FXML
    private TextField getNbre_equipem;

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
       
         Serviceequipe sp= new Serviceequipe();
                 
         List<equipe> ll = sp.afficherId(id);
 
            getNom_equipem.setText(String.valueOf(ll.get(0).getNom_equipe()));
            getType_equipem.setText(String.valueOf(ll.get(0).getType_equipe()));
            getDescription_equipem.setText(String.valueOf(ll.get(0).getDescription_equipe()));
            getMail_equipem.setText(String.valueOf(ll.get(0).getMail_equipe()));
            getNbre_equipem.setText(String.valueOf(ll.get(0).getNbre_joueur()));
            
            ModifItems(id);
    }
    
    public void ModifItems (int id)
    {
                 Serviceequipe sp=new Serviceequipe();
            List<equipe> ll = sp.afficherId(id);
        modifyequipe.setOnAction(e -> {
        String nomAjout = getNom_equipem.getText();
        String typeAjout = getType_equipem.getText();
        String descriptionAjout = getDescription_equipem.getText();
        String mailAjout =getMail_equipem.getText();
        int nbreAjout =Integer.parseInt(getNbre_equipem.getText());
        
        equipe t = new equipe(nomAjout,typeAjout,descriptionAjout,mailAjout,nbreAjout);
      
            sp.modifier(t);
            ((Node)(e.getSource())).getScene().getWindow().hide();
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("match modifié!");
            alert.show(); Serviceequipe tt = new Serviceequipe();
                
           
        });
        }

    
}
