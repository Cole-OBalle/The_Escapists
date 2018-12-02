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
    static final int numRows = 17;
    static final int numColumns = 11;
//Possible values for the board.
    static final int GRASS = 0;
    static final int WALL = 1;
    static final int STAR = 2;
    static final int _END = 3;

    static int board[][] = {
   {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},     
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL},
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL},  
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL},
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL}, 
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL},
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL},  
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL}, 
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL}, 
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL},
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL}, 
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL},
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL},  
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL}, 
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL}, 
   {WALL,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL},
   {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}
   }; 
    
    
    public static void reset(){
         ydelta = Window.getHeight2()/numRows;
         xdelta = Window.getWidth2()/numColumns;
         Wall_Block = Toolkit.getDefaultToolkit().getImage("./Wall_Block.png");
    }
    
    public static void draw(Graphics2D g,The_Escapists frame){
        
       for (int zrow=0;zrow<numRows;zrow++)
        {
            for (int zcolumn=0;zcolumn<numColumns;zcolumn++)
            {
                if (Map.board[zrow][zcolumn] == Map.WALL)
                {
                    g.drawImage(Wall_Block,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                }
            }
        }
    }
    
} 
  


