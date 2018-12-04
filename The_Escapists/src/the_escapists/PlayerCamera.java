/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;
   import java.awt.Dimension;

public class PlayerCamera {
    private int x, y, w, h;
    private Camera cam;

    public PlayerCamera(Camera cm, int x, int y, int w, int h) {
        cam = cm;               
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;  
    }

    public int getWidth() {
        return this.w;
    }

    public int getHeight() {
        return this.h;
    }

    public void setX(int val) {
        this.x += val;
    }

    public void setY(int val) {
        this.y += val;
    }   
}

