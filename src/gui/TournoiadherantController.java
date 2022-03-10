/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Entities.match;
import Entities.tournoi;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import Services.ServiceMatch;
import Services.ServiceTournoi;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TournoiadherantController implements Initializable {

@FXML 
   private VBox vbox;
@FXML
   private Button tournoiButton;
@FXML
  private Label nomT;
@FXML
  private Button loadt;
@FXML
  private Button buttonload;
@FXML
  private TextField loadtnum;

@FXML
  private Label datet;
@FXML
  private Label nbt;
@FXML
  private VBox vboxmatch;
    @FXML
    private Circle taswira;
    /**
     * Initializes the controller class.
     */

    
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("cc");
            
          ServiceTournoi ss = new ServiceTournoi();
            List<tournoi> ltt = ss.afficher();
         int nbtt= ss.nb_tournoi(ltt);
        nbt.setText(String.valueOf(nbtt));
        
         ServiceTournoi tt = new ServiceTournoi();
                
                int nb = tt.nb_tournoi(ltt);
                
               int nbr= (nb/4)+1;
               System.out.println(nbr);
               System.out.println(nb);
               int nbreste = nb%4;
            
            Node [] nodes = new Node[nbr];
            Button[] infot = new Button[nbr+3];
            for (int i=0;i<nbr;i++)
            {    System.out.println("1");
                
                   try {
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("itemTournoi.fxml"));
                Parent root = loader.load();
                
                ItemTournoiController dac = (ItemTournoiController) loader.getController();
                       System.out.println(ltt);
                dac.afficher(ltt,i);
                if ((i==nbr-1)&&(nbreste==2))
              {
                  dac.set3();
                  dac.set4();
              }
                else if ((i==nbr-1)&&(nbreste==3)) {
                    dac.set4();
                }else if ((i==nbr-1)&&(nbreste==1))
                {
                  dac.set2();
                  dac.set3();
                  dac.set4();  
                }
               String s=String.valueOf(nbreste);
              // dac.t1modif(s,ltt);
                    nodes[i]=root;
                    vbox.getChildren().add(nodes[i]);
    //                    int id =dac.boutton (i);
                //       System.out.println(dac.inna());
                } catch (IOException ex) {
                       System.out.println("cccc");
                    Logger.getLogger(TournoiadherantController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
             
                
               
                
            }
            
            
         
            
            
          loadt.setOnAction(e->{
                 buttonload.setVisible(true);
             
               int id1= Integer.parseInt(this.loadtnum.getText())-1;
           int    iddd= ltt.get(id1).getId_tournoi();
               System.out.println(id1);
              List<tournoi> lr= tt.afficherId(iddd);
              DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
                String strDate = dateFormat.format(lr.get(0).getDate_tournoi());  
              nomT.setText(lr.get(0).getNom_tournoi());
              datet.setText(strDate);
              
          
          });
          

       ServiceMatch M = new ServiceMatch();
                List<match> lmm= M.afficher();
            DateFormat dtf= new SimpleDateFormat("yyyy-mm-dd"); 
            
            
          
           HBox hb[]= new HBox[lmm.size()];
          Label[] equipe0=new Label[lmm.size()];
          Label[] equipe00=new Label[lmm.size()];
            Label[] equipe1=new Label[lmm.size()];
        
        Label[] vs=new Label[lmm.size()];
        
        Label[] equipe2=new Label[lmm.size()];
        
        Label[] date=new Label[lmm.size()];
        Label[] date1=new Label[lmm.size()];
        Label[] score=new Label[lmm.size()];
        Label[] score1=new Label[lmm.size()];
        
        Circle[] c = new Circle[lmm.size()];
        /////////////////////////////////////////////
         for (int i = 0; i < lmm.size(); i++) {
             hb[i]=new HBox();
               String datem = dtf.format(lmm.get(i).getDate_match());
              equipe0[i]=new Label("    ");
          equipe00[i]=new Label("               ");
        equipe1[i]=new Label(M.nom_equipe(lmm.get(i).getId_equipe1()));
        vs[i]=new Label(" vs ");
        
        equipe2[i]=new Label(M.nom_equipe(lmm.get(i).getId_equipe2()));
      
        date[i]=new Label("Date: ");
        date1[i]=new Label(datem);
        score[i]=new Label("                 Résultat: ");
        score1[i]=new Label(String.valueOf(lmm.get(i).getResultat_match()));
        
        c[i] = new Circle();
             
        if (lmm.get(i).getId_equipe1()==lmm.get(i).getResultat_match())
        {
           equipe1[i].setStyle("-fx-font-weight:bold;-fx-font-size:16px;-fx-text-fill:#008800 "); 
           equipe2[i].setStyle("-fx-font-weight:bold;-fx-font-size:16px;-fx-text-fill:#FF0000 ");
          
        } 
        else if (lmm.get(i).getId_equipe2()==lmm.get(i).getResultat_match())
        {
           equipe1[i].setStyle("-fx-font-weight:bold;-fx-font-size:16px;-fx-text-fill:#FF0000 "); 
           equipe2[i].setStyle("-fx-font-weight:bold;-fx-font-size:16px;-fx-text-fill:#008800 ");
          
        }
        else{   
            System.out.println("ww");
        }
        
             c[i].setRadius(9);
          hb[i].setSpacing(10);
           hb[i].setStyle("-fx-min-height:40px");
                   hb[i].setStyle("-fx-border-color:#000,-fx-border-width:0px;");
                  c[i].setStyle("-fx-translate-y:4px ");
        
         vs[i].setStyle("-fx-font-weight:bold;-fx-font-size:16px ");
       
      
       date[i].setStyle("-fx-font-weight:bold;-fx-font-size:16px;-fx-padding:0px 0px 0px 20px");
       date1[i].setStyle("-fx-font-weight:bold;-fx-font-size:16px ;-fx-text-fill:#BF3C3C");
       date[i].setStyle("-fx-font-weight:bold;-fx-font-size:16px ");
       score1[i].setStyle("-fx-font-weight:bold;-fx-font-size:16px ;-fx-min-width:20px;");
       score[i].setStyle("-fx-font-weight:bold;-fx-font-size:16px ");
       
     
        //////////////////////////////////////////
        hb[i].getChildren().add(equipe0[i]);
        hb[i].getChildren().add(equipe1[i]);
        hb[i].getChildren().add(vs[i]);
        hb[i].getChildren().add(equipe2[i]);
        
        hb[i].getChildren().add(date[i]);
        hb[i].getChildren().add(date1[i]);
        hb[i].getChildren().add(score[i]);
        hb[i].getChildren().add(score1[i]);
        
    
        hb[i].getChildren().add(equipe00[i]);
        hb[i].getChildren().add(c[i]);
         vboxmatch.getChildren().add(hb[i]);
             System.out.println("zz");
        } 
       
    }

    @FXML
    private void home(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/View/FXMLDashbordclient.fxml"));
          Stage  Stage1_1 = (Stage)((Node)event.getSource()).getScene().getWindow();
              root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage1_1.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage1_1.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        
                        Stage1_1.setScene(scene);
                        Stage1_1.show();
        } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void skander(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/gui/equipe.fxml"));
          Stage  Stage1_1 = (Stage)((Node)event.getSource()).getScene().getWindow();
              root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage1_1.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage1_1.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        
                        Stage1_1.setScene(scene);
                        Stage1_1.show();
        } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void sign_out(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/View/FXMLLogin.fxml"));
          Stage  Stage1_1 = (Stage)((Node)event.getSource()).getScene().getWindow();
              root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage1_1.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage1_1.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        
                        Stage1_1.setScene(scene);
                        Stage1_1.show();
        } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
    }
    
    }    
    

