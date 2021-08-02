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
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller
{
    protected KeyListener playerControls;
    protected Entity puppet;

    public KeyListener getController()
    {
        return playerControls;
    }

    public Controller(Entity a)
    {
        puppet = a;
        playerControls = new KeyListener()
        {
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_W && puppet.isOfType("penguin"))
                {
                    if (puppet.getForceY() > 0)
                    {
                        puppet.setForceY(0);
                    }
                    puppet.force(0, -2);
                }
                
                if (e.getKeyCode() == KeyEvent.VK_A && puppet.isOfType("penguin"))
                {
                    if (puppet.getForceX() > 0)
                    {
                        puppet.setForceX(0);
                    }
                    puppet.force(-2, 0);
                }
                
                if (e.getKeyCode() == KeyEvent.VK_D && puppet.isOfType("penguin"))
                {
                    if (puppet.getForceX() < 0)
                    {
                        puppet.setForceX(0);
                    }
                    puppet.force(2, 0);
                }
                
                if (e.getKeyCode() == KeyEvent.VK_S && puppet.isOfType("penguin"))
                {
                    if (puppet.getForceY() < 0)
                    {
                        puppet.setForceY(0);
                    }
                    puppet.force(0, 2);
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT && puppet.isOfType("seal"))
                {
                    puppet.force(-2, 0);
                }
                
                if (e.getKeyCode() == KeyEvent.VK_RIGHT && puppet.isOfType("seal"))
                {
                    puppet.force(2, 0);
                }
                
                if (e.getKeyCode() == KeyEvent.VK_DOWN && puppet.isOfType("seal"))
                {
                    puppet.force(0, 2);
                }
                
                if (e.getKeyCode() == KeyEvent.VK_UP && puppet.isOfType("seal"))
                {
                    puppet.force(0, -2);
                }
            }

            public void keyTyped(KeyEvent e)
            {

            }

            public void keyReleased(KeyEvent e)
            {

            }
        };
    }

}
