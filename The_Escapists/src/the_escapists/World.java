/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;

public class World {
    private int x, y, w, h;
    private Camera camera;

    public World(Camera cam, int x, int y, int w, int h) {
        camera = cam;               
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
}

