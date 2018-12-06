/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;

public class World {
    private int x, y, w, h;

    public World(int _x, int _y, int _w, int _h) {               
        x = _x;
        y = _y;
        w = _w;
        h = _h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;  
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }
}

