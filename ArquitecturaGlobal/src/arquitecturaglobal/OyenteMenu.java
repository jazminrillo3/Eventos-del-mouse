package arquitecturaglobal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class OyenteMenu {
    
    private final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    private Color celeste = new Color(168, 218, 220);
    private Color rosa = new Color(230, 57, 70);
    private Window window;

    public OyenteMenu(Window window) {
        this.window = window;
    }
    
    public void changeIcon(JLabel item){
        MouseListener oyente = new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                showPanel(item, window);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                item.setBackground(celeste);
                String ruta = "/iconos/"+item.getName()+ "Azul.png";
                item.setIcon(new ImageIcon(getClass().getResource(ruta)));
                item.setCursor(handCursor);
                showFunctionality(item, true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                item.setBackground(rosa);
                String ruta = "/iconos/"+item.getName()+ "Celeste.png";
                item.setIcon(new ImageIcon(getClass().getResource(ruta)));
                showFunctionality(item, false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
        };
        
        item.addMouseListener(oyente);
    }
    
    private void showFunctionality(JLabel item, boolean show){
        if (item.getName().equals("lapiz")) {
            window.lapizHover.setVisible(show);
        }else if (item.getName().equals("click")) {
            window.clickHover.setVisible(show);
        }
    }
    
    private void showPanel(JLabel item, Window window){
        if (item.getName().equals("lapiz")) {
            window.panelDibujar.setVisible(true);
            window.panelClickear.setVisible(false);
            OyenteMouse mouseListener = new OyenteMouse(window.panelDibujar);
            window.cantClicks.setText("0");
            
        }else if (item.getName().equals("click")) {
            window.panelDibujar.setVisible(false);
            window.panelClickear.setVisible(true);
            OyenteMouse mouseListener = new OyenteMouse(window.panelClickear);
            mouseListener.contarClicks(window);
            
        }
        
    }
    
}
