package exercice3;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;


public class SendUDP extends Thread {
	private final static String group="224.0.0.1";
	private final static int port=7654;
	
	private DatagramSocket socket;
	
	public SendUDP() {
		try {
			socket = new MulticastSocket();
		} catch (Exception e) {
			System.out.println("Erreur socket");
			e.printStackTrace();
		}
		
	}
	
	
	public void run() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String saisie = null;	

		while((saisie=scan.nextLine()).compareTo("/exit") != 0) {
			try {
				byte[] buf = saisie.getBytes();
				DatagramPacket paquet = new DatagramPacket(buf, buf.length,InetAddress.getByName(group),port);
				socket.send(paquet);
				System.out.println("Sending message done");
				saisie="";
			} catch (IOException e) {
				System.out.println("Sending message fail");
				e.printStackTrace();
			}
		}
				
	}

	
	/**
	 * @param args
	 *//*
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendUDP sender = new SendUDP(args[0]);
	}*/
	
}
