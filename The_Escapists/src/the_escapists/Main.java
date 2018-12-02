
package the_escapists;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    
    public static void Draw(Graphics2D g,The_Escapists frame,Player player){
        player.Draw(g, frame,50,100);
        Map.draw(g, frame);
    }
<<<<<<< HEAD
    public static void reset(){
        Character.reset();
        Map.reset();
     }
=======
    public static void reset(Player player){
        player.reset();
    }
    public static void Animate(Player player){
        player.animate();
    }
//    public static void reset(){
//        Character.reset();
//        Map.reset();
//     }
>>>>>>> Cole
    
}

