/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import tools.MaConnexion;

/**
 *
 * @author Lenovo
 */
public class CompteService {
            Connection cnx;

    public CompteService() {
        cnx=MaConnexion.getInstance().getCnx();
    }
}
