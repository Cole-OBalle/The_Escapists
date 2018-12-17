/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics2D;
public class Menu {
    private static Image jokeTitleScreen = Toolkit.getDefaultToolkit().getImage("./Assets/Title Screens/Joke Title Screen.png");
    private static Image titleScreen = Toolkit.getDefaultToolkit().getImage("./Assets/Title Screens/Title Screen.jpg");
    private static boolean start = false;
    public static void Draw(Graphics2D g, The_Escapists frame){
        g.drawImage(titleScreen, -350, 0, 1623,Window.getHeight2(), frame);
    }
    public static void reset(){
        start = false;
    }
    public static boolean getStart(){
        return start;
    }
}
