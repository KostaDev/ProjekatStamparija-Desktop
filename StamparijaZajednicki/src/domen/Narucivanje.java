/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kosta
 */
public class Narucivanje implements IOpstiDomenskiObjekat{
    private int narucivanjeID;
    private Date datumNarucivanja;
    private Klijent klijent;
    private Stampanje stampanje;
    

    public Narucivanje() {
    }

    public Narucivanje(int narucivanjeID, Date datumNarucivanja, Stampanje stampanje, Klijent klijent) {
        this.narucivanjeID = narucivanjeID;
        this.datumNarucivanja = datumNarucivanja;
        this.stampanje = stampanje;
        this.klijent = klijent;
    }

    

    

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public int getNarucivanjeID() {
        return narucivanjeID;
    }

    public void setNarucivanjeID(int narucivanjeID) {
        this.narucivanjeID = narucivanjeID;
    }

    public Date getDatumNarucivanja() {
        return datumNarucivanja;
    }

    public void setDatumNarucivanja(Date datumNarucivanja) {
        this.datumNarucivanja = datumNarucivanja;
    }

    public Stampanje getStampanje() {
        return stampanje;
    }

    public void setStampanje(Stampanje stampanje) {
        this.stampanje = stampanje;
    }

    @Override
    public String nazivTabele() {
        return " narucivanje ";
    }

    @Override
    public String alijas() {
        return " n ";
    }

    @Override
    public String join() {
        return " join stampanje s on s.stampanjeID=n.stampanjeID join klijent k on n.klijentID=k.klijentID ";
    }

    @Override
    public String selectWhere() {
        if(klijent != null){
            return " where k.email LIKE '%"+klijent.getEmail()+"%' ";
        }
        
        return "";
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<IOpstiDomenskiObjekat> lista = new ArrayList<>();
        
        while(rs.next()){
            Klijent k = new Klijent(rs.getInt("klijentID"), rs.getString("imeKlijenta"), rs.getString("prezimeKlijenta"), rs.getString("email"), rs.getString("telefon"));
            Stampanje s = new Stampanje(rs.getInt("stampanjeID"), rs.getString("napomena"), new Date(rs.getDate("rokZaIzvrsenje").getTime()), rs.getBoolean("placeno"), null, null);
            lista.add(new Narucivanje(rs.getInt("narucivanjeID"), new Date(rs.getDate("datumNarucivanja").getTime()), s, k));
        }
        
        return lista;
    }

    @Override
    public String koloneInsert() {
        return "(datumNarucivanja,klijentID,stampanjeID)";
    }

    @Override
    public String vrednostiInsert() {
        return "'"+new java.sql.Date(datumNarucivanja.getTime())+"',"+klijent.getKlijentID()+","+stampanje.getStampanjeID();
    }

    @Override
    public String vrednostiUpdate() {
        return " datumNarucivanja='"+new java.sql.Date(datumNarucivanja.getTime())+"',klijentID="+klijent.getKlijentID()+",stampanjeID="+stampanje.getStampanjeID();
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return "narucivanjeID="+narucivanjeID;
    }

    @Override
    public String vratiMax() {
        return " narucivanjeID "; 
    }
    
    
}
