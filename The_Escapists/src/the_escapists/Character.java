
package the_escapists;
<<<<<<< HEAD
import java.awt.Image;
import java.awt.Graphics2D;
=======

>>>>>>> 018c746df99eefe268844f60bf12b1f7b5bd584b
public class Character {
    protected int xPos;
    protected int yPos;
    protected Image image;
    Character(){
        
    }
    public void Move(){
        
    }
    public void Draw(Graphics2D g, The_Escapists frame, int width, int height){
        g.drawImage(image, xPos, yPos, width, height, frame);
    }
}
