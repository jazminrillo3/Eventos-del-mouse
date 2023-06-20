package arquitecturaglobal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

class OyenteDibujo implements MouseListener{
    
    private final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    private Dibujo dibujo;
    
    private JLabel label;

    public OyenteDibujo(Dibujo dibujo) {
        this.dibujo = dibujo;
    }

    // Se ejecuta cuando se hace clic en el JLabel
    @Override
    public void mouseClicked(MouseEvent e) {
        // Obtener el JLabel fuente del evento
        label = (JLabel) e.getSource();
        dibujo.setColorPincel(label.getBackground());
        if (label.getBackground().equals(new Color(255,255,255))) {
            dibujo.setAncho(30);
            dibujo.setAlto(30);
        }else{
            dibujo.setAncho(10);
            dibujo.setAlto(10);
        }
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
        label = (JLabel) e.getSource();
        label.setCursor(handCursor);
    }

    // Se ejecuta cuando el mouse sale del área del JLabel
    @Override
    public void mouseExited(MouseEvent e) {
    }

}

