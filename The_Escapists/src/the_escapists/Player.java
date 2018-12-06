/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package the_escapists;
    import java.awt.Image;
    import java.awt.*;
    public class Player extends Character {
        static private Image FrontImage;
        static private Image BackImage;
        static private Image LeftImage;
        static private Image RightImage;
    
    public static void reset(){
        FrontImage = Toolkit.getDefaultToolkit().getImage("./Player_Up.png");
        BackImage = Toolkit.getDefaultToolkit().getImage("./Player_Down.png");
        LeftImage = Toolkit.getDefaultToolkit().getImage("./Player_Left.png");
        RightImage = Toolkit.getDefaultToolkit().getImage("./Player_Right.png");
    }
    Player(Image _image){
        image = _image;
        xPos = Window.WINDOW_WIDTH/2;
        yPos = Window.WINDOW_HEIGHT/2;
    }
    public void animate(){
        Move();
    }

    public void CharacterDir(int value,Graphics2D g,The_Escapists frame){
        switch(value){
        case 1: {
                g.drawImage(FrontImage,xPos,yPos,55,100,frame);
                break;
        }case 2:{
                g.drawImage(BackImage,xPos,yPos,50,100,frame);
                break;
        }case 3:{
                g.drawImage(LeftImage,xPos,yPos,50,105,frame);
                break;
        }case 4:{ 
                g.drawImage(RightImage,xPos,yPos,50,100,frame);
                break;
        } 
    }
}

    
    public void changeX(int dir){
        xPos += dir;
    }
    public void changeY(int dir){
        yPos += dir;
    }
    int getX(){
        return(xPos);
    }
    int getY(){
        return(yPos);
    }
    
    }
