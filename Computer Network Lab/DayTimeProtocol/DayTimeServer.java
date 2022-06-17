import java.io.*;
import java.net.*;
import java.util.Date;
public class DayTimeServer
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket theServer;
		Socket theConnection;
		PrintStream p;
		try{
			theServer = new ServerSocket(13);
		   	try{
				theConnection = theServer.accept();
				p = new PrintStream(theConnection.getOutputStream());
				p.println(new Date());
				theConnection.close();
			}
			catch(IOException e)
			{
				theServer.close();
				System.err.println(e);
			}
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
}
			