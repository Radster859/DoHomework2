
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.OK_OPTION;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author deng_875452
 */
public class MainGUI extends javax.swing.JFrame {

    private static String flag;
    private static String color;
    private static boolean override = false;
    //private static CalendarFetcher calendar;
    private static regBlocker appBlock;
    private static BlockWebsite webBlock;
    private static ArrayList<String> blockedApps;
    private static ArrayList<String> blockedSites;
    private static ArrayList<String> whitelist;
    private static ArrayList<String> blacklist;

    /**
     * Creates new form TestBlockOverride
     */
    public MainGUI() {
        initComponents();
        try {
            FileInputStream fis = new FileInputStream("save.sve");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //flag + "\n" + color + "\n" + appBlock + "\n" + webBlock + "\n" + whitelist + "\n" + blacklist);
            flag = "" + ois.readObject();
            color = "" + ois.readObject();
            appBlock = (regBlocker) ois.readObject();
            webBlock = (BlockWebsite) ois.readObject();
            whitelist = (ArrayList) ois.readObject();
            blacklist = (ArrayList) ois.readObject();
            blockedApps = (ArrayList) ois.readObject();
            blockedSites = (ArrayList) ois.readObject();
            blockList1.setActualBlockedApps(blockedApps);
            blockList1.setActualBlockedSites(blockedSites);
            blockList1.discardChanges();
            fis.close();
            ois.close();
            logoPanel1.setColor(color);
        } catch (IOException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blockOverride1 = new BlockOverride();
        statistics1 = new Statistics();
        settings1 = new Settings();
        addApp1 = new AddApp();
        addSite1 = new AddSite();
        blockList1 = new BlockList();
        button_Disable = new javax.swing.JButton();
        label_CurrentStatus = new javax.swing.JLabel();
        logoPanel1 = new LogoPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItem_Blocklists = new javax.swing.JMenuItem();
        menuItem_Settings = new javax.swing.JMenuItem();
        menuItem_Statistics = new javax.swing.JMenuItem();

        javax.swing.GroupLayout statistics1Layout = new javax.swing.GroupLayout(statistics1);
        statistics1.setLayout(statistics1Layout);
        statistics1Layout.setHorizontalGroup(
            statistics1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );
        statistics1Layout.setVerticalGroup(
            statistics1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_Disable.setText("Disable DoHomework");
        button_Disable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_DisableActionPerformed(evt);
            }
        });

        label_CurrentStatus.setText("Current Status: ");

        logoPanel1.setMaximumSize(new java.awt.Dimension(175, 175));
        logoPanel1.setMinimumSize(new java.awt.Dimension(175, 175));
        logoPanel1.setPreferredSize(new java.awt.Dimension(175, 175));

        javax.swing.GroupLayout logoPanel1Layout = new javax.swing.GroupLayout(logoPanel1);
        logoPanel1.setLayout(logoPanel1Layout);
        logoPanel1Layout.setHorizontalGroup(
            logoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        logoPanel1Layout.setVerticalGroup(
            logoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        menuItem_Blocklists.setText("Blocklists");
        menuItem_Blocklists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_BlocklistsActionPerformed(evt);
            }
        });
        jMenu1.add(menuItem_Blocklists);

        menuItem_Settings.setText("Settings");
        menuItem_Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_SettingsActionPerformed(evt);
            }
        });
        jMenu1.add(menuItem_Settings);

        menuItem_Statistics.setText("Statistics");
        menuItem_Statistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_StatisticsActionPerformed(evt);
            }
        });
        jMenu1.add(menuItem_Statistics);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_CurrentStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                        .addComponent(button_Disable)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Disable)
                    .addComponent(label_CurrentStatus))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_DisableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DisableActionPerformed
        boolean passedTest = JOptionPane.showConfirmDialog(this, blockOverride1, "DoHomework Override", OK_CANCEL_OPTION) == OK_OPTION && blockOverride1.getText().equals(blockOverride1.getType());
        if (passedTest) {
            JOptionPane.showMessageDialog(this, "You did it!");
            override = true;
        } else {
            JOptionPane.showMessageDialog(this, "String was not typed correctly. DoHomework will continue to run.");
        }
    }//GEN-LAST:event_button_DisableActionPerformed

    private void menuItem_SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_SettingsActionPerformed
        settings1.setColor(color);
        settings1.setFlag(flag);
        if (JOptionPane.showConfirmDialog(this, settings1, "Settings", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == OK_OPTION) {
            flag = settings1.getFlag();
            //calendar.setFlag(flag);
            color = settings1.getColor();
            logoPanel1.setColor(color);
        }
    }//GEN-LAST:event_menuItem_SettingsActionPerformed

    private void menuItem_StatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_StatisticsActionPerformed
        JOptionPane.showConfirmDialog(this, statistics1, "Statistics", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_menuItem_StatisticsActionPerformed

    private void menuItem_BlocklistsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_BlocklistsActionPerformed
        if (JOptionPane.showConfirmDialog(this, blockList1, "Blocklist", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            blockList1.saveChanges();
        }
        else {
            blockList1.discardChanges();
        }
        blockedApps = blockList1.getActualBlockedApps();
        blockedSites = blockList1.getActualBlockedSites();
    }//GEN-LAST:event_menuItem_BlocklistsActionPerformed

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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {

                try {
                    FileOutputStream fos = new FileOutputStream(new File("save.sve"));
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(flag);
                    oos.writeObject(color);
                    oos.writeObject(appBlock);
                    oos.writeObject(webBlock);
                    oos.writeObject(whitelist);
                    oos.writeObject(blacklist);
                    oos.writeObject(blockedApps);
                    oos.writeObject(blockedSites);
                    fos.close();
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        try {
            while (1 == 1) {
                if (!(override/* || calendar.isWork()*/)) {

                    webBlock.blockAllBut(whitelist);
                    webBlock.blockURLs(blacklist);
                } else {
                    appBlock.Off();
                    webBlock.unBlockAll();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private AddApp addApp1;
    private AddSite addSite1;
    private BlockList blockList1;
    private BlockOverride blockOverride1;
    private javax.swing.JButton button_Disable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel label_CurrentStatus;
    private LogoPanel logoPanel1;
    private javax.swing.JMenuItem menuItem_Blocklists;
    private javax.swing.JMenuItem menuItem_Settings;
    private javax.swing.JMenuItem menuItem_Statistics;
    private Settings settings1;
    private Statistics statistics1;
    // End of variables declaration//GEN-END:variables
}
