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
import java.util.Iterator;
/**
 * Write a description of class Collision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Collision
{
    //toComp is the entity that is tested for collision with EVERY OTHER entity within the map
    //Code used is modified version of code given at the first answer on https://stackoverflow.com/questions/335600/collision-detection-between-two-images-in-java
    public static ArrayList<Entity> testForCollision(Entity toComp, ArrayList<Entity> list)
    {
        Iterator<Entity> iter = list.iterator();
        ArrayList<Entity> marked = new ArrayList<Entity>();
        for (Entity e : list)
        {
            if (toComp != e)
            {
                Rectangle a = new Rectangle(toComp.getXPos(), toComp.getYPos(), 
                toComp.getWidth(), toComp.getHeight());

                Rectangle b = new Rectangle(e.getXPos(), e.getYPos(), e.getWidth(), e.getHeight());
                if (a.intersects(b))
                {
                    int interaction = toComp.interact(e);
                    if (interaction == 1)
                    {
                        marked.add(e);
                    }
                    else if (interaction == 2)
                    {
                    	marked.add(toComp);
                    }
                    else if (interaction == 3)
                    {
                    	marked.add(toComp);
                    }
                }
            }
        }
        
        return marked;
    }
}
