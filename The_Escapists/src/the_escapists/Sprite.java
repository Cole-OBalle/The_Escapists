/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;
 import java.awt.Color;
import java.awt.Graphics;

public class Sprite{
    private int xLoc, yLoc, width, height;
    private Camera world;

    public Sprite(Camera wld, int x, int y, int w, int h) {
        xLoc = x;
        yLoc = y;
        width = w;
        height = h;
        world = wld;    
    }

    public int getX() {
        return xLoc;
    }

    public int getY() {
        return yLoc;    
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public void paintComponent(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(xLoc, yLoc, width, height);      
    }


}

