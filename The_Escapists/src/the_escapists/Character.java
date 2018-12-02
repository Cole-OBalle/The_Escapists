/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;
import java.awt.Image;
import java.awt.Graphics2D;
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
