/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;


import Entities.equipe;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import Services.Serviceequipe;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ChartController implements Initializable {

    @FXML
    private PieChart piechart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
        int nb=0;
        int nb1=1;
        Serviceequipe s= new Serviceequipe ();
        List<equipe> ls=s.afficher();
        for (int i = 0; i < ls.size(); i++) {
            nb+=ls.get(i).getNbre_joueur();
            nb1++ ;
            
        }
    
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
          
 
               new PieChart.Data("nbre_joueur", nb),
               new PieChart.Data("moyenne", nb1*32)
             
                        );
                
        //System.out.println(pieChartData);
        piechart.setData(pieChartData);
        piechart.setLabelsVisible(true);
        
        piechart.setTitle("Diagramme moyenne des equipes");
        
       }
        
       
        
        // TODO
    }