/*
 * Copyright 2020 Alberto Enrique Alonso De la Hoz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package View;

import Model.Util;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author Alberto Enrique Alonso De la Hoz
 * @author Cristian Eduardo Coronado Santiago
 */
public class FormInicio extends javax.swing.JFrame {

    /**
     * Creates new form FormInicio
     */
    public static FormCalculo calculo = new FormCalculo();
    int mecanizado = 0;
    int material = 0;

    public FormInicio() {
        initComponents();

        //FormInicio.this.setLocationRelativeTo(FormInicio.this);
        FormInicio.this.setResizable(false);
        FormInicio.this.getContentPane().setBackground(Color.WHITE);
        FormInicio.this.setTitle("Cálculos de mejora, tolerancia y rugosidad");
        // setIconImage(new ImageIcon(getClass().getResource("../Img/logo.png")).getImage());
        //Util.fondo(FormInicio.this, "/Imagenes/fondo.png");
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
        buttonSalir = new javax.swing.JButton();
        jlabelLogo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cmbProcesoMecanizado = new javax.swing.JComboBox<>();
        cmbMaterial = new javax.swing.JComboBox<>();
        jLabelProcesoMecanizado = new javax.swing.JLabel();
        jLabelMaterial = new javax.swing.JLabel();
        buttonSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel1.setText("CÁLCULO DE MEJORA, TOLERANCIA Y RUGOSIDAD");
        jLabel1.setToolTipText("");

        buttonSalir.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        buttonSalir.setText("SALIR");
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });

        jlabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jButton1.setText("ACERCA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbProcesoMecanizado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoger", "Fresado", "Taladrado", " ", " " }));

        cmbMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoger", "ABS", "PC", "EPA-CF" }));

        jLabelProcesoMecanizado.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabelProcesoMecanizado.setText("Proceso de mecanizado:");

        jLabelMaterial.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabelMaterial.setText("Material:");

        buttonSiguiente.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        buttonSiguiente.setText("SIGUIENTE");
        buttonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelProcesoMecanizado)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelMaterial)
                                .addGap(97, 97, 97)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbMaterial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbProcesoMecanizado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(289, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jlabelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProcesoMecanizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProcesoMecanizado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMaterial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(buttonSiguiente)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jlabelLogo))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonabsActionPerformed


    }//GEN-LAST:event_buttonabsActionPerformed

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
        javax.swing.JOptionPane.showMessageDialog(null, "Gracias por utilizar el software");
        System.exit(0);
    }//GEN-LAST:event_buttonSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Util.acercaMensaje("Software desarrollado por "
                + "\n los estudiantes de ing. mecánica de la "
                + "\n Universidad Del Atlántico,"
                + "\n Alberto Enrique Alonso De la Hoz y "
                + "\n Cristian Eduardo Coronado Santiago"
                + "\n para la realización de Cálculos de mejora, tolerancia y rugosidad"
                + "\n correspondientes a su tesis de pregrado.");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSiguienteActionPerformed

        mecanizado = cmbProcesoMecanizado.getSelectedIndex();
        material = cmbMaterial.getSelectedIndex();
        calculo.parametrosEscogidos(mecanizado, material);

        if (mecanizado != 0 && material != 0) {
            if (mecanizado == 1) {
                calculo.jLabelRangosVelocidad.setText("(20 <= Va <= 200)");
                calculo.jLabelVelocidad.setText("Ingrese el valor de velocidad de avance (mm/min)*");
                calculo.jLabelRangosTolerancia.setText("(0.032 <= Ti <= 1.12)");
                
                switch(material){
                    case 1:
                        calculo.jLabelRangosDeRugosidad.setText("(25.165 <= Ri <= 32.31)");
                        break;
                    case 2:
                        calculo.jLabelRangosDeRugosidad.setText("(23.857 <= Ri <= 25.677)");
                        break;
                    case 3:
                        calculo.jLabelRangosDeRugosidad.setText("(9.887 <= Ri <= 11.113)");
                        break;
                    
                }
                calculo.setVisible(true);
            } else {
                calculo.jLabelRangosVelocidad.setText("(18 <= Vc <= 51)");
                calculo.jLabelVelocidad.setText("Ingrese el valor de velocidad de corte (mm/min)*");
                calculo.jLabelRangosTolerancia.setText("(0.589 <= Ti <= 0.778)");
                switch(material){
                    case 1:
                        calculo.jLabelRangosDeRugosidad.setText("(21.346 <= Ri <= 23.273)");
                        break;
                    case 2:
                        calculo.jLabelRangosDeRugosidad.setText("(22.875 <= Ri <= 24.737)");
                        break;
                    case 3:
                        calculo.jLabelRangosDeRugosidad.setText("(20.207 <= Ri <= 23.159)");
                        break;
                    
                }
                calculo.setVisible(true);
            }

        } else {
            Util.mostrarError("Por favor escoger las opciones de \n"
                    + "Proceso de macanizado y tipo de material");
        }
        
        
        
    }//GEN-LAST:event_buttonSiguienteActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSalir;
    private javax.swing.JButton buttonSiguiente;
    private javax.swing.JComboBox<String> cmbMaterial;
    private javax.swing.JComboBox<String> cmbProcesoMecanizado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMaterial;
    private javax.swing.JLabel jLabelProcesoMecanizado;
    private javax.swing.JLabel jlabelLogo;
    // End of variables declaration//GEN-END:variables
}
