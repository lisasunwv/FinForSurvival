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
public class sealPlayer extends Entity implements ActionListener
{
    private boolean loop;
    public sealPlayer(String spriteArt, Map myMap)
    {
        super(spriteArt, myMap);
        id = "seal";
        height = 60;
        width = 137;
        Timer timer = new javax.swing.Timer(80, this);
        timer.start();
        loop = false;
        positionX = 0;
        positionY = 500;
    }

    public int interact(Entity other)
    {
        if (other.isOfType("penguin"))
        {
            return 1;
        }
        else if (other.isOfType("hole"))
        {
            return 3;
        }
        return 0;
    }

    public void act()
    {
        super.act();
        bindEntity();

        if (velocityX > 6)
        {
            velocityX = 6;
        }
        else if (velocityX < -6)
        {
            velocityX = -6;
        }

        if (velocityY > 6)
        {
            velocityY = 6;
        }
        else if (velocityY < -6)
        {
            velocityY = -6;
        }

    }
    
    public void actionPerformed(ActionEvent evt)
    {
        if (loop == false)
        {
            setSprite("seal1.png");
            loop = true;
        }
        else
        {
            setSprite("seal2.png");
            loop = false;
        }

    }

	
}
