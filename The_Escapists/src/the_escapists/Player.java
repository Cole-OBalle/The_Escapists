/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package the_escapists;
    import java.awt.Image;
    import java.awt.*;
    import java.util.ArrayList;
    public class Player extends Character {
        static private Image FrontImage;
        static private Image BackImage;
        static private Image LeftImage;
        static private Image RightImage;
    
    public static void reset(){
        FrontImage = Toolkit.getDefaultToolkit().getImage("./Assets/Characters/Player_Up.png");
        BackImage = Toolkit.getDefaultToolkit().getImage("./Assets/Characters/Player_Down.png");
        LeftImage = Toolkit.getDefaultToolkit().getImage("./Assets/Characters/Player_Left.png");
        RightImage = Toolkit.getDefaultToolkit().getImage("./Assets/Characters/Player_Right.png");
    }
    Player(Image _image){
        image = _image;
        xPos = Window.getX(200);
        yPos = Window.getY(200);
    }
    public void animate(){
        Move();
    }

    public void CharacterDir(int value,Graphics2D g,The_Escapists frame){
        switch(value){
                case 1: {
                    g.drawImage(FrontImage,xPos,yPos,50,100,frame);
                    break;
                }case 2:{
                    g.drawImage(BackImage,xPos,yPos,50,100,frame);
                    break;
                }case 3:{
                    g.drawImage(LeftImage,xPos,yPos,50,100,frame);
                    break;
                }case 4:{ 
                    g.drawImage(RightImage,xPos,yPos,50,100,frame);
                    break;
                }    
        }

    }

    
    public void changeX(int dir){
        if(!checkCollide(Map.board, dir, 0, Map.WALL_) && goThroughDoor(dir,0)){
            xPos += dir;
        }    
    }
    public void changeY(int dir){
        if(!checkCollide(Map.board, 0, dir, Map.WALL_) && goThroughDoor( 0, dir)){
            yPos += dir;
        }
        
    }
    public boolean checkCollide(int[][] board, int xdir, int ydir, int BOARD_TYPE){
        int xdelta = Window.getWidth2()/Map.numColumns;
        int ydelta = Window.getHeight2()/Map.numRows;
        int currentXVal = 0;
        int currentYVal = 0;
        
        int topRightCornerRow = 0;
        int topRightCornerCol = 0;
        
        int topLeftCornerRow = 0;
        int topLeftCornerCol = 0;
        
        int bottomRightCornerRow = 0;
        int bottomRightCornerCol = 0;
        
        int bottomLeftCornerRow = 0;
        int bottomLeftCornerCol = 0;
        
        while(currentYVal*ydelta < yPos - 40 + ydir){
            currentYVal ++;
            topRightCornerRow ++;
            topLeftCornerRow ++;
        }
        currentYVal = 0;
        
       while(currentXVal*xdelta < xPos-45 + xdir){
            currentXVal ++;
            topRightCornerCol ++;
            bottomRightCornerCol++;
        }
        currentXVal = 0;
        
        while(currentYVal*ydelta < yPos + -15 + ydir){
            currentYVal ++;
            bottomRightCornerRow ++;
            bottomLeftCornerRow ++;
        }
        currentYVal = 0;
        
       while(currentXVal*xdelta < xPos - 17 + xdir){
            currentXVal ++;
            topLeftCornerCol ++;
            bottomLeftCornerCol++;
        }
        currentXVal = 0;
        
        if(board[topRightCornerRow][topRightCornerCol] == BOARD_TYPE || board[topLeftCornerRow][topLeftCornerCol] == BOARD_TYPE ||board[bottomRightCornerRow][bottomRightCornerCol] == BOARD_TYPE  ||board[bottomLeftCornerRow][bottomLeftCornerCol] == BOARD_TYPE){
            return(true);
        }else{
            return false;
        }
    }
        int getX(){
            return(xPos);
        }
        int getY(){
            return(yPos);
        }
    public boolean goThroughDoor(int xdir, int ydir){
        int xdelta = Window.getWidth2()/Map.numColumns;
        int ydelta = Window.getHeight2()/Map.numRows;
        
        int currentXVal = 0;
        int currentYVal = 0;
        
        int topRightCornerRow = 0;
        int topRightCornerCol = 0;
        
        int topLeftCornerRow = 0;
        int topLeftCornerCol = 0;
        
        int bottomRightCornerRow = 0;
        int bottomRightCornerCol = 0;
        
        int bottomLeftCornerRow = 0;
        int bottomLeftCornerCol = 0;
        
        while(currentYVal*ydelta < yPos - 40 + ydir){
            currentYVal ++;
            topRightCornerRow ++;
            topLeftCornerRow ++;
        }
        currentYVal = 0;
        
       while(currentXVal*xdelta < xPos-45 + xdir){
            currentXVal ++;
            topRightCornerCol ++;
            bottomRightCornerCol++;
        }
        currentXVal = 0;
        
        while(currentYVal*ydelta < yPos + -15 + ydir){
            currentYVal ++;
            bottomRightCornerRow ++;
            bottomLeftCornerRow ++;
        }
        currentYVal = 0;
        
       while(currentXVal*xdelta < xPos - 17 + xdir){
            currentXVal ++;
            topLeftCornerCol ++;
            bottomLeftCornerCol++;
        }
        currentXVal = 0;
        
        for(int i = 0; i<Map.doors.size(); i++){
            if((Map.doors.get(i).getRow() == topRightCornerRow ||
               Map.doors.get(i).getRow() == bottomRightCornerRow ||     
               Map.doors.get(i).getRow() == topLeftCornerRow ||     
               Map.doors.get(i).getRow() == bottomLeftCornerRow) &&
              (Map.doors.get(i).getColumn() == topRightCornerCol ||
               Map.doors.get(i).getColumn() == bottomRightCornerCol ||     
               Map.doors.get(i).getColumn() == topLeftCornerCol ||     
               Map.doors.get(i).getColumn() == bottomLeftCornerCol))
            {
                if(Map.doors.get(i).getType() == Door.DoorType.NORMAL){
                    Map.doors.get(i).changeState(true);
                    return(true);
                }else{
                    return false;
                }
            }
            else{
                Map.doors.get(i).changeState(false);
            }
        }
        
        return true;
    }
    }
    
