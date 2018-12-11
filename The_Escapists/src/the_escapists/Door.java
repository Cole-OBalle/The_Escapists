/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;
    import java.awt.Image;
    import java.awt.*;

public class Door {
    private Image state;
    public static enum DoorType{
        NORMAL,LOCKED,STAFF,MAILMAN,JANITOR,MECHANIC,PLUMBER,LAUNDRY
    }
    private int row;
    private int column;
    private DoorType type;
    
    Door(int zrow, int zcolumn, DoorType _type){
        row = zrow;
        column = zcolumn;
        type = _type;
        state = Toolkit.getDefaultToolkit().getImage("./Assets/Doors/Door.png");
    }
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
    public DoorType getType(){
        return type;
    }
    public Image getImage(){
        return state;
    }
}
