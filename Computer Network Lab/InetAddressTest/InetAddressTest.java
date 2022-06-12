import java.net.*;
public class InetAddressTest
{
	public static void main(String[] args) throws UnknownHostException
	{
		InetAddress a = InetAddress.getLocalHost();
		InetAddress b = InetAddress.getByName("www.stjohnsdiocesan.in");
		System.out.println(a);
		System.out.println(b);
	}
}