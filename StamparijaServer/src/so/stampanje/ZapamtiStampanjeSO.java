/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stampanje;

import db.DBBroker;
import domen.Stampanje;
import domen.Dokument;
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
public class ZapamtiStampanjeSO extends OpstaSistemskaOperacija{
    @Override
    public ServerskiOdgovor izvrsiKonkretnuOperaciju(IOpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            Stampanje s = (Stampanje) odo;
            int id = DBBroker.getInstance().max(s)+1;
            s.setStampanjeID(id);
            DBBroker.getInstance().insert(s);
            for (IOpstiDomenskiObjekat obj : s.getListaDokumenata()) {
                Dokument dok = (Dokument) obj;
                dok.setStampanje(s);
                DBBroker.getInstance().insert(dok);
            }
            so.setPoruka("Sistem je sacuvao stampanje");
            so.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(ZapamtiStampanjeSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da sacuva stampanje");
        }
        
        return so;
    }

    @Override
    public void proveriPreduslove(IOpstiDomenskiObjekat odo) throws Exception {

    }
    
}
