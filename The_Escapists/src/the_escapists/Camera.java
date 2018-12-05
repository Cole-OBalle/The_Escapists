/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


public class Camera extends JPanel implements KeyListener {
    //add world to camera...
    private static final long serialVersionUID = 1L;
    private int camX, camY, camH, camW;
    private Sprite sprite;
    private PlayerCamera player;
    private World world;

    public Camera(int x, int y, int w, int h) {
        camX = x;
        camY = y;
        camW = w;       
        camH = h;   
        sprite = new Sprite(this, 300, 300, 20, 20);
        player = new PlayerCamera(this, camW/2, camH/2, 25, 40);
        world = new World(this, 0, 0, 1000, 1000);

        addKeyListener(this);
        setFocusable(true);
    }

    public int getWidth() {
        return camW;
    }

    public int getHeight() {
        return camH;
    }    
    
    @Override   
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);

        //cam is 500 x 500
        g.setColor(Color.gray);
        g.fillRect(camX, camY, camW, camH);     

        //draw sprite at JPanel location if in camera sight
        if (((sprite.getX()-camX) >= camX) && ((sprite.getX()-camX) <= (camX+camW)) && ((sprite.getY()-camY) >= camY) && ((sprite.getY()-camY) <= (camY+camH))) {
            g.setColor(Color.green);
            g.fillRect(sprite.getX()-camX, sprite.getY()-camY, 20, 20); 

            //Cam Sprite Location
            g.setColor(Color.white);
            g.drawString("Camera Sprite Location: (" + (sprite.getX()-camX) + ", " + (sprite.getY()-camY) + ")", sprite.getX()-camX, sprite.getY()-camY);                   
        }

        //Player location (center of Camera... Camera follows player)
        g.setColor(Color.cyan);
        g.fillRect(player.getX()-player.getWidth(), player.getY()-player.getWidth(), player.getWidth(), player.getHeight());

        g.setColor(Color.white);
        //World Sprite Location
        g.drawString("World Sprite Location: (" + sprite.getX() + ", " + sprite.getY() + ")", sprite.getX(), sprite.getY());

        //Cam Player Location
        g.drawString("Cam Player Location: (" + (camW/2-player.getWidth()) + ", " + (camH/2-player.getHeight()) + ")", camW/2-player.getWidth(), camH/2-player.getHeight());
    }

    public void keyPressed(KeyEvent e) {
        //move camera right in relation to World
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            camX+=5;
        }
        //move camera left in relation to World
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            camX-=5;
        }
        //move camera up in relation to World
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            camY-=5;
        }
        //move camera down in relation to World
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            camY+=5;
        }
        repaint();
    }   
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

}

