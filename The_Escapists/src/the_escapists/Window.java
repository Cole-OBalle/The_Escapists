

package the_escapists;

public class Window {
    static final int XBORDER = 0;
    static final int TOP_BORDER = 0;
    static final int BOTTOM_BORDER = 0;
    
    static final int YTITLE = 30;
    static final int WINDOW_BORDER = 0;
    static final int WINDOW_WIDTH = 1000;
    static final int WINDOW_HEIGHT = 1000;
    static int xsize = -1;
    static int ysize = -1;


/////////////////////////////////////////////////////////////////////////
    public static int getX(int x) {
        return (x + XBORDER + WINDOW_BORDER);
    }
    public static int getY(int y) {
        return (y + TOP_BORDER + YTITLE);
    }
    
    public static int getYNormal(int y) {
        return (-y + TOP_BORDER + YTITLE + getHeight2());
    }
 

    public static int getWidth2() {
        return (xsize - 2 * (XBORDER + WINDOW_BORDER));
    }
    public static int getHeight2() {
        return (ysize - (TOP_BORDER + YTITLE) - BOTTOM_BORDER);
    }
}
