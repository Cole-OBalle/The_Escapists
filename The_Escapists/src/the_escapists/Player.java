/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;
import java.awt.Image;
public class Player extends Character {
    Player(Image _image){
        image = _image;
        xPos = Window.getX(0);
        yPos = Window.getY(0);
    }
}
