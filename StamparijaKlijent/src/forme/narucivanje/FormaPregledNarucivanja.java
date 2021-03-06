/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.narucivanje;

import domen.IOpstiDomenskiObjekat;
import domen.Klijent;
import domen.Narucivanje;
import forme.glavna.FormaGlavna;
import java.util.List;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import modeli.ModelTabeleNarucivanje;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Kosta
 */
public class FormaPregledNarucivanja extends javax.swing.JDialog {

    /**
     * Creates new form FormaPregledNarucivanja
     */
    public FormaPregledNarucivanja(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        srediTabelu();
        pretrazi();
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
        txtFilter = new javax.swing.JTextField();
        btnDetalji = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaNarucivanja = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pretraga po emailu");

        txtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFilterKeyReleased(evt);
            }
        });

        btnDetalji.setText("Detalji");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        tabelaNarucivanja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaNarucivanja);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtFilter))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnDetalji, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDetalji)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyReleased
        pretrazi();
    }//GEN-LAST:event_txtFilterKeyReleased

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        int red = tabelaNarucivanja.getSelectedRow();
        if(red == -1)
            return;
        
        ModelTabeleNarucivanje mtn = (ModelTabeleNarucivanje) tabelaNarucivanja.getModel();
        Narucivanje n = mtn.getNarucivanje(red);
        
        FormaUnosNarucivanja unos = new FormaUnosNarucivanja((FormaGlavna)getParent(), true, this);
        unos.setFormuZaBrisanje(n);
        unos.pack();
        unos.setVisible(true);
        
    }//GEN-LAST:event_btnDetaljiActionPerformed

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
            java.util.logging.Logger.getLogger(FormaPregledNarucivanja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaPregledNarucivanja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaPregledNarucivanja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaPregledNarucivanja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                FormaPregledNarucivanja dialog = new FormaPregledNarucivanja(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDetalji;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaNarucivanja;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables

    private void srediTabelu() {
        ModelTabeleNarucivanje mtn = new ModelTabeleNarucivanje();
        tabelaNarucivanja.setModel(mtn);
    }
    
    public void pretrazi(){
        try {
            String text = txtFilter.getText();
            Narucivanje nar = new Narucivanje();
            Klijent k = new Klijent();
            k.setEmail(text);
            nar.setKlijent(k);
            ServerskiOdgovor so = Kontroler.getInstance().pretraziNarucivanje(nar);
            List<IOpstiDomenskiObjekat> lista = (List<IOpstiDomenskiObjekat>) so.getOdgovor();
            ModelTabeleNarucivanje mtn = (ModelTabeleNarucivanje) tabelaNarucivanja.getModel();
            mtn.setLista(lista);
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje narucivanje po zadatim parametrima");
    
            }else {
                JOptionPane.showMessageDialog(this, so.getPoruka());
            }
            
    } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da prikaze narucivanje");
    }
    }
}
