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

import Model.Mecanizado;
import Model.Util;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto Enrique Alonso De la Hoz
 * @author Cristian Eduardo Coronado Santiago
 */
public class FormCalculo extends javax.swing.JFrame {

    public Mecanizado meca = new Mecanizado();
    public FormInfo info = new FormInfo();
    public double t;
    public double v;
    public double ri;
    public double tolerancia;
    public double diametro;
    public double mecanizado;
    public double material;
    

    /**
     * Creates new form FormCal1
     */
    public FormCalculo() {
        initComponents();
        //Formabs.this.setLocationRelativeTo(FormABS);
        FormCalculo.this.setLocation(40, -10);
        FormCalculo.this.setResizable(false);
        FormCalculo.this.getContentPane().setBackground(Color.WHITE);
        FormCalculo.this.setTitle("Panel de valores");
        FormCalculo.this.jLabelDiametro.setVisible(false);
        FormCalculo.this.jLabelRangosDiametro.setVisible(false);
        FormCalculo.this.jTextFieldDiametro.setVisible(false);
    }

    public void parametrosEscogidos(double meca, double mate) {
        mecanizado = meca;
        material = mate;
    }

    public void captura() {
        if (mecanizado == 1) {
            meca.setVa(Double.parseDouble(jTextFieldVelocidad.getText()));
        }
        if (mecanizado == 2) {
            meca.setVc(Double.parseDouble(jTextFieldVelocidad.getText()));
        }
        meca.setT(Double.parseDouble(jTextFieldT.getText()));
        
        if ("".equals(jTextFieldRugosidadInicial.getText()) && ri != 0) {
            meca.setRi(ri);

        } else {
            meca.setRi(Double.parseDouble(jTextFieldRugosidadInicial.getText()));

        }
        if ("".equals(jTextFieldToleranciaInicial.getText())) {
            meca.setTolerancia(0);
            meca.setDiametro(0);

        } else {
            meca.setTolerancia(Double.parseDouble(jTextFieldToleranciaInicial.getText()));
            meca.setDiametro(Double.parseDouble(jTextFieldDiametro.getText()));
        }
        info.mostrarResultados(mecanizado, material, meca);
    }

    public void limpiarFormulario() {
        jTextFieldT.setText("");
        jTextFieldVelocidad.setText("");
        jTextFieldRugosidadInicial.setText("");
        jTextFieldToleranciaInicial.setText("");
        jTextFieldDiametro.setText("");
        errorT.setText("");
        errorV.setText("");
        errorDi.setText("");
        errorTi.setText("");
        errorRi.setText("");

    }

    public void habilitarCampos() {
        jLabelVelocidad.setVisible(true);
        jLabelRangosVelocidad.setVisible(true);
        jTextFieldVelocidad.setVisible(true);
        jLabelDiametro.setVisible(false);
        jLabelRangosDiametro.setVisible(false);
        jTextFieldDiametro.setVisible(false);

    }

    public boolean verificar() {
        boolean verificar = true;
        String t = jTextFieldT.getText();
        String v = jTextFieldVelocidad.getText();
        String ri = jTextFieldRugosidadInicial.getText();
        String ti = jTextFieldToleranciaInicial.getText();

        if ("".equals(t)) {
            Util.mostrarError(errorT);
            verificar = false;
        }

        if (mecanizado == 1) {
            if ("".equals(v)) {
                Util.mostrarError(errorV);
                verificar = false;
            }
        }
      
        if ("".equals(ti)) {
            Util.mostrarMensaje("No aplica el campo tolernacia inicial");
        }

        if (verificar == false) {
            Util.mostrarError("El Formulario Contiene Campos Vacíos");
            return verificar;
        } else {
            verificar = true;
            return verificar;
        }
    }

