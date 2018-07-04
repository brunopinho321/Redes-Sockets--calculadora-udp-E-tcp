package testeredes;

import java.net.*;
import java.io.*;
public class ServidorUdp{ 
	public static void main(String args[]){ 
		
		DatagramSocket aSocket = null;
	   
		try{
			System.out.println("Server online!");
	    	aSocket = new DatagramSocket(6789);
	    	 aSocket.setSoTimeout(100000);
	    	byte[] buffer = new byte[1000];
	 		while(true){
 				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
 				aSocket.receive(request);
 				
 				Calculadora c = new Calculadora();
 				String str = Double.toString(c.calcular(new String(request.getData())));
 				
 				DatagramPacket reply = new DatagramPacket(str.getBytes(), 
			   	str.length(), request.getAddress(), request.getPort());
 				
 				aSocket.send(reply);
 				//System.out.println(new String(request.getData()));
			}
	    } catch (SocketException e) {
	    	System.out.println("Socket: " + e.getMessage());
	    } catch (IOException e) {
	    	System.out.println("IO: " + e.getMessage());
		} finally {
			if(aSocket != null) {
				aSocket.close();
			}
		}
    }
}