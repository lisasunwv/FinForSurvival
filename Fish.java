
/**
 * Write a description of class Fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish extends Entity
{
	public Fish(String spriteArt, Map myMap)
	{
		super(spriteArt, myMap);
		height = 32;
		width = 32;
		id = "fish";
		velocityX = -2;
	}

	public int interact(Entity other)
	{
		if (positionX < 0)
		{
			return 3;
		}
		return 0;
	}
}