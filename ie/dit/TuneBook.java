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
            while ((l = inputStream.readLine()) != null) 
            {
            	String ret = "";
                //tunes.add(l);
                //System.out.println(l);
                if (l.charAt(0) == 'X') 
                {
                	ret += l.charAt(1);
                }
                else if(l.charAt(0) == 'T')
                {
                	ret += l.charAt(1);
                }
                System.out.println(ret);

       //          Tune t = new Tune(l);
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
			sb.append(tune + ", ");
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