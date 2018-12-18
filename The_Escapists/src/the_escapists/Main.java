
package the_escapists;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void Draw(Graphics2D g,The_Escapists frame,Player player,int value){
        if(!Menu.getStart()){
            Menu.Draw(g, frame);
        }else{
            player.Draw(g, frame,50,100);
            player.CharacterDir(value, g, frame);
            Map.draw(g, frame, player);
        }
        
    }
    public static void reset(Player player, Menu startMenu){
        Map.reset();
        Character.reset();
        Player.reset();
        Menu.reset(startMenu);
        startMenu.addButton(Toolkit.getDefaultToolkit().getImage("./Assets/Buttons/Start Button.png"), Toolkit.getDefaultToolkit().getImage("./Assets/Buttons/Start Button Selected.png"), 150, 800);
        
    }
    public static void Animate(Player player){
        player.animate();
    }
//    public static void reset(){
//        Character.reset();
//        Map.reset();
//     }

    
}

