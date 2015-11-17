import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;


public class connectionClient5 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InetAddress host=InetAddress.getByName("localhost");
		int port =7993;
		Socket dataSocket=new Socket(host,port);
		PrintStream out=new PrintStream(dataSocket.getOutputStream());
		BufferedReader from_server=new BufferedReader(new InputStreamReader(dataSocket.getInputStream()));
		BufferedReader to_server=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String to_msg=to_server.readLine();
			out.println(to_msg);
			String from_msg=from_server.readLine();
			System.out.println(from_msg);
		}
	}

}
