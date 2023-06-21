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

public class OyenteMinijuego implements MouseListener, MouseMotionListener{
    
    private Window window;
    private JLabel imagen;
    
    private final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    private final Icon iconoMosquito = new ImageIcon(getClass().getResource("/iconos/mosquito.png"));
    private final Icon iconoArana = new ImageIcon(getClass().getResource("/iconos/arana.png"));
    private final Icon iconoBanana = new ImageIcon(getClass().getResource("/iconos/banana.png"));
    private final Icon iconoManzana = new ImageIcon(getClass().getResource("/iconos/manzana.png"));
    
    public OyenteMinijuego(Window window) {
        this.window = window;
        
        imagen = new JLabel();
        window.panelMinijuego.repaint();
        
        imagen.addMouseListener(this);
        imagen.addMouseMotionListener(this);
        
        aparecerImagen();
    }

    public JLabel getImagen() {
        return imagen;
    }
    
    public void aparecerImagen(){
        // Eliminar la imagen anterior si existe
        if (imagen != null) {
            window.panelMinijuego.remove(imagen);
        }
        
        // Generar una posición aleatoria para la nueva imagen
        // Verificar que la x e y no caigan donde está el tacho de basura
        int x,y;
        do {
            x = (int) (Math.random() * (560 - 0 + 1));
            y = (int) (Math.random() * (400 - 70 + 1)) + 70;
        } while (window.basura.getBounds().contains(new Point(x,y)));
        // getBounds() devuelve un objeto Rectangle que representa el rectángulo delimitador del componente en relación con su contenedor
        
        // Generar un número aleatorio entre 0 y 3
        int numero = (int) (Math.random() * 4);
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
        //Si se clickeó una imagen con un bicho, genero otra
        JLabel clickeado = (JLabel) e.getSource();
        if (clickeado.getName().equals("bicho")) {
            aparecerImagen();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JLabel presionado = (JLabel) e.getSource();
        if (presionado.getName().equals("basura")) {
            presionado.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JLabel soltado = (JLabel) e.getSource();
        if (soltado.getName().equals("basura")) {
            soltado.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            
            // Obtener los límites del área de "basura"
            Rectangle basura = window.basura.getBounds();
            // Obtener la ubicación actual del JLabel
            Point banana = imagen.getLocation();
            
            // Verificar si el JLabel arrastrado se soltó dentro del área de "basura"
            if (basura.contains(banana)){
                aparecerImagen();
            }
            window.panelMinijuego.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        imagen.setCursor(handCursor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {    
        JLabel arrastrado = (JLabel) e.getSource();
        if (arrastrado.getName().equals("basura")) {
            // Obtener la posición actual del JLabel
            int x = arrastrado.getLocation().x + e.getX() - arrastrado.getWidth() / 2;
            int y = arrastrado.getLocation().y + e.getY() - arrastrado.getHeight() / 2;
            arrastrado.setLocation(x, y);
        }
            
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }


}
