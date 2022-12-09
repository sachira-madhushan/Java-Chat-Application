import java.io.*;  
import java.net.*;  
import java.util.Scanner;
public class Server {  
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
		System.out.println("--------------------------------------------");  
		System.out.println("------------------Server--------------------");  
		System.out.println("--------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.print("[?]Enter port number :");
		int portNumber=sc.nextInt();
try{  
	ServerSocket ss=new ServerSocket(portNumber); 
	System.out.println("[+]Waiting for client......");
	Socket s=ss.accept();
	System.out.println("[+]Client Connected !");
	System.out.println();
	System.out.println();
	
	DataInputStream din=new DataInputStream(s.getInputStream());  
	DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
	String str="",str2="";  
	while(!str.equals("stop")){  
		str=din.readUTF();  
		System.out.println("client says: "+str);  
		System.out.print("Me (Press enter to send your message): ");  
		
		str2=br.readLine();  
		dout.writeUTF(str2);  
		dout.flush();  
	}  
	din.close();  
	s.close();  
	ss.close();  
}catch(Exception e){
	System.out.println("[*]Erorr while Connecting to the server !");
		}
	}
}