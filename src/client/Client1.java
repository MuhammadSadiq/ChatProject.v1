package clientsock;

import java.io.*;
import java.net.*;

public class Client1 {

	public final static int port = 1977;
	

	public static void main(String[] args) {

		Socket socket = null;

		try {
			socket = new Socket("127.0.0.1", port);
			
			PrintWriter SocketOut = new PrintWriter(socket.getOutputStream(), true);
			SocketOut.println("hello server");
			SocketOut.close();
			
			BufferedReader SocketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			boolean eof = false;
			
			while(!eof){
				String data = SocketIn.readLine();
				if(data == null){
					eof = true;
				} else{
					System.out.println(data);
				}
			}
			
			socket.close();
			
		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException ex) {
			System.out.println(ex);
		} 
			
					
				}
			

		
	}


