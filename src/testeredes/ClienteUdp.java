package testeredes;

import java.net.*;
import java.util.Scanner;
import java.io.*; 
public class ClienteUdp{
	public static void main(String args[]){ 
	// args give message contents and server hostname
		 
		
		DatagramSocket aSocket = null;
		try {
			System.out.println("Conected server!!");
			Scanner teclado = new Scanner(System.in); 
			String str = teclado.nextLine();
			
			aSocket = new DatagramSocket();    
			byte [] m = str.getBytes();
			InetAddress aHost = InetAddress.getByName("127.0.0.1");
			int serverPort = 6789;		                                                 
			DatagramPacket request = new DatagramPacket(m,  str.length(), aHost, serverPort);
			aSocket.send(request);			                        
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
			aSocket.receive(reply);
			System.out.println("Result: " + new String(reply.getData()));	
		} catch (SocketException e){
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e){
			System.out.println("IO: " + e.getMessage());
		} finally {
			if(aSocket != null) {
				aSocket.close();
			}
		}
	} 
}