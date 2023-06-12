package arquitecturaglobal;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelMouse extends JPanel{
    
    private int x = 0;
    private int y = 0;
    private boolean band = false;
    
    public void addEvents(OyenteMouse e){
    }
    
    public void setCoordenadas(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setBandera(boolean band){
        this.band = band;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.translate(x, y);
        g.fillOval(-10, -10, 20, 20);
        if(band){
            g.setColor(Color.red);
            g.drawRect(-25,-20,50,40);
            band = false;
        }
    }
    
}
