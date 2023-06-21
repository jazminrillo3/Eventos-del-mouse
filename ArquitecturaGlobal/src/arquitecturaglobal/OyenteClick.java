package arquitecturaglobal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OyenteClick implements MouseListener{
    
    private int clicks=1;
    private final Color celeste = new Color(168, 218, 220);
    
    private final Window window;

    public OyenteClick(Window window) {
        this.window = window;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        window.cantClicks.setText( Integer.toString(clicks++) );
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Se llama cuando se mantiene presionado el botón.
        window.panelClickear.setBackground(celeste);    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Se invoca cuando has dejado de presionar el boton del mouse.
        window.panelClickear.setBackground(null);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        window.panelClickear.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        window.panelClickear.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
}
