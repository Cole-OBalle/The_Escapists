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
    static private Image Wall_Block;
    static private Image Wall_Block1;
    static private Image Wall_Block2;
    static private Image Wall_Block3;
    static private Image Wall_Block_Sideway;
    static final int numRows = 17;
    static final int numColumns = 11;
//Possible values for the board.
    static final int GRASS = 0;
    static final int WALL = 1;
    static final int VOID = 2;
    static final int END = 3;

    static int board[][] = {
   {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},     
   {WALL,VOID,VOID,VOID,VOID,VOID,VOID,VOID,VOID,VOID,WALL},
   {WALL,VOID,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,VOID,WALL},  
   {WALL,VOID,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,VOID,WALL},
   {WALL,VOID,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,VOID,WALL}, 
   {WALL,VOID,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,VOID,WALL},
   {WALL,VOID,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,VOID,WALL},  
   {WALL,VOID,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,VOID,WALL}, 
   {WALL,VOID,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,VOID,WALL}, 
   {WALL,VOID,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,VOID,WALL},
   {WALL,VOID,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,VOID,WALL}, 
   {WALL,VOID,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,VOID,WALL},
   {WALL,VOID,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,VOID,WALL},  
   {WALL,VOID,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,VOID,WALL}, 
   {WALL,VOID,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,VOID,WALL}, 
   {WALL,VOID,VOID,VOID,VOID,VOID,VOID,VOID,VOID,VOID,WALL},
   {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}
   }; 
    
    
    public static void reset(){
         ydelta = Window.getHeight2()/numRows;
         xdelta = Window.getWidth2()/numColumns;

         Wall_Block = Toolkit.getDefaultToolkit().getImage("./Wall_Block.png");
         Wall_Block1 = Toolkit.getDefaultToolkit().getImage("./Wall_Block1.png");
         Wall_Block2 = Toolkit.getDefaultToolkit().getImage("./Wall_Block2.png");
         Wall_Block3 = Toolkit.getDefaultToolkit().getImage("./Wall_Block3.png");
         Wall_Block_Sideway = Toolkit.getDefaultToolkit().getImage("./Wall_Block_SideWay.png");
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
            }
        }
    }
    
} 
  


