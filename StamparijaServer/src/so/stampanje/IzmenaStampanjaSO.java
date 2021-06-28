/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stampanje;

import db.DBBroker;
import domen.Dokument;
import domen.IOpstiDomenskiObjekat;
import domen.Stampanje;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Kosta
 */
public class IzmenaStampanjaSO extends OpstaSistemskaOperacija{
    @Override
    public ServerskiOdgovor izvrsiKonkretnuOperaciju(IOpstiDomenskiObjekat odo) throws Exception {
       ServerskiOdgovor so = new ServerskiOdgovor();
        try {
           Stampanje s = (Stampanje) odo;
            DBBroker.getInstance().update(s);
            
            DBBroker.getInstance().deleteDokumenta(s);
            
            for (IOpstiDomenskiObjekat o : s.getListaDokumenata()) {
                Dokument d = (Dokument) o;
                d.setStampanje(s);
                DBBroker.getInstance().insert(d);
                
            }
            so.setPoruka("Sistem je izmenio stampanje");
            so.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(IzmenaStampanjaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da izmeni stampanje");
        
        }
 
       
        
       
       return so;
    }

    @Override
    public void proveriPreduslove(IOpstiDomenskiObjekat odo) throws Exception {
    
    }

    
}
