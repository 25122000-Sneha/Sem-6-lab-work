import java.util.Scanner;
class Ipaddress {
    static String findIpClass(String str)
    {
        int index = str.indexOf('.');
        
        String ipsub = str.substring(0,index);
        int ip = Integer.parseInt(ipsub);
        // Class A
        if (ip>=0 && ip<=127)
            return "A";
        // Class B
        else if (ip>=128 && ip<=191)
            return "B";
        // Class C
        else if (ip>=192 && ip<=223)
            return "C";
        // Class D
        else if (ip >=224 && ip<=239)
            return "D";
        // Class E
        else
            return "E";
    }

	static void octetSeperation(String str, String ipClass) 
  	{
        // Initializing network and host empty
        String network = "", host = "";
 
        if(ipClass == "A") {
            int index = str.indexOf('.');
            network = str.substring(0, index);
            host = str.substring(index + 1, str.length());
        }
	else if(ipClass == "B") {
            //Position of breaking network and HOST id
            int index = -1;
            int dot = 2;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) == '.') {
                    dot -= 1;
                    if(dot == 0) {
                        index = i;
                        break;
                    }
                }
            }
            network = str.substring(0, index);
            host = str.substring(index + 1, str.length());
		}
	else if(ipClass == "C") {
            //Position of breaking network and HOST id
            int index = -1;
            int dot = 3;
            for(int i = 0 ; i <str.length(); i++) 
		{
                if(str.charAt(i) == '.') 
		    {
                    dot -= 1;
                    if(dot == 0) {
                        index = i;
                        break;                    
                    }
                }
            }
            network = str.substring(0, index);
            host = str.substring(index + 1, str.length());
        }
	else if(ipClass == "D" || ipClass == "E") 
	{
            System.out.println("In this Class, IP address is not divided into Network and Host IDs.");
            return;
	}
        System.out.println("Network ID is: "+ network);
        
    }
	public static void main(String[] args) {
	  	Scanner reader = new Scanner(System.in);
	  	System.out.print("Enter an IP address in dotted decimal format: ");
	  	String str = reader.nextLine();
	  	String ipClass = findIpClass(str);
	  	System.out.println("Given IP address belongs to Class "+ ipClass);
	  	octetSeperation(str, ipClass);
		}
    
    }
		
