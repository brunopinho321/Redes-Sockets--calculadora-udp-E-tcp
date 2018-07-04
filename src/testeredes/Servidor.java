package testeredes;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.Scanner;

public class Servidor {
		public static void main(String args[]) throws IOException{
			ServerSocket servidor = new ServerSocket(12345);
			System.out.println("Porta 12345 aberta");
		
			Socket cliente = servidor.accept();
			System.out.println("Nova conexão com o cliente: "+cliente.getInetAddress().getHostAddress());;
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());
			String ent = entrada.readUTF();
			//Scanner s = new Scanner(cliente.getInputStream()); 
			
			//while(s.hasNextLine()) {
				//System.out.println(s.nextLine());
			//}
			String str;
			Calculadora c = new Calculadora();
			str = Double.toString(c.calcular(ent));	
			
			saida.writeUTF(str);
			//s.close();
			servidor.close();
			cliente.close();
		
		}
}
