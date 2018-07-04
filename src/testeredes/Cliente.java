package testeredes;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException{
		Socket cliente = new Socket("127.0.0.1",12345);
		System.out.println("O cliente se conectou ao servidor!");
	
		Scanner teclado = new Scanner(System.in);
		DataOutputStream saida =  new DataOutputStream(cliente.getOutputStream());
		DataInputStream entrada = new DataInputStream(cliente.getInputStream());
		//while(teclado.hasNextLine()){
			//saida.println(teclado.nextLine());
		//}
		//saida.close();
		saida.writeUTF(teclado.nextLine());
		System.out.println(entrada.readUTF());
		teclado.close();
		cliente.close();
	}
}
