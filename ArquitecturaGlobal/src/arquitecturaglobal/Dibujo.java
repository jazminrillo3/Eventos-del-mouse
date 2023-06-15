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

public class Dibujo extends JPanel {

    //Listar referencias Point 
    private final ArrayList<Point> puntos = new ArrayList<>();
    private Color color;

    public Dibujo(Color color) {
        
        this.color = color;
        
        //Le ajusto el tamaño y ubicación
        setBounds(100, 0, 590, 456);
        setBackground(new Color(255,255,255));
        
        addMouseMotionListener(new MouseMotionAdapter() {
            //Se llama cuando el mouse es presionado y arrastrado
            //Almacena las coordenadas de arrastre y vuelve a dibujar
            @Override
            public void mouseDragged(MouseEvent evento) {
                puntos.add(evento.getPoint());
                repaint(); //vuelve a dibujar el Jframe
            }
        }
        );
        
    }

    // Sobrescribimos el método paintComponent que extiende de JPanel
    // Se llama automáticamente por el sistema de representación gráfica cuando es necesario actualizar o volver a dibujar el componente en la pantalla
    // Dibuja ovalos en el panel en la ubicaciones especificadas en la ventana
    @Override
    public void paintComponent(Graphics g) {
        //Borra el area
        super.paintComponent(g);
        
        //Dibuja todos los puntos
        for(Point punto : puntos){
            g.setColor(color);
            g.fillOval(punto.x, punto.y, 10, 10);
        }
    }
}
    
