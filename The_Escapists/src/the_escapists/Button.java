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
    private Image currentState;
    private int xPos;
    private int yPos;
    private boolean clicked;
    private int width;
    private int height;    
    
    Button(Image _normal, Image _selected, int _xPos, int _yPos, int _width, int _height){
        imageNormal = _normal;
        imageSelected = _selected;
        currentState = imageNormal;
        xPos = _xPos;
        yPos =_yPos;
        width = _width;
        height = _height;
    }
    
    public void hoverOverButton(int mouseX, int mouseY){
        if(mouseX >= xPos && mouseX <= xPos + 209 && mouseY >= yPos && mouseY <= yPos + 101){
            currentState = imageSelected;
        }else{
            currentState = imageNormal;
        }
        
    }
    public boolean selectButton(int mouseX, int mouseY){
        if(mouseX >= xPos && mouseX <= xPos + 209 && mouseY >= yPos && mouseY <= yPos + 101){
            return true;
        }else{
            return false;
        }
    }
    public void clicked(boolean state){
        clicked = state;
    }
    public Image getNormal(){
        return(imageNormal);
    }
    
    public Image getSelected(){
        return imageSelected;
    }
    public Image getCurrentState(){
        return currentState;
    }
    public int getX(){
        return xPos;
    }
    
    public int getY(){
        return yPos;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}
