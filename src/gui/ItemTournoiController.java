/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.tournoi;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ServiceTournoi;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ItemTournoiController implements Initializable {

    @FXML
    private AnchorPane t1;
     @FXML
    private AnchorPane t3;
      @FXML
    private AnchorPane t2;
       @FXML
    private AnchorPane t4;
       @FXML
       private ImageView imaget1;
        @FXML
       private ImageView imaget2;
         @FXML
       private ImageView imaget3;
          @FXML
       private ImageView imaget4;
    @FXML
    private Label labelt1;
    @FXML
    private Label labelt2;
    @FXML
    private Label labelt3;
    @FXML
    private Label labelt4;
    @FXML
    private Label idd;
    @FXML
    private Label numt1;
    @FXML
    private Label numt2;
    @FXML
    private Label numt3;
    @FXML
    private Label numt4;
    
    
    /**
     * Initializes the controller class.
     */
     public List<tournoi> t1modif(String message,List<tournoi> t)
    {
      
     this.labelt1.setText(message);
     return t;
    }
     public void set3()
     {
         this.t3.setVisible(false);
     }
     public void set2()
     {
         this.t2.setVisible(false);
     }
     public void set4()
     {
         this.t4.setVisible(false);
     }
     
     
      public void afficher (List<tournoi> lt,int i)
   {  System.out.println("ll");
        Image imt1 = new Image(getClass().getResourceAsStream(lt.get(i*4).getImage_tournoi()));
        this.imaget1.setImage(imt1);
        this.labelt1.setText(lt.get(i*4).getNom_tournoi());
        this.numt1.setText("num "+String.valueOf(i*4+1));
        System.out.println(lt.get(i*4).getImage_tournoi());
       
        
        if((lt.size()> i*4+1))
        {    
            Image imt2 = new Image(getClass().getResourceAsStream(lt.get(i*4+1).getImage_tournoi()));
          this.imaget2.setImage(imt2);
           this.labelt2.setText(lt.get(i*4+1).getNom_tournoi());
           this.numt2.setText("num "+String.valueOf(i*4+2));
           System.out.println(lt.get(i*4+1).getImage_tournoi());
        }
         if((lt.size()> i*4+2))
        { 
            Image imt3 = new Image(getClass().getResourceAsStream(lt.get(i*4+2).getImage_tournoi()));
        this.imaget3.setImage(imt3);
        this.labelt3.setText(lt.get(i*4+2).getNom_tournoi());
        this.numt3.setText("num "+String.valueOf(i*4+3));
        System.out.println(lt.get(i*4+2).getImage_tournoi());
        }
           if((lt.size()> i*4+3))
        {  System.out.println(lt.get(i*4+3).getImage_tournoi());
          Image imt4 = new Image(getClass().getResourceAsStream(lt.get(i*4+3).getImage_tournoi()));
        this.imaget4.setImage(imt4);
        this.labelt4.setText(lt.get(i*4+3).getNom_tournoi());
        this.numt4.setText("num "+String.valueOf(i*4+4));
        }
          
    }

     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        System.out.println("bbbbbbbbbbbbbbbbbbb");
         
    } 
    public int inn (int i,int j)
    {
       int id = i*4+j;
       return id;
    }
  public int boutton (int i)
  { 
            
            
       
       
       return Integer.parseInt(this.idd.getText());
           
  }
          
     public int inna ()
    {
      return Integer.parseInt(this.idd.getText());
    }     
    
    
   
}
