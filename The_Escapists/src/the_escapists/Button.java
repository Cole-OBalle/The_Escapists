/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;
    import java.awt.Image;
public class Button {
    private Image imageNormal;
    private Image imageSelected;
    private int xPos;
    private int yPos;
    
    Button(Image _normal, Image _selected, int _xPos, int _yPos){
        imageNormal = _normal;
        imageSelected = _selected;
        xPos = _xPos;
        yPos =_yPos;
    }
    
    public Image getNormal(){
        return(imageNormal);
    }
    
    public Image getSelected(){
        return imageSelected;
    }
    
    public int getX(){
        return xPos;
    }
    
    public int getY(){
        return yPos;
    }
}
