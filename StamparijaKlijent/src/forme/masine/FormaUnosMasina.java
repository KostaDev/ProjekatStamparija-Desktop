/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.masine;

import domen.Masina;
import enumeracije.ModForme;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Kosta
 */
public class FormaUnosMasina extends javax.swing.JDialog {

    private Masina izabranaMasina;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private FormaPregledMasina formaPregled;
    private ModForme mod;

    /**
     * Creates new form SacuvajMasinu
     */
    public FormaUnosMasina(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        errLabelDatum.setVisible(false);
        srediZaIzmenu(false);
    }

    public FormaUnosMasina(java.awt.Frame parent, boolean modal, FormaPregledMasina formaPregled, ModForme mod) {
        this(parent, modal);
        this.formaPregled = formaPregled;
        this.mod = mod;
        primeniMod();
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
        txtOpis = new javax.swing.JTextField();
        txtDatumProizvodnje = new javax.swing.JTextField();
        txtMarka = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        errLabelDatum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Opis:");

        jLabel2.setText("Datum proizvodnje:");

        jLabel3.setText("Marka:");

        jLabel4.setText("Model:");

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        errLabelDatum.setText("Datum mora biti u formatu dd.MM.yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                            .addComponent(txtOpis, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtModel, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                                .addComponent(txtMarka, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                                .addComponent(txtDatumProizvodnje, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)))))
                .addGap(31, 31, 31)
                .addComponent(errLabelDatum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOpis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatumProizvodnje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errLabelDatum))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIzmeni)
                    .addComponent(btnObrisi))
                .addGap(18, 18, 18)
                .addComponent(btnSacuvaj)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        Date datum = null;
        try {
            datum = sdf.parse(txtDatumProizvodnje.getText());
        } catch (ParseException ex) {
            errLabelDatum.setVisible(true);
            return;
        }
        
        try {
            errLabelDatum.setVisible(false);
            String opis = txtOpis.getText();
            String model = txtModel.getText();
            String marka = txtMarka.getText();
            

            
            if (mod == ModForme.UNOS) {
                ServerskiOdgovor so = Kontroler.getInstance().sacuvajMasinu(opis, model, datum, marka);
                JOptionPane.showMessageDialog(this, so.getPoruka());
                this.setVisible(false);
                this.dispose();
            } else if (mod == ModForme.IZMENA) {
                int id = izabranaMasina.getMasinaID();
                ServerskiOdgovor so = Kontroler.getInstance().izmeniMasinu(id, opis, model, datum, marka);
                JOptionPane.showMessageDialog(this, so.getPoruka());
                formaPregled.pretrazi();
                this.setVisible(false);
                this.dispose();
            }            
        } catch (Exception ex) {
            Logger.getLogger(FormaUnosMasina.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Doslo je do greske prilikom cuvanja podataka o masini. ");
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        mod = ModForme.IZMENA;
        primeniMod();
        btnSacuvaj.setVisible(true);
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int id = izabranaMasina.getMasinaID();
        ServerskiOdgovor so = Kontroler.getInstance().obrisiMasinu(id);
        JOptionPane.showMessageDialog(this, so.getPoruka());
        formaPregled.pretrazi();
        this.setVisible(false);
        this.dispose();

    }//GEN-LAST:event_btnObrisiActionPerformed

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
            java.util.logging.Logger.getLogger(FormaUnosMasina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaUnosMasina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaUnosMasina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaUnosMasina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                FormaUnosMasina dialog = new FormaUnosMasina(new javax.swing.JFrame(), true);
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

    public void srediZaIzmenu(boolean izmena) {
        if (!izmena) {
            setTitle("Forma za cuvanje masina");
            btnIzmeni.setVisible(false);
            btnObrisi.setVisible(false);
        } else {
            setTitle("Forma za detalje masine");
            btnIzmeni.setVisible(true);
            btnObrisi.setVisible(true);
            btnSacuvaj.setVisible(false);
            txtDatumProizvodnje.setText(sdf.format(izabranaMasina.getDatumProizvodnje()));
            txtMarka.setText(izabranaMasina.getMarka());
            txtOpis.setText(izabranaMasina.getOpis());
            txtModel.setText(izabranaMasina.getModel());
        }
    }

    public void setIzabranaMasina(Masina izabranaMasina) {
        this.izabranaMasina = izabranaMasina;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel errLabelDatum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDatumProizvodnje;
    private javax.swing.JTextField txtMarka;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtOpis;
    // End of variables declaration//GEN-END:variables

    private void primeniMod() {
        switch(mod){
            case PRIKAZ:
                btnSacuvaj.setVisible(false);
                btnIzmeni.setVisible(true);
                btnObrisi.setVisible(true);
                txtDatumProizvodnje.setEnabled(false);
                txtMarka.setEnabled(false);
                txtModel.setEnabled(false);
                txtOpis.setEnabled(false);
                        
                
                break;
            case UNOS:
                btnSacuvaj.setVisible(true);
                btnIzmeni.setVisible(false);
                btnObrisi.setVisible(false);
                
                txtDatumProizvodnje.setEnabled(true);
                txtMarka.setEnabled(true);
                txtModel.setEnabled(true);
                txtOpis.setEnabled(true);
              
                break;
            case IZMENA:
                btnSacuvaj.setVisible(true);
                btnIzmeni.setVisible(false);
                btnObrisi.setVisible(true);
                
                txtDatumProizvodnje.setEnabled(true);
                txtMarka.setEnabled(true);
                txtModel.setEnabled(true);
                txtOpis.setEnabled(true);
                break;
        }
    }
}
