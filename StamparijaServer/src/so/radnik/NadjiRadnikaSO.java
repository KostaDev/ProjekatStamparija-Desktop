/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.radnik;

import db.DBBroker;
import domen.IOpstiDomenskiObjekat;
import domen.Radnik;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Kosta
 */
public class NadjiRadnikaSO extends OpstaSistemskaOperacija{


    @Override
    public ServerskiOdgovor izvrsiKonkretnuOperaciju(IOpstiDomenskiObjekat odo) throws Exception{
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            List<IOpstiDomenskiObjekat> lista = DBBroker.getInstance().select(odo);
            if(lista.isEmpty()){
                throw new Exception("Sistem ne moze da pronadje radnika sa datim parametrima");
            }
            so.setOdgovor(lista);
            so.setPoruka("Sistem je pronasao radnika po zadatim vrednostima");
            so.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(NadjiRadnikaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da pronadje radnika sa datim parametrima");
        }
        
        return so;
    }

    @Override
    public void proveriPreduslove(IOpstiDomenskiObjekat odo) throws Exception {
        Radnik administrator = (Radnik) odo;
        
        if(administrator.getUsername().isEmpty()){
            throw new Exception("Korisnicko ime mora biti uneto");
        }
        
        if(administrator.getPassword().isEmpty()){
            throw new Exception("Korisnicka sifra mora biti uneta");
        }
    }
    
}
