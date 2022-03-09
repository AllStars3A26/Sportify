/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.equipe;
import entities.terrain;
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
import javafx.scene.Node;
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
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.Serviceequipe;
import services.Serviceterrain;

/**
 * FXML Controller class
 *
 * @author Sahar Zouari
 */
public class terrainController implements Initializable {
  private Desktop desktop = Desktop.getDesktop();
    @FXML
    private Circle photo;
    @FXML
    private Label nbt;
    @FXML
    private TableView<terrain> tableTerrain;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> type;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private TableColumn<?, ?> adresse;
    @FXML
    private TableColumn<?, ?> MODIFIER;
    @FXML
    private TableColumn<?, ?> SUPPRIMER;
    @FXML
    private TableColumn<?, ?> ID;
    @FXML
    private Button reload;
    @FXML
    private TextField getNom_terrain;
    @FXML
    private TextField getType_terrain;
    @FXML
    private TextField getDescription_terrain;
    @FXML
    private TextArea ima;
    @FXML
    private TextField getAdresse_terrain;
    @FXML
    private Label nbt1;
    @FXML
    private Label nbtnj1;
    @FXML
    private TableColumn<?, ?> MODIFIER1;
    @FXML
    private TableColumn<?, ?> SUPPRIMER1;
    @FXML
    private TableColumn<?, ?> ID1;
    @FXML
    private Button reload1;
    @FXML
    private Button ajouterterrain;
    @FXML
    private TextField search_button;
    @FXML
    private Button tri;
    @FXML
    private TableView<equipe> tableEquipe;
    @FXML
    private TableColumn<?, ?> nom_equipe;
    @FXML
    private TableColumn<?, ?> type_equipe;
    @FXML
    private TableColumn<?, ?> description_equipe;
    @FXML
    private TableColumn<?, ?> mail_equipe;
    @FXML
    private TableColumn<?, ?> nbre_equipe;
    @FXML
    private TextField getNom_equipe;
    @FXML
    private TextField getType_equipe;
    @FXML
    private Button ajouterEquipe;
    @FXML
    private TextField getDescription_equipe;
    @FXML
    private TextField getMail_equipe;
    @FXML
    private TextField getNbre_equipe;
    @FXML
    private TextField search_button1;
    @FXML
    private Button tri1;
    
    @FXML
    void reloadd(ActionEvent event) {
            Serviceterrain tt = new Serviceterrain();
        lt = tt.afficher();
             tableTerrain.getItems().clear();
          afficher_terrain(lt);
          Serviceterrain ss = new Serviceterrain();
         int nbtt= ss.nb_terrain(lt);
        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_terrainNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
    }

    
      Serviceterrain st = new Serviceterrain();
     List<terrain> lt = st.afficher();
     Serviceequipe sm = new Serviceequipe();
     List<equipe> lm = sm.afficher();
     
     
     
    
    Button[] modify_button = new Button[100];
       Button[] supprimerb = new Button[100];
       Button[] modify_button1 = new Button[100];
       Button[] supprimerb1 = new Button[100];
        int index=101; 
         
