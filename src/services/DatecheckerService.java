/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class DatecheckerService {
    public static boolean isValid(String strdate, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        df.setLenient(false);
        try {
            Date date = df.parse(strdate);
            return true;
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
