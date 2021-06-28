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
import java.util.ArrayList;
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
public class PretraziStampanjaSO extends OpstaSistemskaOperacija{
    
 

    @Override
    public ServerskiOdgovor izvrsiKonkretnuOperaciju(IOpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            List<IOpstiDomenskiObjekat> listaZaVracanje = new ArrayList<>();
            List<IOpstiDomenskiObjekat> listaStampanja = DBBroker.getInstance().select(odo);
            for (IOpstiDomenskiObjekat stamp : listaStampanja) {
                Dokument dok = new Dokument();
                Stampanje s = (Stampanje) stamp;
                dok.setStampanje(s);
                List<IOpstiDomenskiObjekat> listaDok = DBBroker.getInstance().select(dok);
                s.setListaDokumenata(listaDok);
                listaZaVracanje.add(s);
            }   
            
            so.setOdgovor(listaZaVracanje);
            so.setPoruka("Sistem je pronasao stampanja po zadatim vrednostima");
            so.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(NadjiRadnikaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da pronadje stampanja sa datim parametrima");
        }
        
        return so;
    }

    @Override
    public void proveriPreduslove(IOpstiDomenskiObjekat odo) throws Exception {

    }
}
