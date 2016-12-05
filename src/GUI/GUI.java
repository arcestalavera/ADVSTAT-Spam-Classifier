/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Email;
import Processor.CSVWriter;
import Processor.FeatureMapConstructor;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author Arces
 */
public class GUI extends javax.swing.JFrame {

    private JFileChooser jfc;
    private File inputFile;

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        
        //GUI Adjustments
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(null);
        

        //File Chooser
        this.jfc = new JFileChooser();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        featurePanel = new javax.swing.JPanel();
        featureTitleLabel = new javax.swing.JLabel();
        featureFileLabel = new javax.swing.JLabel();
        featureFileBtn = new javax.swing.JButton();
        featureConstructBtn = new javax.swing.JButton();
        trainPanel = new javax.swing.JPanel();
        featureTitleLabel1 = new javax.swing.JLabel();
        trainFileLabel = new javax.swing.JLabel();
        trainFileBtn = new javax.swing.JButton();
        trainStartBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spam Classifier");

        headerLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Spam Classifier");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        featurePanel.setBackground(new java.awt.Color(255, 255, 255));

        featureTitleLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        featureTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        featureTitleLabel.setText("Construct Feature Map");

        featureFileLabel.setFont(new java.awt.Font("Century Gothic", 2, 10)); // NOI18N
        featureFileLabel.setForeground(new java.awt.Color(102, 102, 102));
        featureFileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        featureFileLabel.setText("Please Select a File");

        featureFileBtn.setText("Select File");
        featureFileBtn.setFocusable(false);
        featureFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                featureFileBtnActionPerformed(evt);
            }
        });

        featureConstructBtn.setText("Construct Feature Map");
        featureConstructBtn.setEnabled(false);
        featureConstructBtn.setFocusable(false);
        featureConstructBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                featureConstructBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout featurePanelLayout = new javax.swing.GroupLayout(featurePanel);
        featurePanel.setLayout(featurePanelLayout);
        featurePanelLayout.setHorizontalGroup(
            featurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(featurePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(featurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(featureTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(featureFileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(featureFileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(featureConstructBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                .addContainerGap())
        );
        featurePanelLayout.setVerticalGroup(
            featurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(featurePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(featureTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(featureFileLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(featureFileBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(featureConstructBtn)
                .addGap(10, 10, 10))
        );

        trainPanel.setBackground(new java.awt.Color(250, 250, 250));

        featureTitleLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        featureTitleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        featureTitleLabel1.setText("Train Machine");

        trainFileLabel.setFont(new java.awt.Font("Century Gothic", 2, 10)); // NOI18N
        trainFileLabel.setForeground(new java.awt.Color(102, 102, 102));
        trainFileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trainFileLabel.setText("Please Select a File");

        trainFileBtn.setText("Select File");
        trainFileBtn.setFocusable(false);

        trainStartBtn.setText("Start Training");
        trainStartBtn.setEnabled(false);
        trainStartBtn.setFocusable(false);

        javax.swing.GroupLayout trainPanelLayout = new javax.swing.GroupLayout(trainPanel);
        trainPanel.setLayout(trainPanelLayout);
        trainPanelLayout.setHorizontalGroup(
            trainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(trainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(featureTitleLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trainFileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trainFileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trainStartBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                .addContainerGap())
        );
        trainPanelLayout.setVerticalGroup(
            trainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(featureTitleLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trainFileLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trainFileBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trainStartBtn)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(featurePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(trainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(featurePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(trainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void featureFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_featureFileBtnActionPerformed
        int val = jfc.showOpenDialog(this);
        if (val == JFileChooser.APPROVE_OPTION) {
            //if a file has been chosen
            //get file
            inputFile = jfc.getSelectedFile();
            //update GUI
            featureFileLabel.setText("Feature Construction is Ready!");
            featureConstructBtn.setEnabled(true);
        } else {
            //if no file has been chosen
            inputFile = null;
            featureFileLabel.setText("Please Select a File");
            featureConstructBtn.setEnabled(false);
        }
    }//GEN-LAST:event_featureFileBtnActionPerformed

    private void featureConstructBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_featureConstructBtnActionPerformed
        featureFileLabel.setText("Constructing Feature Map. . .");
        
        FeatureMapConstructor fmc = new FeatureMapConstructor();
        ArrayList<Email> emailList = fmc.constructFeatureMap(inputFile);
        
        /*
        float totalProb = 0;
        
        for(Email e: emailList){
            totalProb = 0;
            System.out.println("Email: " + (e.getIsSpam()? "spam": "not spam"));
            for(Word w: e.getWordList()){
                System.out.println("\t" + w.getWord() + ": " + w.getCount() + " [" + w.getProbability() + "]");
                totalProb += w.getProbability();
            }
            System.out.println("Sum of Probability: " + totalProb);
        }
        */
        featureFileLabel.setText("Feature Map Complete!");
        
        //export feature map
        int val = jfc.showSaveDialog(this);
        if(val == JFileChooser.APPROVE_OPTION){
            CSVWriter writer = new CSVWriter();
            
            writer.exportFeatureMap(jfc.getSelectedFile().getPath(), emailList);
        }
    }//GEN-LAST:event_featureConstructBtnActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton featureConstructBtn;
    private javax.swing.JButton featureFileBtn;
    private javax.swing.JLabel featureFileLabel;
    private javax.swing.JPanel featurePanel;
    private javax.swing.JLabel featureTitleLabel;
    private javax.swing.JLabel featureTitleLabel1;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton trainFileBtn;
    private javax.swing.JLabel trainFileLabel;
    private javax.swing.JPanel trainPanel;
    private javax.swing.JButton trainStartBtn;
    // End of variables declaration//GEN-END:variables

}