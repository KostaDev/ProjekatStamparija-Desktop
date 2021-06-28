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
public class Masina implements IOpstiDomenskiObjekat{
    private int masinaID;
    private Date datumProizvodnje;
    private String marka;
    private String model;
    private String opis;
    
    

    public Masina() {
    }

    public Masina(int masinaID, String opis, Date datumProizvodnje, String marka, String model) {
        this.masinaID = masinaID;
        this.opis = opis;
        this.datumProizvodnje = datumProizvodnje;
        this.marka = marka;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMasinaID() {
        return masinaID;
    }

    public void setMasinaID(int masinaID) {
        this.masinaID = masinaID;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatumProizvodnje() {
        return datumProizvodnje;
    }

    public void setDatumProizvodnje(Date datumProizvodnje) {
        this.datumProizvodnje = datumProizvodnje;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Override
    public String toString() {
        return opis;
    }

    @Override
    public String nazivTabele() {
        return " masina ";
    }

    @Override
    public String alijas() {
        return "";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String selectWhere() {
        if(!opis.isEmpty() && !marka.isEmpty()){
            return " where opis LIKE '%"+opis+"%' or marka LIKE '%"+marka+"%'";
        }
        
        return "";
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<IOpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {            
            lista.add(new Masina(rs.getInt("masinaID"), rs.getString("opis"), new Date(rs.getDate("datumProizvodnje").getTime()), rs.getString("marka"), rs.getString("model")));
        } 
        return lista;
    }

    @Override
    public String koloneInsert() {
        return "(opis,datumProizvodnje,marka,model)";
    }

    @Override
    public String vrednostiInsert() {
        return "'"+opis+"','"+new java.sql.Date(datumProizvodnje.getTime())+"','"+marka+"','"+model+"'";
    }

    @Override
    public String vrednostiUpdate() {
        return "opis='"+opis+"',datumProizvodnje='"+new java.sql.Date(datumProizvodnje.getTime())+"',marka='"+marka+"',model='"+model+"'";
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return " masinaID="+masinaID;
    }

    @Override
    public String vratiMax() {
        return "masinaID";
    }
    
    
}