    public boolean verificarRangos() {
        boolean verificar = true;

        t = Double.parseDouble(jTextFieldT.getText());
        String ti = jTextFieldToleranciaInicial.getText();
        v = Double.parseDouble(jTextFieldVelocidad.getText());

        if (t < 0.35) {
            Util.mostrarError(errorT);
            verificar = false;
        }
        if (t > 0.75) {
            Util.mostrarError(errorT);
            verificar = false;
        }

        if (mecanizado == 1) {

            if (v < 20) {
                Util.mostrarError(errorV);
                verificar = false;
            }
            if (v > 200) {
                Util.mostrarError(errorV);
                verificar = false;
            }

        }
        if (mecanizado == 2) {

            if (v < 18) {
                Util.mostrarError(errorV);
                verificar = false;
            }
            if (v > 51) {
                Util.mostrarError(errorV);
                verificar = false;
            }

        }

        if (verificar == false) {
            Util.mostrarError("Los valores ingresados están por fuera de "
                    + "rango");
            return verificar;
        } else {
            verificar = true;
            return verificar;
        }
    }

    public boolean verificarRangosRi() {
        boolean verificar = true;
        int k = (int) mecanizado;
        int i = (int) material;
        String rugosidad = jTextFieldRugosidadInicial.getText();
        switch (i) {
            case 1:
                if (k == 1) {
                    if ("".equals(rugosidad)) {
                        ri = 28.144;
                        Util.mostrarMensaje("Los calculos serán estimados \n"
                                + "utilizando un valor de " + ri +"µm como valor \n"
                                + "inicial de Rugosidad Inicial");
                    } else {
                        ri = Double.parseDouble(jTextFieldRugosidadInicial.getText());
                        if (ri < 25.165) {
                            Util.mostrarError(errorRi);
                            verificar = false;
                        }
                        if (ri > 32.31) {
                            Util.mostrarError(errorRi);
                            verificar = false;
                        }
                    }

                } else {
                    if ("".equals(rugosidad)) {
                        ri = 22.441;
                         Util.mostrarMensaje("Los calculos serán estimados \n"
                                + "utilizando un valor de " + ri +"µm como valor \n"
                                + "inicial de Rugosidad Inicial");
                    } else {
                        ri = Double.parseDouble(jTextFieldRugosidadInicial.getText());
                        if (ri < 21.346) {
                            Util.mostrarError(errorRi);
                            verificar = false;
                        }
                        if (ri > 23.273) {
                            Util.mostrarError(errorRi);
                            verificar = false;
                        }
                    }
                }

                break;
            case 2:
                if (k == 1) {
                    if ("".equals(rugosidad)) {
                        ri = 24.6251429;
                         Util.mostrarMensaje("Los calculos serán estimados \n"
                                + "utilizando un valor de " + ri +"µm como valor \n"
                                + "inicial de Rugosidad Inicial");
                    } else {
                        ri = Double.parseDouble(jTextFieldRugosidadInicial.getText());
                        if (ri < 23.857) {
                            Util.mostrarError(errorRi);
                            verificar = false;
                        }
                        if (ri > 25.677) {
                            Util.mostrarError(errorRi);
                            verificar = false;
                        }

                    }

                } else {
                    if ("".equals(rugosidad)) {
                        ri = 24.1607143;
                         Util.mostrarMensaje("Los calculos serán estimados \n"
                                + "utilizando un valor de " + ri +"µm como valor \n"
                                + "inicial de Rugosidad Inicial");
                    } else {
                        ri = Double.parseDouble(jTextFieldRugosidadInicial.getText());
                        if (ri < 22.875) {
                            Util.mostrarError(errorRi);
                            verificar = false;
                        }
                        if (ri > 24.737) {
                            Util.mostrarError(errorRi);
                            verificar = false;
                        }
                    }
                }

                break;
            default:
                if (k == 1) {
                    if ("".equals(rugosidad)) {
                        ri = 10.465;
                         Util.mostrarMensaje("Los calculos serán estimados \n"
                                + "utilizando un valor de " + ri +"µm como valor \n"
                                + "inicial de Rugosidad Inicial");
                    } else {
                        ri = Double.parseDouble(jTextFieldRugosidadInicial.getText());
                        if (ri < 9.887) {
                            Util.mostrarError(errorRi);
                            verificar = false;
                        }
                        if (ri > 11.113) {
                            Util.mostrarError(errorRi);
                            verificar = false;
                        }
                    }

                } else {
                    if ("".equals(rugosidad)) {
                        ri = 21.4592857;
                         Util.mostrarMensaje("Los calculos serán estimados \n"
                                + "utilizando un valor de " + ri +"µm como valor \n"
                                + "inicial de Rugosidad Inicial");
                    } else {
                        ri = Double.parseDouble(jTextFieldRugosidadInicial.getText());
                        if (ri < 20.207) {
                            Util.mostrarError(errorRi);
                            verificar = false;
                        }
                        if (ri > 23.159) {
                            Util.mostrarError(errorRi);
                            verificar = false;
                        }
                    }
                }

                break;
        }

        if (verificar == false) {
            Util.mostrarError("Los valores ingresados están por fuera de "
                    + "rango");
            return verificar;
        } else {
            verificar = true;
            return verificar;
        }
    }

