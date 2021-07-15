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

/**
 *
 * @author Alberto Enrique Alonso De la Hoz
 * @author Cristian Eduardo Coronado Santiago
 */
public class Mecanizado {

    private double t;
    private double va;
    private double vc;
    private double ri;
    double tolerancia;
    double diametro;
    public double mejoraDeRugosidad = 0;
    public double mejoraDePrecision = 0;
    public double rugosidadFinal = 0;
    public double toleranciaFinal = 0;

    public Mecanizado() {
        this(0, 0, 0, 0, 0, 0);
    }

    public Mecanizado(double t, double va, double vc, double ri, 
            double tolerancia, double diametro) {
        this.t = t;
        this.va = va;
        this.vc = vc;
        this.ri = ri;
        this.tolerancia = tolerancia;
        this.diametro = diametro;
    }

    

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    public double getVa() {
        return va;
    }

    public void setVa(double va) {
        this.va = va;
    }

    public double getVc() {
        return vc;
    }

    public void setVc(double vc) {
        this.vc = vc;
    }

    public double getRi() {
        return ri;
    }

    public void setRi(double ri) {
        this.ri = ri;
    }

    public double getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(double tolerancia) {
        this.tolerancia = tolerancia;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }
    
    
    public Double[] calculoDeValores(double tipo, double material, Mecanizado 
            meca) {

        Double i[] = new Double[4];
        double j = tipo;
        int    k = (int)material;
        double prof = meca.getT();
        double velocidadAvance = meca.getVa();
        double velocidadCorte = meca.getVc();
        double rugosidad = meca.getRi();
        double tolerancia = meca.getTolerancia();
        double diametro = meca.getDiametro();

        if (j == 1) {
            switch (k) {
                case 1:
                   i[0] = mejoraDeRugosidad = 111.51 - 0.0001559
                            *Math.pow(velocidadAvance, 2) - 40.912*prof;
                   i[1] = mejoraDePrecision = -67.1998*Math.pow(prof, 2)
                            - 0.13873*velocidadAvance + 55.9768*prof
                            + 0.216373*(velocidadAvance*prof);
                   i[2] = rugosidadFinal = rugosidad * (1 -(i[0]/100));
                   i[3] = toleranciaFinal = ((i[1]*diametro)/100)-tolerancia;
                    break;
                case 2:
                   i[0] = mejoraDeRugosidad = 93.4695 - 0.000107722
                            *Math.pow(velocidadAvance, 2) - 0.0776549
                            *(velocidadAvance*prof);
                   i[1] = mejoraDePrecision = 15.8553 - 0.15405*velocidadAvance
                            -16.6856*prof + 0.2383*(velocidadAvance*prof);
                   i[2] = rugosidadFinal = rugosidad * (1 -(i[0]/100));
                   i[3] = toleranciaFinal = ((i[1]*diametro)/100)-tolerancia;
                    break;
                default:
                    i[0] = mejoraDeRugosidad = 110.637 - 0.000374384
                            *Math.pow(velocidadAvance, 2) - 87.1604*prof;
                    i[1] =mejoraDePrecision = 10.879 - 0.0006745
                            *Math.pow(velocidadAvance, 2)
                            + 0.109876*velocidadAvance - 14.4126*prof
                            + 0.069943*(velocidadAvance*prof);
                    i[2] = rugosidadFinal = rugosidad * (1 -(i[0]/100));
                    i[3] = toleranciaFinal = ((i[1]*diametro)/100)-tolerancia;
                    break;
            }
        } else {
            switch (k) {
                case 1:
                   i[0] = mejoraDeRugosidad = 2.124*velocidadCorte +
                           137.2*prof - 3.017*(velocidadCorte*prof);
                   i[1] = mejoraDePrecision = 0.1570*velocidadCorte
                           + 0.15699*prof - 0.29177*(velocidadCorte*prof);
                   i[2] = rugosidadFinal = rugosidad * (1 -(i[0]/100));
                   i[3] = toleranciaFinal = ((i[1]*diametro)/100)-tolerancia;
                    break;
                case 2:
                   i[0] = mejoraDeRugosidad = 1.399*velocidadCorte 
                           + 105.9*prof - 2.133*(velocidadCorte*prof);
                   i[1] = mejoraDePrecision = 0.11038 + 12.105*prof
                           -0.2718*(velocidadCorte*prof);
                   i[2] = rugosidadFinal = rugosidad * (1 -(i[0]/100));
                   i[3] = toleranciaFinal = ((i[1]*diametro)/100)-tolerancia;
                    break;
                default:
                    i[0] = mejoraDeRugosidad = 1.5159*velocidadCorte
                            +98.2862*prof - 2.1053*(velocidadCorte*prof);
                    i[1] =mejoraDePrecision = 0.224114*velocidadCorte
                            +14.549*prof - 0.33938*(velocidadCorte*prof);
                    i[2] = rugosidadFinal = rugosidad * (1 -(i[0]/100));
                    i[3] = toleranciaFinal = ((i[1]*diametro)/100)-tolerancia;
                    break;
            }
            

        }
        
        Util.mostrarMensaje(
        " Mejora De Rugosidad = " +i[0] +
        "\n Mejora de precisión = " +i[1] +
        "\n Rugosidad final estimada = " + i[2] +
        "\n Tolerancia final estimada = " +i[3]);

        return i;
    }

}