           private void handleButtonAction (ActionEvent event)
    {
       
         for (int i = 0; i < lt.size(); i++) {
            // Button a = supprimerb[i];
            
             if (event.getSource() == supprimerb[i])
             {
                 index=i;
             }
            
                 
         }
          System.out.println(index);
          int index1 = lt.get(index).getId_terrain();
            Serviceterrain tt = new Serviceterrain();
            
             tt.supprimer(index1);
             lt = tt.afficher();
             tableTerrain.getItems().clear();
          afficher_terrain(lt);
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
          private void modifierButtonAction (ActionEvent event)
    {
        try {
            
            FXMLLoader modif= new FXMLLoader(getClass().getResource("modifierterrain.fxml"));
            Parent root = modif.load();
            ModifierterrainController mc = modif.getController();
            for (int i = 0; i < lt.size(); i++) {
            if (event.getSource() == modify_button[i])
             {
                 index=i;
             }}
            System.out.println(index);
            int index1 = lt.get(index).getId_terrain();
            String s=String.valueOf(index1);
            System.out.println(s);
               mc.setTextID(s);
              mc.setItems(index1);
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            
            modifStage.setTitle("Hello World!");
            modifStage.setScene(scene);
            modifStage.show();
            modifStage.setOnHidden(e -> {
                 Serviceterrain tt = new Serviceterrain();
                    lt = tt.afficher();
             tableTerrain.getItems().clear();
          afficher_terrain(lt);
          Serviceterrain ss = new Serviceterrain();
                 int nbtt= ss.nb_terrain(lt);
        nbt.setText(String.valueOf(nbtt));
      
                       
                   modifStage.setScene(null);
                   modifStage.close();
             
             
              });
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(terrainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     } 
        
    private void modifierButtonAction1 (ActionEvent event)
    {
        try {
            
            FXMLLoader modif= new FXMLLoader(getClass().getResource("modifierEquipe.fxml"));
            Parent root = modif.load();
            ModifierEquipeController mc = modif.getController();
            for (int i = 0; i < lm.size(); i++) {
            if (event.getSource() == modify_button[i])
             {
                 index=i;
             }}
            System.out.println(index);
            int index1 = lm.get(index).getId_equipe();
            String s=String.valueOf(index1);
            System.out.println(s);
               mc.setTextID(s);
              mc.setItems(index1);
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            
            modifStage.setTitle("Hello World!");
            modifStage.setScene(scene);
            modifStage.show();
            modifStage.setOnHidden(e -> {
                 Serviceequipe tt = new Serviceequipe();
                    lm = tt.afficher();
             tableEquipe.getItems().clear();
          afficher_Equipe(lm);
          Serviceequipe ss = new Serviceequipe();
                 /*int nbtt= ss.nb_terrain(lm);
        nbt.setText(String.valueOf(nbtt));*/
      
                       
                   modifStage.setScene(null);
                   modifStage.close();
             
             
              });
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(terrainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     } 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        photo.setStroke(Color.SEAGREEN);
        Image im = new Image("/images/1.png", false);
        photo.setFill(new ImagePattern(im));
        photo.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        
      
         
         
         
         
        
        
        for (int i = 0; i < lt.size(); i++) {
            ImageView modify = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
             lt.get(i).setModifier(modify_button[i]);
             lt.get(i).setSupprimer(supprimerb[i]);
           supprimerb[i].setOnAction(this::handleButtonAction);
            modify_button[i].setOnAction(this::modifierButtonAction);
        }
        for (int i = 0; i < lm.size(); i++) {
            ImageView modify= new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
           lm.get(i).setModifier(modify_button[i]);
            lm.get(i).setSupprimer(supprimerb[i]);
            supprimerb[i].setOnAction(this::handleButtonAction1);
           modify_button[i].setOnAction(this::modifierButtonAction1);
      }
        
       ObservableList<terrain> datalist = FXCollections.observableArrayList(lt);
        
          nom.setCellValueFactory(new PropertyValueFactory<>("nom_terrain"));
        type.setCellValueFactory(new PropertyValueFactory<>("type_terrain"));
        description.setCellValueFactory(new PropertyValueFactory<>("description_terrain"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse_terrain"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        System.out.println(lt);
        tableTerrain.setItems(datalist);
         Serviceterrain ss = new Serviceterrain();
         int nbtt= ss.nb_terrain(lt);
        nbt.setText(String.valueOf(nbtt));
        
        ObservableList<equipe> datalist1 = FXCollections.observableArrayList(lm);
        
          nom_equipe.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
        type_equipe.setCellValueFactory(new PropertyValueFactory<>("type_equipe"));
        description_equipe.setCellValueFactory(new PropertyValueFactory<>("description_equipe"));
        mail_equipe.setCellValueFactory(new PropertyValueFactory<>("mail_equipe"));
        nbre_equipe.setCellValueFactory(new PropertyValueFactory<>("nbre_joueur"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        System.out.println(lm);
        tableEquipe.setItems(datalist1);
         Serviceequipe ss1 = new Serviceequipe();
         //int nbtt1= ss1.nb_equipe(lt);
        //nbt.setText(String.valueOf(nbtt));
    }    

   
   


   
    @FXML
    private void reloadd1(ActionEvent event) {
    }

    
    @FXML
    private void ajouterterrain(ActionEvent event) throws IOException {
        //////////////////
        
       
        
        /////////////////////
        
        Serviceterrain sp= new Serviceterrain();
        String nomAjout = getNom_terrain.getText();
        String typeAjout =getType_terrain.getText();
        String descriptionAjout =getDescription_terrain.getText();
        String adresseAjout =getAdresse_terrain.getText();
         
        
        terrain t = new terrain(nomAjout,typeAjout,descriptionAjout,adresseAjout);
        
        
            sp.ajouter(t);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("terrain ajouté!");
            alert.show();
            getNom_terrain.setText("");
            getType_terrain.setText("");
            getDescription_terrain.setText("");
            getAdresse_terrain.setText("");
            Serviceterrain tt = new Serviceterrain();
             List<terrain> ltt = tt.afficher();
             tableTerrain.getItems().clear();
          afficher_terrain(ltt);
          Parent root = FXMLLoader.load(getClass().getResource("terrain.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
//          Serviceterrain ss = new Serviceterrain();
//          int nbtt= ss.nb_terrain(ltt);
//          nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_terrainNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
         
            
        }
    
     public void afficher_terrain(List<terrain> ltt)
    {
        for (int i = 0; i < ltt.size(); i++) {
            ImageView modify = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
            ltt.get(i).setModifier(modify_button[i]);
             ltt.get(i).setSupprimer(supprimerb[i]);
            supprimerb[i].setOnAction(this::handleButtonAction);
           modify_button[i].setOnAction(this::modifierButtonAction);
        }
       ObservableList<terrain> datalist = FXCollections.observableArrayList(ltt);
        
           nom.setCellValueFactory(new PropertyValueFactory<>("nom_terrain"));
        type.setCellValueFactory(new PropertyValueFactory<>("type_terrain"));
        description.setCellValueFactory(new PropertyValueFactory<>("description_terrain"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse_terrain"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        System.out.println(lt);
        tableTerrain.setItems(datalist);
        Serviceterrain ss = new Serviceterrain();
          int nbtt= ss.nb_terrain(ltt);
          nbt.setText(String.valueOf(nbtt));
    }
     private void printLog(TextArea textArea, List<File> files) {
        if (files == null || files.isEmpty()) {
            return;
        }
        for (File file : files) {
            textArea.appendText(file.getAbsolutePath() + "\n");
        }
    }

    private void openFile(File file) {
        try {
            this.desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//             //affichage
         

    @FXML
    private void searchmethode(KeyEvent event) {
        Serviceterrain tt = new Serviceterrain();
          List<terrain> ltt = tt.rechercheterrain(search_button.getText());
          tableTerrain.getItems().clear();
          afficher_terrain(ltt);
    }

    @FXML
    private void tri_on_clicked(ActionEvent event) {
        Serviceterrain tt = new Serviceterrain();
          List<terrain> ltt = tt.TrierParnom();
          tableTerrain.getItems().clear();
          afficher_terrain(ltt);
    }

    @FXML
    private void ajouterEquipe(ActionEvent event) throws IOException {
    Serviceequipe sp= new Serviceequipe();
        String nomAjout = getNom_equipe.getText();
        String typeAjout =getType_equipe.getText();
        String descriptionAjout =getDescription_equipe.getText();
        String mailAjout =getMail_equipe.getText();
        int nbreAjout =Integer.parseInt(getNbre_equipe.getText());
         
        
        equipe t = new equipe(nomAjout,typeAjout,descriptionAjout,mailAjout,nbreAjout);
        
        
            sp.ajouter(t);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("equipe ajouté!");
            alert.show();
            getNom_equipe.setText("");
            getType_equipe.setText("");
            getDescription_equipe.setText("");
            getMail_equipe.setText("");
            getNbre_equipe.setText("");
            Serviceequipe tt = new Serviceequipe();
             List<equipe> ltt = tt.afficher();
             tableEquipe.getItems().clear();
          afficher_Equipe(ltt);
          
//          Serviceterrain ss = new Serviceterrain();
//          int nbtt= ss.nb_terrain(ltt);
//          nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_terrainNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
         
            
        }
    
     public void afficher_Equipe(List<equipe> ltt)
    {
        for (int i = 0; i < lm.size(); i++) {
            ImageView modify = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
           lm.get(i).setModifier(modify_button[i]);
            lm.get(i).setSupprimer(supprimerb[i]);
            supprimerb[i].setOnAction(this::handleButtonAction1);
           modify_button[i].setOnAction(this::modifierButtonAction1);
      }
       ObservableList<equipe> datalist = FXCollections.observableArrayList(ltt);
        
           nom_equipe.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
        type_equipe.setCellValueFactory(new PropertyValueFactory<>("type_equipe"));
        description_equipe.setCellValueFactory(new PropertyValueFactory<>("description_equipe"));
        mail_equipe.setCellValueFactory(new PropertyValueFactory<>("mail_equipe"));
        nbre_equipe.setCellValueFactory(new PropertyValueFactory<>("nbre_joueur"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        System.out.println(lm);
        tableEquipe.setItems(datalist);
        Serviceequipe ss = new Serviceequipe();
          /*int nbtt= ss.nb_terrain(ltt);
          nbt.setText(String.valueOf(nbtt));*/
    }
     
//             //affichage
         

    /*@FXML
    private void searchmethode(KeyEvent event) {
        Serviceterrain tt = new Serviceterrain();
          List<terrain> ltt = tt.rechercheterrain(search_button.getText());
          tableTerrain.getItems().clear();
          afficher_terrain(ltt);
    }

    @FXML
    private void tri_on_clicked(ActionEvent event) {
        Serviceterrain tt = new Serviceterrain();
          List<terrain> ltt = tt.TrierParnom();
          tableTerrain.getItems().clear();
          afficher_terrain(ltt);
    }*/
   

}