    public boolean verificarRangosTi() {
        boolean verificar = true;
        String ti = jTextFieldToleranciaInicial.getText();
        String di = jTextFieldDiametro.getText();
        int k = (int) mecanizado;

        if ("".equals(ti) && "".equals(di)) {
            verificar = true;
        } else {
            jLabelDiametro.setVisible(true);
            jLabelRangosDiametro.setVisible(true);
            jTextFieldDiametro.setVisible(true);
            tolerancia = Double.parseDouble(jTextFieldToleranciaInicial.getText());
            diametro = Double.parseDouble(jTextFieldDiametro.getText());

            switch (k) {
                case 1:
                    if (tolerancia < 0.032) {
                        Util.mostrarError(errorTi);
                        verificar = false;
                    }
                    if (tolerancia > 1.12) {
                        Util.mostrarError(errorTi);
                        verificar = false;
                    }

                    break;
                case 2:
                    if (tolerancia < 0.589) {
                        Util.mostrarError(errorTi);
                        verificar = false;
                    }
                    if (tolerancia > 0.778) {
                        Util.mostrarError(errorTi);
                        verificar = false;
                    }
                    break;
            }

            if (diametro < 5) {
                Util.mostrarError(errorDi);
                verificar = false;
            }
            if (diametro > 8) {
                Util.mostrarError(errorDi);
                verificar = false;
            }

        }

        if (verificar == false) {
            Util.mostrarError("Los valores ingresados están por fuera de "
                    + "rango");
            return verificar;
        } else {
            verificar = true;
            return verificar;
        }

    }

