
import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent
import javax.swing.*;       // access to JFrame and Jcomponents
import javax.swing.event.*;     // access to JSlider events

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends JFrame implements ActionListener
{
    private JButton start, help, control, exit;
    private JPanel menuSelect;
    private JFrame f, helpF, controlF;
    private JTextArea helpText,controlText;
    private JPanel menuLayout;
    //private int helpMessage;
    public Menu(JFrame newFrame)
    {
        f = newFrame;
    }

    public static void main(String[] args)
    {
        JFrame f = new JFrame("Menu");
        Menu myMenu = new Menu(f);
        myMenu.initFrame(f);
    }    

    public void initFrame(JFrame f)
    {
        f.setLayout(new FlowLayout());

        menuLayout = new JPanel();
        start = new JButton("Start");
        control = new JButton("Controls");
        help = new JButton("Help");
        exit = new JButton("Exit");
        menuLayout.setLayout(new GridLayout(4,2));
        menuLayout.add(start);
        menuLayout.add(control);
        menuLayout.add(help);
        menuLayout.add(exit);
        f.add(menuLayout);

        setFocusable(true);
        requestFocusInWindow();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 250);
        f.setVisible(true);
        start.addActionListener(this);
        control.addActionListener(this);
        help.addActionListener(this);
        exit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource() == start)
        {
            Map map = new Map();
            penguinPlayer player1 = new penguinPlayer("penguin1.png", map);
            sealPlayer player2 = new sealPlayer("seal1.png", map);
            Controller sealController = new Controller(player2);
            Controller penguinController = new Controller(player1);

            Renderer render = new Renderer(map);
            JFrame g = new JFrame("GUI Practice");
            render.initFrame(g);
            render.addController(sealController);
            render.addController(penguinController); 
            f.dispose();
        }
        else if (evt.getSource() == exit)
        {
            f.dispose();
        }
        else if (evt.getSource() == help)
        {           
            helpF = new JFrame("Help");  
            helpText = new JTextArea("1. Penguin eats fish to get to next level."
                + "\n    Avoid eating trash, Don't falling into hole."
                + "\n    Avoid the seal. \n2. Seal catches penguin."
                + "\n    Seal becomes paralyzed"
                + "\n    if it falls into hole.");

            helpF.setSize(300, 200);
            helpF.add(helpText);
            helpF.setVisible(true);
        }
        else if (evt.getSource() == control)
        {
            controlF = new JFrame("Controls");
            controlText = new JTextArea("Penguin: \n  Up: W\n  Down: S\n  Left: A\n  Right: D\n\n"
                + "Seal: \n  Up: Up Arrow\n  Down: Down Arrow\n  Left: Left Arrow\n  Right: Right Arrow");
            controlF.setSize(250, 250);
            controlF.add(controlText);
            controlF.setVisible(true);
        }
    }
}
