
package the_escapists;
import java.awt.Image;
import java.awt.Graphics2D;
import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
public class Character {
    protected int xPos;
    protected int yPos;
    protected Image image;
    Character(){
        
    }
    public void Move(){
        
    }
    public void Draw(Graphics2D g, The_Escapists frame, int width, int height){
        g.drawImage(image, xPos, yPos, width, height, frame);
    }
    public static void reset(){
        
    }

}