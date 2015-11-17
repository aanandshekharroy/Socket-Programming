

import java.net.ServerSocket;
import java.net.Socket;
public class connectionServer5{
	public static void main(String[ ] args){
		try{
			int serverPortNum =7993;
			ServerSocket connectionSocket = new ServerSocket(serverPortNum);
			while(true){
				Socket dataSocket = connectionSocket.accept( );
				doThread thread=new doThread(dataSocket);
				thread.start();
			}
		}
			catch(Exception e){e.printStackTrace( );}
			}
}
