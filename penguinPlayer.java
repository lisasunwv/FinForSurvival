import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent

import javax.swing.*;       // access to JFrame and Jcomponents
import javax.swing.event.*;     // access to JSlider events

import apcslib.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class penguinPlayer extends Entity implements ActionListener
{
    private int fishGotten;
    private boolean loop = true;
    public penguinPlayer(String spriteArt, Map myMap)
    {
        super(spriteArt, myMap);
        id = "penguin";
        height = 45;
        width = 64;
        Timer timer = new javax.swing.Timer(1, this);
        timer.start();
        loop = false;
    }

    public int interact(Entity other)
    {
        if (other.isOfType("fish"))
        {
            fishGotten++;
            return 1;
        }
        else if (other.isOfType("seal"))
        {
            //System.out.print(fishGotten);
            return 2;
        }
        else if (other.isOfType("hole"))
        {
            return 2;
        }
        else if (other.isOfType("trash"))
        {
            return 2;
        }
        return 0;
    }

    public void act()
    {
        super.act();
        bindEntity();

        if (velocityX > 5)
        {
            velocityX = 5;
        }
        else if (velocityX < -5)
        {
            velocityX = -5;
        }
        
        if (velocityY > 5)
        {
            velocityY = 5;
        }
        else if (velocityY < -5)
        {
            velocityY = -5;
        }
    }
    
    public int returnFishCount()
    {
        return fishGotten;
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        if (loop == false)
        {
            setSprite("penguin1.png");
            loop = true;
        }
        else
        {
            setSprite("penguin2.png");
            loop = false;
        }
    }
}
