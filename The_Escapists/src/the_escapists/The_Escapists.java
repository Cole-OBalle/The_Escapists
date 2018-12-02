package the_escapists;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class The_Escapists extends JFrame implements Runnable {

    boolean animateFirstTime = true;
   
    Image image;
    Graphics2D g;
    
    static The_Escapists frame;
    public static void main(String[] args) {
        frame = new The_Escapists();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public The_Escapists() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.BUTTON1 == e.getButton()) {
                    //left button

// location of the cursor.
                    int xpos = e.getX();
                    int ypos = e.getY();

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
              
                    
                }else if (e.VK_S == e.getKeyCode()) {
                 
                   
                } else if (e.VK_A == e.getKeyCode()) {

                   
                } else if (e.VK_D == e.getKeyCode()) {

                }
                 else if (e.VK_SPACE == e.getKeyCode()) {
                    //
                }
                 else if (e.VK_Q == e.getKeyCode()) {
                   
                } else if (e.VK_UP == e.getKeyCode()) {
                   
                } else if (e.VK_E == e.getKeyCode()) {
                   
                }
                 else if (e.VK_R == e.getKeyCode()) {
                    //
                 }else if (e.VK_T == e.getKeyCode()) {
                   
                } else if (e.VK_Y == e.getKeyCode()) {
                   
                } else if (e.VK_U == e.getKeyCode()) {
                   
                }
                 else if (e.VK_I == e.getKeyCode()) {
                    //
                } else if (e.VK_O == e.getKeyCode()) {
                   
                } else if (e.VK_P == e.getKeyCode()) {
                   
                } else if (e.VK_LEFT == e.getKeyCode()) {
                   
                }
                 else if (e.VK_DOWN == e.getKeyCode()) {
                    //
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                   
                } else if (e.VK_F == e.getKeyCode()) {
                   
                } else if (e.VK_G == e.getKeyCode()) {
                   
                }
                 else if (e.VK_H == e.getKeyCode()) {
                    //
                } else if (e.VK_J == e.getKeyCode()) {
                   
                } else if (e.VK_K == e.getKeyCode()) {
                   
                } else if (e.VK_L == e.getKeyCode()) {
                   
                }
                 else if (e.VK_Z == e.getKeyCode()) {
                    //
                } else if (e.VK_X == e.getKeyCode()) {
                   
                } else if (e.VK_C == e.getKeyCode()) {
                   
                } else if (e.VK_V == e.getKeyCode()) {
                   
                }
                 else if (e.VK_B == e.getKeyCode()) {
                    //
                }
                else if (e.VK_S == e.getKeyCode()) {
                    //
                } else if (e.VK_D == e.getKeyCode()) {
                   
                } else if (e.VK_F == e.getKeyCode()) {
                   
                } else if (e.VK_G == e.getKeyCode()) {
                   
                }
                 else if (e.VK_H == e.getKeyCode()) {
                    //
                } else if (e.VK_J == e.getKeyCode()) {
                   
                } else if (e.VK_K == e.getKeyCode()) {
                   
                } else if (e.VK_L == e.getKeyCode()) {
                   
                }
                 else if (e.VK_Z == e.getKeyCode()) {
                    //
                } else if (e.VK_X == e.getKeyCode()) {
                   
                } else if (e.VK_C == e.getKeyCode()) {
                   
                } else if (e.VK_V == e.getKeyCode()) {
                   
                }
                 else if (e.VK_B == e.getKeyCode()) {
                    //
                }else if (e.VK_N == e.getKeyCode()) {
                    //
                } else if (e.VK_M == e.getKeyCode()) {
                   
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
        
        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }

 
       
        Main.draw(g,frame);
        
        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .02;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        Main.reset();

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


/////////////////////////////////////////////////////////////////////////
}