
package com.fundation.search.view;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
public class JPanelBackground extends javax.swing.JPanel {
ImageIcon imagen;
 
    public JPanelBackground(String nombre) {
        initComponents();
        imagen= new ImageIcon(nombre);
        setSize(imagen.getIconWidth(),imagen.getIconHeight());

    }
       @Override
       protected void paintComponent(Graphics g){
       Dimension d=getSize();
       g.drawImage(imagen.getImage(), 0, 0, d.width,  d.height, null);
       this.setOpaque(false);
       super.paintComponent(g);



       }

    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }
}
