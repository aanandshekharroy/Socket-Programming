import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class doThread extends Thread {
	Socket conn;

	public doThread(Socket dataSocket) {
		// TODO Auto-generated constructor stub
		conn=dataSocket;
	}
	
	
	public void run(){
		try{
			BufferedReader from_client=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			PrintStream out=new PrintStream(conn.getOutputStream());
			BufferedReader to_server=new BufferedReader(new InputStreamReader(System.in));
			while(true){
				String from_msg=from_client.readLine();
				System.out.println("CLIENT:"+from_msg);
				String to_msg=to_server.readLine();
				out.println("SERVER:"+to_msg);
				
			}
		}
		catch(Exception e){
			System.out.println();
		}
		System.out.println("");
	}
}
