/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arquitecturaglobal;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Dibujo extends JPanel {

    //Listar referencias Point 
    private final ArrayList<Point> puntos = new ArrayList<>();

    //establecer la gui y registra el manejador de eventos del raton
    public Dibujo() {

        addMouseMotionListener(
                new MouseMotionAdapter() {//clase interna anonima
            //almacena las coordenadas de arrastre y vuelve a dibujar
            @Override
            public void mouseDragged(MouseEvent evento) {
                puntos.add(evento.getPoint());
                repaint(); //vuelve a dibujar el Jframe
            }
        }
        );

    }

//dibuja ovalos en iun cuadro delimitador de 4x4 en la ubicaciones especificadas en la ventana
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//borra el area
        //dibuja todos los puntos
        for(Point punto : puntos)
         //   g.fill3DRect( punto.y, punto.y,punto.x, punto.x ,true);
       g.fillOval(punto.x, punto.y, 4, 4);
    }
}
    
