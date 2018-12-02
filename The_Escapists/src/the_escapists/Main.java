
package the_escapists;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    
    public static void draw(Graphics2D g,The_Escapists frame){
        Character.draw(g, frame);
        Map.draw(g, frame);
    }
    public static void reset(){
        Character.reset();
        Map.reset();
     }
    
}


