/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arquitecturaglobal;

import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Dibujo extends JPanel{

    //Listar referencias Point 
    private final ArrayList<PuntoColor> puntos = new ArrayList<>();
    
    private Color colorPincel;
    private int alto = 10;
    private int ancho = 10;

    public Dibujo(Window window) {
        
        colorPincel = new Color(0,0,0);
        
        //Le ajusto el tamaño y ubicación
        setBounds(110, 0, 590, 456);
        setBackground(new Color(255,255,255));
        
        addMouseMotionListener(new MouseMotionAdapter() {
            //Se llama cuando el mouse es presionado y arrastrado
            //Almacena las coordenadas de arrastre y vuelve a dibujar
            @Override
            public void mouseDragged(MouseEvent evento) {
                puntos.add(new PuntoColor(evento.getPoint(), colorPincel, ancho, alto));
                repaint(); //vuelve a dibujar el Jframe
            }
        }
        );
        
    }
    
    public void setColorPincel(Color colorPincel) {
        this.colorPincel = colorPincel;
    }
    
    public void setAncho(int ancho){
        this.ancho = ancho;
    }

    public void setAlto(int alto){
        this.alto = alto;
    }
    
    // Sobrescribimos el método paintComponent que extiende de JPanel
    // Se llama automáticamente por el sistema de representación gráfica cuando es necesario actualizar o volver a dibujar el componente en la pantalla
    // Dibuja ovalos en el panel en la ubicaciones especificadas en la ventana
    @Override
    public void paintComponent(Graphics g) {
        //Borra el area
        super.paintComponent(g);
        
        //Dibuja todos los puntos
        for(PuntoColor puntoColor : puntos){
            g.setColor(puntoColor.getColor());
            Point punto = puntoColor.getPunto();
            g.fillOval(punto.x, punto.y, puntoColor.getAncho(), puntoColor.getAlto());
        }
    }
}
    