    public void cargarDatos() {
        jTextFieldT.setText(String.valueOf(meca.getT()));
        jTextFieldVelocidad.setText(String.valueOf(meca.getVa()));
        jTextFieldRugosidadInicial.setText(String.valueOf(meca.getRi()));
        if (meca.getTolerancia() != 0) {
            FormCalculo.this.jLabelDiametro.setVisible(true);
            FormCalculo.this.jLabelRangosDiametro.setVisible(true);
            FormCalculo.this.jTextFieldDiametro.setVisible(true);
            jTextFieldToleranciaInicial.setText(String.valueOf(meca.getTolerancia()));
            jTextFieldDiametro.setText(String.valueOf(meca.getDiametro()));
            
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

        jLabel10 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabelProfundidad = new javax.swing.JLabel();
        jLabelVelocidad = new javax.swing.JLabel();
        jLabelRangosProfundidad = new javax.swing.JLabel();
        jLabelRangosVelocidad = new javax.swing.JLabel();
        jTextFieldT = new javax.swing.JTextField();
        jTextFieldVelocidad = new javax.swing.JTextField();
        ButtonCalcular = new javax.swing.JButton();
        ButtonVolver = new javax.swing.JButton();
        ButtonRestaurar = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        errorT = new javax.swing.JLabel();
        errorV = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelRugosidadInicial = new javax.swing.JLabel();
        jTextFieldRugosidadInicial = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jLabelRangosDeRugosidad = new javax.swing.JLabel();
        errorRi = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabelToleranciaInicial = new javax.swing.JLabel();
        jLabelRangosTolerancia = new javax.swing.JLabel();
        jTextFieldToleranciaInicial = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        jLabelDiametro = new javax.swing.JLabel();
        jLabelRangosDiametro = new javax.swing.JLabel();
        jTextFieldDiametro = new javax.swing.JTextField();
        errorTi = new javax.swing.JLabel();
        errorDi = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel10.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabel10.setText("Ingrese valor de orientación de impresión");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel1.setText("PANEL DE VALORES ");

        jLabelProfundidad.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabelProfundidad.setText("Ingrese el valor de profundidad de corte (mm) *");

        jLabelVelocidad.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabelVelocidad.setText("Ingrese valor de velocidad de avance");

        jLabelRangosProfundidad.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabelRangosProfundidad.setText("(0.35 <= T <= 0.75)");

        jLabelRangosVelocidad.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabelRangosVelocidad.setText("(20 <= Va <= 220)");

        jTextFieldT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTKeyTyped(evt);
            }
        });

        jTextFieldVelocidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldVelocidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldVelocidadKeyTyped(evt);
            }
        });

        ButtonCalcular.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        ButtonCalcular.setText("Calcular");
        ButtonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCalcularActionPerformed(evt);
            }
        });
        ButtonCalcular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ButtonCalcularKeyPressed(evt);
            }
        });

        ButtonVolver.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        ButtonVolver.setText("Restaurar");
        ButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVolverActionPerformed(evt);
            }
        });

        ButtonRestaurar.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        ButtonRestaurar.setText("Modificar");
        ButtonRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRestaurarActionPerformed(evt);
            }
        });

        errorT.setLabelFor(jTextFieldT);

        errorV.setLabelFor(jTextFieldVelocidad);

        jLabel16.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("Nota. El separador decimal es el punto.");

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo.png"))); // NOI18N

        jLabelRugosidadInicial.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabelRugosidadInicial.setText("Ingrese el valor de rugosidad inicial (µm)");

        jTextFieldRugosidadInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRugosidadInicialActionPerformed(evt);
            }
        });
        jTextFieldRugosidadInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldRugosidadInicialKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldRugosidadInicialKeyTyped(evt);
            }
        });

        jLabelRangosDeRugosidad.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabelRangosDeRugosidad.setText("(20 <= Ri <= 30)");

        jLabelToleranciaInicial.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabelToleranciaInicial.setText("Ingrese el valor de tolerancia inicial  (mm)");

        jLabelRangosTolerancia.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabelRangosTolerancia.setText("(0.3 <= Ti < = 0.78)");

        jTextFieldToleranciaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldToleranciaInicialKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldToleranciaInicialKeyTyped(evt);
            }
        });

        jLabelDiametro.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabelDiametro.setText("Ingrese el valor de diametro/Espesor (mm)");

        jLabelRangosDiametro.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabelRangosDiametro.setText("(5 <= Di <= 8)");

        jTextFieldDiametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDiametroActionPerformed(evt);
            }
        });
        jTextFieldDiametro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDiametroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDiametroKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        jLabel2.setText("* campo obligatorio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelToleranciaInicial)
                            .addComponent(jLabelRugosidadInicial)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDiametro))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelVelocidad))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelProfundidad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRangosProfundidad)
                    .addComponent(jLabelRangosVelocidad)
                    .addComponent(jLabelRangosDeRugosidad)
                    .addComponent(jLabelRangosTolerancia)
                    .addComponent(jLabelRangosDiametro))
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRugosidadInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldToleranciaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDiametro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(errorT, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(errorV, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(errorRi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(errorTi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorDi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(287, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(251, 251, 251))
            .addComponent(jSeparator14, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(ButtonRestaurar)
                        .addGap(6, 6, 6)
                        .addComponent(ButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel16))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelProfundidad)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelRangosProfundidad)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelRangosVelocidad)
                                .addComponent(jTextFieldVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(errorV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errorRi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelRugosidadInicial)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRangosDeRugosidad)
                            .addComponent(jTextFieldRugosidadInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelToleranciaInicial)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldToleranciaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelRangosTolerancia)))
                        .addGap(21, 21, 21)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(errorTi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDiametro)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldDiametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelRangosDiametro))
                    .addComponent(errorDi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabelLogo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonCalcular)
                            .addComponent(ButtonRestaurar)
                            .addComponent(ButtonVolver))
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVolverActionPerformed
        this.dispose();
        limpiarFormulario();
        habilitarCampos();
    }//GEN-LAST:event_ButtonVolverActionPerformed

    private void ButtonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCalcularActionPerformed
        if (verificar() == true) {
            if (verificarRangos() == true) {
                if (verificarRangosRi() == true && verificarRangosTi() == true) {

                    captura();

                    meca.calculoDeValores(mecanizado, material, meca);
                    info.mostrarResultados(mecanizado, material, meca);
                    limpiarFormulario();
                    info.setVisible(true);

                }
            }
        }
    }//GEN-LAST:event_ButtonCalcularActionPerformed

    private void jTextFieldTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTKeyTyped
        if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 45
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this,
                    "Solo se puede digitar numeros",
                    this.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldTKeyTyped

    private void jTextFieldVelocidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVelocidadKeyTyped
        if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 45
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this,
                    "Solo se puede digitar numeros",
                    this.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldVelocidadKeyTyped

    private void ButtonRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRestaurarActionPerformed

        cargarDatos();


    }//GEN-LAST:event_ButtonRestaurarActionPerformed

    private void ButtonCalcularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ButtonCalcularKeyPressed
        if ((int) evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            ButtonCalcularActionPerformed(null);
        }
    }//GEN-LAST:event_ButtonCalcularKeyPressed

    private void jTextFieldTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTKeyPressed
        if ((int) evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            ButtonCalcularActionPerformed(null);
        }
    }//GEN-LAST:event_jTextFieldTKeyPressed

    private void jTextFieldVelocidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVelocidadKeyPressed
        if ((int) evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            ButtonCalcularActionPerformed(null);
        }
    }//GEN-LAST:event_jTextFieldVelocidadKeyPressed

    private void jTextFieldRugosidadInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRugosidadInicialKeyPressed
        if ((int) evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            ButtonCalcularActionPerformed(null);
        }
    }//GEN-LAST:event_jTextFieldRugosidadInicialKeyPressed

    private void jTextFieldRugosidadInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRugosidadInicialKeyTyped
        if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 45
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this,
                    "Solo se puede digitar numeros",
                    this.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldRugosidadInicialKeyTyped

    private void jTextFieldToleranciaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldToleranciaInicialKeyPressed
        if ((int) evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            ButtonCalcularActionPerformed(null);
        }
    }//GEN-LAST:event_jTextFieldToleranciaInicialKeyPressed

    private void jTextFieldToleranciaInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldToleranciaInicialKeyTyped
        if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 45
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this,
                    "Solo se puede digitar numeros",
                    this.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
        } else {
            jLabelDiametro.setVisible(true);
            jLabelRangosDiametro.setVisible(true);
            jTextFieldDiametro.setVisible(true);

        }


    }//GEN-LAST:event_jTextFieldToleranciaInicialKeyTyped

    private void jTextFieldDiametroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiametroKeyPressed
        if ((int) evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            ButtonCalcularActionPerformed(null);
        }
    }//GEN-LAST:event_jTextFieldDiametroKeyPressed

    private void jTextFieldDiametroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiametroKeyTyped
        if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 45
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this,
                    "Solo se puede digitar numeros",
                    this.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldDiametroKeyTyped

    private void jTextFieldRugosidadInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRugosidadInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRugosidadInicialActionPerformed

    private void jTextFieldDiametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDiametroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDiametroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCalcular;
    private javax.swing.JButton ButtonRestaurar;
    private javax.swing.JButton ButtonVolver;
    private javax.swing.JLabel errorDi;
    private javax.swing.JLabel errorRi;
    private javax.swing.JLabel errorT;
    private javax.swing.JLabel errorTi;
    private javax.swing.JLabel errorV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelDiametro;
    private javax.swing.JLabel jLabelLogo;
    public javax.swing.JLabel jLabelProfundidad;
    public javax.swing.JLabel jLabelRangosDeRugosidad;
    private javax.swing.JLabel jLabelRangosDiametro;
    public javax.swing.JLabel jLabelRangosProfundidad;
    public javax.swing.JLabel jLabelRangosTolerancia;
    public javax.swing.JLabel jLabelRangosVelocidad;
    private javax.swing.JLabel jLabelRugosidadInicial;
    private javax.swing.JLabel jLabelToleranciaInicial;
    public javax.swing.JLabel jLabelVelocidad;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField jTextFieldDiametro;
    private javax.swing.JTextField jTextFieldRugosidadInicial;
    public javax.swing.JTextField jTextFieldT;
    private javax.swing.JTextField jTextFieldToleranciaInicial;
    public javax.swing.JTextField jTextFieldVelocidad;
    // End of variables declaration//GEN-END:variables
}
