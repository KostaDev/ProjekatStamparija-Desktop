/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.narucivanja;

import db.DBBroker;
import domen.IOpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.OpstaSistemskaOperacija;
import so.radnik.NadjiRadnikaSO;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Kosta
 */
public class ObrisiNarucivanjeSO extends OpstaSistemskaOperacija{
     @Override
    public ServerskiOdgovor izvrsiKonkretnuOperaciju(IOpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            DBBroker.getInstance().delete(odo);
            so.setPoruka("Sistem je obrisao narucivanje");
            so.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(NadjiRadnikaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da obrise narucivanje");
        }
        
        return so;
    }

    @Override
    public void proveriPreduslove(IOpstiDomenskiObjekat odo) throws Exception {
    }
}
