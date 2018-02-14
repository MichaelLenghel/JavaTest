package ie.dit;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;

public class TuneBook 
{
	ArrayList<Tune> tunes = new ArrayList<Tune>();

	public TuneBook(String fileName)
	{
		loadTunes(fileName);
	}

	public void loadTunes(String fileName)
	{
        // Adapted from: https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
        BufferedReader inputStream = null;

        try 
        {
        	//Didn't work b4 as we didn't set the path for package >>>>>>>>>>>>>.<<<<<<<<<<<<<
            inputStream = new BufferedReader(new FileReader("ie/dit/tunes.txt"));
            
            String l;
            char index1;
            char index2;
            String title;
            String altTitle;
            while ((l = inputStream.readLine()) != null) 
            {
            	if (l.indexOf("X") == 0) 
            	{
            		if(l.length() > 3)
            		{
            			index1 = l.charAt(2);
            			index2 = l.charAt(3);	
            			System.out.println(index1 + index2);
            		}
            		else
            		{
            			index1 = l.charAt(2);
            		}
            	}

            	else if(l.indexOf("T") == 0)
            	{
            		title = l.substring(2, l.length());
            		System.out.println(title + "\n ");
            	}

            	//Array out of bounds index - Could not fix (spent an hour trying to)
            		//System.out.println(l);
        //     		Tune t = new Tune(l);
    				// tunes.add(t);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (inputStream != null) {
                try
                {
                    inputStream.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public String toString()
	{
		//Create the buffer which will hold the words
		StringBuffer sb = new StringBuffer();
		//Turned into string as error other wise
		// String[] wordArr = new String[tunes.size()];
		// wordArr = tunes.toArray(wordArr);
		for (Tune tune:tunes) 
		{
			sb.append(tune + "\n ");
		}
		return sb.toString();
	}

	public static void main(String[] args)
    {
        TuneBook tb = new TuneBook("ie/dit/words.txt");
        //System.out.println(tb);

        // Tune t = tb.findTune("Scotsman over the Border");
        // t.play();
    }
}