package exercice2;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class SendUDP {
	private final static String group="224.0.0.1";
	private final static int port=7654;
	
	private DatagramSocket socket;
	
	public SendUDP(String msg) {
		try {
			// Création du socket multicast et du buffer pour la réception du paquet
			socket = new MulticastSocket();
			byte[] buf = msg.getBytes();
			
			/* Création du paquet, rien ne change par rapport à la version de l'exercice 1
			 * On fournit juste une adresse multicast et un port associé
			 */
			DatagramPacket paquet = new DatagramPacket(buf, buf.length,InetAddress.getByName(group),port);
			socket.send(paquet);
			System.out.println("Sending message done");
			
			socket.close();
		} catch (IOException e) {
			System.out.println("Sending message fail");
			e.printStackTrace();
		}
		
	}
	

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendUDP sender = new SendUDP(args[0]);
	}

}
