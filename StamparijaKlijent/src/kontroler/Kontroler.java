/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Stampanje;
import domen.Masina;
import domen.IOpstiDomenskiObjekat;
import domen.Radnik;
import domen.Klijent;
import domen.Narucivanje;
import java.util.Date;
import java.util.List;
import komunikacija.KomunikacijaSaServerom;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Kosta
 */
public class Kontroler {
    private Radnik radnik;
    
    private static Kontroler instance;

    public Kontroler() {
    }

    public static Kontroler getInstance() {
        if(instance == null)
            instance = new Kontroler();
        return instance;
    }

    public ServerskiOdgovor ulogujSe(String ime, String sifra) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.LOGOVANJE);
        kz.setParametar(new Radnik(0, "", "", ime, sifra));
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        return KomunikacijaSaServerom.getInstance().primiOdgovor();
    }

    public List<IOpstiDomenskiObjekat> pronadjiMasine(String text) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRETRAGA_MASINA);
        Masina mas = new Masina();
        mas.setMarka(text);
        mas.setOpis(text);
        kz.setParametar(mas);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        List<IOpstiDomenskiObjekat> lista = (List<IOpstiDomenskiObjekat>) so.getOdgovor();
        
        return lista;
    }

    public ServerskiOdgovor sacuvajMasinu(String opis, String model, Date datumProizvodnje, String marka) {
        Masina masi = new Masina(0, opis, datumProizvodnje, marka, model);
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.SACUVAJ_MASINU);
        kz.setParametar(masi);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        return KomunikacijaSaServerom.getInstance().primiOdgovor();
    }

    public ServerskiOdgovor izmeniMasinu(int id, String opis, String model, Date datumProizvodnje, String marka) {
        Masina masin = new Masina(id, opis, datumProizvodnje, marka, model);
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_MASINU);
        kz.setParametar(masin);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        return KomunikacijaSaServerom.getInstance().primiOdgovor();
    }

    public ServerskiOdgovor obrisiMasinu(int id) {
        Masina masina = new Masina();
        masina.setMasinaID(id);
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_MASINU);
        kz.setParametar(masina);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        return KomunikacijaSaServerom.getInstance().primiOdgovor();
    }

    public List<IOpstiDomenskiObjekat> pretraziStampanje(Stampanje s) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRETRAZI_STAMPANJE);
        kz.setParametar(s);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return (List<IOpstiDomenskiObjekat>) so.getOdgovor();
    }

    public void setUlogovaniRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public ServerskiOdgovor sacuvajStampanje(Stampanje s) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.SACUVAJ_STAMPANJE);
        kz.setParametar(s);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        return KomunikacijaSaServerom.getInstance().primiOdgovor();
    }

    public ServerskiOdgovor obrisiStampanje(Stampanje s) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_STAMPANJE);
        kz.setParametar(s);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        return KomunikacijaSaServerom.getInstance().primiOdgovor();
    
    }

    public ServerskiOdgovor pretraziNarucivanje(Narucivanje n) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRETRAZI_NARUCIVANJE);
        kz.setParametar(n);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        
        return so;

    }

    public List<IOpstiDomenskiObjekat> dajListuKlijenata() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRETRAZI_KLIJENTE);
        kz.setParametar(new Klijent());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return (List<IOpstiDomenskiObjekat>) so.getOdgovor();

    }

    public List<IOpstiDomenskiObjekat> dajListuStampanja() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRETRAZI_STAMPANJE);
        kz.setParametar(new Stampanje());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return (List<IOpstiDomenskiObjekat>) so.getOdgovor();

    }

    public ServerskiOdgovor sacuvajNarucivanje(Narucivanje na) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.SACUVAJ_NARUCIVANJE);
        kz.setParametar(na);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        return KomunikacijaSaServerom.getInstance().primiOdgovor();
    
    }

    public ServerskiOdgovor obrisiNarucivanje(Narucivanje nar) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_NARUCIVANJE);
        kz.setParametar(nar);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        return KomunikacijaSaServerom.getInstance().primiOdgovor();
    
    }

    public ServerskiOdgovor izmeniStampanje(Stampanje s) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_STAMPANJE);
        kz.setParametar(s);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        return KomunikacijaSaServerom.getInstance().primiOdgovor();
    }
    
    
   
}
