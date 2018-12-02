/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_escapists;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Character {
    private static Image Character_Image = Toolkit.getDefaultToolkit().getImage("./Character.png");
    private static int xLength;
    private static int yLength;
    private static int x;
    private static int y;
    
    
    public static void reset(){
        xLength = 100;
        yLength = 100;
        x=xLength/2;
        y=yLength/2;
    }
    
    public static void draw(Graphics2D g,The_Escapists frame){
        g.drawImage(Character_Image,x,y,xLength,yLength,frame);
    }
    
}


