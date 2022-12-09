import java.io.*;  
import java.net.*;  
import java.util.Scanner;
public class Client {  
public static void main(String[] args) {  
		
		Scanner sc=new Scanner(System.in);
		System.out.println("--------------------------------------------");  
		System.out.println("------------------Client--------------------");  
		System.out.println("--------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.print("[?]Enter port number :");
		int portNumber=sc.nextInt();
		
	
try{      
	Socket s=new Socket("localhost",portNumber);
	
	DataInputStream din=new DataInputStream(s.getInputStream());  
	DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
	  
	String str="",str2="";  
	while(!str.equals("stop")){ 
		System.out.print("Me (Press enter to send your message) : ");  
		str=br.readLine();  
		dout.writeUTF(str);  
		dout.flush();  
		str2=din.readUTF();  
		System.out.println("Server says: "+str2);  
	}  
	  
	dout.close();  
	s.close();  
}catch(Exception e){
	System.out.println("[*]Erorr while Connecting to the client !");
		}
	}
}