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
import java.net.URL;
/**
 * Write a description of class Renderer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Renderer extends JPanel implements ActionListener
{
    private Map mapRef;
    private JFrame fRef;
    private JButton start;
    private JButton stop;
    private JButton exit;
    //private JButton help;
    private JButton retry;
    private JTextField fishCount;
    private JLabel gameOver;
    private JLabel Levels;
    private JLabel win;
    public Renderer(Map myMap)
    {
        mapRef = myMap;
    }

    public void addController(Controller controls)
    {
        addKeyListener(controls.getController());
    }
    
    public void initFrame(JFrame f)
    {
        fRef = f;
        f.setLayout(new BorderLayout(5,5));
        f.add(this);
        JPanel bPanel = new JPanel();
        JPanel rPanel = new JPanel();
        start = new JButton("Start");
        stop = new JButton("Stop");
        exit = new JButton("Exit");
        //help = new JButton("Help");
        retry = new JButton("Try Again");
        
        fishCount = new JTextField("Fish Count: 0");
        fishCount.setEditable(false);
        fishCount.setForeground(Color.RED);
        Font font = new Font("SansSerif", Font.BOLD, 25);
        fishCount.setFont(font); 
        
        f.add(bPanel, BorderLayout.SOUTH);
        f.add(rPanel, BorderLayout.NORTH);
        
        bPanel.add(fishCount);
        bPanel.add(start);
        bPanel.add(stop);
        bPanel.add(exit);
        //bPanel.add(help);
        bPanel.add(retry);
        retry.setVisible(false);
        //retry.setVisible(false);
        
        gameOver = new JLabel("Game is over: YOU LOSE");
        gameOver.setFont(new Font("Serif", Font.BOLD, 40));
        Levels =  new JLabel("Level 1");
        Levels.setFont(new Font("Serif", Font.BOLD, 15));
        win = new JLabel("Game is over: YOU WIN");
        win.setFont(new Font("Serif", Font.BOLD, 40));
        rPanel.add(Levels);
        rPanel.add(gameOver);
        rPanel.add(win);
        gameOver.setVisible(false);
        win.setVisible(false);
        
        
        setFocusable(true);
        requestFocusInWindow();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1300, 700);
        f.setVisible(true);
        start.addActionListener(this);
        stop.addActionListener(this);
        exit.addActionListener(this);
        //help.addActionListener(this);
        retry.addActionListener(this);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (Entity a : mapRef.getList())
        {
            g.drawImage(a.getSprite(), a.getXPos(), a.getYPos(), this);
        }
    }

    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource() == start)
        {
            Timer timer = new javax.swing.Timer(20, this);
            timer.start();
            requestFocusInWindow();
            mapRef.startClock();
        }
        else if (evt.getSource() == stop)
        {
             mapRef.stopClock();
        }
        //else if (evt.getSource() == help)//this can be turned into another class
        //{
        //    JFrame f = new JFrame("help");
        //    f.setLayout(new FlowLayout());
        //   JTextArea helpText = new JTextArea("Penguin movements: ASWD \nSeal Movements: UP/DOWN/LEFT/RIGHT");
        //    f.getContentPane().add(helpText);
        //    f.setSize(350, 350);
        //    f.setVisible(true);
        //}
        else if (evt.getSource() == exit)
        {
             System.exit(0); 
        }
        else if (evt.getSource() == retry)
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
            fRef.setVisible(false);           
        }
        else
        {
            if( mapRef.getResult() == 1000)
            {
               gameOver.setVisible(true);
               start.setEnabled(false);
               stop.setEnabled(false);
               retry.setVisible(true);
               retry.setEnabled(true);    
            }
            else
            {
                fishCount.setText("Fish Count:" + mapRef.updateResult());
            }
            
            if(mapRef.updateResult() >= 2 && mapRef.updateResult() < 5)
            {
                Levels.setText("Level 2");
            }
            else if(mapRef.updateResult() >= 5 && mapRef.updateResult() < 10)
            {
                Levels.setText("Level 3");
            }
            else if(mapRef.updateResult() == 10)
            {
               win.setVisible(true);
               retry.setVisible(true);
               retry.setEnabled(true);  
               //mapRef.stopClock();
            }
            repaint();
        }
    }    
}
