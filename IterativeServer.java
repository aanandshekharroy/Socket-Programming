
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class IterativeServer{
	public static void main(String[ ] args){
		try{
			//String message="start";
			int serverPortNum =7993;
			ServerSocket connectionSocket = new ServerSocket(serverPortNum);
			Socket dataSocket = connectionSocket.accept( );
			PrintStream socketOutput = new PrintStream(dataSocket.getOutputStream( ));
			//socketOutput.println(message);
			BufferedReader to_client=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader from_client=new BufferedReader(new InputStreamReader(dataSocket.getInputStream()));
			while(true){
				System.out.print("SERVER-a:");
				String from_msg=from_client.readLine();
				if(from_msg.length()<1){
					System.out.println("Connection Broke");
					break;
				}
				System.out.println(from_msg);
				String to_msg=to_client.readLine();
				socketOutput.println("CLIENT:"+to_msg);
				socketOutput.flush();
			}
			dataSocket.close();
		}
			catch(Exception e){e.printStackTrace( );}
			}
}
