
package Interfaz;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;

public class PanelImagen extends javax.swing.JPanel {
    BufferedImage imagen = null;
    
    public PanelImagen(BufferedImage imagen) {
            super(new GridBagLayout());
        initComponents();
        this.imagen = imagen;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    public void paint(Graphics g) {
        
        super.paint(g);
        g.drawImage(imagen,10,10,imagen.getWidth(),imagen.getHeight(),null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
