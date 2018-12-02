
package the_escapists;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    
    public static void Draw(Graphics2D g,The_Escapists frame,Player player){
         Map.draw(g, frame);
        player.Draw(g, frame,50,100);
    }

    
    public static void reset(Player player){
        Map.reset();
        Character.reset();
        player.reset();
    }
    public static void Animate(Player player){
        player.animate();
    }
//    public static void reset(){
//        Character.reset();
//        Map.reset();
//     }

    
}

