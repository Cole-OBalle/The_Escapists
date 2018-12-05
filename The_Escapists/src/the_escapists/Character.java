
package the_escapists;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Character {
    protected int xPos;
    protected int yPos;
    protected static Image image;
    Character(){
         xPos = 100;
         yPos = 100;
    }
    public void Move(){
        
    }
    public void Draw(Graphics2D g, Camera frame, int width, int height){
        g.drawImage(image, xPos, yPos, width, height, frame);
    }
    public static void reset(){
        
    }

}