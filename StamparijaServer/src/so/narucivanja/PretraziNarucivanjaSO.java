/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.narucivanja;

import db.DBBroker;
import domen.IOpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.OpstaSistemskaOperacija;
import so.radnik.NadjiRadnikaSO;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Kosta
 */
public class PretraziNarucivanjaSO extends OpstaSistemskaOperacija{
    
    @Override
    public ServerskiOdgovor izvrsiKonkretnuOperaciju(IOpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            List<IOpstiDomenskiObjekat> lista = DBBroker.getInstance().select(odo);
            so.setOdgovor(lista);
            so.setPoruka("Sistem je pronasao narucivanja po zadatim vrednostima");
            so.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(PretraziNarucivanjaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da pronadje narucivanja sa datim parametrima");
        }
        
        return so;
    }

    @Override
    public void proveriPreduslove(IOpstiDomenskiObjekat odo) throws Exception {

    }
    
}
