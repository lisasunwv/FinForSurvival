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
public class spawnSeq implements ActionListener
{
    private Timer timer; 
    private Map mapRef;
    private int holeCount;
    public spawnSeq(Map myMap)
    {
        mapRef = myMap;
        holeCount = 0;
        timer = new javax.swing.Timer(3000, this);
        //Start.randomHoleSpawn(mapRef);
        
    }
    
    public void startSpawn()
    {
        if(mapRef.getLevel() == 1)
        {
        }
        else if(mapRef.getLevel() == 2)
        {
            timer.setDelay(1000);
        }
        else if(mapRef.getLevel() == 3)
        {
            timer.setDelay(800);
        }
        randomFishSpawn();
        randomTrashSpawn();
        
        timer.start();
    }
    
    public void stopSpawn()
    {
        timer.stop(); 
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource() == timer)
        {
          // Start.randomHoleSpawn(mapRef);
          double rando = Math.random();
            if (rando < .33)
            {
               randomFishSpawn();
            }
            else if (rando < .66)
           {
              randomFishSpawn();
           }
           else
          {
              randomTrashSpawn();
          }
          
          randomHoleSpawn();
       }
    }
    
    public void randomFishSpawn()
    {
        Fish newFish = new Fish("fish.png", mapRef);
        newFish.set(1200, (int) (Math.random() *1000));
    }
    
    public void randomTrashSpawn()
    {
        Trash newTrash1 = new Trash("banana.png", mapRef);
        Trash newTrash2 = new Trash("chipbag.png", mapRef);
        Trash newTrash3 = new Trash("fishbone.png", mapRef);
        newTrash1.set(1200, (int) (Math.random() * 1000));
        newTrash2.set(1200, (int) (Math.random() * 1000));
        newTrash3.set(1200, (int) (Math.random() * 1000));
    }
    
    public void randomHoleSpawn()
    {
        if(holeCount == 0 && mapRef.getLevel() == 1)
        {
            Hole newHole1 = new Hole("hole1.png", mapRef);
            newHole1.set((int) (Math.random() * 1200), (int) (Math.random() * 550));
            holeCount = 1;
        }
        else if(holeCount == 1 && mapRef.getLevel() == 2)
        {
            Hole newHole1 = new Hole("hole1.png", mapRef);
            Hole newHole2 = new Hole("hole1.png", mapRef);
            newHole1.set((int) (Math.random() * 1200), (int) (Math.random() * 550));
            newHole2.set((int) (Math.random() * 1200), (int) (Math.random() * 550));
            holeCount = 2;
        }
        else if(holeCount == 2 && mapRef.getLevel() == 3)
        {
            Hole newHole1 = new Hole("hole1.png", mapRef);
            Hole newHole2 = new Hole("hole1.png", mapRef);
            Hole newHole3 = new Hole("hole1.png", mapRef);
            newHole1.set((int) (Math.random() * 1200), (int) (Math.random() * 550));
            newHole2.set((int) (Math.random() * 1200), (int) (Math.random() * 550));
            newHole3.set((int) (Math.random() * 1200), (int) (Math.random() * 550));
            holeCount = 3;
        }   
    }

}
