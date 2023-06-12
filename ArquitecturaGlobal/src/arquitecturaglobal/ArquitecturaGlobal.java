package arquitecturaglobal;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ArquitecturaGlobal {

    public static void main(String[] args) {
        
        Window window = new Window();
        window.setVisible(true);
        
        OyenteMenu menuListener = new OyenteMenu(window);
        menuListener.changeIcon(window.lapiz);
        menuListener.changeIcon(window.click);
    }
    
}
