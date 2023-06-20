package arquitecturaglobal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

class OyenteMenu implements MouseListener{
    
    private final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    private Color celeste = new Color(168, 218, 220);
    private Color rosa = new Color(230, 57, 70);

    private Window window;
    private JLabel label;
    
    private Dibujo dibujo;

    public OyenteMenu(Window window) {
        this.window = window;
    }

    // Se ejecuta cuando se hace clic en el JLabel
    @Override
    public void mouseClicked(MouseEvent e) {
        // Obtener el JLabel fuente del evento
        label = (JLabel) e.getSource();
        
        window.cantClicks.setText("0");
        mostrarPanel(window);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    // Se ejecuta cuando el mouse entra en el área del label
    @Override
    public void mouseEntered(MouseEvent e) {
        // Obtener el JLabel fuente del evento
        label = (JLabel) e.getSource();
        
        // Actualizar el fondo, icono y cursor del JLabel
        label.setBackground(celeste);
        String ruta = "/iconos/" + label.getName() + "Azul.png";
        label.setIcon(new ImageIcon(getClass().getResource(ruta)));
        label.setCursor(handCursor);
        
        // Mostrar el componente hover correspondiente
        mostrarHover(label, true);
    }

    // Se ejecuta cuando el mouse sale del área del JLabel
    @Override
    public void mouseExited(MouseEvent e) {
        // Actualizar el fondo y el icono del JLabel
        label.setBackground(rosa);
        String ruta = "/iconos/" + label.getName() + "Celeste.png";
        label.setIcon(new ImageIcon(getClass().getResource(ruta)));
        // Ocultar el componente hover 
        mostrarHover(label, false);
    }

    // Mostrar u ocultar el componente hover según el JLabel
    private void mostrarHover(JLabel item, boolean mostrar) {
        if (item.getName().equals("lapiz")) {
            window.lapizHover.setVisible(mostrar);
        } else if (item.getName().equals("click")) {
            window.clickHover.setVisible(mostrar);
        }
    }

    // Mostrar el panel correspondiente según el JLabel presionado
    private void mostrarPanel(Window window) {
        if (label.getName().equals("lapiz")) {
            
            if (dibujo != null) {
                window.getContentPane().remove(dibujo);
            }
            
            // Crear un panel Dibujo y lo agrego en la ventana
            dibujo = new Dibujo(window);
            
            //Agrego un oyente para el menú del dibujo 
            Color colorPincel = new Color(0,0,0);
            OyenteDibujo oyente = new OyenteDibujo(dibujo);
            window.borrador.addMouseListener(oyente);
            window.amarillo.addMouseListener(oyente);
            window.azul.addMouseListener(oyente);
            window.rojo.addMouseListener(oyente);
            
            window.getContentPane().add(dibujo);
            
            // Mostrar/ocultar los paneles apropiados
            window.panelDibujar.setVisible(true);
            window.panelClickear.setVisible(false);
            
            
        } else if (label.getName().equals("click")) {
            // Mostrar/ocultar los paneles apropiados
            window.panelDibujar.setVisible(false);
            window.panelClickear.setVisible(true);
            
            // Crear una instancia de OyenteClick
            OyenteClick oyente = new OyenteClick(window);
            window.panelClickear.addMouseListener(oyente);
        }
    }

}
