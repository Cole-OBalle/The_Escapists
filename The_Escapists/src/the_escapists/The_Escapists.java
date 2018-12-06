

package the_escapists;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.util.ArrayList;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class The_Escapists extends JFrame implements Runnable {
        static The_Escapists runMe;
    
    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
    
    int xpos;
    int ypos;
    int value = 1;
    private static final long serialVersionUID = 1L;
    private int camX, camY, camH, camW;
    private World world;
    
    
    Player player = new Player(Toolkit.getDefaultToolkit().getImage("./Player Face Down.png"));

    static The_Escapists frame;
    public static void main(String[] args) {
        frame = new The_Escapists();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public The_Escapists() {
        camX = xpos - Window.WINDOW_WIDTH / 2;
        camY =xpos - Window.WINDOW_WIDTH / 2;
        camW = Window.getWidth2();       
        camH = Window.getHeight2();   
        world = new World(0, 0, 1000, 1000);
        addMouseListener(new MouseAdapter() {            
            public void mousePressed(MouseEvent e) {
                
                if (e.BUTTON1 == e.getButton()) {
                    //left button

// location of the cursor.
                    xpos = e.getX();
                    ypos = e.getY();                                        
                    camX = xpos - Window.WINDOW_WIDTH / 2;
                    camY = ypos - Window.WINDOW_HEIGHT / 2;
                    
                    
                    
                    
                    if (camX > Window.offsetMaxX)
                        camX = Window.offsetMaxX;
                    else if (camX < Window.offsetMinX)
                        camX = Window.offsetMinX;
                    if (camY > Window.offsetMaxY)
                        camY = Window.offsetMaxY;
                    else if (camY < Window.offsetMinY)
                        camY = Window.offsetMinY;
                    
                }
                if (e.BUTTON3 == e.getButton()) {
                    //right button
                    reset();
                }
                repaint();
            }
        });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

               if (e.VK_W == e.getKeyCode()) {
                   value = 1;
                    player.changeY(-10);
                }
               else if (e.VK_S== e.getKeyCode()) {
                   value = 2;
                    player.changeY(10);
                }
               else if (e.VK_A ==e.getKeyCode()) {
                   value = 3;
                    player.changeX(-10);
                }
               else if (e.VK_D== e.getKeyCode()) {
                   value = 4;
                    player.changeX(10);
                }
               else if (e.VK_ESCAPE== e.getKeyCode()) {
                   System.exit(0);
                }
                if(e.getKeyCode() != e.VK_S && e.getKeyCode() != e.VK_W){
                    player.changeY(0);
                }
                if(e.getKeyCode() != e.VK_D && e.getKeyCode() != e.VK_A){
                    player.changeX(0);
                }
                
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }



////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        g.setColor(Color.gray);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.gray);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.black);
        g.drawPolyline(x, y, 5);
        
        
        
        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
               
        Main.Draw(g, frame, player, value);
        world.UpdateWindow();
        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .05;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        Main.reset(player);
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            reset();
        }
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }
}
