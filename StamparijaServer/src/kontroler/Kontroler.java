/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Stampanje;
import domen.Masina;
import domen.Radnik;
import domen.Klijent;
import domen.Narucivanje;
import so.OpstaSistemskaOperacija;
import so.stampanje.ObrisiStampanjeSO;
import so.stampanje.PretraziStampanjaSO;
import so.stampanje.ZapamtiStampanjeSO;
import so.masine.IzmeniMasinuSO;
import so.masine.ObrisiMasinuSO;
import so.masine.PretraziMasineSO;
import so.masine.ZapamtiMasinuSO;
import so.radnik.NadjiRadnikaSO;
import so.narucivanja.ObrisiNarucivanjeSO;
import so.narucivanja.PretraziKlijenteSO;
import so.narucivanja.PretraziNarucivanjaSO;
import so.narucivanja.ZapamtiNarucivanjeSO;
import so.stampanje.IzmenaStampanjaSO;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Kosta
 */
public class Kontroler {
    private static Kontroler instance;

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if(instance == null)
            instance = new Kontroler();
        return instance;
    }

    public ServerskiOdgovor uloguj(Radnik radnik) {
        OpstaSistemskaOperacija oso = new NadjiRadnikaSO();
        return oso.izvrsiOperaciju(radnik);
    }

    public ServerskiOdgovor pronadjiMasine(Masina mas) {
        OpstaSistemskaOperacija oso = new PretraziMasineSO();
        return oso.izvrsiOperaciju(mas);
    }

    public ServerskiOdgovor sacuvajMasinu(Masina masi) {
        OpstaSistemskaOperacija oso = new ZapamtiMasinuSO();
        return oso.izvrsiOperaciju(masi);
    }

    public ServerskiOdgovor izmeniMasinu(Masina masin) {
        OpstaSistemskaOperacija oso = new IzmeniMasinuSO();
        return oso.izvrsiOperaciju(masin);
    }

    public ServerskiOdgovor obrisiMasinu(Masina masina) {
        OpstaSistemskaOperacija oso = new ObrisiMasinuSO();
        return oso.izvrsiOperaciju(masina);
    }

    public ServerskiOdgovor pronadjiStampanje(Stampanje s) {
        OpstaSistemskaOperacija oso = new PretraziStampanjaSO();
        return oso.izvrsiOperaciju(s);
    }

    public ServerskiOdgovor sacuvajStampanje(Stampanje st) {
        OpstaSistemskaOperacija oso = new ZapamtiStampanjeSO();
        return oso.izvrsiOperaciju(st);
    }

    public ServerskiOdgovor obrisiStampanje(Stampanje sta) {
        OpstaSistemskaOperacija oso = new ObrisiStampanjeSO();
        return oso.izvrsiOperaciju(sta);
    }

    public ServerskiOdgovor pretraziNarucivanje(Narucivanje n) {
        OpstaSistemskaOperacija oso = new PretraziNarucivanjaSO();
        return oso.izvrsiOperaciju(n);
    }

    public ServerskiOdgovor pretraziKlijente(Klijent k) {
        OpstaSistemskaOperacija oso = new PretraziKlijenteSO();
        return oso.izvrsiOperaciju(k);
    }

    public ServerskiOdgovor sacuvajNarucivanje(Narucivanje na) {
        OpstaSistemskaOperacija oso = new ZapamtiNarucivanjeSO();
        return oso.izvrsiOperaciju(na);
    }

    public ServerskiOdgovor obrisiNarucivanje(Narucivanje nar) {
        OpstaSistemskaOperacija oso = new ObrisiNarucivanjeSO();
        return oso.izvrsiOperaciju(nar);
    }

    public ServerskiOdgovor izmeniStampanje(Stampanje stampanje) {
        OpstaSistemskaOperacija oso = new IzmenaStampanjaSO();
        return oso.izvrsiOperaciju(stampanje);
    }
    
    
    
}
