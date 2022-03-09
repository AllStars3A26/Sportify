/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import util.MYDB;
import entities.equipe;
import services.Serviceequipe;
import java.time.LocalDate;
import entities.terrain;
import java.util.Date;
import java.time.ZoneId;
import services.Serviceterrain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author ASUS
 */
public class main {
   public static void main(String[] args) throws ParseException{
         
         
         MYDB.getInstance();
     SimpleDateFormat d = new SimpleDateFormat("yyyy/MM/dd");
         Date date =d.parse("2022/01/05");
      //tournoi t = new tournoi(40,"sahar",date,50,"pdp",40);
     // match m = new match(13,14,date,13);
      Serviceterrain tt=new Serviceterrain();
      Serviceequipe M=new Serviceequipe();
     // M.id_auto();
     // tt.ajouter(t);
     
             
                     
      //M.ajouter(m);
      System.out.println(tt.afficher());
   }
   
}
