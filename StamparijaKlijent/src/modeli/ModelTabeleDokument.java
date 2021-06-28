/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Masina;
import domen.Dokument;
import domen.IOpstiDomenskiObjekat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kosta
 */
public class ModelTabeleDokument extends AbstractTableModel{
    List<IOpstiDomenskiObjekat> lista;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleDokument() {
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
        Dokument dok = (Dokument) lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return dok.getMasina();
            case 1: return sdf.format(dok.getDatumStampanja());
            case 2: return dok.getInstrukcijeZaStampu();
            case 3: return dok.getKoricenje();
            
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Naziv masine";
            case 1: return "Datum stampanja";
            case 2: return "Instrukcije za stampu";
            case 3: return "Koricenje";
            
            default: return "N/A";
        }
    }

    public void dodajDokument(Dokument dok) {
        lista.add(dok);
        fireTableDataChanged();
    }

//    @Override
//    public void setValueAt(Object o, int rowIndex, int columnIndex) {
//        try {
//            Dokument dok = (Dokument) lista.get(rowIndex);
//            
//            switch(columnIndex){            
//                case 0:  dok.getMasina().setModel(o.toString()); break;
//                case 1:  dok.setDatumStampanja(sdf.parse(o.toString())); break;
//                case 2:  dok.setInstrukcijeZaStampu(o.toString());break;
//                case 3:  dok.setKoricenje(o.toString());break;
//                
//                
//            }
//             fireTableRowsUpdated(rowIndex, columnIndex);
//        } catch (ParseException ex) {
//            Logger.getLogger(ModelTabeleDokument.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return true;
    }
    
    
    public List<IOpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public Dokument vratiDokument(int i) {
        return (Dokument) lista.get(i);
    }

    public void izmeniDokument(Dokument trenutniDokument, int indeksTrenutnogDokumenta) {
        
        lista.set(indeksTrenutnogDokumenta, trenutniDokument);
    }
    
}
