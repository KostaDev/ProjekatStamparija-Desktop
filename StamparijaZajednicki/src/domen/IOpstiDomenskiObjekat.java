/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Kosta
 */
public interface IOpstiDomenskiObjekat extends Serializable{
    
    public String nazivTabele();
    
    public String alijas();
    
    public String join();
    
    public String selectWhere();
    
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException;
    
    public String koloneInsert();
    
    public String vrednostiInsert();
    
    public String vrednostiUpdate();
    
    public String vrednostPrimarniKljuc();
    
    public String vratiMax();
}
