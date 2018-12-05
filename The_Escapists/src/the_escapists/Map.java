/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;

import java.awt.*;

public class Map {
    static int ydelta;
    static int xdelta;
    static private Image Wall_Block2;
    static private Image Wall_Block_Sideway;
    static private Image StoneImage;
    static private Image GrassBlock;
    static private Image DoorBlock;
    static final int numRows = 17;
    static final int numColumns = 11;
//Possible values for the board.
    static final int GRASS = 0;
    static final int WALL = 1;
    static final int VOID = 2;
    static final int END = 3;
    static final int PATH = 4;
    static final int STONE = 5;
    static final int DOOR = 6;

    static int board[][] = {
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS},     
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS},
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS},  
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS},
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS}, 
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS},
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS},  
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS}, 
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS}, 
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS},
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS}, 
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS},
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS},  
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS}, 
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS}, 
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS},
   {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS}
   }; 
    
    
    public static void reset(){
         ydelta = Window.getHeight2()/numRows;
         xdelta = Window.getWidth2()/numColumns;


         Wall_Block2 = Toolkit.getDefaultToolkit().getImage("./Wall_Block2.png");
         Wall_Block_Sideway = Toolkit.getDefaultToolkit().getImage("./Wall_Block_SideWay.png");
         GrassBlock =  Toolkit.getDefaultToolkit().getImage("./needGrassFixed.jpg");
         StoneImage =  Toolkit.getDefaultToolkit().getImage("./Stone.png");
         DoorBlock =  Toolkit.getDefaultToolkit().getImage("./Door.png");
    }
    
    public static void draw(Graphics2D g,The_Escapists frame){
        
       for (int zrow=0;zrow<numRows;zrow++)
        {
            for (int zcolumn=0;zcolumn<numColumns;zcolumn++)
            {
                if (board[zrow][zcolumn] == WALL)
                {
                    if(zcolumn <= 0 || zcolumn >= numColumns-1)
                        if(zrow == 0 || zrow == numRows-1)
                           g.drawImage(Wall_Block2,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                        else
                           g.drawImage(Wall_Block_Sideway,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                    
                    else 
                    g.drawImage(Wall_Block2,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                }
                else if(board[zrow][zcolumn] == VOID){
                    g.setColor(Color.black);
                    g.fillRect(Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta);
                }
                else if(board[zrow][zcolumn] == GRASS){
                    g.drawImage(GrassBlock,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                }
                 else if(board[zrow][zcolumn] == PATH){
                    g.drawImage(StoneImage,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                }
                 else if(board[zrow][zcolumn] == STONE){
                    g.drawImage(StoneImage,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                }
                 else if(board[zrow][zcolumn] == DOOR){
                    g.drawImage(DoorBlock,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                }
            }
        }
    }
    
}
  


