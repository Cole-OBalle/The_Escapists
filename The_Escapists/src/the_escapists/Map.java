/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;

import java.awt.*;
import java.util.ArrayList;

public class Map {
    static int ydelta;
    static int xdelta;
    static private Image wallImage;
    static private Image StoneImage;
    static private Image GrassBlock;
    static private Image DoorClosed;
    static private Image DoorOpen;
    static final int numRows = 17;
    static final int numColumns = 17;
//Possible values for the board.
    static final int GRASS = 0;
    static final int WALL_ = 1;
    static final int VOID_ = 2;
    static final int _END_ = 3;
    static final int PATH_ = 4;
    static final int STONE = 5;
    static final int DOOR_ = 6;
//Door Arraylist Values    
    public static ArrayList<Map> doors = new ArrayList<Map>();
    private int doorColumn;
    private int doorRow;

    public static int board[][] = {
   {WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_},
   {WALL_,GRASS,GRASS,GRASS,DOOR_,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,WALL_},
   {WALL_,GRASS,GRASS,GRASS,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,GRASS,GRASS,GRASS,WALL_},  
   {WALL_,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,WALL_},
   {WALL_,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,WALL_},
   {WALL_,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,WALL_},  
   {WALL_,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,WALL_},   
   {WALL_,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,WALL_},
   {WALL_,GRASS,GRASS,GRASS,DOOR_,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,DOOR_,GRASS,GRASS,GRASS,WALL_},  
   {WALL_,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,WALL_}, 
   {WALL_,GRASS,GRASS,GRASS,WALL_,WALL_,WALL_,WALL_,DOOR_,WALL_,WALL_,WALL_,WALL_,GRASS,GRASS,GRASS,WALL_},
   {WALL_,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,WALL_},  
   {WALL_,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,WALL_},  
   {WALL_,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,WALL_},
   {WALL_,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,WALL_},  
   {WALL_,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,WALL_,GRASS,GRASS,GRASS,WALL_},
   {WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_,WALL_}
   }; 
    
    
    public static void reset(){
         ydelta = Window.getHeight2()/numRows;
         xdelta = Window.getWidth2()/numColumns;
         GrassBlock =  Toolkit.getDefaultToolkit().getImage("./Assets/Terrain/needGrassFixed.jpg");
         //GrassBlock =  Toolkit.getDefaultToolkit().getImage("./YEE.png");
         StoneImage =  Toolkit.getDefaultToolkit().getImage("./Assets/Terrain/Stone.png");
         DoorClosed =  Toolkit.getDefaultToolkit().getImage("./Assets/Doors/Door.png");
         DoorOpen = Toolkit.getDefaultToolkit().getImage("./Assets/Terrain/Stone.png");
         setDoors();
    }
    private static void setDoors(){
        for (int zrow=0;zrow<numRows;zrow++)
        {
            for (int zcolumn=0;zcolumn<numColumns;zcolumn++)
            {
                if(board[zrow][zcolumn] == Map.DOOR_){
                    doors.add(new Map(zrow,zcolumn));
                }
                
            }
        }
    }
    Map(int zrow, int zcolumn){
        doorRow = zrow;
        doorColumn = zcolumn;
    }
    public static void draw(Graphics2D g,The_Escapists frame, Player player){
        
       for (int zrow=0;zrow<numRows;zrow++)
        {
            for (int zcolumn=0;zcolumn<numColumns;zcolumn++)
            {
                if (board[zrow][zcolumn] == WALL_)
                {
                    wallImage = generateWall(g,frame,zrow,zcolumn);
                    g.drawImage(wallImage,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                }
                else if(board[zrow][zcolumn] == VOID_){
                    g.setColor(Color.black);
                    g.fillRect(Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta);
                }
                else if(board[zrow][zcolumn] == GRASS){
                    g.drawImage(GrassBlock,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                }
                 else if(board[zrow][zcolumn] == PATH_){
                    g.drawImage(StoneImage,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                }
                 else if(board[zrow][zcolumn] == STONE){
                    g.drawImage(StoneImage,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                }
                 else if(board[zrow][zcolumn] == DOOR_){
                    if(player.checkCollide(board, zrow, zcolumn, DOOR_)){
                        for(int i = 0; i<doors.size(); i++){
                            if(doors.get(i).doorRow == zrow && doors.get(i).doorColumn == zcolumn){
                                g.drawImage(DoorOpen,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                                break;
                            }else{
                                g.drawImage(DoorClosed,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);
                            }
                        }                       
                    }else{
                        g.drawImage(DoorClosed,Window.getX(zcolumn*xdelta),Window.getY(zrow*ydelta),xdelta,ydelta,frame);

                    }
                                    }
            }
        }
    }
    public static Image generateWall(Graphics2D g, The_Escapists frame, int zrow, int zcolumn){
        boolean wallNorth = false;
        boolean wallSouth = false;
        boolean wallEast = false;
        boolean wallWest = false;
        if(zrow > 0){
            if(board[zrow-1][zcolumn] == WALL_){
                wallNorth = true;
            }
        }
        if(zrow < numRows -1){
            if(board[zrow+1][zcolumn] == WALL_){
                wallSouth = true;
            }
        }
        if(zcolumn > 0){
            if(board[zrow][zcolumn -1 ] == WALL_){
                wallWest = true;
            }
        }
        if(zcolumn < numColumns -1){
            if(board[zrow][zcolumn+1] == WALL_){
                wallEast = true;
            }
        }
        if(wallNorth &&!wallSouth &&!wallEast &&!wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall Down End.png"));
        }else if(wallNorth && wallSouth &&!wallEast &&!wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall Up.png"));
        }else if(wallNorth && wallSouth && wallEast &&!wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall T Junction Right.png"));
        }else if(wallNorth && wallSouth && wallEast && wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall 4 Junction.png"));
        }else if(!wallNorth && wallSouth && wallEast && wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall T Junction Down.png"));
        }else if(wallNorth && !wallSouth && wallEast && wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall T Junction Up.png"));
        }else if(wallNorth && wallSouth &&!wallEast && wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall T Junction Left.png"));
        }else if(!wallNorth && wallSouth &&!wallEast &&!wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall Up End.png"));
        }else if(!wallNorth && !wallSouth && wallEast &&!wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall Straight End Left.png"));
        }else if(!wallNorth && !wallSouth && !wallEast && wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall Straight End Right.png"));
        }else if(wallNorth && !wallSouth && wallEast &&!wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall Corner Left Down.png"));
        }else if(wallNorth && !wallSouth &&!wallEast &&wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall Corner Right Down.png"));
        }else if(!wallNorth && wallSouth && wallEast &&!wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall Corner Left Up.png"));
        }else if(!wallNorth && wallSouth &&!wallEast && wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall Corner Right Up.png"));
        }else if(!wallNorth && !wallSouth && wallEast && wallWest){
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall Straight.png"));
        }else{
            return(Toolkit.getDefaultToolkit().getImage("./Assets/Walls/Wall Stand Alone.png"));
        }
                
        
    }
    
}
  


