package modeli;

import domen.Masina;
import domen.IOpstiDomenskiObjekat;
import domen.Radnik;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kosta
 */
public class ModelTabeleMasine extends AbstractTableModel{
    List<IOpstiDomenskiObjekat> lista;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleMasine() {
        lista = new ArrayList<>();
    }

    public void setLista(List<IOpstiDomenskiObjekat> lista) {
        this.lista = lista;
        fireTableDataChanged();
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
        Masina m = (Masina) lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return m.getOpis();
            case 1: return sdf.format(m.getDatumProizvodnje());
            case 2: return m.getMarka();
            case 3: return m.getModel();
            
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Opis";
            case 1: return "Datum proizvodnje";
            case 2: return "Marka";
            case 3: return "Model";
            
            default: return "N/A";
        }
    }

    public Masina vratiMasinu(int izabraniRed) {
        return (Masina) lista.get(izabraniRed);
    }
    
    
}
