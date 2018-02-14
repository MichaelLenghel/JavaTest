package ie.dit;

import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;

public class Tune implements play
{
	private int x;
    private String title;
    private String altTitle;
    private String notation;

    public Tune(String line)
    {
    	if (line.charAt(1) == 'X')
    	{
    		this.x = line.charAt(1);
    	}
    	else if(line.charAt(2) == 'T')
    	{
    		this.title = "2";
    	}
    }

    public void play()
    {
    	
    }
    //Accessor
    public int getX()
    {
        return x;
    }//end getRows

    public String getTitle()
    {
        return title;
    }//end getRows

    public String getAltTitle()
    {
        return altTitle;
    }//end getRows

    public String getNotation()
    {
        return notation;
    }//end getRows

    public String toString()
    {
    	return getX() + ", " + getTitle();// + ", " + getAltTitle() + ", " + getNotation();
    }
}