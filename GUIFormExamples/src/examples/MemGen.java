package examples;

import java.awt.*;
import java.io.*;
import javax.swing.JOptionPane;


public class MemGen extends javax.swing.JFrame {
    private LoadImageApp nfile;
    String str1, str2;
    Boolean opened;
   
    public MemGen() {
        initComponents();
        
        img.setFont(new Font("Arial", 1, 120));
        opened = false;
        str1 = ""; str2 = "";     
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pick = new javax.swing.JFileChooser();
        topstr = new javax.swing.JTextField();
        botstr = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        open = new javax.swing.JButton();
        img = new javax.swing.JPanel();
        draw = new javax.swing.JButton();

        pick.setDialogTitle("Выберите что замемить");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Генератор мемосов");
        setResizable(false);

        topstr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        topstr.setText("Верхний текст");
        topstr.setToolTipText("");
        topstr.setEnabled(false);
        topstr.setName(""); // NOI18N
        topstr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topstrActionPerformed(evt);
            }
        });

        botstr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botstr.setText("Нижний текст");
        botstr.setEnabled(false);

        save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        save.setText("Сохранить");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });

        open.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        open.setText("Открыть");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout imgLayout = new org.jdesktop.layout.GroupLayout(img);
        img.setLayout(imgLayout);
        imgLayout.setHorizontalGroup(
            imgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 763, Short.MAX_VALUE)
        );
        imgLayout.setVerticalGroup(
            imgLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );

        draw.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        draw.setText("Ok");
        draw.setEnabled(false);
        draw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drawMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(img, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(open, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(botstr)
                    .add(draw, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .add(save, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(topstr))
                .add(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(open)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(save)
                .add(37, 37, 37)
                .add(topstr, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(botstr, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(draw, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(img, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        if (nfile.isNorm()) {
            pick.showSaveDialog(null);
            File f = pick.getSelectedFile();
            if (f.getAbsolutePath() != "") {
                nfile.SaveImage(f.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(null, "Введите название нового файла!");
            }
        }
    }//GEN-LAST:event_saveMouseClicked

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        
        pick.showOpenDialog(null);
        File f = pick.getSelectedFile();
        if (f.exists()) {
            img.getGraphics().clearRect(0, 0, img.getWidth(), img.getHeight());
            nfile = new LoadImageApp(f.getAbsolutePath(), img.getBounds());
            if (nfile.isNorm()) {
                nfile.DrawImg(img.getGraphics());
                opened = true;
                topstr.setEnabled(true);
                botstr.setEnabled(true);
                draw.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Ошибка открытия изображения!");
                opened = false;
            }
        }
    }//GEN-LAST:event_openActionPerformed

    private void drawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawMouseClicked
        if ((opened)) {
            str1 = topstr.getText();
            str2 = botstr.getText();
            nfile.DrawText(img.getGraphics(), str1, str2, img.getBounds());
        }
    }//GEN-LAST:event_drawMouseClicked

    private void topstrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topstrActionPerformed
       
    }//GEN-LAST:event_topstrActionPerformed
    
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemGen().setVisible(true);  
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField botstr;
    private javax.swing.JButton draw;
    private javax.swing.JPanel img;
    private javax.swing.JButton open;
    private javax.swing.JFileChooser pick;
    private javax.swing.JButton save;
    private javax.swing.JTextField topstr;
    // End of variables declaration//GEN-END:variables
    
}
