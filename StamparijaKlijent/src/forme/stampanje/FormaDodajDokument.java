/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.stampanje;

import domen.Masina;
import domen.Dokument;
import domen.IOpstiDomenskiObjekat;
import enumeracije.ModForme;
import java.awt.Container;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author Kosta
 */
public class FormaDodajDokument extends javax.swing.JDialog {
    FormaUnosStampanja unos;
    ModForme mod;
    Dokument trenutniDokument;
    int indeksTrenutnogDokumenta;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    /**
     * Creates new form FormaDodajDokument
     */
    public FormaDodajDokument(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btnSacuvaj.setVisible(false);
        popuniKombo();
    }

    public FormaDodajDokument(java.awt.Frame parent,boolean modal, FormaUnosStampanja aThis, ModForme modForme) {
        this(parent, modal);
        unos=aThis;
        mod = modForme;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKoricenje = new javax.swing.JTextField();
        txtInstrukcijeZaStampu = new javax.swing.JTextField();
        txtDatumStampanja = new javax.swing.JTextField();
        cmbMasine = new javax.swing.JComboBox();
        btnDodaj = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Koricenje:");

        jLabel2.setText("Instrukcije za stampu:");

        jLabel3.setText("Datum stampanja:");

        jLabel4.setText("Masina:");

        cmbMasine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSacuvaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDodaj))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKoricenje)
                            .addComponent(txtInstrukcijeZaStampu)
                            .addComponent(txtDatumStampanja)
                            .addComponent(cmbMasine, 0, 270, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKoricenje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtInstrukcijeZaStampu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDatumStampanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbMasine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnSacuvaj))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        String instrukcijeZaStampu = txtInstrukcijeZaStampu.getText();
        String koricenje = txtKoricenje.getText();
        String dat = txtDatumStampanja.getText();
        
        if(instrukcijeZaStampu.isEmpty() || koricenje.isEmpty() || dat.isEmpty()){
            JOptionPane.showMessageDialog(this, "Morate uneti sva polja");
            return;
        }
        
        
        Masina mas = (Masina) cmbMasine.getSelectedItem();
        try {
            Date datum = sdf.parse(dat);
            Dokument dok = new Dokument(null, 1, instrukcijeZaStampu, koricenje, datum, mas);
            unos.dodajDokument(dok);
            this.dispose();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Datum mora biti dd.MM.yyyy");           
            Logger.getLogger(FormaDodajDokument.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        String instrukcijeZaStampu = txtInstrukcijeZaStampu.getText();
        String koricenje = txtKoricenje.getText();
        String dat = txtDatumStampanja.getText();
        
        if(instrukcijeZaStampu.isEmpty() || koricenje.isEmpty() || dat.isEmpty()){
            JOptionPane.showMessageDialog(this, "Morate uneti sva polja");
            return;
        }
        
        
        Masina mas = (Masina) cmbMasine.getSelectedItem();
        try {
            Date datum = sdf.parse(dat);
            trenutniDokument.setDatumStampanja(datum);
            trenutniDokument.setKoricenje(koricenje);
            trenutniDokument.setInstrukcijeZaStampu(instrukcijeZaStampu);
            trenutniDokument.setMasina(mas);
            unos.izmeniDokument(trenutniDokument,indeksTrenutnogDokumenta);
            this.dispose();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Datum mora biti dd.MM.yyyy");           
            Logger.getLogger(FormaDodajDokument.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormaDodajDokument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaDodajDokument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaDodajDokument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaDodajDokument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormaDodajDokument dialog = new FormaDodajDokument(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbMasine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDatumStampanja;
    private javax.swing.JTextField txtInstrukcijeZaStampu;
    private javax.swing.JTextField txtKoricenje;
    // End of variables declaration//GEN-END:variables

    private void popuniKombo() {
        List<IOpstiDomenskiObjekat> lista = Kontroler.getInstance().pronadjiMasine("");
        
        cmbMasine.removeAllItems();
        
        for (IOpstiDomenskiObjekat ob : lista) {
            cmbMasine.addItem(ob);
        }
    }

    void setDijalog(FormaUnosStampanja unos) {
        this.unos = unos;
    }

    void setDokument(Dokument dok) {
        trenutniDokument = dok;
    }

    void srediZaIzmenu(boolean izmena) {
        if(!izmena) {
            btnSacuvaj.setVisible(false);
        
        } else {
            btnSacuvaj.setVisible(true);
            btnDodaj.setVisible(false);
            txtDatumStampanja.setText(sdf.format(trenutniDokument.getDatumStampanja()));
            txtInstrukcijeZaStampu.setText(trenutniDokument.getInstrukcijeZaStampu());
            txtKoricenje.setText(trenutniDokument.getKoricenje());
            cmbMasine.setSelectedItem(trenutniDokument.getMasina());
            
        }
    }

    void setIndexDokumenta(int i) {
        indeksTrenutnogDokumenta = i;
    }
}
