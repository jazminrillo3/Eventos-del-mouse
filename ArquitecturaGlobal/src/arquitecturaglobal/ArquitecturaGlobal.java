package arquitecturaglobal;

public class ArquitecturaGlobal {

    public static void main(String[] args) {
        
        Window window = new Window();
        window.setVisible(true);
        
        OyenteMenu oyente = new OyenteMenu(window);
        window.lapiz.addMouseListener(oyente);
        window.click.addMouseListener(oyente);
        window.minijuego.addMouseListener(oyente);
        
    }
    
}
