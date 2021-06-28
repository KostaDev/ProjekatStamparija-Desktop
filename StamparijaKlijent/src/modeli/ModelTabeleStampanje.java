/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Stampanje;
import domen.IOpstiDomenskiObjekat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kosta
 */
public class ModelTabeleStampanje extends AbstractTableModel{
    List<IOpstiDomenskiObjekat> lista;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleStampanje() {
        lista = new ArrayList<>();
    }

    public void setLista(List<IOpstiDomenskiObjekat> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public List<IOpstiDomenskiObjekat> getLista() {
        return lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stampanje p = (Stampanje) lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return p.getStampanjeID();
            case 1: return p.getNapomena();
            case 2: return sdf.format(p.getRokZaIzvrsenje());
            case 3: return p.isPlaceno();
            case 4: return p.getRadnik();
            
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Stampanje ID";
            case 1: return "Napomena";
            case 2: return "Rok za izvrsenje";
            case 3: return "Placeno";
            case 4: return "Radnik";
            
            default: return "N/A";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==3)
            return Boolean.class;
        
        return Object.class;
    }

    
    
    public IOpstiDomenskiObjekat vratiStampanje(int red) {
        return lista.get(red);
    }

    
    
    
    
    
    
}
