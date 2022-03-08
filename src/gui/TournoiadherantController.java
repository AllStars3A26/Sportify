/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.tournoi;
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
import javafx.stage.Stage;
import services.ServiceTournoi;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TournoiadherantController implements Initializable {

@FXML
    private HBox tbox;
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

    /**
     * Initializes the controller class.
     */

    
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
            
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
            {
                
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
               dac.t1modif(s,ltt);
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
          

        
       
    }
    
    }    
    

