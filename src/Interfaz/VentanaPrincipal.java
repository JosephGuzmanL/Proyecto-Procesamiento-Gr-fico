
package Interfaz;

import codigos.Operacion;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

public class VentanaPrincipal extends javax.swing.JFrame {
    BufferedImage imagen = null;
    PanelImagen panelImagen = null;
    public int pixelsTotales = 0;
    public int pixelsAFavor = 0;
    public VentanaPrincipal() {
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        btnPreProceso = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        porcentajeTxt = new javax.swing.JLabel();
        btnIngresar1 = new javax.swing.JButton();
        btnIngresar2 = new javax.swing.JButton();
        btnIngresar3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        categoriaTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Vrinda", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Control de Calidad de Manzanas Red Delicious");
        jLabel2.setOpaque(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnIngresar.setText("Ingresar Imagen");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnPreProceso.setText("PreProceso");
        btnPreProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreProcesoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("MS PGothic", 1, 12)); // NOI18N
        jLabel1.setText("Porcentaje de Cromatización");

        porcentajeTxt.setFont(new java.awt.Font("MS Gothic", 1, 12)); // NOI18N
        porcentajeTxt.setText("   ");

        btnIngresar1.setText("Segmentar");
        btnIngresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar1ActionPerformed(evt);
            }
        });

        btnIngresar2.setText("Representación y Descripción");
        btnIngresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar2ActionPerformed(evt);
            }
        });

        btnIngresar3.setText("Reconocimiento e Interpretación");
        btnIngresar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("MS PGothic", 1, 18)); // NOI18N
        jLabel3.setText("CATEGORÍA");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        categoriaTxt.setFont(new java.awt.Font("Vrinda", 1, 36)); // NOI18N
        categoriaTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(118, 118, 118)
                                .addComponent(btnPreProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(porcentajeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnIngresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(btnIngresar2)
                        .addGap(32, 32, 32))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btnIngresar3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(categoriaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPreProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIngresar2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(btnIngresar3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(porcentajeTxt))
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addComponent(categoriaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        
        
        this.imagen = Operacion.pick();
        
        this.panelImagen = new PanelImagen(imagen);
        add(panelImagen);
        panelImagen.setBounds(5,jLabel2.getHeight(),imagen.getWidth()+15, imagen.getHeight()+15);
        panelImagen.setBorder(BorderFactory.createLineBorder(Color.black));
        panelImagen.setVisible(true);
        porcentajeTxt.setText(Integer.toString(Operacion.devolverCantidadDePixeles(panelImagen.imagen)));
        /*
        this.panelImagen = new PanelImagen(Operacion.segmentacion(Operacion.preProceso(imagen), imagen));*/

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnPreProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreProcesoActionPerformed
        panelImagen.imagen = Operacion.preProceso(panelImagen.imagen);
        panelImagen.repaint();
    }//GEN-LAST:event_btnPreProcesoActionPerformed

    private void btnIngresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar1ActionPerformed
        panelImagen.imagen = Operacion.segmentacion(panelImagen.imagen, imagen);
        panelImagen.repaint();
    }//GEN-LAST:event_btnIngresar1ActionPerformed

    private void btnIngresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar2ActionPerformed
        panelImagen.imagen = Operacion.descripcion(Operacion.preProceso(this.imagen), this.imagen, this);
        panelImagen.repaint();
        
    
    }//GEN-LAST:event_btnIngresar2ActionPerformed

    private void btnIngresar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar3ActionPerformed
        int porcentaje = (pixelsAFavor*100)/pixelsTotales;
        
        porcentajeTxt.setText(Integer.toString(porcentaje) + " %");
        
        if(porcentaje >75) {
        categoriaTxt.setText("A");
        }else {
                if (porcentaje<=75 && porcentaje >50){
                categoriaTxt.setText("B");
                } else {
                if(porcentaje<=50 && porcentaje >25) {
                categoriaTxt.setText("C");
                } else {
                categoriaTxt.setText("D");
                }
            }
        }
    }//GEN-LAST:event_btnIngresar3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnIngresar1;
    private javax.swing.JButton btnIngresar2;
    private javax.swing.JButton btnIngresar3;
    private javax.swing.JButton btnPreProceso;
    private javax.swing.JLabel categoriaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel porcentajeTxt;
    // End of variables declaration//GEN-END:variables
}
