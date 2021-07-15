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
package Model;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Alberto Enrique Alonso De la Hoz
 * @author Cristian Eduardo Coronado Santiago
 */
public class Util {
    
    
    
     public static void mostrarError(JLabel label) {
        label.setText("ERROR");
        label.setForeground(Color.red);
        label.setToolTipText("Vacio");
        label.setVisible(true);
    }
     
     public static void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje,
                "ERROR",
                JOptionPane.ERROR_MESSAGE);
    }
    
     public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje,
                "EXITOSO",
                JOptionPane.INFORMATION_MESSAGE);
    }
     
     public static void acercaMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje,
                "Cálculos de mejora, tolerancia y rugosidad",
                JOptionPane.INFORMATION_MESSAGE);
    }
     
    public static int convertirAEntero(Object dato) {
        if (dato == null) {
            return 0;
        }
        if (dato.toString().equalsIgnoreCase("")) {
            return 0;
        }
        return Integer.parseInt(dato.toString());
    } 
     
     public static void fondo(JFrame formulario, String ruta) {
        ((JPanel) formulario.getContentPane()).setOpaque(false);
        ImageIcon imagen = new ImageIcon(formulario.getClass().
                getResource(ruta));
        JLabel fondoL = new JLabel();
        fondoL.setIcon(imagen);
        formulario.getLayeredPane().add(fondoL, JLayeredPane.FRAME_CONTENT_LAYER);
        fondoL.setBounds(0, 0, imagen.getIconWidth(), imagen.getIconHeight());
        formulario.add(fondoL, BorderLayout.CENTER);
        formulario.setSize(fondoL.getWidth(), fondoL.getHeight());
    }
     
        
}
