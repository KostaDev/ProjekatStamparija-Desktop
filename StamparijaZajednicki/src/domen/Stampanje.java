/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Kosta
 */
public class Stampanje implements IOpstiDomenskiObjekat{
    private int stampanjeID;
    private String napomena;
    private Date rokZaIzvrsenje;
    private boolean placeno;
    private Radnik radnik;
    private List<IOpstiDomenskiObjekat> listaDokumenata;

    public Stampanje() {
        listaDokumenata = new ArrayList<>();
    }

    public Stampanje(int stampanjeID, String napomena, Date rokZaIzvrsenje, boolean placeno, Radnik radnik, List<IOpstiDomenskiObjekat> listaDokumenata) {
        this.stampanjeID = stampanjeID;
        this.napomena = napomena;
        this.rokZaIzvrsenje = rokZaIzvrsenje;
        this.placeno = placeno;
        this.radnik = radnik;
        this.listaDokumenata = listaDokumenata;
    }

    public List<IOpstiDomenskiObjekat> getListaDokumenata() {
        return listaDokumenata;
    }

    public void setListaDokumenata(List<IOpstiDomenskiObjekat> listaDokumenata) {
        this.listaDokumenata = listaDokumenata;
    }

    public int getStampanjeID() {
        return stampanjeID;
    }

    public void setStampanjeID(int stampanjeID) {
        this.stampanjeID = stampanjeID;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Date getRokZaIzvrsenje() {
        return rokZaIzvrsenje;
    }

    public void setRokZaIzvrsenje(Date rokZaIzvrsenje) {
        this.rokZaIzvrsenje = rokZaIzvrsenje;
    }

    public boolean isPlaceno() {
        return placeno;
    }

    public void setPlaceno(boolean placeno) {
        this.placeno = placeno;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik kustos) {
        this.radnik = radnik;
    }

    @Override
    public String nazivTabele() {
        return " stampanje ";
    }

    @Override
    public String alijas() {
        return " s ";
    }

    @Override
    public String join() {
        return " join radnik r on s.radnikID=r.radnikID ";
    }

    @Override
    public String selectWhere() {
        if(napomena != null && !napomena.isEmpty()){
            
            return " where napomena LIKE'%"+napomena+"%'";
        }
        
        if(rokZaIzvrsenje != null){
            return " where rokZaIzvrsenje ='"+new java.sql.Date(rokZaIzvrsenje.getTime())+"'";
        }
        
        return "";
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<IOpstiDomenskiObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {            
            Radnik administrator = new Radnik(rs.getInt("radnikID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("username"), rs.getString("password"));
            Stampanje a = new Stampanje(rs.getInt("stampanjeID"), rs.getString("napomena"), new Date(rs.getDate("rokZaIzvrsenje").getTime()), rs.getBoolean("placeno"), administrator, null);
            lista.add(a);
        }
        
        return lista;
    }

    @Override
    public String koloneInsert() {
        return " (stampanjeID,rokZaIzvrsenje,napomena,placeno,radnikID) ";
    }

    @Override
    public String vrednostiInsert() {
            return  "'"+stampanjeID+"','" +new java.sql.Date(rokZaIzvrsenje.getTime())+"','"+napomena+"',"+placeno+","+radnik.getRadnikID()+"";
    }

    @Override
    public String vrednostiUpdate() {
        return " rokZaIzvrsenje='"+new java.sql.Date(rokZaIzvrsenje.getTime())+"',napomena='"+napomena+"',placeno="+placeno+",radnikID="+radnik.getRadnikID();
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return " stampanjeID="+stampanjeID;
    }

    @Override
    public String vratiMax() {
        return " stampanjeID ";
    }

    @Override
    public String toString() {
        return "Sifra stampanja  "+stampanjeID;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stampanje other = (Stampanje) obj;
        if (this.stampanjeID != other.stampanjeID) {
            return false;
        }
        return true;
    }
    
    
    
}
