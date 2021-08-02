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

import chn.util.*;

import java.util.ArrayList;
/**
 * Write a description of class Map here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map implements ActionListener 
{
    private ArrayList<Entity> allEntities;
    private Timer timer;
    private spawnSeq spawnS;
    private int level;
    private int result;
    public Map()
    {
        allEntities = new ArrayList<Entity>();
        timer = new javax.swing.Timer(17, this);
        spawnS = new spawnSeq(this);
        level = 1;
    }

    public void startClock()
    {
        timer.start();
        spawnS.startSpawn() ;
    }

    public void stopClock()
    {
        timer.stop();
        spawnS.stopSpawn();

    }

    public void actionPerformed(ActionEvent evt)
    {
        triggerAction();
        doCollisions();
        result = updateResult();
        if(result == 1000)
        {
            stopClock();
        }
        else if(level == 1 && result >= 2)
        {
            level = 2;
            startClock();
        }
        else if(level == 2 && result >= 5)
        {
            level = 3;
            startClock();
        }
        else if(level == 3 && result >= 10)
        {
            stopClock();
        }
    }
    
    public int getLevel()
    {
        return level;
    }
    //Entity Methods Below
    public void addEntity(Entity a)
    {
        allEntities.add(a);
    }

    public void removeEntity(Entity a)
    {
        allEntities.remove(a);
    }

    public ArrayList<Entity> getList()
    {
        return allEntities;
    }

    public void doCollisions()
    {
        ArrayList<Entity> temp = new ArrayList<Entity>();
        for (Entity a : allEntities)
        {
            temp.addAll(Collision.testForCollision(a, allEntities));
        }

        for (Entity a : temp)
        {
            removeEntity(a);
        }
    }

    public void triggerAction()
    {
        for (Entity a : allEntities)
        {
            a.act();
        }
    }

    public int getResult()
    {
        return result;
    }   

    public int updateResult()
    {
        boolean penguinFlag = false;
        int result = 0;
        for (Entity a : allEntities)
        {
            if (a.isOfType("penguin"))
            {
                penguinFlag = true;
                result = ((penguinPlayer)a).returnFishCount();
            }
        }

        if(penguinFlag == false)
        {
            result = 1000;
        }
              
        return result;
    }
}
