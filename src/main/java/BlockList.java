
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author deng_875452
 */
public class BlockList extends javax.swing.JPanel {

    ArrayList<String> blockedSites;
    
    
    /**
     * Creates new form BlockList
     */
    public BlockList() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_blockedSites = new javax.swing.JLabel();
        label_blockedApps = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_Sites = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_Apps = new javax.swing.JList();
        button_ImportSites = new javax.swing.JButton();
        button_ImportApps = new javax.swing.JButton();
        button_ExportSites = new javax.swing.JButton();
        button_ExportApps = new javax.swing.JButton();

        label_blockedSites.setText("Blocked Sites");

        label_blockedApps.setText("Blocked Apps");

        jScrollPane1.setViewportView(list_Sites);

        jScrollPane2.setViewportView(list_Apps);

        button_ImportSites.setText("Import Sites");
        button_ImportSites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ImportSitesActionPerformed(evt);
            }
        });

        button_ImportApps.setText("Import Apps");
        button_ImportApps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ImportAppsActionPerformed(evt);
            }
        });

        button_ExportSites.setText("Export Sites");
        button_ExportSites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ExportSitesActionPerformed(evt);
            }
        });

        button_ExportApps.setText("Export Apps");
        button_ExportApps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ExportAppsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_blockedSites)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_ImportSites)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_ExportSites, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_blockedApps)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_ImportApps)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_ExportApps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_blockedSites)
                    .addComponent(label_blockedApps))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button_ImportSites)
                        .addComponent(button_ExportSites))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button_ImportApps)
                        .addComponent(button_ExportApps)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_ImportSitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ImportSitesActionPerformed
        
    }//GEN-LAST:event_button_ImportSitesActionPerformed

    private void button_ExportSitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ExportSitesActionPerformed
        
        String data = "";
        
        try {
            JFileChooser jfc = new JFileChooser();
        
            if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = jfc.getSelectedFile();
                FileWriter writer = new FileWriter(file);
                writer.write(data);
                writer.close();

                JOptionPane.showMessageDialog(this, "Sites List export was successful");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error: Export failed. Please be sure file location\n is accessible and privileges are correct: \n" + ex.toString());
        }
    }//GEN-LAST:event_button_ExportSitesActionPerformed

    private void button_ImportAppsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ImportAppsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_ImportAppsActionPerformed

    private void button_ExportAppsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ExportAppsActionPerformed
        String data = "";
        
        
        try {
            JFileChooser jfc = new JFileChooser();
        
            if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = jfc.getSelectedFile();
                FileWriter writer = new FileWriter(file);
                writer.write(data);
                writer.close();

                JOptionPane.showMessageDialog(this, "Apps List export was successful");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error: Export failed. Please be sure file location\n is accessible and privileges are correct: \n" + ex.toString());
        }
    }//GEN-LAST:event_button_ExportAppsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_ExportApps;
    private javax.swing.JButton button_ExportSites;
    private javax.swing.JButton button_ImportApps;
    private javax.swing.JButton button_ImportSites;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_blockedApps;
    private javax.swing.JLabel label_blockedSites;
    private javax.swing.JList list_Apps;
    private javax.swing.JList list_Sites;
    // End of variables declaration//GEN-END:variables
}
