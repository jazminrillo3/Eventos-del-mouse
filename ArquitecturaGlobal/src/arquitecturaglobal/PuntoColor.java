/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arquitecturaglobal;

import java.awt.Color;
import java.awt.Point;

public class PuntoColor {

    private Point punto;
    private Color color;
    private int ancho;
    private int alto;

    public PuntoColor(Point punto, Color color, int ancho, int alto) {
        this.punto = punto;
        this.color = color;
        this.ancho = ancho;
        this.alto = alto;
    }

    public Point getPunto() {
        return punto;
    }

    public Color getColor() {
        return color;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
    

}
