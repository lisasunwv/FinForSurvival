import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Write a description of class Trash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trash extends Entity implements ActionListener
{
	private boolean loop;
    public Trash(String spriteArt, Map map)
    {
        super(spriteArt, map);
        height = 32;
        width = 32;
        id = "trash";
        velocityX = -2;
    }
    
    public void actionPerformed(ActionEvent evt)
    {
    	if (loop == false)
    	{
    		setSprite("banana.png");
    		loop = true;
    	}
    	else
    	{
    		setSprite("fishbone.png");
    		loop = false;
    	}
    		
    }
}

