package arquitecturaglobal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

class OyenteMenu implements MouseListener{
    
    private final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    private final Color celeste = new Color(168, 218, 220);
    private final Color rosa = new Color(230, 57, 70);

    private final Window window;
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
        mostrarHover(true);
    }

    // Se ejecuta cuando el mouse sale del área del JLabel
    @Override
    public void mouseExited(MouseEvent e) {
        // Actualizar el fondo y el icono del JLabel
        label.setBackground(rosa);
        String ruta = "/iconos/" + label.getName() + "Celeste.png";
        label.setIcon(new ImageIcon(getClass().getResource(ruta)));
        // Ocultar el componente hover 
        mostrarHover(false);
    }

    // Mostrar u ocultar el componente hover según el JLabel
    private void mostrarHover(boolean mostrar) {
        if (label.getName().equals("lapiz")) {
            window.lapizHover.setVisible(mostrar);
        } else if (label.getName().equals("click")) {
            window.clickHover.setVisible(mostrar);
        } else if (label.getName().equals("minijuego")) {
            window.minijuegoHover.setVisible(mostrar);
        }
    }

    // Mostrar el panel correspondiente según el JLabel presionado
    private void mostrarPanel(Window window) {
        setearPaneles();
        
        switch (label.getName()) {
            case "lapiz":
                // Mostrar/ocultar los paneles apropiados
                window.panelDibujar.setVisible(true);
                
                if (dibujo != null) {
                    window.getContentPane().remove(dibujo);
                }
                
                // Crear un panel Dibujo y lo agrego en la ventana
                dibujo = new Dibujo(window);
                window.add(dibujo);
                
                //Agrego un oyente para el menú del dibujo
                OyenteDibujo oyenteDibujo = new OyenteDibujo(dibujo);
                
                window.borrador.addMouseListener(oyenteDibujo);
                window.amarillo.addMouseListener(oyenteDibujo);
                window.azul.addMouseListener(oyenteDibujo);
                window.rojo.addMouseListener(oyenteDibujo);
                
                break;
                
            case "click":
                // Mostrar/ocultar los paneles apropiados
                window.panelClickear.setVisible(true);
                
                window.cantClicks.setText("0");
                // Crear una instancia de OyenteClick
                OyenteClick oyenteClick = new OyenteClick(window);
                window.panelClickear.addMouseListener(oyenteClick);
                break;
                
            case "minijuego":
                // Mostrar/ocultar los paneles apropiados
                window.panelInstrucciones.setVisible(true);
                window.panelMinijuego.setVisible(true);
                
                if (oyenteMinijuego != null) {
                    window.panelMinijuego.remove(oyenteMinijuego.getImagen());
                }
                
                oyenteMinijuego = new OyenteMinijuego(window);
                break;
        }
    }
    
    public void setearPaneles(){
        window.panelDibujar.setVisible(false);
        window.panelClickear.setVisible(false);
        window.panelMinijuego.setVisible(false);
        window.panelInstrucciones.setVisible(false);
    }

}
