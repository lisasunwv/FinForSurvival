
/**
 * Write a description of class Hole here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hole extends Entity
{
    public Hole(String spriteArt, Map myMap)
    {
        super(spriteArt, myMap);
        height = 32;
        width = 32;
        
        id = "hole";
    }
}