/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Stampanje;
import domen.Masina;
import domen.Radnik;
import domen.Klijent;
import domen.Narucivanje;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Kosta
 */
public class ObradaZahtevaNit extends Thread{
    Socket s;
    boolean kraj = false;

    public ObradaZahtevaNit(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (!kraj) {            
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            System.out.println("Operacija: "+kz.getOperacija());
            switch(kz.getOperacija()){
                case Operacije.LOGOVANJE:
                    Radnik radnik = (Radnik) kz.getParametar();
                    so = Kontroler.getInstance().uloguj(radnik);
                    break;
                    
                case Operacije.PRETRAGA_MASINA:
                    Masina mas = (Masina) kz.getParametar();
                    so = Kontroler.getInstance().pronadjiMasine(mas);
                    break;
                case Operacije.SACUVAJ_MASINU:
                    Masina masi = (Masina) kz.getParametar();
                    so = Kontroler.getInstance().sacuvajMasinu(masi);
                    break;
                case Operacije.IZMENI_MASINU:
                    Masina masin = (Masina) kz.getParametar();
                    so = Kontroler.getInstance().izmeniMasinu(masin);
                    break;    
                case Operacije.OBRISI_MASINU:
                    Masina masina = (Masina) kz.getParametar();
                    so = Kontroler.getInstance().obrisiMasinu(masina);
                    break;
                case Operacije.PRETRAZI_STAMPANJE:
                    Stampanje s = (Stampanje) kz.getParametar();
                    so = Kontroler.getInstance().pronadjiStampanje(s);
                    break;
                case Operacije.SACUVAJ_STAMPANJE:
                    Stampanje st = (Stampanje) kz.getParametar();
                    so = Kontroler.getInstance().sacuvajStampanje(st);
                    break;
                case Operacije.OBRISI_STAMPANJE:
                    Stampanje sta = (Stampanje) kz.getParametar();
                    so = Kontroler.getInstance().obrisiStampanje(sta);
                    break;
                case Operacije.PRETRAZI_NARUCIVANJE:
                    Narucivanje n = (Narucivanje) kz.getParametar();
                    so = Kontroler.getInstance().pretraziNarucivanje(n);
                    break;
                case Operacije.PRETRAZI_KLIJENTE:
                    Klijent k = (Klijent) kz.getParametar();
                    so = Kontroler.getInstance().pretraziKlijente(k);
                    break;
                case Operacije.SACUVAJ_NARUCIVANJE:
                    Narucivanje na = (Narucivanje) kz.getParametar();
                    so = Kontroler.getInstance().sacuvajNarucivanje(na);
                    break;
                case Operacije.OBRISI_NARUCIVANJE:
                    Narucivanje nar = (Narucivanje) kz.getParametar();
                    so = Kontroler.getInstance().obrisiNarucivanje(nar);
                    break;
                case Operacije.IZMENI_STAMPANJE:
                    Stampanje stampanje = (Stampanje) kz.getParametar();
                    so = Kontroler.getInstance().izmeniStampanje(stampanje);
                    break;
            }
            
            posaljiOdgovor(so);
        }
    }

    private KlijentskiZahtev primiZahtev() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
        } catch (Exception ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return kz;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
