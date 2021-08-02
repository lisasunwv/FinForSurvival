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
import java.net.URL;
/**
 * Write a description of class Entity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entity
{
    protected int velocityX;
    protected int velocityY;
    protected int positionX;
    protected int positionY;
    protected int accelerationX;
    protected int accelerationY;
    protected int height;
    protected int width;
    protected Image sprite;
    protected String id;
    protected Map myMap;
    //spriteArt is the name of the image used for our entity
    public Entity(String spriteArt, Map map)
    {
    	ClassLoader cldr = this.getClass().getClassLoader();
        ImageIcon spriteIcon = new ImageIcon(cldr.getResource(spriteArt));
        sprite = spriteIcon.getImage();
        id = "";
        
        myMap = map;
        myMap.addEntity(this);
    }
    
    public void setSprite(String spriteArt)
    {
    	ClassLoader cldr = this.getClass().getClassLoader();
    	ImageIcon spriteIcon = new ImageIcon(cldr.getResource(spriteArt));
        sprite = spriteIcon.getImage();
    } 
    
    public int getHeight()
    {
        return height;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getXPos()
    {
        return positionX;
    }
    
    public int getYPos()
    {
        return positionY;
    }
    
    public Image getSprite()
    {
        return sprite;
    }
    
    public void act()
    {
        velocityX += accelerationX;
        velocityY += accelerationY;
        
        positionX += velocityX;
        positionY += velocityY;
    }
    
    public void set(int x, int y)
    {
        positionX = x;
        positionY = y;
    }
    
    public void move(int x, int y)
    {
        positionX += x;
        positionY += y;
    }
    
    public void force(int x, int y)
    {
        velocityX += x;
        velocityY += y;
    }
    
    public void setForceX(int x)
    {
    	velocityX = x;
    }
    
    public void setForceY(int y)
    {
    	velocityY = y;
    }
    
    public int getForceX()
    {
    	return velocityX;
    }
    
    public int getForceY()
    {
    	return velocityY;
    }
        
    public void accelerate(int x, int y)
    {
        accelerationX += x;
        accelerationY += y;
    }
    
    public int interact(Entity other)
    {
        return 0;
        //Fill this in in subclasses, base entity is a ghost, doesn't interact
    }
    
    protected void bindEntity()
    {
    	if (positionX > 1200) // stays within screen & change 20 to screen size
        {
        	positionX = 1200;
        }
        else if (positionX < 30)
        {
        	positionX = 30;
        }
        
        if (positionY > 550)
        {
        	positionY = 550;
        }
        else if (positionY < 30)
        {
        	positionY = 30;
        }
    }
    
    public boolean isOfType(String type)
    {
        if (id.equals(type))
        {
            return true;
        }
        return false;
    }
}
