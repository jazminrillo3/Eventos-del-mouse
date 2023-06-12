package arquitecturaglobal;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class OyenteMouse{
    
    private JPanel panel;
    private int cantClicks=1;

    public OyenteMouse(JPanel panel) {
        this.panel = panel;
    }
    
    public void contarClicks(Window window){
        MouseListener oyente = new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                window.cantClicks.setText(Integer.toString(cantClicks++));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //Se llama cuando se mantiene presionado el botón.
                panel.setBackground(Color.CYAN);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //Se invoca cuando has dejado de presionar el boton del mouse.
                panel.setBackground(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //Se llama cuando el mouse entra a los limites del componente.
                //Cuando sale y entra de la ventana (en este caso)
                System.out.println("Entraste al area del componente.");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //Se llama cuando el cursor sale de los limites del componente
                System.out.println("Saliste al area del componente.");
            }
        };
        
        MouseMotionListener oyenteMotion = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //Se llama cuando se mantiene presionado el boton y mueve el cursor.
                //panel.setCoordenadas(e.getX(), e.getY());
                //panel.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //Se llama al moverse el cursor
                System.out.println("Estas moviendo el cursor.");
            }
        };
        
        panel.addMouseListener(oyente);
        panel.addMouseMotionListener(oyenteMotion);
    }
    
}
