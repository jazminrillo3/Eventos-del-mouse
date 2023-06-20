package arquitecturaglobal;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class OyenteMinijuego implements MouseListener{
    
    private Window window;
    private JLabel imagen;
    
    private boolean arrastra = false;
    private boolean presiona = false;
    private int desdeX;
    private int desdeY;
    
    private final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    private Icon iconoMosquito = new ImageIcon(getClass().getResource("/iconos/mosquito.png"));
    private Icon iconoArana = new ImageIcon(getClass().getResource("/iconos/arana.png"));
    private Icon iconoBanana = new ImageIcon(getClass().getResource("/iconos/banana.png"));
    private Icon iconoManzana = new ImageIcon(getClass().getResource("/iconos/manzana.png"));
    
    public OyenteMinijuego(Window window) {
        this.window = window;
        imagen = new JLabel();
        window.panelMinijuego.repaint();
        
        agregarImagen();
    }

    public JLabel getImagen() {
        return imagen;
    }
    
    public void agregarImagen(){
        // Eliminar la imagen anterior si existe
        if (imagen != null) {
            window.panelMinijuego.remove(imagen);
        }
        // Generar una posición aleatoria para la nueva imagen
        int x = (int) (Math.random() * (560 - 0 + 1));
        int y = (int) (Math.random() * (400 - 70 + 1)) + 70;
        
        // Generar un número aleatorio entre 0 y 4
        int numero = (int) (Math.random() * 5);
        // Configurar la imagen y asignarle el nombre segun el numero obtenido
        switch (numero) {
            case 0:
                imagen.setIcon(iconoMosquito);
                imagen.setName("bicho");
                break;
            case 1:
                imagen.setIcon(iconoArana);
                imagen.setName("bicho");
                break;
            case 2:
                imagen.setIcon(iconoBanana);
                imagen.setName("basura");
                break;
            case 3:
                imagen.setIcon(iconoManzana);
                imagen.setName("basura");
                break;
        }
        
        // Establezco las coordenadas y tamaño de la imagen
        imagen.setBounds(x, y, 64, 64);
        window.panelMinijuego.add(imagen);
        window.panelMinijuego.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel clickeado = (JLabel) e.getSource();
        if (clickeado.getName().equals("bicho")) {
            agregarImagen();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JLabel presionado = (JLabel) e.getSource();
        if (presionado.getName().equals("basura")) {
            arrastra = true;
            desdeX = e.getX();
            desdeY = e.getY();
            window.panelMinijuego.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (arrastra) {
            JLabel arrastrado = (JLabel) e.getSource();
            // Mover la imagen a la nueva ubicación en función del desplazamiento del mouse
            arrastrado.setLocation(arrastrado.getX() + e.getX() - desdeX, arrastrado.getY() + e.getY() - desdeY);
            arrastra = false;
            
             // Obtener los límites del área de "basura"
            Rectangle basura = window.basura.getBounds();
            // Obtener la ubicación actual del JLabel
            Point banana = imagen.getLocation();
            
            // Verificar si el JLabel arrastrado se soltó dentro del área de "basura"
            if (basura.contains(banana)){
                agregarImagen();
            }
            window.panelMinijuego.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == imagen) {
            imagen.setCursor(handCursor);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


}
