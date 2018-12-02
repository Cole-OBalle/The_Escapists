/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;

import java.awt.Color;
import java.awt.Graphics2D;

public class Map {
    
    static final int numRows = 17;
    static final int numColumns = 11;
//Possible values for the board.
    static final int PATH = 0;
    static final int WALL = 1;
    static final int STAR = 2;
    static final int _END = 3;

    static int board[][] = {
   {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},     
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},  
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL}, 
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},  
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL}, 
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL}, 
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL}, 
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},  
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL}, 
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL}, 
   {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
   {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}
   }; 
} 
  


