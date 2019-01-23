/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics2D;
import java.util.ArrayList;
public class Menu {
    private static boolean start = false;
    private static Menu currentMenu;
    private Image image;
    private ArrayList<Button> buttons = new ArrayList<Button>();
    Menu(Image _image){
        image = _image;
    }
    public static void Draw(Graphics2D g, The_Escapists frame){
        g.drawImage(currentMenu.image, -350, 0, 1623,Window.getHeight2(), frame);
        for(Button button : currentMenu.buttons){
            g.drawImage(button.getCurrentState(),button.getX(),button.getY(),frame);
        }
    }
    public static void reset(Menu startMenu){
        start = false;
        currentMenu = startMenu;
    }
    public void addButton(Image normal, Image selected, int xPos, int yPos, int width, int height){
        buttons.add(new Button(normal, selected, xPos, yPos, width, height));
    }
    public void buttonClicked(Button button, int mouseX, int mouseY){
        if(mouseX >= button.getX() && mouseX <= button.getX() + button.getWidth() && mouseY >= button.getY() && mouseY <= button.getY()+button.getHeight())
        {
            button.clicked(true);
        }
    }
    public static boolean getStart(){
        return start;
    }
    public ArrayList<Button> getButtons(){
        return buttons;
    }
}
