/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;
import java.awt.*;
public class World {
    
    private static int CameraX;
    private static int CameraY;
    private static int x, y, w, h;
    Player player = new Player(Toolkit.getDefaultToolkit().getImage("./Player Face Down.png"));
    public World(int _x, int _y, int _w, int _h) {               
        x = _x;
        y = _y;
        w = _w;
        h = _h;
        CameraX = player.getX();
        CameraY = player.getY();
    }

    public void UpdateWindow(){
        CameraX = player.getX();
        CameraY = player.getY();
        
        System.out.println(CameraX + " "  + CameraY);
        
        
        
        
    }
    
    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;  
    }

    public static int getWidth() {
        return w;
    }

    public static int getHeight() {
        return h;
    }
}

