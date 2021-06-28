/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Stampanje;
import domen.IOpstiDomenskiObjekat;
import domen.Narucivanje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kosta
 */
public class ModelTabeleNarucivanje extends AbstractTableModel{
    List<IOpstiDomenskiObjekat> lista;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleNarucivanje() {
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Narucivanje kon = (Narucivanje) lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return kon.getNarucivanjeID();
            case 1: return kon.getKlijent();
            case 2: return sdf.format(kon.getDatumNarucivanja());
            case 3: return kon.getStampanje().getNapomena();
            
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Narucivanje ID";
            case 1: return "Klijent";
            case 2: return "Datum narucivanja";
            case 3: return "Napomena";
            
            default: return "N/A";
        }
    }

    public IOpstiDomenskiObjekat vratiNarucivanje(int red) {
        return lista.get(red);
    }
    public Narucivanje getNarucivanje(int red) {
        return (Narucivanje) lista.get(red);
    }
    
}
