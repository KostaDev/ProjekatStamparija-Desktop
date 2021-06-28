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
public class Dokument implements IOpstiDomenskiObjekat{
    private Stampanje stampanje;
    private int dokumentID;
    private String instrukcijeZaStampu;
    private String koricenje;
    private Date datumStampanja;
    
    private Masina masina;

    public Dokument() {
    }

    public Dokument(Stampanje stampanje, int dokumentID, String instrukcijeZaStampu, String koricenje, Date datumStampanja, Masina masina) {
        this.stampanje = stampanje;
        this.dokumentID = dokumentID;
        this.instrukcijeZaStampu = instrukcijeZaStampu;
        this.koricenje = koricenje;
        this.datumStampanja = datumStampanja;
        this.masina = masina;
    }

    public void setStampanje(Stampanje stampanje) {
        this.stampanje = stampanje;
    }

    public Stampanje getStampanje() {
        return stampanje;
    }
    
    

   
    public int getDokumentID() {
        return dokumentID;
    }

    public void setDokumentID(int dokumentID) {
        this.dokumentID = dokumentID;
    }

    public String getInstrukcijeZaStampu() {
        return instrukcijeZaStampu;
    }

    public void setInstrukcijeZaStampu(String instrukcijeZaStampu) {
        this.instrukcijeZaStampu = instrukcijeZaStampu;
    }

    public String getKoricenje() {
        return koricenje;
    }

    public void setKoricenje(String koricenje) {
        this.koricenje = koricenje;
    }

    public Date getDatumStampanja() {
        return datumStampanja;
    }

    public void setDatumStampanja(Date datumStampanja) {
        this.datumStampanja = datumStampanja;
    }

    public void setMasina(Masina masina) {
        this.masina = masina;
    }

    public Masina getMasina() {
        return masina;
    }
    

    @Override
    public String nazivTabele() {
        return " dokument ";
    }

    @Override
    public String alijas() {
        return " d ";
    }

    @Override
    public String join() {
        return " join masina m on d.masinaID=m.masinaID ";
    }

    @Override
    public String selectWhere() {
        if(stampanje!=null)
            return " where stampanjeID="+stampanje.getStampanjeID();
        return "";
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
         List<IOpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
        Masina mas = new Masina(rs.getInt("masinaID"), rs.getString("opis"), new Date(rs.getDate("datumProizvodnje").getTime()), rs.getString("marka"), rs.getString("model"));            
            lista.add(new Dokument(null, rs.getInt("dokumentID"), rs.getString("instrukcijeZaStampu"), rs.getString("koricenje"), new Date(rs.getDate("datumStampanja").getTime()), mas));
        } 
        return lista;
    }

    @Override
    public String koloneInsert() {
        return "(stampanjeID,instrukcijeZaStampu,koricenje,datumStampanja,masinaID)";
    }

    @Override
    public String vrednostiInsert() {
        return ""+stampanje.getStampanjeID()+",'"+instrukcijeZaStampu+"','"+koricenje+"','"+new java.sql.Date(datumStampanja.getTime())+"',"+masina.getMasinaID()+"";
    }

    @Override
    public String vrednostiUpdate() {
        return "instrukcijeZaStampu='"+instrukcijeZaStampu+"',koricenje='"+koricenje+"',datumStampanja='"+new java.sql.Date(datumStampanja.getTime())+"',masinaID="+masina.getMasinaID()+"";
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return " stampanjeID="+stampanje.getStampanjeID()+" AND dokumentID="+dokumentID;
    }

    @Override
    public String vratiMax() {
        return " dokumentID ";
    }

  
    
}
