/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stegnography_application;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Azmi
 */
public class Select_Text_File extends javax.swing.JFrame {

    //My Private Variables Declaration
    private static String textFilePath;
    private static String textFileMimeType;
    private static boolean SelectFileButtonIsPressed = false;
    //End Private Variables Declaration
    
    /**
     * Creates new form Select_Text_File
     */
    public Select_Text_File() {
        SelectFileButtonIsPressed = false;
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

        TextFlieLabel = new javax.swing.JLabel();
        SelectFileButton = new javax.swing.JButton();
        InformationLabel = new javax.swing.JLabel();
        FinishButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextFlieLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        TextFlieLabel.setForeground(new java.awt.Color(255, 40, 0));

        SelectFileButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SelectFileButton.setText("Select File");
        SelectFileButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        SelectFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectFileButtonActionPerformed(evt);
            }
        });

        InformationLabel.setBackground(new java.awt.Color(255, 255, 255));
        InformationLabel.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        InformationLabel.setForeground(new java.awt.Color(62, 0, 255));
        InformationLabel.setText("<html>This Text File Should Be 4 Times Smaller Than The Cover Image</html>");
        InformationLabel.setOpaque(true);

        FinishButton.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        FinishButton.setText("Finish");
        FinishButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        FinishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(InformationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(TextFlieLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FinishButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SelectFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelectFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFlieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InformationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FinishButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectFileButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Files", "txt");
        chooser.addChoosableFileFilter(fnef);
        int showOpenDialog = chooser.showOpenDialog(null);
        
        try {
            if(showOpenDialog == JFileChooser.APPROVE_OPTION){
                File file = chooser.getSelectedFile();
                String mimetype = Files.probeContentType(file.toPath());

                if(mimetype.equals("text/plain")){
                    String filePath = file.getAbsolutePath();
                    set_TextFilePath(filePath);
                    set_TextFileMimeType("txt");

                    String fileName = file.getName();
                    TextFlieLabel.setText(fileName);
                }
                else{
                    JOptionPane.showMessageDialog(null, "File Is Not An Text File","WRONG FILE",JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        catch (IOException ex) {
            Logger.getLogger(Select_Text_File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SelectFileButtonActionPerformed

    private void FinishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishButtonActionPerformed
        // TODO add your handling code here:
        if(SelectFileButtonIsPressed == true){
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Select Any Text File","FILE NOT SELECTED",JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_FinishButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Select_Text_File.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Select_Text_File.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Select_Text_File.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Select_Text_File.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Select_Text_File().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FinishButton;
    private javax.swing.JLabel InformationLabel;
    private javax.swing.JButton SelectFileButton;
    private javax.swing.JLabel TextFlieLabel;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Create setMessage_Type() method to set file path
     */
    private void set_TextFilePath(String text) {
        textFilePath = text;
        SelectFileButtonIsPressed = true;
    }
    
    /**
     * Create setMessage_Type() method to get file path
     * @return 
     */
    public String get_TextFilePath() {
        return textFilePath;
    }

    
    /**
     * Create set_TextFileMimeType() method to set the mime type of file
     */
    private void set_TextFileMimeType(String text) {
        textFileMimeType = text;
    }
    
    /**
     * Create get_TextFileMimeType() method to get the mime type of file
     * @return 
     */
    public String get_TextFileMimeType() {
        return textFileMimeType;
    }
}
