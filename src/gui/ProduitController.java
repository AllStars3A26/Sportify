/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.equipe;
import entities.produit;
import entities.terrain;
import entities.tournoi;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//import services.ServiceCommande;
import services.ServiceProduit;
import services.ServiceProduit;
import services.Serviceequipe;
import services.Serviceterrain;

/**
 * FXML Controller class
 *
 * @author snowy
 */
public class ProduitController implements Initializable {

    @FXML
    private Circle photo;
    @FXML
    private TableView<?> tableProd;
    @FXML
    private TableColumn<?, ?> NOM;
    @FXML
    private TableColumn<?, ?> PRIX;
    @FXML
    private TableColumn<?, ?> QUANTITE;
    @FXML
    private TableColumn<?, ?> IMAGE;
    @FXML
    private TableColumn<?, ?> CATEGORIE;
    @FXML
    private TableColumn<?, ?> ID;
    @FXML
    private TableColumn<?, ?> DESCRIPTION;
    @FXML
    private TableColumn<?, ?> MODIFIER;
    @FXML
    private TableColumn<?, ?> SUPPRIMER;
    @FXML
    private Button reload;
    @FXML
    private TextField search_button;
    @FXML
    private TextField getNom_prod;
    @FXML
    private TextField getPrix_prod;
    @FXML
    private Button ajouterProduit;
    @FXML
    private TextArea ima;
    @FXML
    private Button buttonima;
    @FXML
    private TextField getQuant_prod;
    @FXML
    private TextField getCat_prod;
    @FXML
    private TextField getDesc_prod;
    @FXML
    private TableView<?> tableMatch;
    @FXML
    private TableColumn<?, ?> EQUIPE2M;
    @FXML
    private TableColumn<?, ?> DATEM;
    @FXML
    private TableColumn<?, ?> SERVEURM;
    @FXML
    private TableColumn<?, ?> ETATM;
    @FXML
    private TableColumn<?, ?> TYPEM;
    @FXML
    private TableColumn<?, ?> TOURNOIM;
    @FXML
    private TableColumn<?, ?> ID1;
    @FXML
    private Button reload1;
    @FXML
    private TextField search_button1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void reloadd(ActionEvent event) {
    

    }
       ServiceProduit sp = new ServiceProduit();
     List<produit> lp = sp.afficher();
        
    Button[] modify_button = new Button[100];
       Button[] supprimerb = new Button[100];
       Button[] modify_button1 = new Button[100];
       Button[] supprimerb1 = new Button[100];
        int index=101; 
        
     private void handleButtonAction (ActionEvent event)
    {
       
         for (int i = 0; i < lp.size(); i++) {
            // Button a = supprimerb[i];
            
             if (event.getSource() == supprimerb[i])
             {
                 index=i;
             }
            
                 
         }
          System.out.println(index);
          int index1 = lp.get(index).getId_prod();
            Serviceterrain tt = new Serviceterrain();
            
             tt.supprimer(index1);
             lp = sp.afficher();
             tableProd.getItems().clear();
          afficher_produit(lp);
          Serviceterrain ss = new Serviceterrain();
         int nbtt= ss.nb_terrain(lt);
        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_terrainNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
     }
          private void handleButtonAction1 (ActionEvent event)
    {
       
         for (int i = 0; i < lt.size(); i++) {
            // Button a = supprimerb[i];
            
             if (event.getSource() == supprimerb[i])
             {
                 index=i;
             }
            
                 
         }
          System.out.println(index);
          int index1 = lm.get(index).getId_equipe();
            Serviceequipe tt = new Serviceequipe();
            
             tt.supprimer(index1);
             lm = tt.afficher();
             tableTerrain.getItems().clear();
          afficher_Equipe(lm);
          Serviceequipe ss = new Serviceequipe();
         /*int nbtt= ss.nb_terrain(lt);
        nbt.setText(String.valueOf(nbtt));*/
//        int nbttt= ss.nb_terrainNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
     }
    @FXML
    private void searchmethode(KeyEvent event) {
    }

    @FXML
    private void ajouterProduit(ActionEvent event) {
    }

    @FXML
    private void reloadd1(ActionEvent event) {
    }
    
}
